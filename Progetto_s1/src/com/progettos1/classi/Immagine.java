package com.progettos1.classi;

import com.progettos1.interfaces.ILumen;

public class Immagine extends ElementoMultimediale implements ILumen{
	private int lumen;
	
	public Immagine(String titolo, int lumen) {
		super(titolo);
		this.lumen = lumen;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Immagine [lumen=" + lumen + ", toString()=" + super.toString() + "]";
	}





	public int getLumen() {
		return lumen;
	}

	public void setLumen(int lumen) {
		this.lumen = lumen;
	}

	
	
	@Override
	public void alzaLumen() {
		lumen ++;
	};
	
	@Override
	public void abbassaLumen() {
		lumen --;
	};
	
	public void show() {
		for (int i=0; i<lumen; i++) {
		System.out.print(this.getTitolo());
			for (int y=0; y<lumen; y++) {
				System.out.print("*");
			}
		System.out.println("");
		}
	}
}
