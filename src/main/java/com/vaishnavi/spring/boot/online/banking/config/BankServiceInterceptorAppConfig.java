package com.vaishnavi.spring.boot.online.banking.config;

import com.vaishnavi.spring.boot.online.banking.interceptor.BankServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class BankServiceInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    private BankServiceInterceptor bankServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bankServiceInterceptor)
                .addPathPatterns("/api/**"); // Apply to all banking API endpoints
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Allow CORS for all paths
                        .allowedOrigins("http://localhost:8080") // Adjust if frontend runs on different port or domain
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

