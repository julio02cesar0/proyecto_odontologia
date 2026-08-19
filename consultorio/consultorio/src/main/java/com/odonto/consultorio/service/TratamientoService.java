package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Tratamiento;
import com.odonto.consultorio.repository.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<Tratamiento> listarTodos() {
        return tratamientoRepository.findAll();
    }

    public Optional<Tratamiento> obtenerPorId(Long id) {
        if (id == null) return Optional.empty();
        return tratamientoRepository.findById(id);
    }

    public Tratamiento guardar(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Optional<Tratamiento> actualizar(Long id, Tratamiento datos) {
        if (id == null) return Optional.empty();
        return tratamientoRepository.findById(id).map(t -> {
            t.setNombre(datos.getNombre());
            t.setDescripcion(datos.getDescripcion());
            t.setCostoBase(datos.getCostoBase());
            t.setDuracionEstimadaMin(datos.getDuracionEstimadaMin());
            return tratamientoRepository.save(t);
        });
    }

    public boolean eliminar(Long id) {
        if (id != null && tratamientoRepository.existsById(id)) {
            tratamientoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}