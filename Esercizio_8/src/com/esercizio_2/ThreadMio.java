package com.esercizio_2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadMio extends Thread {
	
	Logger log =LoggerFactory.getLogger(ThreadMio.class);
	 
	private int[] array;
	private List<Integer> listaParziali;
	private int numIniziale;
	private int numFinale;
	
	
	public ThreadMio(int[] array, List<Integer> listaParziali, int numIniziale, int numFinale) {
		super();
		this.array = array;
		this.listaParziali = listaParziali;
		this.numIniziale = numIniziale;
		this.numFinale = numFinale;
	}

	@Override
	public void run() {
		int somma = 0;
		for(int i = numIniziale; i < numFinale; i++) {
			somma += array[i];
		}
		this.listaParziali.add(somma);
		log.info("Somma("+numIniziale+" - "+numFinale+"): " + somma);
	}
	
	
	

}
