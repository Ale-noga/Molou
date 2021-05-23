package com.moloucars.moloucars.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.moloucars.moloucars.Model.VeiculoFipe;
import com.moloucars.moloucars.Service.FipeService;

@RestController
@CrossOrigin("*")
public class VeiculoController {
	
	@Autowired
	private FipeService fipesevice;
	
	@GetMapping("/{tipoVeiculo}/marcas")
	public ResponseEntity<VeiculoFipe> getMarcas (@PathVariable String tipoVeiculos){
		VeiculoFipe veiculo = fipesevice.getAllMarcas(tipoVeiculos);
		return veiculo != null ? ResponseEntity.ok().body(veiculo) : ResponseEntity.notFound().build();
	}

}
