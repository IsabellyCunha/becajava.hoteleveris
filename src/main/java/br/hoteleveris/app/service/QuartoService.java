package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.ComodidadeQuarto;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.ComodidadeQuartoRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.ClienteList;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoList;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;

@Service
public class QuartoService {
	@Autowired
	private QuartoRepository repository;

	@Autowired
	private ComodidadeQuartoRepository comodidadeQuartoRepository;

	public BaseResponse inserir(QuartoRequest request) {
		if (request.getAndar() <= 0) {
			return new BaseResponse(400, "Preencha o andar");
		}
		if (request.getNoQuarto() <= 0) {
			return new BaseResponse(400, "Preencha o número do quarto");
		}
		// var checkNoQuarto = repository.findByNoQuarto(request.getNoQuarto());

		if (repository.existsByNoQuarto(request.getAndar()) == true) {
			return new BaseResponse(400, "O número do quarto já existe");
		}
		if (request.getSituacao() == "" || request.getSituacao() == null) {
			return new BaseResponse(400, "Preencha a situação");
		}
		TipoQuarto tipoQuarto = new TipoQuarto(request.getTipoQuartoId());

		Quarto quarto = new Quarto(request.getAndar(), request.getNoQuarto(), request.getSituacao(), tipoQuarto);

		repository.save(quarto);

		Long idQuarto = repository.findByNoQuarto(request.getNoQuarto()).get().getId();

		if (request.getComodidades() != null && request.getComodidades().size() > 0) {
			for (ComodidadeRequest item : request.getComodidades()) {
				ComodidadeQuarto comodidadeQuarto = new ComodidadeQuarto(new Quarto(idQuarto),
						new Comodidade(item.getId()));

				comodidadeQuartoRepository.save(comodidadeQuarto);
			}
		}

		return new BaseResponse(201, "Quarto inserido com sucesso");
	}

	public QuartoResponse obter(int noQuarto) {
		QuartoResponse response = new QuartoResponse();

		Optional<Quarto> quarto = repository.findByNoQuarto(noQuarto);

		if (repository.existsByNoQuarto(noQuarto) == false) {
			return new QuartoResponse(400, "Esse quarto não existe!");
		}

		response.setId(quarto.get().getId());
		response.setAndar(quarto.get().getAndar());
		response.setNoQuarto(quarto.get().getNoQuarto());
		response.setSituacao(quarto.get().getSituacao());
		response.setAndar(quarto.get().getAndar());
		response.setStatusCode(200);
		response.setMessage("Quarto obtido com sucesso!");

		return response;
	}

	
	  public QuartoList obterPorTipo(Long tipoQuartoId) { 
		  QuartoList response = new QuartoList();
	  
		  List<Quarto> lista = repository.findByTipoQuartoId(tipoQuartoId);
	  
		  response.setQuartos(lista); 
		  response.setStatusCode(200);
		  response.setMessage("Quartos obtidos com sucesso.");
	  
		  return response;
	  
	  }
	 

	public QuartoList listar() {
		List<Quarto> lista = repository.findAll();

		QuartoList response = new QuartoList();
		response.setQuartos(lista);
		response.setStatusCode(200);
		response.setMessage("Clientes obtidos com sucesso.");

		return response;
	}

}
