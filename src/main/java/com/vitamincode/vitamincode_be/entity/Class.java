package com.vitamincode.vitamincode_be.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Class {
    private Integer classId;
    private String className;
    private String classDescription;
}
