package com.vitamincode.vitamincode_be.exception;

import com.vitamincode.vitamincode_be.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandling {

    private void logError(Exception e, HttpServletRequest request) {
        log.error("Fail to call API" + request.getRequestURI() + " : " +e);
    }


    // Bad SQL Grammar
    @ExceptionHandler(value = BadSqlGrammarException.class)
    ResponseEntity<ApiResponse> handleBadSQLGrammarRequestException(BadSqlGrammarException e, HttpServletRequest request) {

       logError(e, request);

        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                .status(ErrorCode.BAD_SQL.getStatus())
                .success(false)
                .message(ErrorCode.BAD_SQL.getMessage())
                .build());
    }


    //Null pointer
    @ExceptionHandler(value = NullPointerException.class)
    ResponseEntity<ApiResponse> handleNullPointerException(NullPointerException e, HttpServletRequest request) {

        logError(e, request);

        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .status(ErrorCode.NULL_POINTER_EXCEPTION.getStatus())
                        .success(false)
                        .message(ErrorCode.NULL_POINTER_EXCEPTION.getMessage())
                        .build());
    }




    //Unknown error
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handleUncatchException(Exception e, HttpServletRequest request) {

        logError(e, request);

        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .status(ErrorCode.UNCATCH_EXCEPTION.getStatus())
                        .success(false)
                        .message(e.getClass().getSimpleName())
                        .build());
    }


}
