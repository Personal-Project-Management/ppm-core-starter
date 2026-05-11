package com.ppm.corestarter.infrastructure.bootstrap.utils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.security.SecureRandom;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RandomGenerator {
    static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generate(Integer length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
