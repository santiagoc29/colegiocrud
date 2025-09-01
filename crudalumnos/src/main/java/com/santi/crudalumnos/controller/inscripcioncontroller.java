package com.santi.crudalumnos.controller;

import com.santi.crudalumnos.entity.Inscripcion;
import com.santi.crudalumnos.service.inscripcionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones")
public class inscripcioncontroller {

    @Autowired
    private inscripcionservice inscripcionservice;

    // CREATE - Crear nueva inscripción
    @PostMapping
    public Inscripcion createinscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionservice.saveinscripcion(inscripcion);
    }

    // READ ALL - Obtener todas las inscripciones
    @GetMapping
    public List<Inscripcion> getAllinscripciones() {
        return inscripcionservice.getAllinscripciones();
    }

    // READ BY ID - Obtener inscripción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getInscripcionById(@PathVariable Long id) {
        Optional<Inscripcion> inscripcion = inscripcionservice.getinscripcionById(id);
        return inscripcion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Actualizar inscripción
    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> updateInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcionDetails) {
        try {
            Inscripcion updatedinscripcion = inscripcionservice.updateinscripcion(id, inscripcionDetails);
            return ResponseEntity.ok(updatedinscripcion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar inscripción
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteinscripcion(@PathVariable Long id) {
        try {
            inscripcionservice.deleteinscripcion(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
