package com.progettos1.classi;

public abstract class ElementoMultimediale {
	private String titolo;
	
	

	public ElementoMultimediale(String titolo) {
		super();
		this.titolo = titolo;
	};
	
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	@Override
	public String toString() {
		return "ElementoMultimediale [titolo=" + titolo + "]";
	}
	
	
}
