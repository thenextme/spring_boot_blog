package com.betatq.blog.exceptions;

import org.osgi.resource.Resource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionError handleResourceNotFound(ResourceNotFoundException e) {
        ExceptionError error = new ExceptionError(
                404,
                e.getMessage(),
                Instant.now()
        );
        // log exception as it is internally
        return error;
    }

    @ExceptionHandler(Exception.class)
    public ExceptionError handleAll(Exception e) {
       ExceptionError error = new ExceptionError(
               500,
               "Internal Server Error",
               Instant.now()
       );
       return error;
    }
}
