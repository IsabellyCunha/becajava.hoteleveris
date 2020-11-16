package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

/*
 * @Service public class TipoQuartoService extends BaseResponse{
 * 
 * final TipoQuartoRepository _repository;
 * 
 * @Autowired public TipoQuartoService(TipoQuartoRepository repository) {
 * _repository = repository; }
 * 
 * public BaseResponse inserir(TipoQuartoRequest tipoQuartoRequest) { TipoQuarto
 * tipoQuarto = new TipoQuarto(); BaseResponse base = new BaseResponse();
 * base.StatusCode = 400;
 * 
 * if(tipoQuartoRequest.getDescricao().trim().equals("") ||
 * tipoQuartoRequest.getDescricao().equals("string")) {//no swagger, por padrao,
 * o "rótulo" dos campos fica com "string" escrito, então impedi que seja
 * inserido no banco um cliente com dados escritos string base.Message =
 * "A descrição do tipo de quarto deve ser preenchido"; return base; }
 * if(tipoQuartoRequest.getValor() == null || tipoQuartoRequest.getValor() <= 0)
 * {//no swagger, por padrao, o "rótulo" dos campos fica com "string" escrito,
 * então impedi que seja inserido no banco um cliente com dados escritos string
 * base.Message = "Digite um valor válido!"; return base; }
 * 
 * tipoQuarto.setDescricao(tipoQuartoRequest.getDescricao());
 * tipoQuarto.setValor(tipoQuartoRequest.getValor());
 * 
 * _repository.save(tipoQuarto);
 * 
 * base.StatusCode = 201; base.Message = "Tipo de quarto inserido com sucesso.";
 * return base; }
 * 
 * public TipoQuartoResponse obter(Long id) { Optional<TipoQuarto> tipoQuarto =
 * _repository.findById(id); TipoQuartoResponse response = new
 * TipoQuartoResponse();
 * 
 * if (tipoQuarto.get().getId() == null) { response.Message =
 * "Cliente não encontrado"; response.StatusCode = 404; return response; }
 * 
 * response.setDescricao(tipoQuarto.get().getDescricao());
 * response.setValor(tipoQuarto.get().getValor()); response.Message =
 * "Tipo de quarto obtido com sucesso obtido com sucesso"; response.StatusCode =
 * 200; return response; }
 * 
 * public TipoQuartoList listar() { 
 * List<TipoQuarto> lista =  * _repository.findAll();
 * 
 * TipoQuartoList response = new TipoQuartoList();
 * response.setTipoQuartos(lista); response.StatusCode = 200; response.Message =
 * "Tipos de quarto obtidos com sucesso.";
 * 
 * return response; }
 * 
 * public BaseResponse atualizar(Long id, TipoQuartoRequest tipoQuartoRequest) {
 * TipoQuarto tipoQuarto = new TipoQuarto(); BaseResponse base = new
 * BaseResponse(); base.StatusCode = 400;
 * 
 * if(tipoQuartoRequest.getDescricao().trim().equals("") ||
 * tipoQuartoRequest.getDescricao().equals("string")) {//no swagger, por padrao,
 * o "rótulo" dos campos fica com "string" escrito, então impedi que seja
 * inserido no banco um cliente com dados escritos string base.Message =
 * "A descrição do tipo de quarto deve ser preenchido"; return base; }
 * if(tipoQuartoRequest.getValor() == null || tipoQuartoRequest.getValor() <= 0)
 * {//no swagger, por padrao, o "rótulo" dos campos fica com "string" escrito,
 * então impedi que seja inserido no banco um cliente com dados escritos string
 * base.Message = "Digite um valor válido!"; return base; }
 * 
 * tipoQuarto.setId(id);
 * tipoQuarto.setDescricao(tipoQuartoRequest.getDescricao());
 * tipoQuarto.setValor(tipoQuarto.getValor());
 * 
 * _repository.save(tipoQuarto);
 * 
 * base.StatusCode = 201; base.Message =
 * "Tipo de quarto atualizado com sucesso."; return base; }
 * 
 * public BaseResponse deletar(Long id) { BaseResponse response = new
 * BaseResponse();
 * 
 * if (id == null || id == 0) { response.StatusCode = 400; return response; }
 * 
 * _repository.deleteById(id); response.StatusCode = 200; response.Message =
 * "Tipo de quarto excluído com sucesso"; return response; } }
 */