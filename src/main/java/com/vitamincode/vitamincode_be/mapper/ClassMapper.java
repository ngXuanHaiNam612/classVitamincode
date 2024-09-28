package com.vitamincode.vitamincode_be.mapper;

import com.vitamincode.vitamincode_be.entity.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassMapper {
    List<Class> selectAllClass();

    Class selectClassByID(@Param("classID") Integer classID);

    Class selectClassByName(@Param("className") String className);
    List<Class>  selectClassLikeName(@Param("className") String className);


    int insertNewClass(@Param("newClass") Class newClass);

    int updateClass(@Param("updateClass") Class updateClass);

    int deleteClass(@Param("classID") Integer classID);
}
