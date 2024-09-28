package com.vitamincode.vitamincode_be.service.impl;

import com.vitamincode.vitamincode_be.convert.ClassConvert;
import com.vitamincode.vitamincode_be.dto.request.ClassDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ClassDtoResponse;
import com.vitamincode.vitamincode_be.entity.Class;
import com.vitamincode.vitamincode_be.exception.AppException;
import com.vitamincode.vitamincode_be.exception.ErrorCode;
import com.vitamincode.vitamincode_be.mapper.ClassMapper;
import com.vitamincode.vitamincode_be.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassMapper classMapper;

    @Override
    public List<ClassDtoResponse> selectAllClass() {

        if(classMapper.selectAllClass().isEmpty()) throw new AppException(ErrorCode.LIST_CLASS_EMPTY);

        return ClassConvert.listClassEntityConvertToListClassDtoResponse(classMapper.selectAllClass());

    }

    @Override
    public ClassDtoResponse selectClassById(Integer classID) {
        var result = ClassConvert.classEntityConvertToClassDtoResponse(classMapper.selectClassByID(classID));
        if(!Objects.isNull(result)){
            return result;
        }
        return null;
    }

    @Override
    public ClassDtoResponse selectClassByName(String className) {
        var result =   ClassConvert.classEntityConvertToClassDtoResponse(classMapper.selectClassByName(className));
        if(!Objects.isNull(result)){
            return result;
        }
        return null;
    }

    @Override
    public List<ClassDtoResponse> selectClassLikeName(String className) {
        List<ClassDtoResponse> classDtoResponseList = classMapper.selectClassLikeName(className)
                .stream()
                .map(ClassConvert::classEntityConvertToClassDtoResponse)
                .toList();

        if(!classDtoResponseList.isEmpty()){
            return classDtoResponseList;
        }
        return null;
    }

    @Override
    public int insertClass(ClassDtoRequest newClass) {
        return classMapper.insertNewClass(ClassConvert.classDtoRequestConvertToClass(newClass));
    }

    @Override
    public int updateClass(ClassDtoRequest updateClass) {
        return classMapper.updateClass(ClassConvert.classDtoRequestConvertToClass(updateClass));
    }

    @Override
    public int deleteClassById(Integer classID) {
        return classMapper.deleteClass(classID);
    }


}
