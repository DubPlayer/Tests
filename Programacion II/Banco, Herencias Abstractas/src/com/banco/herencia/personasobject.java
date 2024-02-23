package com.banco.herencia;

public class personasobject{
	
	private String usuario;
	private String clave;
	private String nombre;
	private String telefono;
	private String cedula;
	private int seleccion;
	private Double monto;

	public personasobject(String usuario, String clave, String nombre, String telefono, String cedula, int seleccion, Double monto) {
		// TODO Auto-generated constructor stub
		
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.telefono = telefono;
		this.cedula = cedula;
		this.seleccion = seleccion;
		this.monto = monto;
		
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void getString(String cedula) {
		this.cedula = cedula;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
}

