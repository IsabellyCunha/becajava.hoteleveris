package br.hoteleveris.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ComodidadeQuarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "quartoId")
	private Quarto Quarto;
	
	@ManyToOne
	@JoinColumn(name = "comodidadeId")
	private Comodidade Comodidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quarto getQuarto() {
		return Quarto;
	}

	public void setQuarto(Quarto quarto) {
		Quarto = quarto;
	}

	public Comodidade getComodidade() {
		return Comodidade;
	}

	public void setComodidade(Comodidade comodidade) {
		Comodidade = comodidade;
	}
	
	
}
