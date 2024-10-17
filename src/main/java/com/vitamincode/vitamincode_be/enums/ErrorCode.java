package com.vitamincode.vitamincode_be.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_SQL(500, "Bad SQL! Check lại SQL"),
    UNCATCH_EXCEPTION(501, "Uncatch exception! không bắt được ngoại lệ"),
    NULL_POINTER_EXCEPTION(503, "Null Pointer! dữ liệu trả về trống"),

    LIST_USER_EMPTY(1000, "List user is empty!"),
    PASSWORD_INCORRECT(1001, "Password incorrect!"),
    USER_NOT_FOUND(1002, "User not found!"),
    INVALID_TOKEN(1003, "Invalid token!"),


    LIST_CLASS_EMPTY(2000, "List classes is empty!"),
    CLASS_EMPTY(2001, "Class is empty!"),
    NO_CLASS_WITH_THIS_ID(2002, "There's no class with this id!"),


    LIST_STUDENT_EMPTY(3000, "List students is empty!"),
    STUDENT_EMPTY(33001, "Student is empty!"),
    NO_STUDENT_WITH_THIS_ID(3002, "There's no student with this id!"),


    HTTP_STATUS_200(200, "ok"),
    HTTP_STATUS_400(400, "request error"),
    HTTP_STATUS_401(401, "no authentication"),
    HTTP_STATUS_403(403, "no authorities"),
    HTTP_STATUS_500(500, "server error");


    private final Integer status;
    private final String message;

}
