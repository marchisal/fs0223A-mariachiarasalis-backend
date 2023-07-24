package com.trasp.model.mezzi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tratteAssegnate")
@NamedQuery(name = "findRipetizioniTratta", query = "SELECT t FROM TrattaAssegnata t WHERE t.tratta.id = :idTratta")
public class TrattaAssegnata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Tratta tratta;
	private double tempoEffettivo;
	
	public TrattaAssegnata() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	public double getTempoEffettivo() {
		return tempoEffettivo;
	}

	public void setTempoEffettivo(double tempoEffettivo) {
		this.tempoEffettivo = tempoEffettivo;
	}

	@Override
	public String toString() {
		return "TrattaAssegnata [tratta=" + tratta + ", tempoEffettivo=" + tempoEffettivo + "]";
	}
	
}
