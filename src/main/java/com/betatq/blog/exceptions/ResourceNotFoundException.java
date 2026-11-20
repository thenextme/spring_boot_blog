package com.betatq.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public static final String MESSAGE = "Resource Not Found";

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
