package com.vitamincode.vitamincode_be.mapper;

import com.vitamincode.vitamincode_be.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectAllStudent();
    Student selectStudentByID(@Param("id")Integer studentID);
    Student selectStudentByName(@Param("name") String studentName);
    List<Student> selectStudentLikeName(@Param("name") String studentName);
    int insertStudent(@Param("student")Student student);
    int updateStudent(@Param("student")Student student);
    int deleteStudent(@Param("id")Integer studentID);

}
