package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.asignatura;
import com.santi.crudalumnos.repository.asignaturarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class asignaturaservice {

    @Autowired
    private asignaturarepository asignaturarepository;

    // CREATE
    public asignatura saveasignatura(asignatura asignatura) {
        return asignaturarepository.save(asignatura);
    }

    // READ ALL
    public List<asignatura> getAllasignaturas() {
        return asignaturarepository.findAll();
    }

    // READ BY ID
    public Optional<asignatura> getasignaturaById(Long id) {
        return asignaturarepository.findById(id);
    }

    // UPDATE
    public asignatura updateasignatura(Long id, asignatura asignaturaDetails) {
        asignatura asignatura = asignaturarepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + id));

        asignatura.setNombre_asignatura(asignaturaDetails.getNombre_asignatura());

        return asignaturarepository.save(asignatura);
    }

    // DELETE
    public void deleteasignatura(Long id) {
        asignaturarepository.deleteById(id);
    }
}
