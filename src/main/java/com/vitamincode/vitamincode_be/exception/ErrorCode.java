package com.vitamincode.vitamincode_be.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_SQL(500, "Bad SQL! Check lại SQL"),
    UNCATCH_EXCEPTION(501, "Uncatch exception! không bắt được ngoại lệ"),
    NULL_POINTER_EXCEPTION(503, "Null Pointer! dữ liệu trả về trống"),

    LIST_CLASS_EMPTY(1000, "List classes is empty!"),
    CLASS_EMPTY(1001, "Class is empty!"),
    NO_CLASS_WITH_THIS_ID(1002, "There's no class with this id!"),


    LIST_STUDENT_EMPTY(2000, "List students is empty!"),
    STUDENT_EMPTY(2001, "Student is empty!"),
    NO_STUDENT_WITH_THIS_ID(2002, "There's no student with this id!"),


    HTTP_STATUS_200(200, "ok"),
    HTTP_STATUS_400(400, "request error"),
    HTTP_STATUS_401(401, "no authentication"),
    HTTP_STATUS_403(403, "no authorities"),
    HTTP_STATUS_500(500, "server error");


    private final Integer status;
    private final String message;
}
