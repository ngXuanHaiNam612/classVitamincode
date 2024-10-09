package com.vitamincode.vitamincode_be.mapper;

import com.vitamincode.vitamincode_be.entity.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassMapper {
    List<Class> selectAllClass();
    List<Class> selectClassByID(@Param("id") Integer classID);
    Class selectClassByName(@Param("name") String className);
    List<Class>selectClassLikeName(@Param("name") String className);


    int insertNewClass(@Param("newClass") Class newClass);

    int updateClass(@Param("updateClass") Class updateClass);

    int deleteClass(@Param("id") Integer classID);

    boolean isClassExist(@Param("id") Integer classID);
}
