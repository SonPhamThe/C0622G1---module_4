package com.example.form_registration.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.spi.ResourceBundleControlProvider;
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
