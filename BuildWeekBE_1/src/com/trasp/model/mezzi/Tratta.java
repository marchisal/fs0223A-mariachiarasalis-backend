package com.trasp.model.mezzi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tratte")
public class Tratta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double tempoMedio;
	private String capolinea;
	private String zonaDiPartenza;

	public Tratta() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(double tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public String getCapolinea() {
		return capolinea;
	}

	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}

	public Long getId() {
		return id;
	}

	public String getZonaDiPartenza() {
		return zonaDiPartenza;
	}

	public void setZonaDiPartenza(String zonaDiPartenza) {
		this.zonaDiPartenza = zonaDiPartenza;
	}
	
	@Override
	public String toString() {
		return "Tratta [id=" + id + ", nome=" + nome + ", tempoMedio=" + tempoMedio + ", capolinea=" + capolinea
				+ ", zonaDiPartenza=" + zonaDiPartenza + "]";
	}

}
