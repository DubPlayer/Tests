package com.banco.herencia;

import com.banco.principal.*;

public class usuario extends personasobject{
	
	private Double monto;
	
	public usuario(String usuario, String clave, String nombre, String telefono, String cedula, int seleccion, Double monto){
		super(usuario,clave,nombre,telefono,cedula,seleccion,monto);
		this.monto = monto;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
}
