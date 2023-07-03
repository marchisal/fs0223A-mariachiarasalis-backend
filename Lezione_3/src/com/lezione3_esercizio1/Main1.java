package com.lezione3_esercizio1;

public class Main1 {

	public static void main(String[] args) {
		
		System.out.println(condizione("armadio"));
		System.out.println(bisestile(12));
		valoreRitornato(5);
		caratteriVirgola("madonna");
	}

//ESERCIZIO1
//lunghezza string
	public static Boolean condizione(String string) {
		if (string.length()% 2 == 0) {
			return true;
		}else{
			return false;
		}
	}
	
//anno bisestile
	public static Boolean bisestile(int n) {
		if (n%4==0) {
			return true;
		}else if (n%100==0 && n%400==0){
			return true;
		}else {
			return false;
		}
		
	}
	
//ESERCIZIO2 - switch
	public static void valoreRitornato(int lin) {
		switch(lin) {
		case 0: System.out.println("zero");
		break;
		case 1: System.out.println("uno");
		break;
		case 2: System.out.println("due");
		break;
		case 3: System.out.println("tre");
		default: System.out.println("Errore");
		}
	}
	

	
	
	
	
	
	
}

