package com.example.demodds.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration

public class ApplicationConfig {
    @Bean
    public MessageSource mesaMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("ValidateMessage");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
