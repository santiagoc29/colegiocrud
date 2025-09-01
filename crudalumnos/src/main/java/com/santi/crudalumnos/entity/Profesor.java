package com.santi.crudalumnos.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesores")
public class profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesor;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String apellido;

    @Column(length = 255)
    private String email;

    // Relación con Asignaturas (un profesor puede tener muchas asignaturas)
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<asignatura> asignaturas;

    // Getters y Setters
    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
