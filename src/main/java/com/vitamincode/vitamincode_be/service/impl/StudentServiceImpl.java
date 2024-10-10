package com.vitamincode.vitamincode_be.service.impl;

import com.vitamincode.vitamincode_be.convert.StudentConvert;
import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.StudentDtoRespone;
import com.vitamincode.vitamincode_be.exception.AppException;
import com.vitamincode.vitamincode_be.enums.ErrorCode;
import com.vitamincode.vitamincode_be.mapper.StudentMapper;
import com.vitamincode.vitamincode_be.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Override
    public List<StudentDtoRespone> selectAllStudent() {
        var result = StudentConvert.listStudentEntityConvertToListStudentResponse(studentMapper.selectAllStudent());
        if(result.isEmpty()) throw  new AppException(ErrorCode.LIST_STUDENT_EMPTY);
        return result;
    }

    @Override
    public  List<StudentDtoRespone> selectStudentById(Integer id) {
        var result = StudentConvert.listStudentEntityConvertToListStudentResponse(studentMapper.selectStudentByID(id));
        if(result.isEmpty()) throw new AppException(ErrorCode.NO_STUDENT_WITH_THIS_ID);
        return result;
    }

    @Override
    public StudentDtoRespone selectStudentByName(String name) {
        var result = StudentConvert.studentEntityConvertToStudentResponse(studentMapper.selectStudentByName(name));
        if(Objects.isNull(result)) throw new AppException(ErrorCode.STUDENT_EMPTY);
        return result;
    }

    @Override
    public List<StudentDtoRespone> selectStudentLikeName(String name) {
        var result = StudentConvert.listStudentEntityConvertToListStudentResponse(studentMapper.selectStudentLikeName(name));
        if(result.isEmpty()) throw new AppException(ErrorCode.LIST_STUDENT_EMPTY);
        return result;
    }

    @Override
    public int saveStudent(StudentDtoRequest studentDtoRequest) {
        var entity = StudentConvert.studentDtoRequestConvertToStudentEntity(studentDtoRequest);
        Integer id = studentDtoRequest.getStudentId();
        if(studentMapper.isStudentExist(id)){
            return studentMapper.updateStudent(entity);
        }
        return studentMapper.insertStudent(entity);

    }


    @Override
    public int deleteStudentById(Integer studentID) {
        return studentMapper.deleteStudent(studentID);
    }
}
