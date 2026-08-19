package com.odonto.consultorio.controller;

import com.odonto.consultorio.model.Odontograma;
import com.odonto.consultorio.model.OdontogramaDetalle;
import com.odonto.consultorio.service.OdontogramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/odontogramas")
@SuppressWarnings("null")
public class OdontogramaController {

    @Autowired
    private OdontogramaService odontogramaService;

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<Odontograma> obtenerPorPaciente(@PathVariable Long pacienteId) {
        if (pacienteId == null) return ResponseEntity.badRequest().build();
        return odontogramaService.obtenerPorPaciente(pacienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Odontograma guardar(@RequestBody Odontograma odontograma) {
        return odontogramaService.guardar(odontograma);
    }

    @GetMapping("/{odontogramaId}/detalles")
    public List<OdontogramaDetalle> obtenerDetalles(@PathVariable Long odontogramaId) {
        return odontogramaService.obtenerDetalles(odontogramaId);
    }

    @PostMapping("/detalles")
    public OdontogramaDetalle agregarDetalle(@RequestBody OdontogramaDetalle detalle) {
        return odontogramaService.agregarDetalle(detalle);
    }

    @DeleteMapping("/detalles/{detalleId}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long detalleId) {
        if (detalleId == null) return ResponseEntity.badRequest().build();
        odontogramaService.eliminarDetalle(detalleId);
        return ResponseEntity.noContent().build();
    }
}