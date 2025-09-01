package com.santi.crudalumnos.controller;

import com.santi.crudalumnos.entity.asignatura;
import com.santi.crudalumnos.service.Asignaturaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class Asignaturacontroller {

    @Autowired
    private Asignaturaservice asignaturaservice;


    @PostMapping
    public asignatura createasignatura(@RequestBody asignatura asignatura) {
        return asignaturaservice.saveasignatura(asignatura);
    }


    @GetMapping
    public List<asignatura> getAllasignaturas() {
        return asignaturaservice.getAllasignaturas();
    }


    @GetMapping("/{id}")
    public ResponseEntity<asignatura> getAsignaturaById(@PathVariable Long id) {
        Optional<asignatura> asignatura = asignaturaservice.getasignaturaById(id);
        return asignatura.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignaturaDetails) {
        try {
            asignatura updatedasignatura = asignaturaservice.updateasignatura(id, asignaturaDetails);
            return ResponseEntity.ok(updatedasignatura);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


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
