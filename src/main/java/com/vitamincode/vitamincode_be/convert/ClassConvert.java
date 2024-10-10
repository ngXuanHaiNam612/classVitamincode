package com.vitamincode.vitamincode_be.convert;

import com.vitamincode.vitamincode_be.dto.request.ClassDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ClassDtoResponse;
import com.vitamincode.vitamincode_be.entity.Class;

import java.util.List;

public class ClassConvert {

    public static ClassDtoResponse classEntityConvertToClassDtoResponse(Class classEntity){

        return ClassDtoResponse.builder()
                .classId(classEntity.getClassId())
                .className(classEntity.getClassName())
                .classDescription(classEntity.getClassDescription())
                .build();
    }

    public static List<ClassDtoResponse> listClassEntityConvertToListClassDtoResponse(List<Class> listEntity){
        return listEntity
                .stream()
                .map(ClassConvert::classEntityConvertToClassDtoResponse)
                .toList();
    }

    public static Class classDtoRequestConvertToClass(ClassDtoRequest classDtoRequest){

        return Class.builder()
                .classId(classDtoRequest.getClassId())
                .className(classDtoRequest.getClassName())
                .classDescription(classDtoRequest.getClassDescription())
                .build();
    }


}
