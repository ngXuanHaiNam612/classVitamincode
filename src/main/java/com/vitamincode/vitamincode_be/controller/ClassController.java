package com.vitamincode.vitamincode_be.controller;


import com.vitamincode.vitamincode_be.dto.request.ClassDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ApiResponse;
import com.vitamincode.vitamincode_be.exception.ErrorCode;
import com.vitamincode.vitamincode_be.mapper.ClassMapper;
import com.vitamincode.vitamincode_be.service.ClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/class")

@RequiredArgsConstructor
public class ClassController {
    private final ClassService classServiceImpl;
    private final ClassMapper classMapper;


    @GetMapping("/getAllClass")
    public ApiResponse<?> getAllClass() {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.selectAllClass())
                .build();
    }

    @GetMapping("/getClassByID/{id}")
    public ApiResponse<?> getClassByID(@PathVariable("id") Integer classID) {
        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.selectClassById(classID))
                .build();
    }
    //cách 2
    @GetMapping("/getClassByID")
    public ApiResponse<?> getClassByIDc2(@RequestParam("id") Integer classID) {
        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.selectClassById(classID))
                .build();

    }


    @GetMapping("/getClassByName/{name}")
    public ApiResponse<?> getClassByName(@PathVariable("name") String className) {
        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.selectClassByName(className))
                .build();
    }

    @GetMapping("/getClassLikeName")
    public ApiResponse<?> getClassByNameC2(@RequestParam("name") String className) {
        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.selectClassByName(className))
                .build();
    }

    @PostMapping(value = "/insertNewClass")
    public ApiResponse<?> createClass(@RequestBody ClassDtoRequest newClass) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.insertClass(newClass))
                .build();

    }

    @PutMapping(value = "/updateClass")
    public ApiResponse<?> updateClass(@RequestBody ClassDtoRequest updateClass) {

        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.updateClass(updateClass))
                .build();

    }

    @DeleteMapping("/deleteClass/{id}")
    public ApiResponse<?> deleteClass(@PathVariable("id") Integer classID) {
        return ApiResponse.builder()
                .status(ErrorCode.HTTP_STATUS_200.getStatus())
                .success(true)
                .data(classServiceImpl.deleteClassById(classID))
                .build();
    }
}
