package com.santi.crudalumnos.repository;

import com.santi.crudalumnos.entity.Alumno; // ← ¡Cambiado de "alumno" a "Alumno"!
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface alumnorepository extends JpaRepository<Alumno, Long> {

}