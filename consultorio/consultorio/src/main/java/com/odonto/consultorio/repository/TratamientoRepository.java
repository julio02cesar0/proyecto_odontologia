package com.odonto.consultorio.repository;

import com.odonto.consultorio.model.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
}