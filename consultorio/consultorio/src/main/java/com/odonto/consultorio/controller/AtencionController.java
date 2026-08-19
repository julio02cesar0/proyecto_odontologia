package com.odonto.consultorio.controller;

import com.odonto.consultorio.model.Atencion;
import com.odonto.consultorio.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atenciones")
@SuppressWarnings("null")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public List<Atencion> listarTodas() {
        return atencionService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> obtenerPorId(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().build();
        return atencionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cita/{citaId}")
    public ResponseEntity<Atencion> obtenerPorCita(@PathVariable Long citaId) {
        if (citaId == null) return ResponseEntity.badRequest().build();
        return atencionService.obtenerPorCita(citaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Atencion guardar(@RequestBody Atencion atencion) {
        return atencionService.guardar(atencion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().build();
        if (atencionService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}