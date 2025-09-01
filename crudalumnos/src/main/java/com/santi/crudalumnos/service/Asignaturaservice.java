package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.asignatura;
import com.santi.crudalumnos.repository.Asignaturarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Asignaturaservice {

    @Autowired
    private Asignaturarepository asignaturarepository;


    public asignatura saveasignatura(asignatura asignatura) {
        return asignaturarepository.save(asignatura);
    }


    public List<asignatura> getAllasignaturas() {
        return asignaturarepository.findAll();
    }


    public Optional<asignatura> getasignaturaById(Long id) {
        return asignaturarepository.findById(id);
    }


    public asignatura updateasignatura(Long id, asignatura asignaturaDetails) {
        asignatura asignatura = asignaturarepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + id));

        asignatura.setNombre_asignatura(asignaturaDetails.getNombre_asignatura());

        return asignaturarepository.save(asignatura);
    }


    public void deleteasignatura(Long id) {
        asignaturarepository.deleteById(id);
    }
}
