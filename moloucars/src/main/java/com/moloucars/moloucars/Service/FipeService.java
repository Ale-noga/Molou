package com.moloucars.moloucars.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moloucars.moloucars.Model.VeiculoFipe;

@FeignClient(url = "https://parallelum.com.br/fipe/api/v1", name = "parallelum")
public interface FipeService {

	@GetMapping("{tipoVeiculo}")
	VeiculoFipe getAllMarcas(@PathVariable("tipoVeiculo") String tipoVeiculo);
	
	
}
