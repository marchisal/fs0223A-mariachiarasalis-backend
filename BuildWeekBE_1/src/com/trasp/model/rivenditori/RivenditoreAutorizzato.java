package com.trasp.model.rivenditori;

import java.time.LocalTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.trasp.enums.TipologiadiRivenditori;

@Entity
@DiscriminatorValue("RivenditoreAutorizzato")
public class RivenditoreAutorizzato extends Rivenditore {

	@Enumerated(EnumType.STRING)
	private TipologiadiRivenditori tipologiadiRivenditore;
	private LocalTime orariodiApertura = LocalTime.of(9, 0);
	private LocalTime orariodiChiusura = LocalTime.of(21, 0);

	public RivenditoreAutorizzato() {
		super();
	}

	public TipologiadiRivenditori getTipoRivenditore() {
		return tipologiadiRivenditore;
	}

	public void setTipoRivenditore(TipologiadiRivenditori tipoRivenditore) {
		this.tipologiadiRivenditore = tipoRivenditore;
	}

	public LocalTime getOrariodiApertura() {
		return orariodiApertura;
	}

	public LocalTime getOrariodiChiusura() {
		return orariodiChiusura;
	}

	@Override
	public String toString() {
		return "RivenditoreAutorizzato" + super.toString() + "tipoRivenditore=" + tipologiadiRivenditore
				+ ", orariodiApertura=" + orariodiApertura + ", orariodiChiusura=" + orariodiChiusura + "]";
	}

}
