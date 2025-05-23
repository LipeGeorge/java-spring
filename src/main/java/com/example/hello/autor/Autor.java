package com.example.hello.autor;

import java.util.List;
import java.util.Objects;

import com.example.hello.livro.Livro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	/*
	 * mappedBy-> indica onde está a chave estrangeira
	 * cascade -> caso o autor seja deletado, todos os seus livros também serão
	 * orphanRemoval -> Remove livros "órfãos" (se um livro for removido da lista de livros de um autor e não tiver outro autor, ele será deletado)
	 * fetch (ou Workspace) -> Os livros só serão carregados do banco de dados quando forem realmente acessados (evita carregar tudo de uma vez).
	**/
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Livro> livros;
	
	public Autor() {}
	
	public Autor(String nome) {
		this.nome = nome;
	}
	
	public Autor(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

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
	

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Autor{"
				+ "id=" + id + 
				", nome=" + nome + 
				"}";
	}
	
	
	

}
