package com.odonto.consultorio.controller;

import com.odonto.consultorio.model.Tratamiento;
import com.odonto.consultorio.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamientos")
@SuppressWarnings("null")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping
    public List<Tratamiento> listarTodos() {
        return tratamientoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> obtenerPorId(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().build();
        return tratamientoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tratamiento guardar(@Valid @RequestBody Tratamiento tratamiento) {
        return tratamientoService.guardar(tratamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> actualizar(@PathVariable Long id, @Valid @RequestBody Tratamiento datos) {
        if (id == null) return ResponseEntity.badRequest().build();
        return tratamientoService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().build();
        if (tratamientoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}