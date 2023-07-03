package com.progettos1.classi;

import com.progettos1.interfaces.ILumen;
import com.progettos1.interfaces.IVolume;

public class Video extends ElementoMultimediale implements IVolume, ILumen {

	private int lumen;
	private int durata;
	private int volume;
	
	public Video(String titolo, int lumen, int durata, int volume) {
		super(titolo);
		this.lumen = lumen;
		this.durata = durata;
		this.volume = volume;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Video [lumen=" + lumen + ", durata=" + durata + ", volume=" + volume + ", toString()="
				+ super.toString() + "]";
	}




	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getLumen() {
		return lumen;
	}

	public void setLumen(int lumen) {
		this.lumen = lumen;
	}

	
	@Override
	public void alzaVolume() {
		this.volume++;
	};
	
	@Override
	public void abbassaVolume() {
		this.volume--;
	}

	@Override
	public void alzaLumen() {
		this.lumen++;
	};

	@Override
	public void abbassaLumen() {
		this.lumen--;
	};
	

	public void play() {
		for(int i=0; i<this.durata; i++) {
			System.out.print(this.getTitolo());
			for(int y=0; y<this.volume; y++) {
				System.out.print("!");
			}
			System.out.println("");
		}
	}
	
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
