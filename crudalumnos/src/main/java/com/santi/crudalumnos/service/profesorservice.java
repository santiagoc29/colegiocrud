package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.profesor;
import com.santi.crudalumnos.repository.profesorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class profesorservice {

    @Autowired
    private profesorrepository profesorrepository;

    // CREATE
    public profesor saveprofesor(profesor profesor) {
        return profesorrepository.save(profesor);
    }

    // READ ALL
    public List<profesor> getAllprofesores() {
        return profesorrepository.findAll();
    }

    // READ BY ID
    public Optional<profesor> getprofesorById(Long id) {
        return profesorrepository.findById(id);
    }

    // UPDATE
    public profesor updateprofesor(Long id, profesor profesorDetails) {
        profesor profesor = profesorrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));

        profesor.setNombre(profesorDetails.getNombre());
        profesor.setApellido(profesorDetails.getApellido());
        profesor.setEmail(profesorDetails.getEmail());

        return profesorrepository.save(profesor);
    }

    // DELETE
    public void deleteprofesor(Long id) {
        profesorrepository.deleteById(id);
    }
}
