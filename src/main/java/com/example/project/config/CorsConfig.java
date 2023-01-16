package com.example.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/user").allowedOrigins("*");
                registry.addMapping("/books").allowedOrigins("*");
                registry.addMapping("/review").allowedOrigins("*");
                registry.addMapping("/\"/**\"").allowedOrigins("http://localhost:4200");

            }
        };
    }

}
