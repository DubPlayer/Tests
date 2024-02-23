package com.inventario.principal;


public class productos {


	private int num;
	private String codigo;
	private String nombre;
	private Double precio;
	private int descuento;
	private int cantidad;
	
	public productos(){
		
	}
	
	public productos(int num, String codigo, String nombre, Double precio, int descuento, int cantidad) {
		
		this.num = num;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.cantidad = cantidad;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	public int getDescuento() {
		return descuento;
	}
	
	public void getDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void getCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
