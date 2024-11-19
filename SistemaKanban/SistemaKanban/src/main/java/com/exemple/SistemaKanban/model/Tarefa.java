package com.exemple.SistemaKanban.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private LocalDate dataCriacao = LocalDate.now();

    private LocalDate dataLimite;

    @Enumerated(EnumType.STRING)
    private Status status = Status.A_FAZER;

    // Getters e Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Prioridade getPrioridade() { return prioridade; }

    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }

    public LocalDate getDataCriacao() { return dataCriacao; }

    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }

    public LocalDate getDataLimite() { return dataLimite; }

    public void setDataLimite(LocalDate dataLimite) { this.dataLimite = dataLimite; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }
}
