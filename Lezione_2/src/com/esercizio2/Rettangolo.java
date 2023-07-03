package com.esercizio2;

public class Rettangolo {
	public int altezza;
	public int base;
	public Rettangolo(int altezza, int base){
		this.altezza = altezza;
		this.base = base;
	};
	public static int perimetroRett(int altezza, int base){
		return (altezza + base)*2;
	};
	public static int areaRett(int altezza, int base){
		return altezza * base;
	};
}
