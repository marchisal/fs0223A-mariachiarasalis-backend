package com.lezione4;

public class Dipendente {
	
	static public double stipendioBase = 1000;
	private int matricola;
	private double stipendio;
	public double importoOrarioStraordinario;
	private Livello livello;
	public Dipartimento dipartimento;
	
	public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario, Livello livello,
			Dipartimento dipartimento) {
		super();
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	public Dipendente(int matricola, Dipartimento dipartimento) {
		super();
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public static double getStipendioBase() {
		return stipendioBase;
	}

	public int getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public Livello getLivello() {
		return livello;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Dipendente matricola: " + matricola + ", stipendio: " + stipendio + ", livello dipendente: " + livello + ", nel dipartimento: " + dipartimento + ", importo orario straordinario: " + importoOrarioStraordinario);
	}
	
	public void promuovi() {
		switch (this.livello) {
		case OPERAIO:
			this.livello = Livello.IMPIEGATO;
			this.stipendio = stipendioBase*1.2;
			System.out.println(" è stata promossa a " + this.livello + " e prende ora " + this.stipendio);
			break;
		case IMPIEGATO:
			this.livello = Livello.QUADRO;
			this.stipendio = stipendioBase*1.5;
			System.out.println(" è stata promossa a " + this.livello + " e prende ora " + this.stipendio);
			break;
		case QUADRO:
			this.livello = Livello.DIRIGENTE;
			this.stipendio = stipendioBase*2;
			System.out.println(" è stata promossa a " + this.livello + " e prende ora " + this.stipendio);
			break;
		default: System.out.println("ERRORE");
		}
	};
	
	public static double calcolaPaga(Dipendente dipendente) {
		return dipendente.stipendio;
	};
	
	public static double calcolaPagaStrao(Dipendente dipendente, int oreS) {
		return dipendente.stipendio + (oreS * dipendente.importoOrarioStraordinario);
	};
	
}
