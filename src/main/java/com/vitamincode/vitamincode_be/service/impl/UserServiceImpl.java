package com.vitamincode.vitamincode_be.service.impl;

import com.vitamincode.vitamincode_be.convert.UserConvert;
import com.vitamincode.vitamincode_be.dto.response.UserDtoResponse;
import com.vitamincode.vitamincode_be.enums.ErrorCode;
import com.vitamincode.vitamincode_be.exception.AppException;
import com.vitamincode.vitamincode_be.repository.UserRepository;
import com.vitamincode.vitamincode_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDtoResponse> getAllUser() {
        var result = userRepository.findAll();
        if(result.isEmpty()) throw new AppException(ErrorCode.LIST_USER_EMPTY);
        return  UserConvert.listStudentEntityConvertToListStudentResponse(result);
    }
}
