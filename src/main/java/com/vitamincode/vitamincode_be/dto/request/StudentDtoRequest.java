package com.vitamincode.vitamincode_be.dto.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDtoRequest {
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private Integer classId;
}
