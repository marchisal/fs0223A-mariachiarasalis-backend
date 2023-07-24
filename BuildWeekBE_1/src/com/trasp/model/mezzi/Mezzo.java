package com.trasp.model.mezzi;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.trasp.enums.StatodeiMezzi;

@Entity
@Table(name = "mezzi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_mezzo", discriminatorType = DiscriminatorType.STRING)
public class Mezzo {

	@Id
	@SequenceGenerator(name = "mezzo_seq", sequenceName = "mezzo_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mezzo_seq")
	private Long id;
	private int capienza;
	@ManyToMany
	private List<Manutenzione> periodoDiManutenzione;
	@ManyToMany
	private List<TrattaAssegnata> tratteAssegnate;
	@Enumerated(EnumType.STRING)
	private StatodeiMezzi statomezzo;

	public Mezzo() {
		super();
		setStatomezzo(StatodeiMezzi.INSERVIZIO);
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public List<Manutenzione> getPeriodoDiManutenzione() {
		return periodoDiManutenzione;
	}

	public void setPeriodoDiManutenzione(List<Manutenzione> periodoDiManutenzione) {
		this.periodoDiManutenzione = periodoDiManutenzione;
	}

	public List<TrattaAssegnata> getTratteAssegnate() {
		return tratteAssegnate;
	}

	public void setTratteAssegnate(List<TrattaAssegnata> tratteAssegnate) {
		this.tratteAssegnate = tratteAssegnate;
	}

	public Long getId() {
		return id;
	}

	public StatodeiMezzi getStatomezzo() {
		return statomezzo;
	}

	public void setStatomezzo(StatodeiMezzi statomezzo) {
		this.statomezzo = statomezzo;
	}

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", capienza=" + capienza + ", periodoDiManutenzione=" + periodoDiManutenzione
				+ ", tratte assegnate=" + tratteAssegnate + ", statomezzo=" + statomezzo + "]";
	}

}
