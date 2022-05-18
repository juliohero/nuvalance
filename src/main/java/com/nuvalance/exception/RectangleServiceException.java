package com.nuvalance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RectangleServiceException extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public RectangleServiceException() { super(); }
    public RectangleServiceException(String message) { super(message); }
    public RectangleServiceException(Throwable throwable) { super(throwable); }
    public RectangleServiceException(String message, Throwable throwable) { super(message, throwable); }
}
