package com.vitamincode.vitamincode_be.controller;


import com.vitamincode.vitamincode_be.dto.request.ClassDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ApiResponse;
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
                .status(200)
                .success(true)
                .data(classServiceImpl.selectAllClass())
                .build();
    }

    @GetMapping("/getClassByID/{id}")
    public ResponseEntity<?> getClassByID(@PathVariable("id") Integer classID) {
        Map<String, Object> resultMapAPI = new LinkedHashMap<>();

        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", classServiceImpl.selectClassById(classID));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/class/getClassByID/{id}", e);

        }
        return ResponseEntity.ok(resultMapAPI);
    }
    //cách 2
    @GetMapping("/getClassByID")
    public ResponseEntity<?> getClassByIDc2(@RequestParam("id") Integer classID) {
        Map<String, Object> resultMapAPI = new LinkedHashMap<>();

        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", classServiceImpl.selectClassById(classID));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/class/getClassByID", e);

        }
        return ResponseEntity.ok(resultMapAPI);

    }


    @GetMapping("/getClassByName/{name}")
    public ResponseEntity<?> getClassByName(@PathVariable("name") String className) {
        Map<String, Object> resultMapAPI = new LinkedHashMap<>();

        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", classServiceImpl.selectClassByName(className));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/class/getClassByName/{name}", e);

        }
        return ResponseEntity.ok(resultMapAPI);
    }

    @GetMapping("/getClassLikeName")
    public ResponseEntity<?> getClassByNameC2(@RequestParam("name") String className) {
        Map<String, Object> resultMapAPI = new LinkedHashMap<>();

        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            resultMapAPI.put("data", classServiceImpl.selectClassLikeName(className));

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            resultMapAPI.put("data", e.getMessage());
            log.error("fail to call api /api/v1/class/getClassLikeName", e);

        }
        return ResponseEntity.ok(resultMapAPI);
    }

    @PostMapping(value = "/insertNewClass")
    public ResponseEntity<?> createClass(@RequestBody ClassDtoRequest newClass) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();

        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            classServiceImpl.insertClass(newClass);

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            log.error("fail to call api /api/v1/class/insertNewClass", e);

        }
        return ResponseEntity.ok(resultMapAPI);

    }

    @PutMapping(value = "/updateClass")
    public ResponseEntity<?> updateClass(@RequestBody ClassDtoRequest newClass) {

        Map<String, Object> resultMapAPI = new LinkedHashMap<>();

        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            classServiceImpl.updateClass(newClass);

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            log.error("fail to call api /api/v1/class/updateClass", e);

        }
        return ResponseEntity.ok(resultMapAPI);

    }

    @DeleteMapping("/deleteClass/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable("id") Integer classID) {
        Map<String, Object> resultMapAPI = new LinkedHashMap<>();
        try{
            resultMapAPI.put("status", 200);
            resultMapAPI.put("success", true);
            classServiceImpl.deleteClassById(classID);

        }catch(Exception e){
            resultMapAPI.put("status", 500);
            resultMapAPI.put("success", false);
            log.error("fail to call api /api/v1/class/deleteClass/{id}", e);

        }
        return ResponseEntity.ok(resultMapAPI);
    }
}
