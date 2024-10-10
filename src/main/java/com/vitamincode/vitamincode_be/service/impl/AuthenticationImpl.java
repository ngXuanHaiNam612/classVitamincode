package com.vitamincode.vitamincode_be.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.vitamincode.vitamincode_be.dto.request.AuthenticationDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.AuthenticationDtoResponse;
import com.vitamincode.vitamincode_be.entity.User;
import com.vitamincode.vitamincode_be.enums.ErrorCode;
import com.vitamincode.vitamincode_be.exception.AppException;
import com.vitamincode.vitamincode_be.repository.UserRepository;
import com.vitamincode.vitamincode_be.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class AuthenticationImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Value("${jwt.secret-key}")
    protected String SECRET_KEY;


    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) throws JOSEException {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        String username = request.getUsername();
        var user = userRepository.findByUserName(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated) throw new AppException(ErrorCode.PASSWORD_INCORRECT);

        return AuthenticationDtoResponse.builder()
                .token(generateToken(user))
                .authenticated(true)
                .build();
    }

    private String generateToken(User user) throws JOSEException {
        JWSHeader jwsHeader  = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUserName())
                .issuer("ngxuanhainam.com")
                .issueTime(new Date())
                .expirationTime(Date
                                .from(Instant.now()
                                .plus(1, ChronoUnit.HOURS)))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
        return jwsObject.serialize();
    }
}
