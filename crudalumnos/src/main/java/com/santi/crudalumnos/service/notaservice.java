package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.nota;
import com.santi.crudalumnos.repository.notarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class notaservice {

    @Autowired
    private notarepository notarepository;

    // CREATE
    public nota savenota(nota nota) {
        return notarepository.save(nota);
    }

    // READ ALL
    public List<nota> getAllnotas() {
        return notarepository.findAll();
    }

    // READ BY ID
    public Optional<nota> getnotaById(Long id) {
        return notarepository.findById(id);
    }

    // UPDATE
    public nota updatenota(Long id, nota notaDetails) {
        nota nota = notarepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con id: " + id));

        nota.setInscripcion(notaDetails.getInscripcion());
        nota.setValor(notaDetails.getValor());

        return notarepository.save(nota);
    }

    // DELETE
    public void deletenota(Long id) {
        notarepository.deleteById(id);
    }
}
