import java.util.Scanner;
import java.text.DecimalFormat;

public class InventarioExamen {

	public static void main(String[] args) {
		
		double IVA = 0.16, tasa = 33.04;
		 DecimalFormat df = new DecimalFormat("#.##");
		
		Scanner sc = new Scanner(System.in);
		
		int seleccion = 0, cuantos = 0, vivo = 1, cantidad = 0, repetido = 0,unidades = 0,configurar = 0, valido = 0, ID = 0, edit = 0, encontrado = 0, escoger = 0;
		String codigo = "", nombre = "", editar = "",nombrepromayor = "", nombrepromenor = "";
		double precio = 0.0, preciomayor = 0.0, preciomenor = 0.0,totalbruto = 0.0, totalbrutobs = 0.0, totalneto = 0.0, totalnetobs = 0.0;
		
	
		String codigos[] = new String[99];
		String nombres[] = new String[99];
		int cantidades[] = new int[99];
		double precios[] = new double[99];
		for(int i = 0; i<codigos.length; i++){
		}
	
		do{
			
			System.out.println("Progama de inventario, que desea hacer? \n [1] Agregar productos \n [2] Editar productos (ver lista) \n [3] Escoger un producto para ver \n [4] Estadistica \n [5] Configuracion del sistema \n [6] Salir");
			seleccion = sc.nextInt();
			switch(seleccion){
			
			case 1:
				//agregar productos
				System.out.println("Cuantos productos va a ingresar?");
				cuantos = sc.nextInt();
				
				for(int i = 0; i<cuantos; i++){
					System.out.println("Ingrese el codigo del producto ["+(cantidad+1)+ "] ej 0000: ");
					codigo = sc.next();
					
					
					for(int l = 0; l<codigos.length; l++) {
						
						if(codigo.equals(codigos[l])) {
							
							repetido = 1;
							
						} 
						
					}
					if(repetido == 1){
					    System.out.println("Codigo ya introducido anteriormente, abortando procedimiento");
					    repetido = 0;
					    i--;
					   
					    break;
					}else{
						System.out.println("Ingrese el nombre del producto ["+(cantidad+1)+ "] ej Manzana: ");
						nombre = sc.next();
						
						System.out.println("Ingrese cuantas unidades del producto ["+(cantidad+1)+ "] va a ingresar, ej 10: ");
						unidades = sc.nextInt();
						while(unidades < 0){
							System.out.println("No puede ser un numero negativo, vuelva a ingresar: ");
							unidades = sc.nextInt();
						}
						System.out.println("Ingrese el precio del producto ["+(cantidad+1)+ "] en $: ");
						precio = sc.nextDouble();
						while(precio <= 0){
							System.out.println("No puede ser un numero negativo ni 0, vuelva a ingresar: ");
							precio = sc.nextDouble();
						}
							
						
					}
					
					codigos[cantidad] = codigo;	
					nombres[cantidad] = nombre;	
					cantidades[cantidad] = unidades;
					precios[cantidad] = precio;	
					cantidad++;
					
					
				}
				
	
				
				
				
				
		
				
			break;
	
			case 2:
				if(cantidad == 0) {
					System.out.println("No hay nada que mostrar");
				}else {
					for(int i = 0; i<cantidad; i++) {
						System.out.println("Producto " + (i+1)+ ":" +
											" \n Codigo del producto: " + codigos[i] + 
								           " \n Nombre del producto: " + nombres[i]+
								           " \n Unidades del producto: " + cantidades[i]+
								          " \n Precio $: " + df.format(precios[i]) +" \n Precio bs: " + (df.format(precios[i] * tasa)) + " \n") ;
						
						
					}
					System.out.println("Que producto desea editar? indique el codigo del producto: ");
					editar = sc.next();
					
						for(int l = 0; l<cantidad; l++) {
						
						if(editar.equals(codigos[l])) {
							ID = l;
							encontrado = 1;
							}
							
						}
						if(encontrado == 1){
    						System.out.println("Producto escogido: [" + (ID+1) + "]");
    						
    						
    						System.out.println("Ingrese el nombre del producto ["+(ID+1)+ "] ej Manzana: ");
    						nombre = sc.next();
    						
    						System.out.println("Ingrese cuantas unidades del producto ["+(ID+1)+ "] va a ingresar, ej 10: ");
    						unidades = sc.nextInt();
    						while(unidades < 0){
    							System.out.println("No puede ser un numero negativo, vuelva a ingresar: ");
    							unidades = sc.nextInt();
    						}
    						System.out.println("Ingrese el precio del producto ["+(ID+1)+ "] en $: ");
    						precio = sc.nextDouble();
    						while(precio <= 0){
    							System.out.println("No puede ser un numero negativo ni 0, vuelva a ingresar: ");
    							precio = sc.nextDouble();
    						}
    							nombres[ID] = nombre;	
            					cantidades[ID] = unidades;
            					precios[ID] = precio;	
    						
    						System.out.println("Modificacion realizada. ");
						}else{
							    System.out.println("Codigo no encontrado"); break;
							}
					editar = "";
				}

			break;
	
			case 3:
				if(cantidad == 0) {
					System.out.println("No hay nada que mostrar");
				}else{
				    	System.out.println("Ahora mismo existen: "+cantidad + "productos escoja un numero del 1 al " + cantidad +" para mostrar");
				    	escoger = sc.nextInt();
				    	if(escoger <= cantidad) {
				    		
				    	
				    	escoger--;
				    	
				    	System.out.println("Producto " + (escoger+1)+ ":" +" \n Codigo del producto: " + codigos[escoger] + " \n Nombre del producto: " + nombres[escoger]+ " \n Precio $: " + precios[escoger] +" \n Precio bs: " + (precios[escoger] * tasa) + " \n" +  " \n Unidades del producto: " + cantidades[escoger]);
				    	}else{System.out.println("Producto inexistente");
				    		}
				   
				}
				
			break;
	
			case 4:
				if(cantidad == 0) {
					System.out.println("No hay nada que mostrar");
				}else{
					
					// VERIFICACION
					
					for(int i = 0; i<cantidad; i++) {
						
						if(i == 0){
							
							nombrepromayor = nombres[i];
							preciomayor = precios[i];
							
							nombrepromenor = nombres[i];
							preciomenor = precios[i];
							
						
						}else if(i >= 1){
						
							if(preciomayor < precios[i]){
								preciomayor = precios[i];
								nombrepromayor = nombres[i];
						
							}else if(preciomenor > precios[i]){
								preciomenor = precios[i];
								nombrepromenor = nombres[i];
						
							}
			
						}
					}
					
					System.out.println("INVENTARIO [ESTADISTICAS]\n \n");
					
					System.out.println("Total de productos: " + cantidad);
					//preciomayor = precio;
					//nombrepromayor = nombre;
					System.out.println("Producto mas caro: [" + nombrepromayor + "] con un precio de: [" + df.format(preciomayor) + "$]. Precio en bs: [" + (preciomayor * tasa) + "]");
					System.out.println("Producto mas barato: [" + nombrepromenor + "] con un precio de: [" + df.format(preciomenor) + "$]. Precio en bs: [" + (preciomenor * tasa) + "]");
					
					System.out.println("Productos con cantidad 0: ");
					for(int i = 0; i<cantidad; i++) {
						
						if(cantidades[i] == 0) {
							System.out.println("El producto: "+ nombres[i] + " Tiene 0 unidades");
						}
						
					}
					for(int i = 0; i<cantidad; i++){
						
						totalbruto += precios[i] * cantidades[i];
						
						totalbrutobs = totalbruto * tasa;
						
						totalneto += cantidades[i] * (precios[i] + (precios[i] * IVA) ) ;
						
						totalnetobs = totalneto * tasa;
					}
					
					
					System.out.println("El precio bruto total en $ es de: ["  + df.format(totalbruto) + "$]");
					System.out.println("El precio bruto total en BS es de: ["  + df.format(totalbrutobs)+ "Bs]");
					System.out.println( "El precio neto total en $ es de: [" + df.format(totalneto)+ "$]");
					System.out.println( "El precio neto total en BS es de: [" + df.format(totalnetobs)+ "Bs]");
					totalbruto = 0;
					totalnetobs = 0;
					totalneto = 0;
					totalnetobs = 0;
					
				}
				
			break;
	
			case 5:
				
				do {
					System.out.println("CONFIGURACION DEL SISTEMA");
					System.out.println("[1]  ACTUALIZAR IVA");
					System.out.println("[2] ACTUALIZAR TASA");
					System.out.println("[3] --- SALIR --- ");
					configurar = sc.nextInt();
					
					switch(configurar){
					
						case 1:
							System.out.println("IVA actual: " + IVA + ", ingrese nuevo IVA FORMATO: #.##");
							IVA = sc.nextDouble();
						break;
						
						case 2:
							System.out.println("Tasa actual: " + tasa + ", ingrese nueva tasa FORMATO: ##.##");
							tasa = sc.nextDouble();
						break;
							
						case 3:
							//VACIO
						break;
						
						default:
							System.out.println("error");
						break;
						
					}
			 }while(configurar != 3);
				
			break;
	
			case 6:
				vivo = 0;
				System.err.println("termino el programa");
				
			break;
	
			default:
			
			break;
			}
		}while(vivo == 1);

	}

}