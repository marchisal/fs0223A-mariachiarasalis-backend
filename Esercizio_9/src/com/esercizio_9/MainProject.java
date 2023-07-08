package com.esercizio_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	static Logger log = LoggerFactory.getLogger(MainProject.class);

	static List<Product> listaProduct = new ArrayList<Product>();
	static List<Order> listaOrder = new ArrayList<Order>();
	
	
	

	public static void main(String[] args) {

		Product p1 = new Product(7l, "LOTR", "books", 199.00);
		Product p2 = new Product(9l, "Biberon", "Baby", 200.00);
		Product p3 = new Product(5l, "Il cimitero di Parigi", "books", 60.00);
		Product p4 = new Product(23l, "Pannolini", "Boys", 500.00);
		Product p5 = new Product(18l, "La vita di B", "books", 1000.00);
		
		listaProduct.add(p1); //String name, String category, double price
		listaProduct.add(p2);
		listaProduct.add(p3);
		listaProduct.add(p4);
		listaProduct.add(p5);
		
		
		
		Customer gigio = new Customer(7l, "Gigio", 2);
		Customer alfonso = new Customer(9l, "Alfonso", 5);
		Customer giulia = new Customer(5l, "Giulia", 2);
		
		Order order_1 = new Order(7l, "shipping", LocalDate.of(2021, 1, 25), LocalDate.of(2021, 01, 30), Arrays.asList(p1, p3), gigio);
		Order order_2 = new Order(9l, "ready", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 02, 06), Arrays.asList(p4, p5), alfonso);
		Order order_3 = new Order(5l, "Not shipped", LocalDate.of(2021, 5, 9), LocalDate.of(2021, 05, 12), Arrays.asList(p2, p3), giulia);
		
		listaOrder.add(order_1);
		listaOrder.add(order_2);
		listaOrder.add(order_3);
		
		
		//ESERIZIO 1
		//Ottenere una lista di prodotti che appartengono alla categoria «Books» ed hanno un prezzo > 100
		
		List<Product> Books = (List<Product>) listaProduct.stream()
				.filter(e -> e.getCategory().equalsIgnoreCase("books"))
				.filter (e -> e.getPrice() >100)
				.collect(Collectors.toList());
		Books.forEach(e -> {
			log.info("Books' price over €100: " + e.toString());
		});
//------------------------------------------------------------------
		
			
		List<Product> Baby = (List<Product>) listaProduct.stream()
				.filter(b -> b.getCategory().equalsIgnoreCase(null))
				.collect(Collectors.toList());
		Baby.forEach(b -> {
			log.info("Category baby: " + b.toString());
		});
			
		
		
		//ESERCIZIO 2
		//Ottenere una lista di ordini con prodotti che appartengono alla categoria «Baby»
		
		
		
		
		//Esercizio 3
		//Ottenere una lista di prodotti che appartengono alla categoria «Boys» ed applicare 10% di sconto al loro prezzo
		
		
		
		
		//Esercizio 4
		//Ottenere una lista di prodotti ordinati da clienti di livello (tier) 2 tra l'Ol-Feb-2021 e l'Ol-Apr-2021
		
		
		
		
		
		
	}
}