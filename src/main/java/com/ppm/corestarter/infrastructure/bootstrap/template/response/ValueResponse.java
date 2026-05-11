package com.ppm.corestarter.infrastructure.bootstrap.template.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public record ValueResponse<T>(
        T data,
        Boolean isSuccess,
        String httpStatusCode,
        String message,
        LocalDateTime responseTime
) {
    public static <T> ValueResponse<T> success(T data) {
        return ValueResponse.<T>builder()
                .data(data)
                .isSuccess(true)
                .httpStatusCode(String.valueOf(HttpStatus.OK.value()))
                .message("Dịch vụ thực hiện thành công!")
                .responseTime(LocalDateTime.now())
                .build();
    }

    public static <T> ValueResponse<T> success() {
        return ValueResponse.<T>builder()
                .isSuccess(true)
                .httpStatusCode(String.valueOf(HttpStatus.OK.value()))
                .message("Dịch vụ thực hiện thành công!")
                .responseTime(LocalDateTime.now())
                .build();
    }

    public static <T> ValueResponse<T> exception(String message, HttpStatus status) {
        return ValueResponse.<T>builder()
                .isSuccess(false)
                .httpStatusCode(String.valueOf(status.value()))
                .message(message)
                .responseTime(LocalDateTime.now())
                .build();
    }
}
