package com.vitamincode.vitamincode_be.controller;


import com.vitamincode.vitamincode_be.dto.response.ApiResponse;
import com.vitamincode.vitamincode_be.dto.response.UserDtoResponse;
import com.vitamincode.vitamincode_be.enums.ErrorCode;
import com.vitamincode.vitamincode_be.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/getAllUser")
    ApiResponse<List<UserDtoResponse>> getAllUser() {
        return ApiResponse.<List<UserDtoResponse>>builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(userService.getAllUser())
                .build();

    }
}
