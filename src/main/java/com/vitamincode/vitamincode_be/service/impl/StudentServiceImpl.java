package com.vitamincode.vitamincode_be.service.impl;

import com.vitamincode.vitamincode_be.convert.StudentConvert;
import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.StudentDtoRespone;
import com.vitamincode.vitamincode_be.entity.Student;
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
        var result = StudentConvert.listStudentEntityConvertToListStudentRespone(studentMapper.selectAllStudent());
        if(!result.isEmpty()){
            return result;
        }
        return null;
    }

    @Override
    public Student selectStudentById(Integer id) {
        var result = studentMapper.selectStudentByID(id);
        if(!Objects.isNull(result)){
            return result;
        }
        return null;
    }

    @Override
    public Student selectStudentByName(String name) {
        var result = studentMapper.selectStudentByName(name);
        if(!Objects.isNull(result)){
            return result;
        }
        return null;
    }

    @Override
    public List<StudentDtoRespone> selectStudentLikeName(String name) {
        var result = StudentConvert.listStudentEntityConvertToListStudentRespone(studentMapper.selectStudentLikeName(name));
        if(!result.isEmpty()){
            return result;
        }
        return null;
    }

    @Override
    public int insertStudent(StudentDtoRequest newStudent) {
        return studentMapper.insertStudent(StudentConvert.studentDtoRequestConvertToStudentEntity(newStudent));
    }

    @Override
    public int updateStudent(StudentDtoRequest updateStudent) {
        return studentMapper.updateStudent(StudentConvert.studentDtoRequestConvertToStudentEntity(updateStudent));
    }

    @Override
    public int deleteStudentById(Integer studentID) {
        return studentMapper.deleteStudent(studentID);
    }
}
