package com.vitamincode.vitamincode_be.convert;

import com.vitamincode.vitamincode_be.dto.request.StudentDtoRequest;
import com.vitamincode.vitamincode_be.dto.response.StudentDtoRespone;
import com.vitamincode.vitamincode_be.entity.Student;

import java.util.List;

public class StudentConvert {

    public static StudentDtoRespone studentEntityConvertToStudentResponse(Student studentEntity){

        return StudentDtoRespone.builder()
                .studentId(studentEntity.getStudentId())
                .studentName(studentEntity.getStudentName())
                .studentEmail(studentEntity.getStudentEmail())
                .classId(studentEntity.getClassId())
                .build();
    }

    public static List<StudentDtoRespone> listStudentEntityConvertToListStudentResponse(List<Student> listStudentEntity){
        return listStudentEntity
                .stream()
                .map(StudentConvert::studentEntityConvertToStudentResponse)
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

}
