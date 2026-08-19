package com.odonto.consultorio.repository;

import com.odonto.consultorio.model.Odontograma;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OdontogramaRepository extends JpaRepository<Odontograma, Long> {
    Optional<Odontograma> findByPacienteId(Long pacienteId);
}