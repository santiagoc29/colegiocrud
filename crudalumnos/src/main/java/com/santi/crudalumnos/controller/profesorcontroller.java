package com.santi.crudalumnos.controller;

import com.santi.crudalumnos.entity.Profesor;
import com.santi.crudalumnos.service.profesorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class profesorcontroller {

    @Autowired
    private profesorservice profesorservice;

    // CREATE - Crear nuevo profesor
    @PostMapping
    public Profesor createprofesor(@RequestBody Profesor profesor) {
        return profesorservice.saveprofesor(profesor);
    }

    // READ ALL - Obtener todos los profesores
    @GetMapping
    public List<Profesor> getAllprofesores() {
        return profesorservice.getAllprofesores();
    }

    // READ BY ID - Obtener profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorservice.getprofesorById(id);
        return profesor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Actualizar profesor
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable Long id, @RequestBody Profesor profesorDetails) {
        try {
            Profesor updatedprofesor = profesorservice.updateprofesor(id, profesorDetails);
            return ResponseEntity.ok(updatedprofesor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteprofesor(@PathVariable Long id
