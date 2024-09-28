package com.vitamincode.vitamincode_be.controller;

import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.entity.Student;
import com.vitamincode.vitamincode_be.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentServiceImpl;

    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAllStudents() {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();

        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.selectAllStudent());

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/getAllStudent", e);
        }
        return ResponseEntity.ok(resultMapAPI);

    }

    @GetMapping("/getStudentByID/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.selectStudentById(id));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/getStudentByID/{id}", e);

        }
        return ResponseEntity.ok(resultMapAPI);
    }

    @GetMapping("/getStudentByID")
    public ResponseEntity<?> getStudentByIdC2(@RequestParam("id") Integer id) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.selectStudentById(id));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/getStudentByID", e);

        }
        return ResponseEntity.ok(resultMapAPI);
    }

    @GetMapping("/getStudentByName/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.selectStudentByName(name));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/getStudentByName/{name}", e);
        }
        return ResponseEntity.ok(resultMapAPI);
    }


    @GetMapping("/getStudentLikeName")
    public ResponseEntity<?> getStudentLikeName(@RequestParam("name") String name) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.selectStudentByName(name));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/getStudentLikeName", e);
        }
        return ResponseEntity.ok(resultMapAPI);
    }


    @PostMapping("/insertNewStudent")
    public ResponseEntity<?> insertNewStudent(@RequestBody StudentDtoRequest student) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.insertStudent(student));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/insertNewStudent", e);
        }
        return ResponseEntity.ok(resultMapAPI);
    }


    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDtoRequest student) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.updateStudent(student));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/updateStudent", e);
        }
        return ResponseEntity.ok(resultMapAPI);
    }

    @DeleteMapping("/deleteStudentByID/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id) {
        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", studentServiceImpl.deleteStudentById(id));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/student/deleteStudentByID/{id}", e);
        }
        return ResponseEntity.ok(resultMapAPI);

    }




}
