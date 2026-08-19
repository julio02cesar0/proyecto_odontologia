package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Rol;
import com.odonto.consultorio.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorNombre(String nombre) {
        if (nombre == null) return Optional.empty();
        return rolRepository.findByNombre(nombre);
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }
}