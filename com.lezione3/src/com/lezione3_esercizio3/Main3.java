package com.lezione3_esercizio3;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		//caratteriSep("ciao");
		contoAllaRovescia();

	}

//ESERCIZIO3 - while

	public static void caratteriSep(String s) {
		Scanner sc = new Scanner(System.in);

//		while (!s.equals(":q")) {
//			System.out.println("Inserisci una parola: ");
//			s = sc.nextLine();
//			if (s.equals(":q")) {
//				System.out.println(":q");
//			} else {
//				System.out.println(Arrays.toString(s.split("")));
//				System.out.println(String.join(",", s.split("")));
//			}
//
//		}

		while (!s.equals(":q")) {
			System.out.println("Inserisci una parola: ");
			s = sc.nextLine();
			if (!s.equals(":q")) {
				System.out.println(Arrays.toString(s.split("")));
				System.out.println(String.join(",", s.split("")));
			}

		}
		sc.close();
	}
//	
//	public static void contoAllaRovescia() {
//		System.out.println("Inserisci un numero ");
//		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		for(int i = n; i >= 0; i-- ) {
//			System.out.println(i);
//		}
//		
//	}

}
