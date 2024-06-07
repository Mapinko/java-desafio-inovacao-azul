package com.desafioinovacaoazul.testeeco3.config;

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
                registry.addMapping("/**")
                        .allowedOrigins("*") // Adicione as origens permitidas
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Adicione os métodos permitidos
                        .allowedHeaders("*") // Adicione os cabeçalhos permitidos
                        .allowCredentials(true); // Permitir credenciais
            }
        };
    }
}
