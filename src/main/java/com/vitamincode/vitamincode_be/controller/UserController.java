package com.vitamincode.vitamincode_be.controller;

import com.vitamincode.vitamincode_be.dto.response.ApiResponse;
import com.vitamincode.vitamincode_be.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class UserController {

    @GetMapping("/getAllUser")
    ApiResponse<List<User>> getAllUser(){

        return ApiResponse.<List<User>>.
    }
}
