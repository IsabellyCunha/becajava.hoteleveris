package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.imp.FaturaServiceImp;

@SpringBootTest
public class FaturaTeste {

	@Autowired
	private FaturaServiceImp service;
	
	@Test
	 public void fazTransferenciaComDevedores() {
		service.inserir();
		BaseResponse response = new BaseResponse();
		Assertions.assertEquals(200,response.getStatusCode());
	}
	
//	@Test
//	 public void fazTransferenciaSemDevedores() {
//		BaseResponse response = service.transferencia();
//		Assertions.assertEquals(400,response.getStatusCode());
//	}
}
