package com.ppm.corestarter.infrastructure.bootstrap.utils;

import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class SorterUtils {
    public static Sort of(String sorter) {
        if (!StringUtils.hasText(sorter)) {
            return Sort.unsorted();
        }
        String[] splits  = sorter.split("_");
        if (Objects.equals(splits.length, 2)) {
            if(Objects.equals(splits[1], "desc")) {
                return Sort.by(splits[0]).descending();
            }
            if (Objects.equals(splits[1], "asc")) {
                return Sort.by(splits[0]).ascending();
            }
        }

        return Sort.unsorted();
    }
}
