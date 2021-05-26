package com.moloucars.moloucars.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moloucars.moloucars.Model.Veiculo;
import com.moloucars.moloucars.Repository.VeiculoRepository;
import com.moloucars.moloucars.Service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
@CrossOrigin("*")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository repository;
	
	@Autowired
	private VeiculoService service;
	
	@PostMapping
	public ResponseEntity<?> post(@RequestBody Veiculo veiculo) {
		return service.postVeiculo(veiculo);
	}

}
