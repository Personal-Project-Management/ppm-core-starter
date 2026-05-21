package com.ppm.corestarter.infrastructure.bootstrap.configuration.aware;

import com.ppm.corestarter.infrastructure.bootstrap.configuration.provider.CurrentAuditorProvider;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BaseAuditorAware implements AuditorAware<String> {
    CurrentAuditorProvider currentAuditorProvider;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(currentAuditorProvider.getCurrentAuditor());
    }
}
