package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.request.ClienteList;
import br.hoteleveris.app.response.ClienteResponse;

@Service
public class ClienteService extends BaseResponse{
	
	final ClienteRepository _repository;
		
	@Autowired
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}
	
	public BaseResponse inserir(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;
		
		if(clienteRequest.getNome().trim().equals("") || clienteRequest.getNome().equals("string")) {//no swagger, por padrao, o "rótulo" dos campos fica com "string" escrito, então impedi que seja inserido no banco um cliente com dados escritos string
			base.Message = "O nome do cliente deve ser preenchido";
			return base;
		}
		if(clienteRequest.getCpf().trim().equals("") || clienteRequest.getCpf().equals("string")) {//no swagger, por padrao, o "rótulo" dos campos fica com "string" escrito, então impedi que seja inserido no banco um cliente com dados escritos string
			base.Message = "O CPF do cliente deve ser preenchido";
			return base;
		}
		if(clienteRequest.getHash().trim().equals("") || clienteRequest.getHash().equals("string")) {//no swagger, por padrao, o "rótulo" dos campos fica com "string" escrito, então impedi que seja inserido no banco um cliente com dados escritos string
			base.Message = "O hash do cliente deve ser preenchido";
			return base;
		}
		
		cliente.setNome(clienteRequest.getNome());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setHash(clienteRequest.getHash());
		
		_repository.save(cliente);
		
		base.StatusCode = 201;
		base.Message = "Cliente inserido com sucesso.";
		return base;
	}
	
	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);
		ClienteResponse response = new ClienteResponse();

		if (cliente == null) {
			response.Message = "Cliente não encontrado";
			response.StatusCode = 404;
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());
		response.setId(cliente.get().getId());
		response.Message = "Cliente obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

	public ClienteList listar() {
		List<Cliente> lista = _repository.findAll();

		ClienteList response = new ClienteList();
		response.setClientes(lista);
		response.StatusCode = 200;
		response.Message = "Clientes obtidos com sucesso.";

		return response;
    }

	public BaseResponse atualizar(Long id, ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (clienteRequest.getNome().trim().equals("") || clienteRequest.getNome().equals("string")) {
			base.Message = "O nome do cliente não foi preenchido.";
			return base;
		}
		if (clienteRequest.getCpf().trim().equals("") || clienteRequest.getCpf().equals("string")) {
			base.Message = "O CPF do cliente não foi preenchido.";
			return base;
		}
		if (clienteRequest.getHash().trim().equals("") || clienteRequest.getHash().equals("string")) {
			base.Message = "O hash do cliente não foi preenchido.";
			return base;
		}

		cliente.setId(id);
		cliente.setNome(clienteRequest.getNome());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setHash(clienteRequest.getHash());

		_repository.save(cliente);
		base.StatusCode = 200;
		base.Message = "Cliente atualizado com sucesso.";
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
		response.Message = "Cliente excluído com sucesso";
		return response;
	}
}
