package it.epicode.be;

import java.util.Scanner;

public class Helloworld {
	
	static String[] arrFive = {"Ciao", "Ciao", "Ciao", "Ciao", "Ciao"};

	public static void main(String[] args) {
		// Stampa a console la frase
		System.out.println("This is my first Epicode Java Project!");
		
		System.out.println(molt(3, 4));
		
		System.out.println(conc(10, "hhh"));
		
		String[] resInserisciInArray = insert(arrFive, "Test");
		//per stampare un array ho bisogno di iterarlo
		for (int i = 0; i<resInserisciInArray.length; i++) {
			System.out.println(resInserisciInArray[i]);
		}
		
		//main1();
		System.out.println(perimetroRettangolo(12.5, 5.6));
		System.out.println(pariDispari(5));
		main2();
	}

//primo metodo
	public static int molt(int x, int y) {
		int result = x * y;
		return result;
	}

//secondo metodo
	public static String conc(int str1, String str2) {
		String result = str1 + str2;
		return result;
	}
		
// terzo metodo
		public static String[] insert(String[] x, String y) {
			String[] arr = new String[5];
			arr[0] = x[0];
			arr[1] = x[1];
			arr[2] = x[2];
			arr[3] = y;
			arr[4] = x[4];
			return arr;
		}
		
//scanner
		public static void main1() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Inserisci il nome");
			String nome = sc.nextLine();
			System.out.println("Inserisci il cognome");
			String cognome = sc.nextLine();
			System.out.println("Inserisci la citta");
			String citta = sc.nextLine();
			System.out.println(nome + cognome + citta);
			System.out.println(citta + cognome + nome);
			}
		
//perimetroRettangolo
		public static double perimetroRettangolo(double x, double y) {
			return (x + y)*2;
		}
		
//pariDispari
		public static int pariDispari(int x){
			if(x% 2 == 0) {
				return 0;
			}else {
				return 1;
			}
		}
		
//scrittodall'utente
		public static void main2() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Inserisci il numero della base del quadrato");
			double x = sc.nextDouble();
			System.out.println("Inserisci il numero dell'altezza del quadrato");
			double y = sc.nextDouble();
			System.out.println("Inserisci un numero");
			int z = sc.nextInt();
		
			double perimetro = perimetroRettangolo(x, y);
			int result = pariDispari(z);
			System.out.println("Il risultato è " + perimetro + " e il resto è " + result);
		}
		
}
