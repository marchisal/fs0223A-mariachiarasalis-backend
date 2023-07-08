package com.esercizio_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadExerc extends Thread{
	Logger log = LoggerFactory.getLogger(ThreadExerc.class);

	String message;
	
	public ThreadExerc(String message) {
		super();
		this.message = message;
	}
	
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
                log.info("N: " + (i+1) + message);
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
	
	
}
