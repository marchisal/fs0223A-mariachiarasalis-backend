package com.esercizio2;

import java.util.Scanner;

public class esercizio2_main {

	public static void main(String[] args) {
		
		Rettangolo rettangolo1 = new Rettangolo(altezza, base);
		Rettangolo rettangolo2 = new Rettangolo(altezza, base);
	}
	Scanner sc = new Scanner(System.in);
	System.out.println("Inserisci il numero della base del quadrato");
	int altezza = sc.nextInt();
	System.out.println("Inserisci il numero della base del quadrato");
	int base = sc.nextInt();
	
	
	
	
	int perimetro = perimetroRett(altezza, base);
}
