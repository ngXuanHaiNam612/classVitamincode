package com.vitamincode.vitamincode_be.convert;

import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.StudentDtoRespone;
import com.vitamincode.vitamincode_be.entity.Student;

import java.util.List;

public class StudentConvert {

    public static StudentDtoRespone studentEntityConvertToStudentRespone(Student studentEntity){

        return StudentDtoRespone.builder()
                .studentId(studentEntity.getStudentId())
                .studentName(studentEntity.getStudentName())
                .studentEmail(studentEntity.getStudentEmail())
                .classId(studentEntity.getClassId())
                .build();
    }

    public static List<StudentDtoRespone> listStudentEntityConvertToListStudentRespone(List<Student> listStudentEntity){
        return listStudentEntity
                .stream()
                .map(StudentConvert::studentEntityConvertToStudentRespone)
                .toList();

    }

    public static Student studentDtoRequestConvertToStudentEntity(StudentDtoRequest studentDtoRequest){

        return Student.builder()
                .studentId(studentDtoRequest.getStudentId())
                .studentName(studentDtoRequest.getStudentName())
                .studentEmail(studentDtoRequest.getStudentEmail())
                .classId(studentDtoRequest.getClassId())
                .build();
    }

    public static List<Student> listStudentDtoRequestConvertToListStudentEntity(List<StudentDtoRequest> listStudentDtoRequest){

        return listStudentDtoRequest
                .stream()
                .map(StudentConvert::studentDtoRequestConvertToStudentEntity)
                .toList();
    }
}
