package com.odonto.consultorio.repository;

import com.odonto.consultorio.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    Optional<Odontologo> findByDocumento(String documento);
}