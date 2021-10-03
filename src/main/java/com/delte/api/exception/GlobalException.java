package com.delte.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @Author rohit
 * @Date 04/10/21
 **/
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NullPointerException.class})
    public final ResponseEntity<ErrorDetails<Object>> handleAllExceptions(Exception ex, WebRequest request) {
        ex.printStackTrace();
        ErrorDetails<Object> errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .trace(ex.getStackTrace()[0])
                .details(request.getDescription(false))
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({ExpenseException.class})
    public final ResponseEntity<ErrorDetails<Object>> ExpenseExceptions(Exception ex, WebRequest request) {
        ex.printStackTrace();
        ErrorDetails<Object> errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .message("something went wrong")
                .trace(ex.getStackTrace()[0])
                .details(request.getDescription(false))
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
