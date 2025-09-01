package com.santi.crudalumnos.service;

import com.santi.crudalumnos.entity.nota;
import com.santi.crudalumnos.repository.Notarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Notaservice {

    @Autowired
    private Notarepository notarepository;


    public nota savenota(nota nota) {
        return notarepository.save(nota);
    }


    public List<nota> getAllnotas() {
        return notarepository.findAll();
    }


    public Optional<nota> getnotaById(Long id) {
        return notarepository.findById(id);
    }


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
