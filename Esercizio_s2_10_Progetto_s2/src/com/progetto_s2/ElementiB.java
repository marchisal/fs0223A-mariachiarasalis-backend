package com.progetto_s2;

public class ElementiB {
	
	private String codiceISBM;
	private String titolo;
	private int annoDiPubblicazione;
	private int numeroPagine;
	
	public ElementiB(String codiceISBM, String titolo, int annoDiPubblicazione, int numeroPagine) {
		super();
		this.codiceISBM = codiceISBM;
		this.titolo = titolo;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getCodiceISBM() {
		return codiceISBM;
	}

	public void setCodiceISBM(String codiceISBM) {
		this.codiceISBM = codiceISBM;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoDiPubblicazione() {
		return annoDiPubblicazione;
	}

	public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
		this.annoDiPubblicazione = annoDiPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Archivio [codiceISBM=" + codiceISBM + ", titolo=" + titolo + ", annoDiPubblicazione="
				+ annoDiPubblicazione + ", numeroPagine=" + numeroPagine + "]";
	}
}
