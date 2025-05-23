package com.example.hello.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity // 1. Marca a classe como uma entidade JPA
public class Produto {

    @Id // 2. Indica que este campo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. Configura a geração automática do ID
    private Long id; // Agora com tipo de objeto para o ID
    private String nome; // Será mapeado para uma coluna 'nome'
    private double preco; // Será mapeado para uma coluna 'preco'

    // Construtor padrão (OBRIGATÓRIO para JPA)
    public Produto() {
    }

    // Construtor sem ID (útil para criar novos produtos, o ID será gerado pelo BD)
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Construtor com ID (útil para testes ou quando o ID já existe, ex: ao carregar do BD)
    public Produto(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters (necessários para JPA acessar os atributos)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Métodos equals e hashCode (SEMPRE baseados no ID para entidades JPA)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id); // Comparar pelo ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Gerar hash baseado no ID
    }

    @Override
    public String toString() {
        return "Produto{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", preco=" + preco +
               '}';
    }
}