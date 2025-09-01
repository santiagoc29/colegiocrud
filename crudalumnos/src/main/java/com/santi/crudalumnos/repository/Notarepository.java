package com.santi.crudalumnos.repository;

import com.santi.crudalumnos.entity.nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Notarepository extends JpaRepository<nota, Long> {
}
