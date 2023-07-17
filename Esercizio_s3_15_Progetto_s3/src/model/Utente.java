package model;

public class Utente {
	
	private String nome;
	private String cognome;
	private int dataDiNascita;
	private int numeroDiTessera;
	
	public Utente(String nome, String cognome, int dataDiNascita, int numeroDiTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTessera = numeroDiTessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(int dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public int getNumeroDiTessera() {
		return numeroDiTessera;
	}

	public void setNumeroDiTessera(int numeroDiTessera) {
		this.numeroDiTessera = numeroDiTessera;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", numeroDiTessera=" + numeroDiTessera + "]";
	}
	
	

}
