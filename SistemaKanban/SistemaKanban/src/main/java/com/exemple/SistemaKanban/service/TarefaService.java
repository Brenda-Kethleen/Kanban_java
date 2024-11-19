package com.exemple.SistemaKanban.service;

import com.exemple.SistemaKanban.model.Tarefa;
import com.exemple.SistemaKanban.model.Status;
import com.exemple.SistemaKanban.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa atualizarTarefa(Long id, Tarefa novaTarefa) {
        Tarefa tarefaExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa com ID " + id + " não encontrada"));

        tarefaExistente.setTitulo(novaTarefa.getTitulo());
        tarefaExistente.setDescricao(novaTarefa.getDescricao());
        tarefaExistente.setPrioridade(novaTarefa.getPrioridade());
        tarefaExistente.setDataLimite(novaTarefa.getDataLimite());
        return repository.save(tarefaExistente);
    }

    public void deletarTarefa(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Tarefa com ID " + id + " não encontrada");
        }
        repository.deleteById(id);
    }

    public Tarefa moverTarefa(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa com ID " + id + " não encontrada"));

        switch (tarefa.getStatus()) {
            case A_FAZER -> tarefa.setStatus(Status.EM_PROGRESSO);
            case EM_PROGRESSO -> tarefa.setStatus(Status.CONCLUIDO);
            case CONCLUIDO -> throw new IllegalStateException("Tarefa já está concluída");
        }

        return repository.save(tarefa);
    }
}
