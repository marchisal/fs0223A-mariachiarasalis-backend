package com.esercizio_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject_esercizio_8 {
	Logger log = LoggerFactory.getLogger(MainProject_esercizio_8.class);
	
	
	public static void main(String[] args) {
		ThreadExerc t1 = new ThreadExerc("*");
		t1.start();
		ThreadExerc t2 = new ThreadExerc("#");
		t2.start();
		

	}

}
