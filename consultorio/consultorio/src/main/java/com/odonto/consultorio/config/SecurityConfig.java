package com.odonto.consultorio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Provee el PasswordEncoder (BCrypt) usado por UsuarioService para
 * hashear las contraseñas antes de guardarlas.
 * NOTA: esto NO activa Spring Security como filtro web (no exige login
 * en los endpoints). Solo agrega la herramienta de hashing.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
