package com.odonto.consultorio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración global de CORS.
 * Antes cada controller tenía (o no) su propio @CrossOrigin, lo que causaba
 * que algunos endpoints (ej. /api/pacientes, /api/citas) fallaran al ser
 * llamados desde el frontend Angular (localhost:4200) por bloqueo de CORS.
 * Con esta clase, TODOS los endpoints /api/** quedan habilitados por igual.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
