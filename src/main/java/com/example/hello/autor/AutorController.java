package com.example.hello.autor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus; // Para status HTTP mais específicos
import org.springframework.http.ResponseEntity; // Para construir respostas HTTP

import com.example.hello.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorRepository autorRepository;
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
		
	}
	
	@GetMapping
	public List<Autor> getAutores(){
		//método do JpaRespository
		return autorRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> getAutorById(@PathVariable Long id){
		//findById() retorna um Optional<Type>
		Optional<Autor> autor = autorRepository.findById(id);
		
		return autor.map(ResponseEntity::ok) // Se encontrar, retorna 200 OK com o produto
				.orElseGet(() -> ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor createAutor(@RequestBody Autor autor) {
		
		//usa o save() do JpaRepository. ID gerado pelo banco
		return autorRepository.save(autor);
		
		
	}
}

























