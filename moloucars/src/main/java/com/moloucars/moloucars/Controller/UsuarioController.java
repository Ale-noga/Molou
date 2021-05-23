package com.moloucars.moloucars.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moloucars.moloucars.Model.Usuario;
import com.moloucars.moloucars.Repository.UsuarioRepository;
import com.moloucars.moloucars.Service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<?> post(@RequestBody @Valid Usuario usuario) {
		return service.postUsuario(usuario);
	}

	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
