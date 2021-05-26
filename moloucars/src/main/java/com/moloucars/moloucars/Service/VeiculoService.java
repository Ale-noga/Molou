package com.moloucars.moloucars.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.moloucars.moloucars.Model.ObjetoArray;
import com.moloucars.moloucars.Model.Veiculo;
import com.moloucars.moloucars.Model.VeiculoFipe;
import com.moloucars.moloucars.Repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private FipeService fipeservice;
	
	private OBService obService;

	public ResponseEntity<?> postVeiculo(Veiculo veiculo) {
		String tipoVeiculo = veiculo.getTipoVeiculo();
		Optional<ObjetoArray> todasMarcas = fipeservice.getAllMarcas(tipoVeiculo);
		String marca = veiculo.getMarca();

		if (todasMarcas.get().equals(marca)) {
			ObjetoArray marcaVeiculo = obService.findByNomeContainingIgnoreCase(marca);
			String codigoMarca = marcaVeiculo.getCodigo();
			Optional<ObjetoArray> todosModelos = fipeservice.getAllModelos(tipoVeiculo, codigoMarca);
			String modelo = veiculo.getModelo();

			if (todosModelos.get().equals(modelo)) {
				ObjetoArray modeloVeiculo = obService.findByNomeContainingIgnoreCase(modelo);
				String codigoModelo = modeloVeiculo.getCodigo();
				Optional<ObjetoArray> listaAno = fipeservice.getAllAnos(tipoVeiculo, codigoMarca, codigoModelo);
				String ano = veiculo.getAno();

				if (listaAno.get().equals(ano)) {
					ObjetoArray anoVeiculo = obService.findByNomeContainingIgnoreCase(ano);
					String codigoAno = anoVeiculo.getCodigo();
					VeiculoFipe veiculoFipe = fipeservice.getVeiculo(tipoVeiculo, codigoMarca, codigoModelo, codigoAno);
					veiculo.setValor(veiculoFipe.getValor());
					return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(veiculo));

				}

				else {
					String message = "Ano do veiculo não encontrado";
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
				}

			}

			else {
				String message = "Modelo do veiculo não encontrado";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
			}

		}

		else {
			String message = "Tipo de veiculo não encontrado. INSERIR: carros, motos ou caminhoes ";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}

	}
	


}
