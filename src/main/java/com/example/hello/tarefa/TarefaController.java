package com.example.hello.tarefa;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private List<Tarefa> tarefas = new ArrayList<>();
    private Long proximoId = 1L;

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa nova) {
        nova.setId(proximoId++);
        tarefas.add(nova);
        return nova;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return tarefas;
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    @GetMapping("/status")
    public List<Tarefa> buscaPorStatus(@RequestParam Boolean concluida){
        return tarefas.stream()
            .filter(t -> t.isConcluida() == concluida)
            .collect(Collectors.toList());
    }

    @GetMapping("/concluidas")
    public List<Tarefa> concluidas(){
        return tarefas.stream()
            .filter(t -> t.isConcluida() == true)
            .collect(Collectors.toList());
    }

    @GetMapping("/pendentes")
    public List<Tarefa> pendentes(){
        return tarefas.stream()
            .filter(t -> t.isConcluida() == false)
            .collect(Collectors.toList());
    }

    @GetMapping("/resumo")
    public TarefaResumo resumo(){

        int total = tarefas.size();
        int concluidas = (int)tarefas.stream().filter(t -> t.isConcluida()==true).count();
        int pendentes = (int)tarefas.stream().filter(t -> t.isConcluida()==false).count();

        return new TarefaResumo(total, concluidas, pendentes);
    }


    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa atualizada) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setTitulo(atualizada.getTitulo());
        tarefa.setConcluida(atualizada.isConcluida());
        return tarefa;
    }

    @PutMapping("/{id}/concluir")
    public Tarefa concluir(@PathVariable Long id, Boolean conclusao) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setConcluida(conclusao);
        return tarefa;
    }
    

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefas.removeIf(t -> t.getId().equals(id));
    }
}
