package com.marcelo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //
                .allowedOrigins("*") 
                .allowedMethods("*")
                .allowedHeaders("*");
              
    }
}

/*
 * 
 *     @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //
                .allowedOrigins("http://localhost:9001", "http://localhost:9000") 
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .allowCredentials(false)
                .maxAge(3600);
              
    }
 */



