package com.nuvalance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MyRectangleServiceException extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public MyRectangleServiceException() { super(); }
    public MyRectangleServiceException(String message) { super(message); }
    public MyRectangleServiceException(Throwable throwable) { super(throwable); }
    public MyRectangleServiceException(String message, Throwable throwable) { super(message, throwable); }
}
