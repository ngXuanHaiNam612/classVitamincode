package com.vitamincode.vitamincode_be.service;

import com.vitamincode.vitamincode_be.dto.request.ClassDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ClassDtoResponse;

import java.util.List;

public interface ClassService {

    //read
    List<ClassDtoResponse> selectAllClass();
    List<ClassDtoResponse> selectClassById(Integer classID);
    ClassDtoResponse selectClassByName(String className);
    List<ClassDtoResponse> selectClassLikeName(String className);

    //save
    int saveClass(ClassDtoRequest classDtoRequest);

    //delete
    int deleteClassById(Integer classID);
}
