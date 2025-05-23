package com.example.hello.produto;

import com.example.hello.repository.ProdutoRepository; // Importe o seu novo repositório
import org.springframework.http.HttpStatus; // Para status HTTP mais específicos
import org.springframework.http.ResponseEntity; // Para construir respostas HTTP
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional; // Para lidar com retornos de findById

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoRepository produtoRepository; // 1. Declara a instância do repositório

	// 2. Injeção de Dependência via Construtor (melhor prática)
	// O @Autowired é opcional a partir do Spring 4.3 para injeção via construtor
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@GetMapping
	public List<Produto> getAllProdutos() {
		// 3. Usa o método findAll() do JpaRepository
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
		
		// 4. Usa findById(), que retorna um Optional<Produto>
		Optional<Produto> produto = produtoRepository.findById(id);

		// Usa Optional para construir a resposta: 200 OK se presente, 404 Not Found se  não
		return produto.map(ResponseEntity::ok) // Se encontrar, retorna 200 OK com o produto
				.orElseGet(() -> ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
		
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // Retorna status 201 Created (melhor semântica para POST)
	public Produto createProduto(@RequestBody Produto produto) {
		
		// 5. Usa save() para criar/persistir. O ID será gerado automaticamente pelo banco.
		return produtoRepository.save(produto);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
		
		// 6. Tenta encontrar o produto existente pelo ID
		return produtoRepository.findById(id).map(produtoExistente -> {
			
			// Atualiza os campos do produto existente com os dados do produtoAtualizado
			produtoExistente.setNome(produtoAtualizado.getNome());
			produtoExistente.setPreco(produtoAtualizado.getPreco());

			// 7. Salva a entidade atualizada. O método save() faz um UPDATE se o ID já existe.
			Produto updatedProduto = produtoRepository.save(produtoExistente);
			
			return ResponseEntity.ok(updatedProduto); // Retorna 200 OK com o produto atualizado
			
		}).orElseGet(() -> ResponseEntity.notFound().build()); // Se não encontrar, retorna 404 Not Found
		
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // Retorna status 204 No Content (melhor semântica para DELETE)
	public void deleteProduto(@PathVariable Long id) {
		
		// 8. Deleta o produto pelo ID.
		produtoRepository.deleteById(id);
		
	}
	
}