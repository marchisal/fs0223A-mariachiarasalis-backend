package com.trasp.control;

import com.trasp.dao.TitoloDAO;
import com.trasp.dao.TrattaDAO;

import com.trasp.dao.MezzoDAO;
import com.trasp.dao.RivenditoreDAO;
import com.trasp.dao.TesseraDAO;
import com.trasp.enums.Durata;
import com.trasp.enums.TipologiadiRivenditori;
import com.trasp.model.mezzi.Autobus;
import com.trasp.model.mezzi.Tram;
import com.trasp.model.mezzi.Tratta;
import com.trasp.model.rivenditori.DistributoreAutomatico;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;

public class GestioneTest {
	
//	### CLASSE PER TESTARE IL PROGRAMMA ###

//		PER GENERARE UN BIGLIETTO ABBIAMO BIOSOGNO DELL'ID DEL RIVENDITORE 
//		CHE LO HA VEDUTO, GLI ALTRI DATI VENGONO GENERATI AUTOMATICAMENTE
	public static void emettiBiglietti() {
		
		TitoloDAO.emissioneBiglietto(1);
		TitoloDAO.emissioneBiglietto(1);
		TitoloDAO.emissioneBiglietto(2);
		TitoloDAO.emissioneBiglietto(2);
		TitoloDAO.emissioneBiglietto(3);
		TitoloDAO.emissioneBiglietto(3);
		TitoloDAO.emissioneBiglietto(2);
		TitoloDAO.emissioneBiglietto(3);
	}

//		PER GENERARE UN RIVENTIRORE AUTORIZZATO ABBIAMO BIOSOGNO DI INSERIRE IL NOME 
//		E LA TIPOLOGIA [ EDICOLA, TABACCHI, SUPERMERCATO ]
	public static void generaRivenditori() {
		
		RivenditoreAutorizzato ra1 = new RivenditoreAutorizzato();
		ra1.setNome("Da Mario");
		ra1.setTipoRivenditore(TipologiadiRivenditori.EDICOLA);
		RivenditoreDAO.saveRivenditore(ra1);
		
		RivenditoreAutorizzato ra2 = new RivenditoreAutorizzato();
		ra2.setNome("Da Maria");
		ra2.setTipoRivenditore(TipologiadiRivenditori.TABACCHI);
		RivenditoreDAO.saveRivenditore(ra2);
		
//		PER GENERARE UN DISTRIBUTORE AUTOMATICO ABBIAMO BIOSOGNO DI INSERIRE IL NOME 
		DistributoreAutomatico da1 = new DistributoreAutomatico();
		da1.setNome("H24 Merendine");
		RivenditoreDAO.saveRivenditore(da1);
		
	}
	
//		PER GENERARE UNA TESSERA E UN UTENTE CHIEDIAMO ALL'UTENTE NOME E COGNOME 
//		SUCCESSIVAMENTE GLI MOSTRIAMO IL NUMERO DELLA SUA TESSERA
	public static void emettiTessere() {
		
		TesseraDAO.emissioneTessera();
		TesseraDAO.emissioneTessera();
		TesseraDAO.emissioneTessera();
	}
	
//		PER VENDERE UN ABBONAMENTO ABBIAMO BISOGNO DELL'ID DEL RIVENDITORE, 
//		IL NUMERO DELLA TESSERA DEL CLIENTE E DELLA DURATA DELL'ABBONAMENTO
	public static void caricaAbbonamenti() {
		
		TitoloDAO.caricaAbbonamento(1, 1, Durata.MENSILE);
		TitoloDAO.caricaAbbonamento(2, 2, Durata.SETTIMANALE);
		TitoloDAO.caricaAbbonamento(2, 3, Durata.SETTIMANALE);
		
	}

	public static void caricaMezzi() {
		
		Autobus a1 = new Autobus();
		MezzoDAO.saveMezzo(a1);
		Autobus a2 = new Autobus();
		MezzoDAO.saveMezzo(a2);
		Autobus a3 = new Autobus();
		MezzoDAO.saveMezzo(a3);
		Autobus a4 = new Autobus();
		MezzoDAO.saveMezzo(a4);
		Autobus a5 = new Autobus();
		MezzoDAO.saveMezzo(a5);
		Autobus a6 = new Autobus();
		MezzoDAO.saveMezzo(a6);
		
		Tram t1 = new Tram();
		MezzoDAO.saveMezzo(t1);
		Tram t2 = new Tram();
		MezzoDAO.saveMezzo(t2);
		Tram t3 = new Tram();
		MezzoDAO.saveMezzo(t3);
		
	}
	
	public static void caricaTratte() {
		
		Tratta t1 = new Tratta();
		t1.setNome("Stazione - Ospedale");
		t1.setCapolinea("Ospedale Malpighi");
		t1.setZonaDiPartenza("Stazione Centrale");
		t1.setTempoMedio(00.27);
		TrattaDAO.saveTratta(t1);
		
		Tratta t2 = new Tratta();
		t2.setNome("Stazione - Stadio");
		t2.setCapolinea("San Siro");
		t2.setZonaDiPartenza("Stazione Centrale");
		t2.setTempoMedio(00.40);
		TrattaDAO.saveTratta(t2);
		
		Tratta t3 = new Tratta();
		t3.setNome("Polisportiva - Stazione");
		t3.setCapolinea("Stazione Centrale");
		t3.setZonaDiPartenza("Polisportiva Alemanni");
		t3.setTempoMedio(1.10);
		TrattaDAO.saveTratta(t3);
		
		Tratta t4 = new Tratta();
		t4.setNome("Stazione - Aereoporto");
		t4.setCapolinea("Aereoporto Linate");
		t4.setZonaDiPartenza("Stazione Centrale");
		t4.setTempoMedio(1.20);
		TrattaDAO.saveTratta(t4);
		
	}

	public static void assegnaTratte() {
		TrattaDAO.assegnaTratta(1, 3);
		TrattaDAO.assegnaTratta(1, 3);
		TrattaDAO.assegnaTratta(1, 3);
		TrattaDAO.assegnaTratta(7, 1);
		TrattaDAO.assegnaTratta(3, 2);
		TrattaDAO.assegnaTratta(7, 1);
		TrattaDAO.assegnaTratta(2, 3);
	}

	public static void dichiaraTempiEffettivi() {
		TrattaDAO.dichiaraTempoEffettivo(2, 0.45);
		TrattaDAO.dichiaraTempoEffettivo(1, 0.30);
		TrattaDAO.dichiaraTempoEffettivo(3, 0.40);
		TrattaDAO.dichiaraTempoEffettivo(6, 1.05);
	}

}
