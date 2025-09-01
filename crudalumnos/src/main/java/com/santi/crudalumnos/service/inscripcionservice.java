package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.inscripcion;
import com.santi.crudalumnos.repository.inscripcionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class inscripcionservice {

    @Autowired
    private inscripcionrepository inscripcionrepository;

    // CREATE
    public inscripcion saveinscripcion(inscripcion inscripcion) {
        return inscripcionrepository.save(inscripcion);
    }

    // READ ALL
    public List<inscripcion> getAllinscripciones() {
        return inscripcionrepository.findAll();
    }

    // READ BY ID
    public Optional<inscripcion> getinscripcionById(Long id) {
        return inscripcionrepository.findById(id);
    }

    // UPDATE
    public inscripcion updateinscripcion(Long id, inscripcion inscripcionDetails) {
        inscripcion inscripcion = inscripcionrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada con id: " + id));

        inscripcion.setAlumno(inscripcionDetails.getAlumno());
        inscripcion.setAsignatura(inscripcionDetails.getAsignatura());
        inscripcion.setFecha_inscripcion(inscripcionDetails.getFecha_inscripcion());

        return inscripcionrepository.save(inscripcion);
    }

    // DELETE
    public void deleteinscripcion(Long id) {
        inscripcionrepository.deleteById(id);
    }
}
