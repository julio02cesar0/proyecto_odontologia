package com.odonto.consultorio.repository;

import com.odonto.consultorio.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByOdontologoId(Long odontologoId);
    List<Cita> findByPacienteId(Long pacienteId);
}