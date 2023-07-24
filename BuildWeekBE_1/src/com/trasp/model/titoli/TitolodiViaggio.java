package com.trasp.model.titoli;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.trasp.model.rivenditori.Rivenditore;

@MappedSuperclass
public abstract class TitolodiViaggio {
	
	@Id
	@SequenceGenerator(name = "titolodiViaggio_seq", sequenceName = "titolodiViaggio_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="titolodiViaggio_seq")
	private Long id;
	private LocalDate datadiEmissione;
	@ManyToOne
	private Rivenditore luogodiAcquisto;

	public TitolodiViaggio() {
		super();
		setDatadiEmissione(LocalDate.now());
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDatadiEmissione() {
		return datadiEmissione;
	}

	public void setDatadiEmissione(LocalDate datadiEmissione) {
		this.datadiEmissione = datadiEmissione;
	}

	public Rivenditore getLuogodiAcquisto() {
		return luogodiAcquisto;
	}

	public void setLuogodiAcquisto(Rivenditore luogodiAcquisto) {
		this.luogodiAcquisto = luogodiAcquisto;
	}

	@Override
	public String toString() {
		return "TitolodiViaggio [id=" + id + ", datadiEmissione=" + datadiEmissione + ", luogodiAcquisto="
				+ luogodiAcquisto + "]";
	}

	
}
