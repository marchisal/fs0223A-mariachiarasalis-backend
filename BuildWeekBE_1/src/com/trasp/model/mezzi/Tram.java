package com.trasp.model.mezzi;

import javax.persistence.Entity;

@Entity
public class Tram extends Mezzo {

	public Tram() {
		super();
		this.setCapienza(50);
		
	}	
}
