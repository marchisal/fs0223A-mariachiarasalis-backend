package com.progetto_s2;

public class Libro extends ElementiB {
	
	private String autore;
	private String genere;

	public Libro(String codiceISBM, String titolo, int annoDiPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(codiceISBM, titolo, annoDiPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return super.toString() + "Libro [autore=" + autore + ", genere=" + genere + "]";
	}
	
	
}
