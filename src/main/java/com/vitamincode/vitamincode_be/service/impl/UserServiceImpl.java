package com.vitamincode.vitamincode_be.service.impl;

import com.vitamincode.vitamincode_be.convert.UserConvert;
import com.vitamincode.vitamincode_be.dto.response.UserDtoResponse;
import com.vitamincode.vitamincode_be.entity.User;
import com.vitamincode.vitamincode_be.enums.ErrorCode;
import com.vitamincode.vitamincode_be.exception.AppException;
import com.vitamincode.vitamincode_be.repository.UserRepository;
import com.vitamincode.vitamincode_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDtoResponse> getAllUser() {
        var listEntity = userRepository.findAll();
        if(listEntity.isEmpty()) throw new AppException(ErrorCode.LIST_USER_EMPTY);
        return UserConvert.listStudentEntityConvertToListStudentResponse(listEntity);
    }

    @Override
    public UserDtoResponse getUserInfo() {
        var securityContext  = SecurityContextHolder.getContext();
        String name = securityContext .getAuthentication().getName();
        User entity = userRepository.findByUserName(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return UserConvert.userEntityConvertToUserResponse(entity);
    }

    @Override
    @PreAuthorize("#userName == authentication.name") //match userName => auth else deny
    public UserDtoResponse getByUserName(String userName) {
        User entiy = userRepository.findByUserName(userName)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return UserConvert.userEntityConvertToUserResponse(entiy);
    }

}
