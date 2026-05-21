package com.ppm.corestarter.adivce;
import com.ppm.corestarter.domain.exception.ResourceDuplicateException;
import com.ppm.corestarter.domain.exception.ResourceNotFoundException;
import com.ppm.corestarter.infrastructure.bootstrap.template.response.ValueResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        ValueResponse<?> valueResponse = ValueResponse.exception(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(valueResponse);
    }

    @ExceptionHandler(ResourceDuplicateException.class)
    public ResponseEntity<?> resourceDuplicateExceptionHandler(ResourceDuplicateException e) {
        ValueResponse<?> valueResponse = ValueResponse.exception(e.getMessage(), HttpStatus.CONFLICT);
        return ResponseEntity.ok(valueResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> resourceDuplicateExceptionHandler(NullPointerException e) {
        ValueResponse<?> valueResponse = ValueResponse.exception(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(valueResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> err = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(f -> {
            err.put(f.getField(), f.getDefaultMessage());
        });
        String message = String.join(", ", err.values());
        ValueResponse<?> valueResponse = ValueResponse.exception(message, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(valueResponse);
    }
}
