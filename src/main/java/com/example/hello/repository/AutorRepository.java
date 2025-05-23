package com.example.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hello.autor.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

	// Spring Data JPA vai gerar automaticamente as implementações para
	// os métodos CRUD básicos (save, findById, findAll, deleteById, etc.).

	// Exemplo de Query Method: Encontrar produtos por nome (ignorando maiúsculas/minúsculas)
	// Isso será implementado automaticamente pelo Spring Data JPA!
	// List<Produto> findByNomeContainingIgnoreCase(String nome);
	
	// Se você tiver a entidade Livro, crie uma interface semelhante:
	// public interface LivroRepository extends JpaRepository<Livro, Long> {}
	
	
}
