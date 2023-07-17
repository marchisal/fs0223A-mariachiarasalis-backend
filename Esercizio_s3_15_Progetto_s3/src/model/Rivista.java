package model;

import javax.persistence.Entity;

@Entity
public class Rivista extends ElementiB {
	
	Periodicità periodicità;
	
	public Rivista() {
		super();
	}

	public Rivista(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
	}

	public Periodicità getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Periodicità periodicità) {
		this.periodicità = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista [periodicità=" + periodicità + "]";
	}
	
	
}
