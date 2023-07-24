package com.trasp.model.mezzi;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manutenzioni")

public class Manutenzione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate inizioManutenzione;
	private LocalDate fineManutenzione;

	public Manutenzione() {
		super();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getInizioManutenzione() {
		return inizioManutenzione;
	}

	public void setInizioManutenzione(LocalDate inizioManutenzione) {
		this.inizioManutenzione = inizioManutenzione;
	}

	public LocalDate getFineManutenzione() {
		return fineManutenzione;
	}

	public void setFineManutenzione(LocalDate fineManutenzione) {
		this.fineManutenzione = fineManutenzione;
	}

	@Override
	public String toString() {
		return "Manutenzione [id=" + id + ", inizioManutenzione=" + inizioManutenzione + ", fineManutenzione="
				+ fineManutenzione + "]";
	}

}
