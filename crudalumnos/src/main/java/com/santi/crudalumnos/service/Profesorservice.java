package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.profesor;
import com.santi.crudalumnos.repository.Profesorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Profesorservice {

    @Autowired
    private Profesorrepository profesorrepository;


    public profesor saveprofesor(profesor profesor) {
        return profesorrepository.save(profesor);
    }


    public List<profesor> getAllprofesores() {
        return profesorrepository.findAll();
    }


    public Optional<profesor> getprofesorById(Long id) {
        return profesorrepository.findById(id);
    }


    public profesor updateprofesor(Long id, profesor profesorDetails) {
        profesor profesor = profesorrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));

        profesor.setNombre(profesorDetails.getNombre());
        profesor.setApellido(profesorDetails.getApellido());
        profesor.setEmail(profesorDetails.getEmail());

        return profesorrepository.save(profesor);
    }


    public void deleteprofesor(Long id) {
        profesorrepository.deleteById(id);
    }
}
