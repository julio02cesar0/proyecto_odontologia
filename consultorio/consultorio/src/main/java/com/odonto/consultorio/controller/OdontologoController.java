package com.odonto.consultorio.controller;

import com.odonto.consultorio.model.Odontologo;
import com.odonto.consultorio.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/odontologos")
@SuppressWarnings("null")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public List<Odontologo> listarTodos() {
        return odontologoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> obtenerPorId(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().build();
        return odontologoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Odontologo guardar(@Valid @RequestBody Odontologo odontologo) {
        return odontologoService.guardar(odontologo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> actualizar(@PathVariable Long id, @Valid @RequestBody Odontologo datos) {
        if (id == null) return ResponseEntity.badRequest().build();
        return odontologoService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().build();
        if (odontologoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}