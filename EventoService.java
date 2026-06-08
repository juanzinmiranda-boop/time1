package com.eventhub.service;

import com.eventhub.model.Evento;
import com.eventhub.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public List<Evento> listar() {
        return repository.findAll();
    }

    public Evento buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Evento não encontrado"));
    }

    public Evento salvar(Evento evento) {

        if(evento.getDataFim()
                .isBefore(evento.getDataInicio())) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Data final não pode ser anterior à inicial");
        }

        if(repository.existsByNomeEventoAndDataInicio(
                evento.getNomeEvento(),
                evento.getDataInicio())) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Evento já cadastrado");
        }

        return repository.save(evento);
    }

    public Evento atualizar(Long id, Evento evento) {

        Evento existente = buscar(id);

        if(evento.getDataFim()
                .isBefore(evento.getDataInicio())) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Data inválida");
        }

        existente.setNomeEvento(evento.getNomeEvento());
        existente.setDescricao(evento.getDescricao());
        existente.setDataInicio(evento.getDataInicio());
        existente.setDataFim(evento.getDataFim());
        existente.setLocal(evento.getLocal());
        existente.setLimiteParticipantes(
                evento.getLimiteParticipantes());

        return repository.save(existente);
    }

    public void deletar(Long id) {

        Evento evento = buscar(id);

        repository.delete(evento);
    }

}
