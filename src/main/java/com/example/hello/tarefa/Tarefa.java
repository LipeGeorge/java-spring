package com.example.hello.tarefa;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity //Marca a classe como uma entidade JPA
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //geração automática de id
    private Long id;
    private String titulo;
    private boolean concluida;

    //default constructor 
    public Tarefa() {}
    
    // Construtor sem ID (para criar novos produtos, o ID será gerado pelo BD)
    public Tarefa( String titulo, boolean concluida) {
        this.titulo = titulo;
        this.concluida = concluida;
    }

    // Construtor com ID (para testes ou quando o ID já existe, ex: ao carregar do BD)
    public Tarefa(Long id, String titulo, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.concluida = concluida;
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    public boolean isConcluida() { 
        return concluida; 
    }
    public void setConcluida(boolean concluida) { 
        this.concluida = concluida; 
    }
    
    @Override
    public boolean equals(Object o) {
    	
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id); // Comparar pelo ID
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id); // Gerar hash baseado no ID
    }

	@Override
	public String toString() {
		return "Tarefa{" + 
				"id=" + id + 
				", titulo=" + titulo + 
				", concluida=" + concluida + 
				"}";
	}   
}