package com.eventhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    private String nomeEvento;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 10, message = "Descrição deve ter no mínimo 10 caracteres")
    private String descricao;

    @NotNull(message = "Data início é obrigatória")
    private LocalDate dataInicio;

    @NotNull(message = "Data fim é obrigatória")
    private LocalDate dataFim;

    @NotBlank(message = "Local é obrigatório")
    private String local;

    @NotNull(message = "Limite obrigatório")
    @Min(value = 1, message = "Limite deve ser maior que zero")
    private Integer limiteParticipantes;

    public Evento() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getLimiteParticipantes() {
        return limiteParticipantes;
    }

    public void setLimiteParticipantes(Integer limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
    }
}
