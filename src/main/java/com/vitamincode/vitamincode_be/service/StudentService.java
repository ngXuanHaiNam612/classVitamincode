package com.vitamincode.vitamincode_be.service;

import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.StudentDtoRespone;

import java.util.List;

public interface StudentService {

    //read
    List<StudentDtoRespone> selectAllStudent();
    StudentDtoRespone selectStudentById(Integer id);
    StudentDtoRespone selectStudentByName(String name);
    List<StudentDtoRespone> selectStudentLikeName(String name);

    //create
    int insertStudent(StudentDtoRequest newStudent);

    //update
    int updateStudent(StudentDtoRequest updateStudent);

    //delete
    int deleteStudentById(Integer studentID);




}
