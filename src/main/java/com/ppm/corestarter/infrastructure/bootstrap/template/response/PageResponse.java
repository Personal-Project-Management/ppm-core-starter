package com.ppm.corestarter.infrastructure.bootstrap.template.response;

import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PageResponse<T>(
        List<T> data,
        Metadata metadata,
        Boolean isSuccess,
        String httpStatusCode,
        String message,
        LocalDateTime responseTime
) {
    @Builder
    public record  Metadata(
            Long totalElements,
            String sortBy,
            Integer current,
            Integer pageSize
    ) {}

    public static <T> PageResponse<T> success(Page<T> page) {
        Metadata metadata1 = Metadata.builder()
                .totalElements(page.getTotalElements())
                .sortBy(page.getPageable().getSort().toString())
                .current(page.getNumber())
                .pageSize(page.getSize())
                .build();
        return PageResponse.<T>builder()
                .data(page.getContent())
                .metadata(metadata1)
                .isSuccess(true)
                .httpStatusCode(String.valueOf(HttpStatus.OK.value()))
                .message("Dịch vụ thực hiện thành công!")
                .responseTime(LocalDateTime.now())
                .build();
    }
}
