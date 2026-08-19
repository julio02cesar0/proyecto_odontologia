package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Odontologo;
import com.odonto.consultorio.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    public List<Odontologo> listarTodos() {
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> obtenerPorId(Long id) {
        if (id == null) return Optional.empty();
        return odontologoRepository.findById(id);
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> actualizar(Long id, Odontologo datos) {
        if (id == null) return Optional.empty();
        return odontologoRepository.findById(id).map(o -> {
            o.setNombre(datos.getNombre());
            o.setApellido(datos.getApellido());
            o.setDocumento(datos.getDocumento());
            o.setEspecialidad(datos.getEspecialidad());
            o.setTelefono(datos.getTelefono());
            o.setEstado(datos.getEstado());
            return odontologoRepository.save(o);
        });
    }

    public boolean eliminar(Long id) {
        if (id != null && odontologoRepository.existsById(id)) {
            odontologoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}