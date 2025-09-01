package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.inscripcion;
import com.santi.crudalumnos.repository.Inscripcionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Inscripcionservice {

    @Autowired
    private Inscripcionrepository inscripcionrepository;


    public inscripcion saveinscripcion(inscripcion inscripcion) {
        return inscripcionrepository.save(inscripcion);
    }


    public List<inscripcion> getAllinscripciones() {
        return inscripcionrepository.findAll();
    }


    public Optional<inscripcion> getinscripcionById(Long id) {
        return inscripcionrepository.findById(id);
    }


    public inscripcion updateinscripcion(Long id, inscripcion inscripcionDetails) {
        inscripcion inscripcion = inscripcionrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada con id: " + id));

        inscripcion.setAlumno(inscripcionDetails.getAlumno());
        inscripcion.setAsignatura(inscripcionDetails.getAsignatura());
        inscripcion.setFecha_inscripcion(inscripcionDetails.getFecha_inscripcion());

        return inscripcionrepository.save(inscripcion);
    }


    public void deleteinscripcion(Long id) {
        inscripcionrepository.deleteById(id);
    }
}
