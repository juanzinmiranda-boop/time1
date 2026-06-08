package com.eventhub.repository;

import com.eventhub.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    boolean existsByNomeEventoAndDataInicio(
            String nomeEvento,
            LocalDate dataInicio
    );

}
