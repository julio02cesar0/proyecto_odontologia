package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Atencion;
import com.odonto.consultorio.repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    public List<Atencion> listarTodas() {
        return atencionRepository.findAll();
    }

    public Optional<Atencion> obtenerPorId(Long id) {
        if (id == null) return Optional.empty();
        return atencionRepository.findById(id);
    }

    public Optional<Atencion> obtenerPorCita(Long citaId) {
        if (citaId == null) return Optional.empty();
        return atencionRepository.findByCitaId(citaId);
    }

    public Atencion guardar(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    public boolean eliminar(Long id) {
        if (id != null && atencionRepository.existsById(id)) {
            atencionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}