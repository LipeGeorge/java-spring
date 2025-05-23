package com.example.hello.livro;

import java.util.Objects;

import com.example.hello.autor.Autor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Transient;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo_do_livro", nullable = false)
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	private Integer ano_publicacao;
	
	//@Transient
	private transient String statusInterno;
	
	public Livro() {}
	
	public Livro(String titulo, Autor autor, Integer ano_publicacao, String statusInterno) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano_publicacao = ano_publicacao;
		this.statusInterno = statusInterno;
	}
	
	public Livro(Long id, String titulo, Autor autor, Integer ano_publicacao, String statusInterno) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano_publicacao = ano_publicacao;
		this.statusInterno = statusInterno;
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Integer getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(Integer ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	

	public String getStatusInterno() {
		return statusInterno;
	}

	public void setStatusInterno(String statusInterno) {
		this.statusInterno = statusInterno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)return true;
		if (obj == null)return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Livro livro = (Livro) obj;
		return Objects.equals(id, livro.id);
	}

	@Override
	public String toString() {
		return "Livro{"
				+ "id=" + id + 
				", titulo=" + titulo + 
				", autor=" + autor + 
				", ano_publicacao=" + ano_publicacao
				+ "}";
	}
	
	

}
















