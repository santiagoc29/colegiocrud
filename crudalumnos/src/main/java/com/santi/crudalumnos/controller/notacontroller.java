package com.santi.crudalumnos.controller;

import com.santi.crudalumnos.entity.Nota;
import com.santi.crudalumnos.service.notaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class notacontroller {

    @Autowired
    private notaservice notaservice;

    // CREATE - Crear nueva nota
    @PostMapping
    public Nota createnota(@RequestBody Nota nota) {
        return notaservice.savenota(nota);
    }

    // READ ALL - Obtener todas las notas
    @GetMapping
    public List<Nota> getAllnotas() {
        return notaservice.getAllnotas();
    }

    // READ BY ID - Obtener nota por ID
    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Long id) {
        Optional<Nota> nota = notaservice.getnotaById(id);
        return nota.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Actualizar nota
    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Long id, @RequestBody Nota notaDetails) {
        try {
            Nota updatednota = notaservice.updatenota(id, notaDetails);
            return ResponseEntity.ok(updatednota);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar nota
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
