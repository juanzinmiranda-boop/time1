package com.eventhub.controller;

import com.eventhub.model.Evento;
import com.eventhub.service.EventoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public ResponseEntity<List<Evento>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscar(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Evento> salvar(
            @Valid @RequestBody Evento evento) {

        Evento novo = service.salvar(evento);

        return ResponseEntity.status(201)
                .body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Evento evento) {

        return ResponseEntity.ok(
                service.atualizar(id, evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.ok(
                "Evento removido com sucesso");
    }

}