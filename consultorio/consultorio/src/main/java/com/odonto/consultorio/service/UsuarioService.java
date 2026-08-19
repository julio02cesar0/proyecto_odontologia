package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Usuario;
import com.odonto.consultorio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        if (id == null) return Optional.empty();
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerPorEmail(String email) {
        if (email == null) return Optional.empty();
        return usuarioRepository.findByEmail(email);
    }

    public Usuario guardar(Usuario usuario) {
        // Nunca se guarda la contraseña en texto plano: se hashea con BCrypt.
        // Si ya viene hasheada (ej. actualizando otros campos), evitamos
        // volver a hashear un hash comparando el prefijo típico de BCrypt.
        String pass = usuario.getPasswordHash();
        if (pass != null && !pass.startsWith("$2a$") && !pass.startsWith("$2b$")) {
            usuario.setPasswordHash(passwordEncoder.encode(pass));
        }
        return usuarioRepository.save(usuario);
    }

    public boolean existePorEmail(String email) {
        if (email == null) return false;
        return usuarioRepository.existsByEmail(email);
    }
}