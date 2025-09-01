package com.santi.crudalumnos.controller;

import com.santi.crudalumnos.entity.Alumno;
import com.santi.crudalumnos.service.Alumnoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class Alumnocontroller {

    @Autowired
    private Alumnoservice alumnoservice;


    @PostMapping
    public Alumno createalumno(@RequestBody Alumno alumno) {
        return alumnoservice.savealumno(alumno);
    }


    @GetMapping
    public List<Alumno> getAllalumnos() {
        return alumnoservice.getAllalumnos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoservice.getalumnoById(id);
        return alumno.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        try {
            Alumno updatedalumno = alumnoservice.updatealumno(id, alumnoDetails);
            return ResponseEntity.ok(updatedalumno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletealumno(@PathVariable Long id) {
        try {
            alumnoservice.deletealumno(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}