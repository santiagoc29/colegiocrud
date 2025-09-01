package com.santi.crudalumnos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nota;

    private Double valor;


    @ManyToOne
    @JoinColumn(name = "id_inscripcion")
    private inscripcion inscripcion;


    public Long getId_nota() {
        return id_nota;
    }

    public void setId_nota(Long id_nota) {
        this.id_nota = id_nota;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
}
