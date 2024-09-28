package com.vitamincode.vitamincode_be.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_SQL(500, "Bad SQL! Check lại SQL"),
    UNCATCH_EXCEPTION(501, "Uncatch exception! không bắt được ngoại lệ"),
    LIST_CLASS_EMPTY(1000, "List class is empty!");
    private final Integer status;
    private final String message;
}
