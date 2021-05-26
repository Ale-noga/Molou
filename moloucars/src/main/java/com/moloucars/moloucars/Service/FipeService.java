package com.moloucars.moloucars.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moloucars.moloucars.Model.ObjetoArray;
import com.moloucars.moloucars.Model.VeiculoFipe;

@FeignClient(url = "https://parallelum.com.br/fipe/api/v1", name = "parallelum")
public interface FipeService {

	@GetMapping("{tipoVeiculo}/marcas")
	Optional<ObjetoArray> getAllMarcas(@PathVariable("tipoVeiculo") String tipoVeiculo);

	@GetMapping("{tipoVeiculo}/marcas/{codigoMarca}/modelos")
	Optional<ObjetoArray> getAllModelos(@PathVariable String tipoVeiculo, @PathVariable("codigoMarca") String codigoMarca);

	@GetMapping("{tipoVeiculo}/marcas/{codigoMarca}/modelos/{codigoModelo}/anos")
	Optional<ObjetoArray> getAllAnos(@PathVariable String tipoVeiculo, @PathVariable("codigoMarca") String codigoMarca,
			@PathVariable("codigoModelo") String codigoModelo);

	@GetMapping("{tipoVeiculo}/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{codigoAno}")
	VeiculoFipe getVeiculo(@PathVariable String tipoVeiculo, @PathVariable("codigoMarca") String codigoMarca,
			@PathVariable("codigoModelo") String codigoModelo, @PathVariable("codigoAno") String codigoAno);

}
