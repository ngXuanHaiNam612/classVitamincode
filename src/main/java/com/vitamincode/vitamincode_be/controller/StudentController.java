package com.vitamincode.vitamincode_be.controller;

import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ApiResponse;
import com.vitamincode.vitamincode_be.enums.ErrorCode;
import com.vitamincode.vitamincode_be.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/s")
@RequiredArgsConstructor
@CrossOrigin

public class StudentController {

    private final StudentService studentServiceImpl;

    @GetMapping
    public ApiResponse<?> getAllStudents() {

       return ApiResponse.builder()
               .status(ErrorCode.HTTP_STATUS_200.getStatus())
               .success(true)
               .data(studentServiceImpl.selectAllStudent())
               .build();

    }

    @GetMapping("/getStudent")
    public ApiResponse<?> getStudentByIdC2(@RequestParam(name ="id", required = false) Integer id) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.selectStudentById(id))
                .build();
    }

    @GetMapping("/getStudentByName/{name}")
    public ApiResponse<?> getStudentByName(@PathVariable String name) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.selectStudentByName(name))
                .build();
    }


    @GetMapping("/getStudentLikeName")
    public ApiResponse<?> getStudentLikeName(@RequestParam("name") String name) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.selectStudentLikeName(name))
                .build();
    }


    @PostMapping("/save")
    public ApiResponse<?> insertNewStudent(@RequestBody StudentDtoRequest studentDtoRequest) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.saveStudent(studentDtoRequest))
                .build();
    }


    @DeleteMapping("/deleteStudentByID/{id}")
    public ApiResponse<?> deleteStudentById(@PathVariable("id") Integer id) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.deleteStudentById(id))
                .build();
    }
}
