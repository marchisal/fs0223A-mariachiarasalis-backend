package model;

import javax.persistence.Entity;

@Entity
public class Libri extends ElementiB {
 
	private String autore;
	private String genere;

	
	
	public Libri() {
		super();
	}

	public Libri(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
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
		return "Libri [autore=" + autore + ", genere=" + genere + "]";
	}
	
	
	
}
