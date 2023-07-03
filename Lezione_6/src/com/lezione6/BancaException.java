package com.lezione6;

public class BancaException extends Exception {
	
	

	public BancaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BancaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getMessage();
	}

	

	
}
