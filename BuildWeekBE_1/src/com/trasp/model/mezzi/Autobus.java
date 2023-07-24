package com.trasp.model.mezzi;

import javax.persistence.Entity;

@Entity
public class Autobus extends Mezzo {

	public Autobus() {
		super();
		this.setCapienza(30);
	}
	
}
