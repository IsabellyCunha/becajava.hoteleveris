package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.model.Ocupacao;

public class OcupacaoList {
	private List<Ocupacao> Ocupacoes;

    public List<Ocupacao> getOcupacoes() {
        return Ocupacoes;
    }

    public void setOcupacoes(List<Ocupacao> ocupacoes) {
    	Ocupacoes = ocupacoes;
    }
}
