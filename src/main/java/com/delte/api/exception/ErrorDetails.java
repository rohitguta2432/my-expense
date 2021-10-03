package com.delte.api.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author rohit
 * @Date 04/10/21
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails<T> {
    private Date timestamp;
    private String message;
    private T details;
    private Integer code;
    private StackTraceElement trace;
}
