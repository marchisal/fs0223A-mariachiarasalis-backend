package com.trasp.model.titoli;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tessere")
public class Tessera {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroTessera;
	@ManyToOne
	private Utente utente;
	@OneToOne
	private Abbonamento abbonamento;
	private LocalDate datadiScadenza = LocalDate.now().plusYears(1);

	public Tessera() {
		super();
	}


	public Long getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(Long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Abbonamento getAbbonamento() {
		return abbonamento;
	}

	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}

	public LocalDate getDatadiScadenza() {
		return datadiScadenza;
	}

	public void setDatadiScadenza(LocalDate datadiScadenza) {
		this.datadiScadenza = datadiScadenza;
	}

	@Override
	public String toString() {
		return "Tessera [numeroTessera=" + numeroTessera + ", utente=" + utente + ", abbonamento=" + abbonamento
				+ ", datadiScadenza=" + datadiScadenza + "]";
	}

}
