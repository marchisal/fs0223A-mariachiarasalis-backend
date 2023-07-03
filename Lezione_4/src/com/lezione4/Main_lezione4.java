package com.lezione4;

public class Main_lezione4 {

	public static void main(String[] args) {
		Dipendente mary = new Dipendente(0, Dipartimento.PRODUZIONE);
		System.out.println("MARY ----------------------");
		mary.stampaDatiDipendente();
		mary.promuovi();
		
		
		Dipendente giorgio = new Dipendente(0, Dipartimento.PRODUZIONE);
		System.out.println("GIORGIO -----------------------");
		giorgio.stampaDatiDipendente();
		
		
		Dipendente giulia = new Dipendente(0, 1200, 3, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		System.out.println("GIULIA --------------------");
		giulia.stampaDatiDipendente();
		giulia.promuovi();
		
		Dipendente marcello = new Dipendente(0, 2000, 5, Livello.DIRIGENTE, Dipartimento.VENDITE);
		System.out.println("MARCELLO -----------------------");
		marcello.stampaDatiDipendente();
		
		Dipendente.calcolaPagaStrao(marcello, 5);
		Dipendente.calcolaPagaStrao(giulia, 5);
		Dipendente.calcolaPagaStrao(mary, 5);
		Dipendente.calcolaPagaStrao(giorgio, 5);
		
		Dipendente.calcolaPaga(marcello);
		Dipendente.calcolaPaga(giulia);
		Dipendente.calcolaPaga(giorgio);
		Dipendente.calcolaPaga(mary);
		}
}
