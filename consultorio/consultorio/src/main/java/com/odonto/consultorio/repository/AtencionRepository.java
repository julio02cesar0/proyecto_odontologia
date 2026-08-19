package com.odonto.consultorio.repository;

import com.odonto.consultorio.model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {
    Optional<Atencion> findByCitaId(Long citaId);
}