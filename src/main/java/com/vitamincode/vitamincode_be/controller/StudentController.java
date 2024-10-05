package com.vitamincode.vitamincode_be.controller;

import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ApiResponse;
import com.vitamincode.vitamincode_be.exception.ErrorCode;
import com.vitamincode.vitamincode_be.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin

public class StudentController {

    private final StudentService studentServiceImpl;

    @GetMapping("/getAllStudent")
    public ApiResponse<?> getAllStudents() {

       return ApiResponse.builder()
               .status(ErrorCode.HTTP_STATUS_200.getStatus())
               .success(true)
               .data(studentServiceImpl.selectAllStudent())
               .build();

    }

    @GetMapping("/getStudentByID/{id}")
    public ApiResponse<?> getStudentById(@PathVariable Integer id) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.selectStudentById(id))
                .build();
    }

    @GetMapping("/getStudentByID")
    public ApiResponse<?> getStudentByIdC2(@RequestParam("id") Integer id) {

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


    @PostMapping("/insertNewStudent")
    public ApiResponse<?> insertNewStudent(@RequestBody StudentDtoRequest newStudent) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.insertStudent(newStudent))
                .build();
    }


    @PutMapping("/updateStudent")
    public ApiResponse<?> updateStudent(@RequestBody StudentDtoRequest updateStudent) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(studentServiceImpl.updateStudent(updateStudent))
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
