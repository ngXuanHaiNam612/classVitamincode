package com.vitamincode.vitamincode_be.service;

import com.vitamincode.vitamincode_be.dto.request.ClassDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ClassDtoResponse;

import java.util.List;

public interface ClassService {

    //read
    List<ClassDtoResponse> selectAllClass();
    ClassDtoResponse selectClassById(Integer classID);
    ClassDtoResponse selectClassByName(String className);
    List<ClassDtoResponse> selectClassLikeName(String className);

    //create
    int insertClass(ClassDtoRequest newClass);

    //update
    int updateClass(ClassDtoRequest updateClass);

    //delete
    int deleteClassById(Integer classID);
}
