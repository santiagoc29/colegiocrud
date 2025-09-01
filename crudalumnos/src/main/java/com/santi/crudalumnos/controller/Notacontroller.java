package com.santi.crudalumnos.controller;

import com.santi.crudalumnos.entity.Nota;
import com.santi.crudalumnos.service.Notaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class Notacontroller {

    @Autowired
    private Notaservice notaservice;


    @PostMapping
    public Nota createnota(@RequestBody Nota nota) {
        return notaservice.savenota(nota);
    }


    @GetMapping
    public List<Nota> getAllnotas() {
        return notaservice.getAllnotas();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Long id) {
        Optional<Nota> nota = notaservice.getnotaById(id);
        return nota.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Long id, @RequestBody Nota notaDetails) {
        try {
            Nota updatednota = notaservice.updatenota(id, notaDetails);
            return ResponseEntity.ok(updatednota);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletenota(@PathVariable Long id) {
        try {
            notaservice.deletenota(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
