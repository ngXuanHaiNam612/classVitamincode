package com.vitamincode.vitamincode_be.service.impl;

import com.vitamincode.vitamincode_be.convert.ClassConvert;
import com.vitamincode.vitamincode_be.dto.request.ClassDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.ClassDtoResponse;
import com.vitamincode.vitamincode_be.exception.AppException;
import com.vitamincode.vitamincode_be.exception.ErrorCode;
import com.vitamincode.vitamincode_be.mapper.ClassMapper;
import com.vitamincode.vitamincode_be.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassMapper classMapper;

    // check if exist
    public void isExistClass(Integer classID) {
        if(Objects.isNull(classMapper.selectClassByID(classID))) throw new AppException(ErrorCode.NO_CLASS_WITH_THIS_ID);
    }

    @Override
    public List<ClassDtoResponse> selectAllClass() {

        var result = ClassConvert.listClassEntityConvertToListClassDtoResponse(classMapper.selectAllClass());
        if(result.isEmpty()) throw new AppException(ErrorCode.LIST_CLASS_EMPTY);
        return result;

    }

    @Override
    public ClassDtoResponse selectClassById(Integer classID) {
        var result = ClassConvert.classEntityConvertToClassDtoResponse(classMapper.selectClassByID(classID));
        if(Objects.isNull(result)) throw new AppException(ErrorCode.CLASS_EMPTY);
        return result;
    }

    @Override
    public ClassDtoResponse selectClassByName(String className) {
        var result =  ClassConvert.classEntityConvertToClassDtoResponse(classMapper.selectClassByName(className));
        if(Objects.isNull(result))  throw  new AppException(ErrorCode.CLASS_EMPTY);
        return result;
    }

    @Override
    public List<ClassDtoResponse> selectClassLikeName(String className) {
        var result = ClassConvert.listClassEntityConvertToListClassDtoResponse(classMapper.selectClassLikeName(className));
        if(result.isEmpty()) throw new AppException(ErrorCode.LIST_CLASS_EMPTY);
        return result;
    }

    @Override
    public int insertClass(ClassDtoRequest newClass) {
        return classMapper.insertNewClass(ClassConvert.classDtoRequestConvertToClass(newClass));
    }

    @Override
    public int updateClass(ClassDtoRequest updateClass) {
        isExistClass(updateClass.getClassId());
        return classMapper.updateClass(ClassConvert.classDtoRequestConvertToClass(updateClass));
    }

    @Override
    public int deleteClassById(Integer classID) {
        isExistClass(classID);
        return classMapper.deleteClass(classID);
    }


}
