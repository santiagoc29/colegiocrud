package com.santi.crudalumnos.repository;

import com.santi.crudalumnos.entity.asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Asignaturarepository extends JpaRepository<asignatura, Long> {
}
