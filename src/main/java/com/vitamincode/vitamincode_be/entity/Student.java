package com.vitamincode.vitamincode_be.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Student {
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private Integer classId;
}
