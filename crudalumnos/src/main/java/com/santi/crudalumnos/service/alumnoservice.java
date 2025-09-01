package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class alumnoservice {

    @Autowired
    private alumnorepository alumnorepository;

    // CREATE - Guardar nuevo alumno
    public Alumno savealumno(Alumno alumno) {
        return alumnorepository.save(alumno);
    }

    // READ - Obtener todos los alumnos
    public List<Alumno> getAllalumnos() {
        return alumnorepository.findAll();
    }

    // READ - Obtener alumno por ID
    public Optional<Alumno> getalumnoById(Long id) {
        return alumnorepository.findById(id);
    }

    // UPDATE - Actualizar alumno
    public Alumno updatealumno(Long id, Alumno alumnoDetails) {
        Alumno alumno = alumnorepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));

        alumno.setNombre(alumnoDetails.getNombre());
        alumno.setApellido(alumnoDetails.getApellido());
        alumno.setFecha_nacimiento(alumnoDetails.getFecha_nacimiento());
        alumno.setEmail(alumnoDetails.getEmail());

        return alumnorepository.save(alumno);
    }

    // DELETE - Eliminar alumno
    public void deletealumno(Long id) {
        alumnorepository.deleteById(id);
    }
}