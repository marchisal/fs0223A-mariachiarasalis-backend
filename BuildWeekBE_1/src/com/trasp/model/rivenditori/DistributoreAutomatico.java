package com.trasp.model.rivenditori;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.trasp.enums.StatodiServizio;

@Entity
@DiscriminatorValue("DistributoreAutomatico")
public class DistributoreAutomatico extends Rivenditore {

	@Enumerated(EnumType.STRING)
	private StatodiServizio status = StatodiServizio.ATTIVO;

	public DistributoreAutomatico() {
		super();
	}

	public StatodiServizio getStatus() {
		return status;
	}

	public void setStatus(StatodiServizio status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DistributoreAutomatico" + super.toString() + "status=" + status + "]";
	}

}
