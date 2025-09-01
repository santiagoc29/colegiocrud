package com.santi.crudalumnos.repository;

import com.santi.crudalumnos.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Alumnorepository extends JpaRepository<Alumno, Long> {

}