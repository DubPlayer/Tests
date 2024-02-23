package com.inventario.principal;


import com.inventario.calculos.Calculos;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CodigoPrincipal {
	static int cantidadpro = 0;
	static Double tasacambio = 35.04;
	static Double IVA = 0.16;
	DecimalFormat df = new DecimalFormat("#.##");
	Calculos cal = new Calculos();
 
	List<productos> lista = new ArrayList<productos>();
	

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		CodigoPrincipal es = new CodigoPrincipal();
		

		boolean vivo = true;
	
		int option = 0, cantidadlocal = 0;
		
	
		do{
			System.out.println("Que desea hacer? \n [1] Agregar producto \n [2] Editar producto (seleccionar opcion) \n [3] Lista de productos (buscar por codigo) \n [4] Estadistica \n [5] Configuraciones \n [6] Salir");
			option = sc.nextInt();
			
			switch(option) {
			
			case 1:
				
				es.agregar();
				
			break;
			
			case 2:
				if(cantidadpro == 0) {
					es.print("No hay nada que mostrar");
				}else{
					//Debe ser posible modificar el codigo, eso es como xd pero bueno
					es.editar();
				}
				
				
			break;
			
			case 3:
				if(cantidadpro == 0) {
					System.out.println("No hay nada que mostrar");
				}else{
					
					es.mostrarlista();
	
				}
				
			break;
			
			case 4:
				if(cantidadpro == 0) {
					System.out.println("No hay nada que mostrar");
				}else{	
					// aqui empieza la bromita, la intencion es usar funciones en este caso, para aprender bien el uso de ellas
					
					es.estadistica();
				}
				
			break;
			
			case 5:
				es.config();
			
			break;
			
			case 6:
				vivo = false;
				es.print("Termino el programa");
			break;

			default:
				System.err.println("Error");
			break;
			}
			

		}while(vivo == true);
		

	}
	public void print(String text) {
		System.out.println(text);
	}
	public void agregar() {
		String nombrelocal,codigolocal = null;
		Double preciolocal = null;
		
		int cantidadlocal, descuentolocal = 0;
		boolean bloqueo = false;
		print("Ingrese el codigo del producto: ");
		Scanner sc = new Scanner(System.in);
		
		codigolocal = sc.next();
	
		
		for(int i = 0; i<lista.size(); i++) {
			if(codigolocal.equals(lista.get(i).getCodigo())) {
				print("----- Codigo igual a otro, abortando ------");
			bloqueo = true;
			}
					
		}
		
		if(bloqueo == false) {
			
			print("Ingrese el nombre del producto: ");
			nombrelocal = sc.next();
			
			print("Ingrese el precio del producto: ");
			preciolocal = sc.nextDouble();
			while(preciolocal < 1) {
				print("Ingrese de nuevo, no puede ser 0 o negativo: ");
				preciolocal = sc.nextDouble();
			}
			
			print("Ingrese el descuento del producto, por ej 10, eso seria 10%: ");
			descuentolocal = sc.nextInt();
			while(descuentolocal > 99 || descuentolocal < 1){
				print("Descuento invalido, no puede ser mayor a 99 ni menor a 1");
				descuentolocal = sc.nextInt();
			}
			
			print("Ingrese la cantidad del producto: ");
			cantidadlocal = sc.nextInt();
			while(cantidadlocal < 0) {
				print("cantidad invalida, no ingrese cantidades negativas");
				cantidadlocal = sc.nextInt();
			}
			
			lista.add(new productos(cantidadpro, codigolocal, nombrelocal, preciolocal, descuentolocal, cantidadlocal));			
		
		cantidadpro++;
		}else if (bloqueo == true){
			bloqueo = false;
			print("----- Codigo igual a otro, abortando ------");
		}
		
	}
	public void mostrarlista() {
		
		Scanner sc = new Scanner(System.in);
		String vercodigo = "";
		int ID = 0;
		boolean found = false;
		
		
		print("Lista de productos, por favor, ingrese el codigo del producto que desea ver");
		
		
		for(int i = 0; i<lista.size(); i++) {
			print("Producto [" + (lista.get(i).getNum()+ 1) +"]\n Codigo: " + lista.get(i).getCodigo());
		}
		
		vercodigo = sc.next();
		
		
		for(int i = 0; i<lista.size(); i++) {
			if(vercodigo.equals(lista.get(i).getCodigo())){
				ID = i;
				found = true;
			}
		}
		if(found == true) {
			print("Producto [" + (lista.get(ID).getNum()+ 1) +"]\n Codigo: " + lista.get(ID).getCodigo() + "\n Nombre: " + lista.get(ID).getNombre() + "\n Precio: " + lista.get(ID).getPrecio() + "$ " + (lista.get(ID).getPrecio() * tasacambio) +  "Bs. \n Descuento: "+ lista.get(ID).getDescuento() + "% \n Cantidad: " + lista.get(ID).getCantidad());
			found = false;
		}else{
			print("El codigo ingresado no coincide con el codigo de un producto");
			}
		
	}
	public void editar() {
		
		String nombrelocal = null,codigolocal = null;
		Double preciolocal = null;
		int cantidadlocal = 0,editar,opc = 0,descuentolocal = 0;
		boolean bloqueo = false, valido = false;
		
		Scanner sc = new Scanner(System.in);
		
				print("Bienvenido, primero, que producto desea editar?");
		
		
		for(int i = 0; i<lista.size(); i++) {
			print("Producto [" + (lista.get(i).getNum()+ 1)+ "]");
		}
		
	
		editar = sc.nextInt();
		
		editar--;
		
		if(editar < cantidadpro && editar >= 0) {
			valido = true;
		}else {
			System.err.println("no hay producto en el indice indicado");
		}
		
		if(valido == true) {
		
			do{
				
				
				print("Está editando el producto con el indice " + (editar+1));
				print("Que desea hacer? \n [1] Modificar codigo de producto \n [2] Modificar nombre \n [3] Modificar precio \n [4] Modificar descuento \n [5] Modificar cantidad  \n [6] Salir");
				
				opc = sc.nextInt();
				switch(opc) {
				
				case 1:
					print("Ingrese el nuevo codigo");
					codigolocal = sc.next();
					
					for(int i = 0; i<lista.size(); i++) {
						if(codigolocal.equals(lista.get(i).getCodigo())) {
							
						bloqueo = true;
						}
					}
					if(bloqueo != true) {
					lista.set(editar, new productos(lista.get(editar).getNum(),codigolocal,lista.get(editar).getNombre(),lista.get(editar).getPrecio(),lista.get(editar).getDescuento(),lista.get(editar).getCantidad()));
					}else {
						print("----- Codigo igual a otro, abortando ------");
						bloqueo = false;
					}
				break;
		
				case 2:
					print("Ingrese el nuevo nombre: ");
					nombrelocal = sc.next();
					lista.set(editar, new productos(lista.get(editar).getNum(),lista.get(editar).getCodigo(),nombrelocal,lista.get(editar).getPrecio(),lista.get(editar).getDescuento(),lista.get(editar).getCantidad()));
				break;
				
				case 3:
					print("Ingrese el nuevo precio: ");
					preciolocal = sc.nextDouble();
					while(preciolocal < 1) {
						print("Ingrese de nuevo, no puede ser 0 o negativo: ");
						preciolocal = sc.nextDouble();
					}
					lista.set(editar, new productos(lista.get(editar).getNum(),lista.get(editar).getCodigo(),lista.get(editar).getNombre(),preciolocal,lista.get(editar).getDescuento(),lista.get(editar).getCantidad()));
				break;
				
				case 4:
					print("Modificar descuento: ");
					descuentolocal = sc.nextInt();
					while(descuentolocal > 99 || descuentolocal < 1){
						print("Descuento invalido, no puede ser mayor a 99 ni menor a 1");
						descuentolocal = sc.nextInt();
					}
					lista.set(editar, new productos(lista.get(editar).getNum(),lista.get(editar).getCodigo(),lista.get(editar).getNombre(),lista.get(editar).getPrecio(),descuentolocal,lista.get(editar).getCantidad()));
				break;
					
				case 5:
					print("Modificar cantidad: ");
					cantidadlocal = sc.nextInt();
					lista.set(editar, new productos(lista.get(editar).getNum(),lista.get(editar).getCodigo(),lista.get(editar).getNombre(),lista.get(editar).getPrecio(),lista.get(editar).getDescuento(),cantidadlocal));
					while(cantidadlocal < 0) {
						print("cantidad invalida, no ingrese cantidades negativas");
						cantidadlocal = sc.nextInt();
					}
				break;
				
				case 6:
					print("Salió del menú de edición");
				break;
				
				default:
					System.err.println("error");
				break;
				}
				
			}while(opc != 6);
			valido = false;
		}
		
				
		
	}
	public void config() {
		int opc = 0;
		Double cambiotasa = 0.0; 
		int nuevoiva = 0;
		Scanner sc = new Scanner(System.in);
		
		do{
			print(" [1] Modificar tasa de cambio \n [2] Modificar IVA \n [3] Salir");
			opc = sc.nextInt();
			switch(opc) {
			
			case 1:
				print("Ingrese la nueva tasa de cambio, FORMATO [##.##], tasa actual: " + tasacambio);
				cambiotasa = sc.nextDouble();
				while(cambiotasa < 1) {
					print("No se admiten numero negativos o 0, tasa actual: " + tasacambio);
					cambiotasa = sc.nextDouble();
				}
				tasacambio = cambiotasa;
				print("Cambio realizado, nueva tasa: " + tasacambio);
			break;
			
			case 2:
				print("Ingrese el nuevo IVA, FORMATO [INGRESE 50 Y EL IVA SERA 0.5] --- IVA actual: " + IVA);
				nuevoiva = sc.nextInt();
				while(nuevoiva < 1 || nuevoiva > 99) {
					print("No se admiten numero negativos, mayores a 99 o 0, IVA actual: " + IVA);
					nuevoiva = sc.nextInt();
				}
				IVA = ((double)nuevoiva / 100);
				print("Cambio realizado, nuevo IVA: " + IVA);
			break;
				
			case 3:
				
			break;
			
			default:
				System.err.print("error");
			break;
			}
			
			
			
			
		}while(opc != 3);
	}
	public void estadistica(){
		Double totalbruto = 0.0;
		Double totalneto = 0.0;
		Double precio = 0.0;
		Double total;
		//String nombrepromayor,nombrepromenor,nombrecantidadmayor,nombrecantidadmenor,nombredescuentomayor,nombredescuentomenor;
		Double preciomayor = 0.0,preciomenor = 0.0;
		int cantidadmayor = 0, cantidadmenor = 0,descuentomayor = 0,descuentomenor = 0;

		int cantidad,cuantos;
		int totalproductos = 0;
	
		print("ESTADISTICA DE INVENTARIO");
		//bruto
		for(int i = 0; i<lista.size(); i++) {
			
			cantidad = lista.get(i).getCantidad();
			precio = lista.get(i).getPrecio();
			
			totalbruto += (cal.bruto(cantidad,precio));

		}
	
		
		
		//neto
		for(int i = 0; i<lista.size(); i++) {
			
			cantidad = lista.get(i).getCantidad();
			precio = lista.get(i).getPrecio();
			
			totalneto += cal.neto(cantidad,precio,IVA);
		
			//totaldeproductos
		}

		//PRODUCTOS MAS Y MENOS COSTOSOS $ Y BS, CANTIDADES Y DESCUENTOS
		
		for(int i = 0; i<lista.size(); i++) {
			
			if(i == 0){
				//precios
				preciomayor = lista.get(i).getPrecio();
				
				preciomenor = lista.get(i).getPrecio();
				//cantidades
	
				cantidadmayor = lista.get(i).getCantidad();		
		
				cantidadmenor = lista.get(i).getCantidad();
				//descuentos
		
				descuentomayor = lista.get(i).getDescuento();
			
				descuentomenor = lista.get(i).getDescuento();
				
			}else if(i >= 1){
				//precios
				if(preciomayor < lista.get(i).getPrecio()){
		
					preciomayor = lista.get(i).getPrecio();
			
				}else if(preciomenor > lista.get(i).getPrecio()){
		
					preciomenor = lista.get(i).getPrecio();
				}
				//cantidades
				if(cantidadmayor < lista.get(i).getCantidad()){
			
					cantidadmayor = lista.get(i).getCantidad();
			
				}else if(cantidadmenor > lista.get(i).getCantidad()){
			
					cantidadmenor = lista.get(i).getCantidad();
				}
				//descuentos
				if(descuentomayor < lista.get(i).getDescuento()){
			
					descuentomayor = lista.get(i).getDescuento();
			
				}else if(descuentomenor > lista.get(i).getDescuento()){
		
					descuentomenor = lista.get(i).getDescuento();
				}

			}
		}
		
		
		for(int i = 0; i<lista.size(); i++) {
			
			cuantos = lista.get(i).getCantidad();
			
			totalproductos += cal.cuantosproductos(cuantos);
			
		}
		
		//NETO BRUTO Y CANTIDAD
		System.out.println("Total bruto de los productos: [" +  df.format(totalbruto) + "$]" + "En bs. [" +  df.format((totalbruto * tasacambio)) + "bs]");
		System.out.println("Total neto de los productos: [" +  df.format(totalneto) + "$]" + "En bs. [" +  df.format((totalneto * tasacambio)) + "bs]\n\n\n");
		
		System.out.println("Cantidad de productos ingresados al sistema: " + "[" + cantidadpro +"]");
		
		//PRECIOS CANTIDADES DESCUENTOS ALTOS Y BAJOS
		
		//precios
	print("[Productos con precio mas alto], precio mas alto actual: [" +  df.format(preciomayor) + "$]"+ "En bs. [" +  df.format((preciomayor * tasacambio))+ "]");
		
		for(int i = 0; i<lista.size(); i++){
			
			if(lista.get(i).getPrecio().equals(preciomayor)){
				print(lista.get(i).getNombre());
			}
			
		}
		
	print("[Productos con precio mas bajo], precio mas bajo actual: [" +  df.format(preciomenor) + "$]"+ "En bs. [" +  df.format((preciomenor * tasacambio)) + "]");
		
		for(int i = 0; i<lista.size(); i++){
			
			if(lista.get(i).getPrecio().equals(preciomayor)){
				print(lista.get(i).getNombre());
			}
			
		}
		//cantidad
	print("[Productos con mas existencias], mayor actual: [" +  cantidadmayor + "]");
		
		for(int i = 0; i<lista.size(); i++){
			
			if(lista.get(i).getCantidad() == cantidadmayor){
				print(lista.get(i).getNombre());
			}
			
		}
		
	print("[Productos con menos existencias], menor actual: [" + cantidadmenor + "]");
		
		for(int i = 0; i<lista.size(); i++){
			
			if(lista.get(i).getCantidad() == cantidadmenor){
				print(lista.get(i).getNombre());
			}
			
		}
		//descuento
	print("[Productos con mayor descuento], mayor actual: [" + descuentomayor + "%]");
		
		for(int i = 0; i<lista.size(); i++){
			
			if(lista.get(i).getDescuento() == descuentomayor){
				print(lista.get(i).getNombre());
			}
			
		}
		
	print("[Productos con menor descuento], menor actual: [" + descuentomenor + "%]");
		
		for(int i = 0; i<lista.size(); i++){
			
			if(lista.get(i).getDescuento() == descuentomenor){
				print(lista.get(i).getNombre());
			}
			
		}
		
		


	}
		
}