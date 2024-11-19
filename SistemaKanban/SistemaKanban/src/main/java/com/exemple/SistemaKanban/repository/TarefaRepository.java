package com.exemple.SistemaKanban.repository;

import com.exemple.SistemaKanban.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
