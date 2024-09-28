package com.vitamincode.vitamincode_be.dto.response;


import lombok.*;

@Getter
@Setter
@Builder
public class ClassDtoResponse {
    private Integer classId;
    private String className;
    private String classDescription;
}
