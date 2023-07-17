package model;

import java.time.LocalDate;

public class Prestito {

	private Utente utente;
	private ElementiB elementoPrestato;
	private LocalDate inizioPrestito;
	private LocalDate restituzionePrevista;
	private LocalDate restituzioneEffettiva;
	public Utente getUtente() {
		return utente;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public ElementiB getElementoPrestato() {
		return elementoPrestato;
	}
	public void setElementoPrestato(ElementiB elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}
	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}
	public void setInizioPrestito(LocalDate inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}
	public LocalDate getRestituzionePrevista() {
		return restituzionePrevista;
	}
	public void setRestituzionePrevista(LocalDate restituzionePrevista) {
		this.restituzionePrevista = restituzionePrevista;
	}
	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}
	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}
	
	
}
