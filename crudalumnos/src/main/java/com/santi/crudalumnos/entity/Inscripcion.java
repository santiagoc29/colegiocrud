package com.santi.crudalumnos.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
public class inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inscripcion;

    // Relación con alumno (muchas inscripciones -> un alumno)
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private alumno alumno;

    // Relación con asignatura (muchas inscripciones -> una asignatura)
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private asignatura asignatura;

    private LocalDate fecha_inscripcion;

    // Getters y Setters
    public Long getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(Long id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(alumno alumno) {
        this.alumno = alumno;
    }

    public asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }
}
