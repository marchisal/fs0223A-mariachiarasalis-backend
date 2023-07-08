package com.progetto_s2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	static Logger log = LoggerFactory.getLogger(MainProject.class);
	
	
			
	public static void main(String[] args) {
		//istanzio libri e riviste 
		Libro l1 = new Libro("987", "LOTR", 1970, 5000, "Tolkien", "fantasy");
		Libro l2 = new Libro("988", "Il cimitero di zia Paola", 1990, 1900, "Cerus", "fantasy");
		Rivista r1 = new Rivista("776", "La Bibbia per i piccoli", 2020, 30, Periodicita.MENSILE);
		Rivista r2 = new Rivista("576", "Gossipnanana", 2023, 10, Periodicita.SETTIMANALE);

		Archivio archivio = new Archivio();
		archivio.addE(l1);
		archivio.addE(l2);
		archivio.addE(r1);
		archivio.addE(r2);
		log.info(archivio.toString());
		
		archivio.deleteEByISBM("988");
		log.info(archivio.toString());
		
		archivio.findByISBM("576");
		
		
		archivio.findByYear(1970);
		
		archivio.findByAuthor("Tolkien");
		
		try {
			Archivio.writeArchivio(archivio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
