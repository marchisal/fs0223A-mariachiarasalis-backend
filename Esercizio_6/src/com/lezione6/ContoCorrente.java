package com.lezione6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoCorrente {

	static Logger log = LoggerFactory.getLogger(ContoCorrente.class);

	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) throws BancaException {

		if (nMovimenti < maxMovimenti)
			saldo = saldo - x;
		else
			saldo = saldo - x - 0.50;
		nMovimenti++;
		if (saldo < 0) {
			throw new BancaException("Il conto è in rosso");
		}

	}

	double restituisciSaldo() {
		return saldo;
	}
}
