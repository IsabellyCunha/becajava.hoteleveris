package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeList;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService extends BaseResponse{
	final ComodidadeRepository _repository;
	
	@Autowired
	public ComodidadeService(ComodidadeRepository repository) {
		_repository = repository;
	}
	
	public BaseResponse inserir(ComodidadeRequest comodidadeRequest) {
		Comodidade comodidade = new Comodidade();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;
		
		if(comodidadeRequest.getNome().trim().equals("") || comodidadeRequest.getNome().equals("string")) {//no swagger, por padrao, o "rótulo" dos campos fica com "string" escrito, então impedi que seja inserido no banco um comodidade com dados escritos string
			base.Message = "O nome da comodidade deve ser preenchido";
			return base;
		}
		
		comodidade.setNome(comodidadeRequest.getNome());
		
		_repository.save(comodidade);
		
		base.StatusCode = 201;
		base.Message = "Comodidade inserida com sucesso.";
		return base;
	}
	
	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = _repository.findById(id);
		ComodidadeResponse response = new ComodidadeResponse();

		if (comodidade == null) {
			response.Message = "Comodidade não encontrado";
			response.StatusCode = 404;
			return response;
		}

		response.setNome(comodidade.get().getNome());
		response.Message = "Comodidade obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

	public ComodidadeList listar() {
		List<Comodidade> lista = _repository.findAll();

		ComodidadeList response = new ComodidadeList();
		response.setComodidades(lista);
		response.StatusCode = 200;
		response.Message = "Comodidades obtidos com sucesso.";

		return response;
    }

	public BaseResponse atualizar(Long id, ComodidadeRequest comodidadeRequest) {
		Comodidade comodidade = new Comodidade();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if(comodidadeRequest.getNome().trim().equals("") || comodidadeRequest.getNome().equals("string")) {//no swagger, por padrao, o "rótulo" dos campos fica com "string" escrito, então impedi que seja inserido no banco um comodidade com dados escritos string
			base.Message = "O nome da comodidade não foi preenchida.";
			return base;
		}

		comodidade.setId(id);
		comodidade.setNome(comodidadeRequest.getNome());

		_repository.save(comodidade);
		base.StatusCode = 200;
		base.Message = "Comodidade atualizada com sucesso.";
		return base;
	}

	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();

		if (id == null || id == 0) {
			response.StatusCode = 400;
			return response;
		}

		_repository.deleteById(id);
		response.StatusCode = 200;
		response.Message = "Comodidade excluída com sucesso";
		return response;
	}
}
