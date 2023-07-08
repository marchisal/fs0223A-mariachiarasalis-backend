package com.progetto_s2;

public class Rivista extends ElementiB {
	private Periodicita periodicita;

	public Rivista(String codiceISBM, String titolo, int annoDiPubblicazione, int numeroPagine,
			Periodicita periodicita) {
		super(codiceISBM, titolo, annoDiPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return super.toString()+ "Rivista [periodicita=" + periodicita + "]";
	}

}
