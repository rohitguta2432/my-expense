package com.delte.api.exception;

/**
 * @Author rohit
 * @Date 04/10/21
 **/
public class ExpenseException extends RuntimeException {

    private static final long serialVersionUID = 2771174581631905388L;


    public ExpenseException() {
    }

    public ExpenseException(String message) {
        super(message);
    }

    public ExpenseException(Throwable cause) {
        super(cause);
    }

    public ExpenseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpenseException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
