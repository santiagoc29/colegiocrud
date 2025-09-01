package com.santi.crudalumnos.repository;

import com.santi.crudalumnos.entity.profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface profesorrepository extends JpaRepository<profesor, Long> {
}
