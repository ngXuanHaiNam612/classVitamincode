package com.vitamincode.vitamincode_be.service;

import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.StudentDtoRespone;
import com.vitamincode.vitamincode_be.entity.Student;

import java.util.List;

public interface StudentService {

    //read
    List<StudentDtoRespone> selectAllStudent();
    Student selectStudentById(Integer id);
    Student selectStudentByName(String name);
    List<StudentDtoRespone> selectStudentLikeName(String name);

    //create
    int insertStudent(StudentDtoRequest newStudent);

    //update
    int updateStudent(StudentDtoRequest updateStudent);

    //delete
    int deleteStudentById(Integer studentID);




}
