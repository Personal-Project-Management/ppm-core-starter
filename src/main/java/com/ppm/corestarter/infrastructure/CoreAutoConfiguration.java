package com.ppm.corestarter.infrastructure;

import com.ppm.corestarter.adivce.GlobalExceptionHandler;
import com.ppm.corestarter.infrastructure.bootstrap.configuration.aware.BaseAuditorAware;
import com.ppm.corestarter.infrastructure.bootstrap.configuration.provider.CurrentAuditorProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class CoreAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public CurrentAuditorProvider currentAuditorProvider() {
        return () -> "System";
    }

    @Bean
    @ConditionalOnMissingBean
    public BaseAuditorAware baseAuditorAware(CurrentAuditorProvider currentAuditorProvider) {
        return new BaseAuditorAware(currentAuditorProvider);
    }

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
