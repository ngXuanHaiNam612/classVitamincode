package com.vitamincode.vitamincode_be.config;


import com.nimbusds.jose.JOSEException;
import com.vitamincode.vitamincode_be.dto.request.IntrospectDtoRequest;
import com.vitamincode.vitamincode_be.enums.ErrorCode;
import com.vitamincode.vitamincode_be.exception.AppException;
import com.vitamincode.vitamincode_be.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CustomJwtDecoder implements JwtDecoder {


    @Value("${jwt.secret-key}")
    protected String SECRET_KEY;

    private final AuthenticationService authenticationService;
    private NimbusJwtDecoder jwtDecoder = null;

    @Override
    public Jwt decode(String token) throws JwtException {

        try {
            // check valid
            var response = authenticationService.introspect(IntrospectDtoRequest.builder()
                    .accessToken(token)
                    .build()
            );
            if(!response.getIsValid()) throw new AppException(ErrorCode.INVALID_TOKEN);
        } catch (JOSEException | ParseException e) {
            throw new JwtException(e.getMessage());
        }

        if (Objects.isNull(jwtDecoder)) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "HS256");
            jwtDecoder = NimbusJwtDecoder
                    .withSecretKey(secretKeySpec)
                    .macAlgorithm(MacAlgorithm.HS256)
                    .build();

        }

        return jwtDecoder.decode(token);
    }
}
