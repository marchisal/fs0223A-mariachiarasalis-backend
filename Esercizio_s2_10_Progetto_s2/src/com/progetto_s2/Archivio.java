package com.progetto_s2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class Archivio {

	private List<ElementiB> archivio = new ArrayList<ElementiB>();

	public Archivio() {
		super();
		this.archivio = new ArrayList<>();
	}

	public List<ElementiB> getArchivio() {
		return archivio;
	}

	public void setArchivio(List<ElementiB> archivio) {
		this.archivio = archivio;
	}

	@Override
	public String toString() {
		return "Archivio [archivio=" + archivio + "]";
	}

	public void addE(ElementiB e) {
		this.archivio.add(e);
	}

	public void deleteEByISBM(String codiceISBM) {
		this.archivio = this.archivio.stream().filter(e -> !e.getCodiceISBM().equalsIgnoreCase(codiceISBM))
				.collect(Collectors.toList());

	}

	public void findByISBM(String codiceISBM) {
		this.archivio.stream().filter(e -> e.getCodiceISBM().equalsIgnoreCase(codiceISBM)).forEach(e -> {
			System.out.println(e);
		});
	}

	public void findByYear(int annoDiPubblicazione) {
		this.archivio.stream().filter(e -> e.getAnnoDiPubblicazione() == annoDiPubblicazione).forEach(e -> {
			System.out.println(e);
		});
	}

	public void findByAuthor(String autore) {
		this.archivio.stream().forEach(e -> {
			if (e.getClass() == Libro.class) {
				Libro l = (Libro) e;
				l.getAutore();
				if (l.getAutore().equals(autore)) {
					System.out.println(l);
				}
			}
		});
	}

	public static void writeArchivio(Archivio ElementiB) throws IOException {
		String stringElementiB = "";
		for (ElementiB i : ElementiB.getArchivio()) {
			if (i.getClass() == Libro.class) {
				Libro l = (Libro) i;
				stringElementiB += l.getTitolo() + "#" 
						+ l.getCodiceISBM() + "#" 
						+ l.getAnnoDiPubblicazione() + "#"
						+ l.getNumeroPagine() + "#" 
						+ l.getAutore() + "#";
			} else {
				Rivista r = (Rivista) i;
				stringElementiB += r.getCodiceISBM() + "#" 
						+ r.getTitolo() + "#" 
						+ r.getAnnoDiPubblicazione() + "#" 
						+ r.getNumeroPagine() + "#" 
						+ r.getPeriodicita() + "#";
			}
			;
			File archivioFile = new File("Archivio/archivio.txt");
			FileUtils.writeStringToFile(archivioFile, stringElementiB, "UTF-8");
		}
	}
	
	
//	public static Archivio readArchivio() throws IOException{
//		File archivioFile  = new File("Archivio/archivio.txt");
//		String readFileToString = FileUtils.readFileToString(archivioFile, "UTF-8");
//		String[] splitElementiB = readFileToString.split("#");
//		ElementiB elementib = new Libro(Integer.valueOf(splitElementiB[0]), splitElementiB[1], splitElementiB[2], splitElementiB[3], splitElementiB[4], splitElementiB[5]);
//		return elementib;
//	}
	
}
