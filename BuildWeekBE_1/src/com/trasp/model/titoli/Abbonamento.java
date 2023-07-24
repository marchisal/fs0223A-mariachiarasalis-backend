package com.trasp.model.titoli;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.trasp.enums.Durata;

@Entity
@NamedQuery(name = "findAbbonamentiByRivenditore", query = "SELECT a FROM Abbonamento a WHERE a.luogodiAcquisto.id = :idRivenditore")
@NamedQuery(name = "findAbbonamentiByDate", query = "SELECT a FROM Abbonamento a WHERE a.datadiEmissione >= :inizio AND a.datadiEmissione <= :fine")
@NamedQuery(name = "printAllAbbonamenti", query = "SELECT a FROM Abbonamento a")
public class Abbonamento extends TitolodiViaggio {

	@OneToOne(mappedBy = "abbonamento")
	private Tessera tessera;
	@Enumerated(EnumType.STRING)
	private Durata durata;
	private LocalDate datadiScadenza;

	public Abbonamento() {
		super();
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public Durata getDurata() {
		return durata;
	}

	public void setDurata(Durata durata) {
		this.durata = durata;
	}
	
	public LocalDate getDatadiScadenza() {
		return datadiScadenza;
	}

	public void setDatadiScadenza(LocalDate datadiScadenza) {
		this.datadiScadenza = datadiScadenza;
	}

	@Override
	public String toString() {
		return "Abbonamento" + super.toString() + "tessera=" + tessera.getNumeroTessera() + ", durata=" + durata + ", datadiScadenza=" + datadiScadenza + "]";
	}

	

}
