package com.inventario.calculos;


public class Calculos {

	public Double bruto(int cantidad, Double precio) {
	
		double suma = cantidad * precio;
		
		return suma;
		
	}
	public Double neto(int cantidad, Double precio, Double IVAact) {
	
		
		double suma = cantidad * (precio + (precio * IVAact));
		
		return suma;
	}
	
	public int cuantosproductos(int cantidad) {
	
		
		int suma = cantidad;
		
		return suma;
	}
}
