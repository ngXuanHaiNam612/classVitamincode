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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassServiceImpl implements ClassService {

    private final ClassMapper classMapper;

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

//    @Override
//    public int insertClass(ClassDtoRequest newClass) {
//        return classMapper.insertNewClass(ClassConvert.classDtoRequestConvertToClass(newClass));
//    }
//
//    @Override
//    public int updateClass(ClassDtoRequest updateClass) {
//        return classMapper.updateClass(ClassConvert.classDtoRequestConvertToClass(updateClass));
//    }

    @Override
    public int saveClass(ClassDtoRequest classDtoRequest) {
        var entity = ClassConvert.classDtoRequestConvertToClass(classDtoRequest);
        Integer id = entity.getClassId();

        if (classMapper.isClassExist(id)) {
            log.error( "" + classMapper.isClassExist(id));
            log.error("exist");
            return classMapper.updateClass(entity);
        }
        log.error("not exist");
        return classMapper.insertNewClass(entity);
    }

    @Override
    public int deleteClassById(Integer classID) {
        return classMapper.deleteClass(classID);
    }




}
