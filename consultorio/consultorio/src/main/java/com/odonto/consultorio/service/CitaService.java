package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Cita;
import com.odonto.consultorio.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerPorId(Long id) {
        if (id == null) return Optional.empty();
        return citaRepository.findById(id);
    }

    public List<Cita> listarPorOdontologo(Long odontologoId) {
        if (odontologoId == null) return List.of();
        return citaRepository.findByOdontologoId(odontologoId);
    }

    public List<Cita> listarPorPaciente(Long pacienteId) {
        if (pacienteId == null) return List.of();
        return citaRepository.findByPacienteId(pacienteId);
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public Optional<Cita> actualizar(Long id, Cita datos) {
        if (id == null) return Optional.empty();
        return citaRepository.findById(id).map(c -> {
            c.setPaciente(datos.getPaciente());
            c.setOdontologo(datos.getOdontologo());
            c.setFechaHora(datos.getFechaHora());
            c.setMotivo(datos.getMotivo());
            c.setEstado(datos.getEstado());
            c.setNotas(datos.getNotas());
            return citaRepository.save(c);
        });
    }

    public boolean eliminar(Long id) {
        if (id != null && citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}