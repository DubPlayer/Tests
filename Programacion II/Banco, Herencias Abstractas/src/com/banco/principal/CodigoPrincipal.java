package com.banco.principal;
import com.banco.herencia.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 public class CodigoPrincipal {
	 List<personasobject> listapersonas = new ArrayList<personasobject>();
	 List<operaciones> listaoperaciones = new ArrayList<operaciones>();
	 static int[] baneados = new int[100];
	 usuario user = new usuario (null,null,null,null,null,0,0.0);
	 operador operador = new operador(null,null,null,null,null,0);
 	
	static int cantidadper = 0;
	static int cantidadop = 0;
	static Double tasacambio = 36.21;
	static Scanner sc = new Scanner(System.in);
	static boolean vivo = true;
	
	public static void main(String[] args){
		
		for(int i = 0; i<100; i++) {
			baneados[i] = 0;
		}
		CodigoPrincipal CodP = new CodigoPrincipal();
		
		do{
			System.out.println("Banco, por favor seleccione una opcion \n [1] Registro \n [2] Iniciar Sesion \n [3] Salir");
			int option = sc.nextInt();
			
			switch(option) {
			
			case 1:
			//REGISTRO
				
				CodP.registro();
				
				
			break;
			
			case 2:
				//INICIAR SESION
				if(cantidadper == 0) {
					System.out.println("No hay nada que mostrar");
				}else{
				
				CodP.InicioSesion();
					
				}
				
				
			break;
			
			case 3:
				//SALIR
				vivo = false;
				System.err.println("Termino el programa");
			break;
			
	
			default:
				System.err.println("Error");
			break;
			}
			
	
		}while(vivo == true);
	}
	
	public void registro() {
		//REGISTRO
		int seleccion = 0;
		String usuario = "",clave = "",nombre= "",telefono= "", cedula="";
		boolean bloqueo = false;
	
		print("Bienvenido al registro, quiere registrarse como persona o operador? [1] persona [2] operador");
		seleccion = sc.nextInt();
		while(seleccion != 1 && seleccion != 2) {
			print("Dato no valido, ingrese de nuevo: ");
			seleccion = sc.nextInt();
		}
		
		if(seleccion == 1){
			print("Usted es una persona natural o judicial? [1] persona [0] Judicial");
			seleccion = sc.nextInt();
			while(seleccion != 1 && seleccion != 0) {
				print("Dato no valido, ingrese de nuevo: ");
				seleccion = sc.nextInt();
			}
		}
		//NO SE REPITE
		print("Ingrese su usuario: ");
		
		usuario = sc.next();
		for(int i = 0; i<listapersonas.size(); i++) {
			
		
			if(usuario.equals(listapersonas.get(i).getUsuario())){
				
				print("----- usuario igual a otro, abortando ------");
				bloqueo = true;
				
			}
			
			
			
		}
		if(bloqueo == false){
		
		//NO SE REPITE
			print("Ingrese su numero telefonico: ");
			telefono = sc.next();
			for(int i = 0; i<listapersonas.size(); i++) {
				
				
				if(usuario.equals(listapersonas.get(i).getTelefono())){
					print("----- Telefono igual a otro, abortando ------");
				bloqueo = true;
				}
						
			}
		}
		if(bloqueo == false){
			//NO SE REPITE	
			print("Ingrese su numero de cedula: ");
			cedula = sc.next();
			for(int i = 0; i<listapersonas.size(); i++) {
				
				if(usuario.equals(listapersonas.get(i).getCedula())) {
					print("----- Telefono igual a otro, abortando ------");
				bloqueo = true;
				}
						
			}
		}
		
		if(bloqueo == false){
			
			print("Ingrese su clave: ");
			clave = sc.next();
		
			print("Ingrese su nombre: ");
			nombre = sc.next();
				
		
			
			if(seleccion == 1 || seleccion == 0) {
				usuario user = new usuario (usuario,clave,nombre,telefono,cedula,seleccion,0.0);
				
				listapersonas.add(user);
			
			}else if(seleccion == 2) {
				operador operador = new operador(usuario,clave,nombre,telefono,cedula,seleccion);
				
				listapersonas.add(operador);
					
			}
		
		}
		
		/*
		 //ESTO VERIFICA DE QUE CLASE (OBJETO) PROVIENE EL VALOR RETORNADO DEL LA PROPIEDAD DEL OBJETO, AL FINAL NO SE USO PERO ME QUEDO LINDO
		 if(listapersonas.get(i).getClass().equals(operador.class) && usuario.equals(listapersonas.get(i).getCedula())) {
					print("----- Telefono igual a otro, abortando ------");
				bloqueo = true;
				}
						
		 */
	
			cantidadper++;
			bloqueo = false;
	
	}
	public void print(String text) {
		System.out.println(text);
	}
	public void InicioSesion(){
		boolean entrada = false,found = false; 
		int index = 0,tipopersona = 1,tipooperador = 2; 
		
		print("Por favor, ingrese su usuario: ");
		String usuario = sc.next();
		
		for(int i = 0; i<listapersonas.size(); i++) {
			
			if(usuario.equals(listapersonas.get(i).getUsuario())){
				index = i;
				found = true;
				if(found == true){
				
					print("Por favor, ingrese su clave: ");
					String clave = sc.next();
					if(clave.equals(listapersonas.get(index).getClave())){
						entrada = true;
						}else {
							entrada = false;
							print("Clave invalida");
							
					}
				}else{print("Usuario no encontrado");
				found = false;
				
				}
				
			}
		}
		
		if(entrada == true){
			if(tipopersona == listapersonas.get(index).getSeleccion() || 0 == listapersonas.get(index).getSeleccion()){
				MenuPersona(index);
			}else if(tipooperador == listapersonas.get(index).getSeleccion()){
				MenuOperador(index);
			}
			
		}
	}
	public void MenuPersona(int index){
		int opc = 0,objetivo = 0;
		String type = "",name = "",ID= "";
		Double deposito = 0.0,retiro = 0.0;
		Double montofinal = 0.0;
		
		do {
				print("Bienvenido usuario: " + listapersonas.get(index).getUsuario() +
						" \n portador de la cedula: " + listapersonas.get(index).getCedula());
				System.out.println("Que desea hacer? "
						+ "\n [1] Ver datos "
						+ "\n [2] Modificar datos "
						+ "\n [3] Transferir"
						+ "\n [4] Deposito"
						+ "\n [5] Retiro"
						+ "\n [6] Salir");
				opc = sc.nextInt();
				
				switch(opc){
				
					case 1:
						print("Usuario: " + listapersonas.get(index).getUsuario() +
								" \n Nombre: " + listapersonas.get(index).getNombre() +
									" \n Telefono: " + listapersonas.get(index).getTelefono() +
										" \n Cedula: " + listapersonas.get(index).getCedula() + 
											" \n Dinero: " + listapersonas.get(index).getMonto()+ "$" + " En bs: " + (listapersonas.get(index).getMonto() * tasacambio) + "bs" +
											"\n usted es una persona natural/judicial");
					break;
					
					case 2:
						int opcion = 0;
						boolean bloqueo = false;
						do{
						
							print("Que dato desea modificar?");
							print("Que desea hacer? "
									+ "\n [1] Usuario "
									+ "\n [2] Clave"
									+ "\n [3] Nombre"
									+ "\n [4] Telefono"
									+ "\n [5] Cedula"
									+ "\n [6] Salir");
							opcion = sc.nextInt();
							switch(opcion){
							
								case 1:
									print("Ingrese el nuevo usuario: ");
									String usuario = sc.next();
									for(int i = 0; i<listapersonas.size(); i++) {
										if(usuario.equals(listapersonas.get(i).getUsuario())) {
											
										bloqueo = true;
										}
									}
									if(bloqueo == false){
									listapersonas.set(index, new usuario(usuario,listapersonas.get(index).getClave(),listapersonas.get(index).getNombre(),listapersonas.get(index).getTelefono(),listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion(),listapersonas.get(index).getMonto()));
									print("modificacion realizada");
									}else{
										print("Usuario igual a otro, abortando...");
										bloqueo = false;
									}
								break;
								
								case 2:
									print("Ingrese la nueva clave: ");
									String clave = sc.next();
									listapersonas.set(index, new usuario(listapersonas.get(index).getUsuario(),clave,listapersonas.get(index).getNombre(),listapersonas.get(index).getTelefono(),listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion(),listapersonas.get(index).getMonto()));
									print("modificacion realizada");
								break;
									
								case 3:
									print("Ingrese el nombre nuevo: ");
									String nombre = sc.next();
									listapersonas.set(index, new usuario(listapersonas.get(index).getUsuario(),listapersonas.get(index).getClave(),nombre,listapersonas.get(index).getTelefono(),listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion(),listapersonas.get(index).getMonto()));
									print("modificacion realizada");
								break;
									
								case 4:
									print("Ingrese el telefono nuevo: ");
									String telefono = sc.next();
									for(int i = 0; i<listapersonas.size(); i++) {
										if(telefono.equals(listapersonas.get(i).getTelefono())) {
											
										bloqueo = true;
										}
									}
									if(bloqueo == false){
									listapersonas.set(index, new usuario(listapersonas.get(index).getUsuario(),listapersonas.get(index).getClave(),listapersonas.get(index).getNombre(),telefono,listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion(),listapersonas.get(index).getMonto()));
									print("modificacion realizada");
									}else{
										print("Telefono igual a otro, abortando...");
										bloqueo = false;
									}
								break;
									
								case 5:
									
									print("Ingrese la nueva cedula: ");
									String cedula = sc.next();
									for(int i = 0; i<listapersonas.size(); i++) {
										if(cedula.equals(listapersonas.get(i).getCedula())) {
											
										bloqueo = true;
										}
									}
									if(bloqueo == false){
									listapersonas.set(index, new usuario(listapersonas.get(index).getUsuario(),listapersonas.get(index).getClave(),listapersonas.get(index).getNombre(),listapersonas.get(index).getTelefono(),cedula,listapersonas.get(index).getSeleccion(),listapersonas.get(index).getMonto()));
									print("modificacion realizada");
									}else{
										print("Cedula igual a otro, abortando...");
										bloqueo = false;
									}
								break;
									
								case 6:
									
								break;
								
								default:
									
								break;
							}
								
						}while(opcion != 6);
						
					break;
					
					case 3:
						
						print("Pagomovil: \n \n"
								+ "Ingrese Telefono, cedula y monto, en el respectivo orden");
							String telefono = sc.next();
							String cedula = sc.next();
							Double transferencia = sc.nextDouble();
							
							if(transferencia < listapersonas.get(index).getMonto()){
								
								for(int i = 0; i<listapersonas.size(); i++) {
									if(telefono.equals(listapersonas.get(i).getTelefono())){
										objetivo = i;
										if(cedula.equals(listapersonas.get(i).getCedula())){
											objetivo = i;
											//restar a la cuenta propia
											montofinal = listapersonas.get(index).getMonto() - transferencia;
											listapersonas.get(index).setMonto(montofinal);
											
											Double montoqyatiene = listapersonas.get(objetivo).getMonto();
											
											montoqyatiene = listapersonas.get(objetivo).getMonto() + transferencia;
											listapersonas.get(objetivo).setMonto(montoqyatiene);
											
											name = listapersonas.get(index).getNombre();
											ID = listapersonas.get(index).getCedula();
											
											
											type = "Transferencia";
											print("Trasferencia realizada con exito");
											
											operaciones historial = new operaciones(name,ID,type,transferencia);
											
											listaoperaciones.add(historial);
											cantidadop++;
											
										}else{
											print("Trasferencia fallida");
										}
									}else{
										print("Trasferencia fallida");
									}
										
								}
								
							}else if(transferencia > listapersonas.get(index).getMonto()) {
								print("Trasferencia fallida");
							}
							
							
						
					break;
						
					case 4:
						print("Deposito, cuanto desea depositar? \n Saldo: "+ listapersonas.get(index).getMonto() +"$" + " En bs: " + (listapersonas.get(index).getMonto() * tasacambio) + "bs");
						deposito = sc.nextDouble();
						if(deposito > 0){
							montofinal = deposito + listapersonas.get(index).getMonto();
							
							listapersonas.get(index).setMonto(montofinal);
							montofinal = 0.0;
							System.out.println("Nuevo saldo en la cuenta: " + listapersonas.get(index).getMonto() +"$" + " En bs: " + (listapersonas.get(index).getMonto() * tasacambio) + "bs");
							
							String nombre = listapersonas.get(index).getNombre();
							String cedula1 = listapersonas.get(index).getCedula();
							
							
							String tipo = "Deposito";
							
							
							operaciones historial = new operaciones(nombre,cedula1,tipo,deposito);
							
							listaoperaciones.add(historial);
							cantidadop++;
						}
						
	
						
					break;
					
					case 5:
						
						print("Retiro, cuanto desea Retirar? \n Saldo: "+ listapersonas.get(index).getMonto() +"$" + " En bs: " + (listapersonas.get(index).getMonto() * tasacambio) + "bs");
						retiro = sc.nextDouble();
						if(retiro < listapersonas.get(index).getMonto()) {
							
						
						montofinal = (listapersonas.get(index).getMonto() - retiro);
						
						listapersonas.get(index).setMonto(montofinal);
						montofinal = 0.0;
						System.out.println("Nuevo saldo: " + listapersonas.get(index).getMonto() +"$" + " En bs: " + (listapersonas.get(index).getMonto() * tasacambio) + "bs");
						
						String nombre1 = listapersonas.get(index).getNombre();
						String cedula11 = listapersonas.get(index).getCedula();
						
						String tipo1 = "Retiro";
						
						
						operaciones historial1 = new operaciones (nombre1,cedula11,tipo1,retiro);
						
						listaoperaciones.add(historial1);
						cantidadop++;
						
						}else{System.out.println("No puedes retirar el dinero que no tienes");
						}
						
						
					
					break;
					
					case 6:
							
					break;
					
					default:
						print("Error!");
					break;
			}
		}while(opc != 6);
	}
	public void MenuOperador(int index){
		int menu = 0;

		boolean valido = false;
		do {
				print("Bienvenido usuario: " + listapersonas.get(index).getUsuario() +
						" \n portador de la cedula: " + listapersonas.get(index).getCedula());
				System.out.println("MENU DE OPERADOR: "
						+ "\n [1] Ver datos "
						+ "\n [2] Modificar datos "
						+ "\n [3] Listar usuario y ver"
						+ "\n [4] Buscar usuario por usuario y cedula"
						+ "\n [5] Ver transacciones"
						+ "\n [6] Estadisticas"
						+ "\n [7] Salir");
				menu = sc.nextInt();
				
				switch(menu){
				
					case 1:
						print("Usuario: " + listapersonas.get(index).getUsuario() +
								" \n Nombre: " + listapersonas.get(index).getNombre() +
									" \n Telefono: " + listapersonas.get(index).getTelefono() +
										" \n Cedula: " + listapersonas.get(index).getCedula() + 
											"\n usted es un Operador del sistema");
					break;
					
					case 2:
						int opcion = 0;
						boolean bloqueo = false;
						do{
						
							print("Que dato desea modificar?");
							print("Que desea hacer? "
									+ "\n [1] Usuario "
									+ "\n [2] Clave"
									+ "\n [3] Nombre"
									+ "\n [4] Telefono"
									+ "\n [5] Cedula"
									+ "\n [6] Salir");
							opcion = sc.nextInt();
							switch(opcion){
							
								case 1:
									print("Ingrese el nuevo usuario: ");
									String usuario = sc.next();
									for(int i = 0; i<listapersonas.size(); i++) {
										if(usuario.equals(listapersonas.get(i).getUsuario())) {
											
										bloqueo = true;
										}
									}
									if(bloqueo == false){
									listapersonas.set(index, new operador(usuario,listapersonas.get(index).getClave(),listapersonas.get(index).getNombre(),listapersonas.get(index).getTelefono(),listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion()));
									print("modificacion realizada");
									}else{
										print("Usuario igual a otro, abortando...");
										bloqueo = false;
									}
								break;
								
								case 2:
									print("Ingrese la nueva clave: ");
									String clave = sc.next();
									listapersonas.set(index, new operador(listapersonas.get(index).getUsuario(),clave,listapersonas.get(index).getNombre(),listapersonas.get(index).getTelefono(),listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion()));
									print("modificacion realizada");
								break;
									
								case 3:
									print("Ingrese el nombre nuevo: ");
									String nombre = sc.next();
									listapersonas.set(index, new operador(listapersonas.get(index).getUsuario(),listapersonas.get(index).getClave(),nombre,listapersonas.get(index).getTelefono(),listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion()));
									print("modificacion realizada");
								break;
									
								case 4:
									print("Ingrese el telefono nuevo: ");
									String telefono = sc.next();
									for(int i = 0; i<listapersonas.size(); i++) {
										if(telefono.equals(listapersonas.get(i).getTelefono())) {
											
										bloqueo = true;
										}
									}
									if(bloqueo == false){
									listapersonas.set(index, new operador(listapersonas.get(index).getUsuario(),listapersonas.get(index).getClave(),listapersonas.get(index).getNombre(),telefono,listapersonas.get(index).getCedula(),listapersonas.get(index).getSeleccion()));
									print("modificacion realizada");
									}else{
										print("Telefono igual a otro, abortando...");
										bloqueo = false;
									}
								break;
									
								case 5:
									
									print("Ingrese la nueva cedula: ");
									String cedula = sc.next();
									for(int i = 0; i<listapersonas.size(); i++) {
										if(cedula.equals(listapersonas.get(i).getCedula())) {
											
										bloqueo = true;
										}
									}
									if(bloqueo == false){
									listapersonas.set(index, new operador(listapersonas.get(index).getUsuario(),listapersonas.get(index).getClave(),listapersonas.get(index).getNombre(),listapersonas.get(index).getTelefono(),cedula,listapersonas.get(index).getSeleccion()));
									print("modificacion realizada");
									}else{
										print("Cedula igual a otro, abortando...");
										bloqueo = false;
									}
								break;
									
								case 6:
									
								break;
								
								default:
									
								break;
							}
								
						}while(opcion != 6);
						
					break;
					
					case 3:
						print("Lista de usuarios, escoja el indice del usuario que quiere ver");
						
						for(int i = 0; i<listapersonas.size(); i++) {
							if(listapersonas.get(i).getClass().equals(usuario.class)) {
								print("Persona ["+ (i+1) +"] Usuario: [" + (listapersonas.get(i).getUsuario()) +"]\n Cedula: " + listapersonas.get(i).getCedula());
							}else {
								baneados[i] = i;
							}
						
						}
						
						int which = sc.nextInt();
						
						which--;
						
						if(which < cantidadper && which >= 0) {
							valido = true;
						}else {
							System.err.println("no hay persona en el indice indicado");
							valido = false;
						}
						if(valido == true && baneados[which] == 0) {
							print("Usuario: " + listapersonas.get(which).getUsuario() +
									" \n Nombre: " + listapersonas.get(which).getNombre() +
										" \n Telefono: " + listapersonas.get(which).getTelefono() +
											" \n Cedula: " + listapersonas.get(which).getCedula() + 
												" \n Dinero: " + listapersonas.get(which).getMonto() + " En bs: " + (listapersonas.get(which).getMonto() * tasacambio + "bs") +
												"\n Esta persona es un usuario");
						}else {
							print("La persona indicada es un operador");
						}
					
					break;
						
					case 4:
						boolean entrada = false,found = false; 
						int index1 = 0; 
						
						print("Por favor, ingrese su usuario: ");
						String usuario = sc.next();
						
						for(int i = 0; i<listapersonas.size(); i++) {
							
							if(usuario.equals(listapersonas.get(i).getUsuario())){
								index1 = i;
								found = true;
								if(found == true){
								
									print("Por favor, ingrese su cedula: ");
									String cedula = sc.next();
									if(cedula.equals(listapersonas.get(index1).getCedula())){
										entrada = true;
										}else {
											entrada = false;
											print("Clave invalida");
											
									}
								}else{print("Usuario no encontrado");
								found = false;
								
								}
								
							}
						}
						
						if(entrada == true){
							print("Usuario: " + listapersonas.get(index1).getUsuario() +
									" \n Nombre: " + listapersonas.get(index1).getNombre() +
										" \n Telefono: " + listapersonas.get(index1).getTelefono() +
											" \n Cedula: " + listapersonas.get(index1).getCedula() + 
												" \n Dinero: " + listapersonas.get(index1).getMonto() + "En bs: " + (listapersonas.get(index1).getMonto() * tasacambio) +
													"\n esta persona es una persona natural");
						}
					break;
					
					case 5:
						for(int i = 0; i<listaoperaciones.size(); i++) {
							print("Transaccion N" + (i+1) +
									"\n Nombre: "+ listaoperaciones.get(i).getName()+
										"\n Cedula: "+ listaoperaciones.get(i).getID()+
											"\n Tipo de operacion: "+ listaoperaciones.get(i).getType()+
												"\n Monto de la operacion: "+ listaoperaciones.get(i).getMoney() +"$ \n \n");
						}
						
					break;
					
					case 6:
						Double mayormonto = 0.0,menormonto = 0.0;
						String usuariomayor = "",usuariomenor = "";
						print("Cantidad de operaciones realizadas desde el inicio del sistema: " + cantidadop);
						
						for(int i = 0; i<listapersonas.size(); i++) {
							if(i == 0){
								if(listapersonas.get(i).getClass().equals(usuario.class)) {
									
								usuariomayor = listapersonas.get(i).getUsuario();
								mayormonto = listapersonas.get(i).getMonto();
								
								usuariomenor = listapersonas.get(i).getUsuario();
								menormonto = listapersonas.get(i).getMonto();
							}
								
							}else if(i >= 1){
								if(listapersonas.get(i).getClass().equals(usuario.class)) {
									if(mayormonto < listapersonas.get(i).getMonto()) {
										
										usuariomayor = listapersonas.get(i).getUsuario();
										mayormonto = listapersonas.get(i).getMonto();
										
									}else if(menormonto > listapersonas.get(i).getMonto()) {
										
										usuariomenor = listapersonas.get(i).getUsuario();
										menormonto = listapersonas.get(i).getMonto();
									}
								}
							}
						}
						print("Usuario con mas dinero: " + usuariomayor + " Saldo: " + mayormonto + "$" +" en bs: "+ (mayormonto * tasacambio) + "bs");
						print("Usuario con menos dinero: " + usuariomenor + " Saldo: " + menormonto + "$" +" en bs: "+ (menormonto * tasacambio) + "bs");
					break;
					
					case 7:
						
						
					break;
					
					default:
						print("Error!");
					break;
			}
		}while(menu != 7);
	}
}
