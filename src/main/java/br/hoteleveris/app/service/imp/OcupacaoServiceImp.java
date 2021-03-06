package br.hoteleveris.app.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoList;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.OcupacaoService;
@Service
public class OcupacaoServiceImp implements OcupacaoService {

    @Autowired
    private OcupacaoRepository _repository;


    public BaseResponse inserir(OcupacaoRequest request) {

        if (request.getData() == null)
            return new BaseResponse(400, "Data não foi preenchida!");

        if (request.getQtdeDiarias() == 0 )
            return new BaseResponse(400, "Quantidade de diárias não foi preenchido");

        if (request.getSituacao()== "")
            return new BaseResponse(400, "Situação não foi preenchida");

        if (request.getCliente() == null )
            return new BaseResponse(400, "Cliente não foi preenchido!");

        if (request.getQuarto() == null )
            return new BaseResponse(400, "Quarto não foi preenchido!");

        Cliente cliente = new Cliente(request.getCliente().getId());

        Quarto quarto = new Quarto(request.getQuarto().getId());

        Ocupacao ocupacao = new Ocupacao(
        		request.getData(),
        		request.getQtdeDiarias(),                             
                request.getSituacao(),
                cliente,
                quarto
                );

        _repository.save(ocupacao);
        return new BaseResponse(201, "Nova ocupação salva com sucesso!");
    }
    
    public OcupacaoList listar() {
		List<Ocupacao> lista = _repository.findAll();

		OcupacaoList response = new OcupacaoList();
		response.setOcupacoes(lista);
		response.setStatusCode(200);
		response.setMessage("Clientes obtidos com sucesso.");

		return response;
	}
}