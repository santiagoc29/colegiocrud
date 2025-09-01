package com.santi.crudalumnos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignatura;

    @Column(nullable = false, length = 255)
    private String nombre_asignatura;

    // Relación con profesor (muchas asignaturas -> un profesor)
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private profesor profesor;

    // Getters y Setters
    public Long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(profesor profesor) {
        this.profesor = profesor;
    }
}
