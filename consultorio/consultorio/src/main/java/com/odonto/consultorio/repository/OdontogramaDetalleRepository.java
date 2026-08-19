package com.odonto.consultorio.repository;

import com.odonto.consultorio.model.OdontogramaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OdontogramaDetalleRepository extends JpaRepository<OdontogramaDetalle, Long> {
    List<OdontogramaDetalle> findByOdontogramaId(Long odontogramaId);
}