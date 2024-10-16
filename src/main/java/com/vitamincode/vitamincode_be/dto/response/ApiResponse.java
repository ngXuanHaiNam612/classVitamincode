package com.vitamincode.vitamincode_be.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T>{
    private Integer status;
    private Boolean success;
    private T data;
    private String message;
}
