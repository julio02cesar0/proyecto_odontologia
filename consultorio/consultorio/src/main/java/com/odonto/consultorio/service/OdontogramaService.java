package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Odontograma;
import com.odonto.consultorio.model.OdontogramaDetalle;
import com.odonto.consultorio.repository.OdontogramaDetalleRepository;
import com.odonto.consultorio.repository.OdontogramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class OdontogramaService {

    @Autowired
    private OdontogramaRepository odontogramaRepository;

    @Autowired
    private OdontogramaDetalleRepository detalleRepository;

    public Optional<Odontograma> obtenerPorPaciente(Long pacienteId) {
        if (pacienteId == null) return Optional.empty();
        return odontogramaRepository.findByPacienteId(pacienteId);
    }

    public Odontograma guardar(Odontograma odontograma) {
        return odontogramaRepository.save(odontograma);
    }

    public List<OdontogramaDetalle> obtenerDetalles(Long odontogramaId) {
        return detalleRepository.findByOdontogramaId(odontogramaId);
    }

    public OdontogramaDetalle agregarDetalle(OdontogramaDetalle detalle) {
        return detalleRepository.save(detalle);
    }

    public void eliminarDetalle(Long detalleId) {
        if (detalleId != null && detalleRepository.existsById(detalleId)) {
            detalleRepository.deleteById(detalleId);
        }
    }
}