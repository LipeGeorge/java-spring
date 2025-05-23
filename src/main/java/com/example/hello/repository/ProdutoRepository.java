package com.example.hello.repository;

import com.example.hello.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository; // Importe JpaRepository
import org.springframework.stereotype.Repository; // Importe Repository

@Repository // 1. Opcional, mas boa prática para indicar a função do componente
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
 // Spring Data JPA vai gerar automaticamente as implementações para
 // os métodos CRUD básicos (save, findById, findAll, deleteById, etc.).

 // Exemplo de Query Method: Encontrar produtos por nome (ignorando maiúsculas/minúsculas)
 // Isso será implementado automaticamente pelo Spring Data JPA!
 // List<Produto> findByNomeContainingIgnoreCase(String nome);

 // Se você tiver a entidade Livro, crie uma interface semelhante:
 // public interface LivroRepository extends JpaRepository<Livro, Long> {}
	
}
