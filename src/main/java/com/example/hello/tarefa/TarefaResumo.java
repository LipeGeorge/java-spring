package com.example.hello.tarefa;

public class TarefaResumo {
    private int total;
    private int concluidas;
    private int pendentes;

    public TarefaResumo(int total, int concluidas, int pendentes) {
        this.total = total;
        this.concluidas = concluidas;
        this.pendentes = pendentes;
    }

    public int getTotal() {
        return total;
    }

    public int getConcluidas() {
        return concluidas;
    }

    public int getPendentes() {
        return pendentes;
    }
}
