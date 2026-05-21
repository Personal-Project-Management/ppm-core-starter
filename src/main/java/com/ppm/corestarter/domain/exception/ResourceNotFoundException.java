package com.ppm.corestarter.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super();
    }
}
