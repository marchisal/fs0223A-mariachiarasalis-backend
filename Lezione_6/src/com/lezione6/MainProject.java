package com.lezione6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	static Logger log = LoggerFactory.getLogger(MainProject.class);

	public static void main(String[] args) {
//ESERCIZIO 1
//		int[] arrayS = generaArray();
//		log.info(Arrays.toString(arrayS));
//		changeArray(arrayS);
	
		
//ESERCIZIO 2
	//log.info(calcolaKm()+ "");

	
//ESERCIZIO 3

		
		
	}
	
	
	
	
	
	
	
//ESERCIZIO 1
	public static int[] generaArray() {
		int[] array = new int[5];
		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(11);
		}
		return array;

	}
	public static void changeArray(int[] arrayNuovo) {
		Scanner sc = new Scanner(System.in);
		int val = -1;
		int pos;
		while (val != 0) {

			log.info("Scegli il numero da inserire nell'array o 0 per uscire");

			try {
				val = Integer.parseInt(sc.nextLine());
				if (val == 0) {
					log.info("FINE");
					return;
				}

				if (val < 1 || val > 10) {
					throw new myException("Devi inserire valori tra 1 e 10!!!!!!!!!!!!!!!!!!");
				}
				log.info("Scegli posizione");
				pos = Integer.parseInt(sc.nextLine())-1;

				arrayNuovo[pos] = val;

			} catch (ArrayIndexOutOfBoundsException e) {
				log.error("Scegli una posizione compresa tra 1 e 5!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			} catch (myException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			log.info(Arrays.toString(arrayNuovo));
		}
		

	}


//ESERCIZIO 2
//Scrivere un programma che permetta di calcolare il numero di km/litro percorsi da un'auto. II programma riceve
//dall'utente il numero di km percorsi ed i litri di carburante consumati e stampa i km/litro percorsi. Gestire per
//mezzo del try-catch l'eventualità che l'utente inserisca il valore 0 per il numero di litri consumati e venga generata
//una eccezione di divisione per zero.

	public static double calcolaKm() {
		double consumi = 0;
		Scanner sc = new Scanner(System.in);
		log.info("Inserisci i km");
		int km = sc.nextInt();
		sc.nextLine();
		log.info("Inserisci i litri");
		int litri = sc.nextInt();
		sc.nextLine();
		
		try {
			consumi = km/litri;
		}catch(ArithmeticException e) {
			log.error("Non puoi dividere per 0");
		}
		return consumi;

		}
		
		
		
		
		
		
		
		
	

}