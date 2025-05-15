package org.exam.diemprojectsbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // tillad CORS på alle endpoints
                        .allowedOrigins("http://localhost:63342") // din frontend origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // tillad disse metoder
                        .allowedHeaders("*");
            }
        };
    }
}