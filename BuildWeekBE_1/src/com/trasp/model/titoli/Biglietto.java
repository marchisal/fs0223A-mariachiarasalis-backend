package com.trasp.model.titoli;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.trasp.model.mezzi.Mezzo;

@Entity
@NamedQuery(name = "findBigliettiByRivenditore", query = "SELECT b FROM Biglietto b WHERE b.luogodiAcquisto.id = :idRivenditore")
@NamedQuery(name = "findBigliettiByDate", query = "SELECT b FROM Biglietto b WHERE b.datadiEmissione >= :inizio AND b.datadiEmissione <= :fine")
@NamedQuery(name = "printAllBiglietti", query = "SELECT b FROM Biglietto b")
@NamedQuery(name = "findBigliettiByMezzo", query = "SELECT b FROM Biglietto b WHERE b.luogodiValidazione.id = :idMezzo")
@NamedQuery(name = "findBigliettiByValidationDate", query = "SELECT b FROM Biglietto b WHERE b.datadiValidazione >= :inizio AND b.datadiValidazione <= :fine")
public class Biglietto extends TitolodiViaggio {
	
	private LocalDate datadiValidazione;
	@ManyToOne
	private Mezzo luogodiValidazione;
	
	private boolean valid = true;
	
	public Biglietto() {
		super();
	}

	public LocalDate getDatadiValidazione() {
		return datadiValidazione;
	}

	public void setDatadiValidazione(LocalDate datadiValidazione) {
		this.datadiValidazione = datadiValidazione;
	}

	public Mezzo getLuogodiValidazione() {
		return luogodiValidazione;
	}

	public void setLuogodiValidazione(Mezzo luogodiValidazione) {
		this.luogodiValidazione = luogodiValidazione;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "Biglietto" + super.toString() + "datadiValidazione=" + datadiValidazione + ", luogodiValidazione=" + luogodiValidazione
				+ ", valid=" + valid + "]";
	}
	

}
