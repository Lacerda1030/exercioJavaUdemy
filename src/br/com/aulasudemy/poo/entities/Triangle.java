package br.com.aulasudemy.poo.entities;

public class Triangle {
	
	public Double a;
	public Double b;
	public Double c;
	
	public Double area() {
		Double p;
		Double result;
		p = (a + b + c)/2.0;
		result = Math.sqrt(p *(p-a) * (p-b) * (p-c));
		return result;
	}

}
