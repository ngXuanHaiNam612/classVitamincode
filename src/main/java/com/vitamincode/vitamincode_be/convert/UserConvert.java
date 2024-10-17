package com.vitamincode.vitamincode_be.convert;

import com.vitamincode.vitamincode_be.dto.response.UserDtoResponse;
import com.vitamincode.vitamincode_be.entity.User;

import java.util.List;

public class UserConvert {
    public static UserDtoResponse userEntityConvertToUserResponse(User user){

        return UserDtoResponse.builder()
                .username(user.getUserName())
                .email(user.getEmail())
                .enabled(user.getEnabled())
                .role(user.getRole())
                .build();
    }

    public static List<UserDtoResponse> listStudentEntityConvertToListStudentResponse(List<User> listUserEntity){
        return listUserEntity
                .stream()
                .map(UserConvert::userEntityConvertToUserResponse)
                .toList();

    }
}
