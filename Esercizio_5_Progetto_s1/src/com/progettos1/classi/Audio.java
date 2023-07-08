package com.progettos1.classi;

import com.progettos1.interfaces.IVolume;

public class Audio extends ElementoMultimediale implements IVolume{
	private int volume;
	private int durata;
	
	public Audio(String titolo, int volume, int durata) {
		super(titolo);
		this.volume = volume;
		this.durata = durata;
	}
	
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}


	public void alzaVolume() {
		 this.volume ++;
	};
	public void abbassaVolume() {
		 this.volume --;
	};	
	
	
	
	
	


	@Override
	public String toString() {
		return "Audio [volume=" + volume + ", durata=" + durata + ", toString()=" + super.toString() + "]";
	}


	public void play() {
		for(int i=0; i<this.durata; i++) {
			System.out.print(this.getTitolo());
			for(int y=0; y<this.volume; y++) {
				System.out.print("!");
			}
			System.out.println("");
		}
	}
	
	
}
