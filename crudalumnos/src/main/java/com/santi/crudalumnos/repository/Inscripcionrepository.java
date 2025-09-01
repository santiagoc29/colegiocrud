package com.santi.crudalumnos.repository;

import com.santi.crudalumnos.entity.inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inscripcionrepository extends JpaRepository<inscripcion, Long> {
}
