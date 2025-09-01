package com.santi.crudalumnos.controller;

import com.santi.crudalumnos.entity.Asignatura;
import com.santi.crudalumnos.service.asignaturaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class asignaturacontroller {

    @Autowired
    private asignaturaservice asignaturaservice;

    // CREATE - Crear nueva asignatura
    @PostMapping
    public Asignatura createasignatura(@RequestBody Asignatura asignatura) {
        return asignaturaservice.saveasignatura(asignatura);
    }

    // READ ALL - Obtener todas las asignaturas
    @GetMapping
    public List<Asignatura> getAllasignaturas() {
        return asignaturaservice.getAllasignaturas();
    }

    // READ BY ID - Obtener asignatura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable Long id) {
        Optional<Asignatura> asignatura = asignaturaservice.getasignaturaById(id);
        return asignatura.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Actualizar asignatura
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignaturaDetails) {
        try {
            Asignatura updatedasignatura = asignaturaservice.updateasignatura(id, asignaturaDetails);
            return ResponseEntity.ok(updatedasignatura);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar asignatura
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteasignatura(@PathVariable Long id) {
        try {
            asignaturaservice.deleteasignatura(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
