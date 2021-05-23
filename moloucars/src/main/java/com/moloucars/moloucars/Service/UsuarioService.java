package com.moloucars.moloucars.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.moloucars.moloucars.Model.Usuario;
import com.moloucars.moloucars.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public ResponseEntity<?> postUsuario(Usuario usuario) {
		String cpf = usuario.getCpf();
		Optional<Usuario> validaCpf = repository.findByCpfEquals(cpf);
		String email = usuario.getEmail();
		Optional<Usuario> validaEmail = repository.findByEmailEquals(email);

		if (validaCpf.isPresent()) {
			String message = "CPF DUPLICADO";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}

		else if (validaEmail.isPresent()) {
			String message = "E-MAIL DUPLICADO";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}

		else {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
		}

	}

}
