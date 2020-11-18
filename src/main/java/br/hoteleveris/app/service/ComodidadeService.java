package br.hoteleveris.app.service;

import br.hoteleveris.app.request.ComodidadeList;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

public interface ComodidadeService {
	BaseResponse inserir(ComodidadeRequest comodidadeRequest);
	ComodidadeResponse obter(Long id);
	ComodidadeList listar();
}
