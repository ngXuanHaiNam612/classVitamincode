package com.vitamincode.vitamincode_be.dto.request;


import lombok.*;

@Getter
@Setter
@Builder
public class ClassDtoRequest {
    private Integer classId;
    private String className;
    private String classDescription;
}
