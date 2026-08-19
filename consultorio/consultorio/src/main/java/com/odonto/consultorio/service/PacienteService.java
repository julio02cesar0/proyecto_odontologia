package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Paciente;
import com.odonto.consultorio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> obtenerPorId(Long id) {
        if (id == null) return Optional.empty();
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> obtenerPorDocumento(String documento) {
        if (documento == null) return Optional.empty();
        return pacienteRepository.findByDocumento(documento);
    }

    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> actualizar(Long id, Paciente datos) {
        if (id == null) return Optional.empty();
        return pacienteRepository.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            p.setApellido(datos.getApellido());
            p.setDocumento(datos.getDocumento());
            p.setFechaNacimiento(datos.getFechaNacimiento());
            p.setTelefono(datos.getTelefono());
            p.setEmail(datos.getEmail());
            p.setAlergias(datos.getAlergias());
            return pacienteRepository.save(p);
        });
    }

    public boolean eliminar(Long id) {
        if (id != null && pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}