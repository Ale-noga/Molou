package com.moloucars.moloucars.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moloucars.moloucars.Model.Usuario;
import com.moloucars.moloucars.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	Boolean validadeEmail = true;
	Boolean validadeCpf = true;

	public Boolean validaEmail(String email) {
		Optional<Usuario> usuario = repository.findByCpf(email);

		if (usuario.isPresent()) {
			validadeEmail = false;
			return validadeEmail;
		}

		return validadeEmail;
	}

	public Boolean validaCPF(String cpf) {
		Optional<Usuario> usuario = repository.findByCpf(cpf);

		if (usuario.isPresent()) {
			validadeCpf = false;
			return validadeCpf;
		}

		return validadeCpf;
	}

	public Boolean getValidadeEmail() {
		return validadeEmail;
	}

	public Boolean getValidadeCpf() {
		return validadeCpf;
	}

}
