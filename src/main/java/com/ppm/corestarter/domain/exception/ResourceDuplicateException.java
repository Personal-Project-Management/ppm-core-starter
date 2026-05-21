package com.ppm.corestarter.domain.exception;

public class ResourceDuplicateException extends RuntimeException {
    public ResourceDuplicateException(String message) {
        super(message);
    }

    public ResourceDuplicateException() {
        super();
    }
}
