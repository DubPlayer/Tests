#include <iostream>

using namespace std;

/*
EXAMEN EDUARD FERNANDEZ prog 1
Hacer un sistema de inventario con los datos:
-Nombre
-Precio ($)
-Descuento
-Cantidad

Indicar:

-Agregar productos
-Modificar productos
-Listar productos
-Estadistica
	Cantidad de productos
	Total neto, Bruto
	Producto mas costoso y barato
	Producto con mayor y menor cantidad
	Cantidad de producto
	
	TODO TIENE QUE SER DADO EN BOLIVARES Y DOLARES
-Configuraciones
	IVA (16%) --> 0.16
	Tasa de cambio (BCV)
-Salir
*/
	string nombres[10000];
		double precios[10000];
		double descuentos[10000];
		int cantidades[10000];
int seleccion,cantidad,productos,espacios,cuantos,marca,productoscondescuento,modificar,agregar;
int cual,descuento,cantidadpro,config;
int valor,hola,primero,cantidadpromayor,cantidadpromenor;
double precio,totalneto,totalbruto,totaldiv,suma,IVAact,tasabs,nuevoIVA,tasabsact,nuevatasabs,preciomayor,preciomenor,totalnetobs,totalbrutobs;
bool programa,bloqueo,primeravez;
string nombre,nombrepromayor,nombrepromenor,nombrepro,nombrecantmayor,nombrecantmenor;


main(){
programa = true;
bloqueo = true;
primeravez = false;
IVAact = 0.16;
tasabsact = 33;
		cout << "Bienvenido al inventario, escoja alguna de las siguientes opciones" << endl;
		cout << "[Agregar productos] 1" << endl << "[Modificar producto] 2" << endl << "[Listar productos] 3" << endl;
		cout << "[Estadistica] 4" << endl << "[Configuracion] 5" << endl << "[Acabar programa] 6" << endl;
		cin >> seleccion;
	while(bloqueo == true){
			
		if(seleccion == 1){
			bloqueo = false;
			marca = 1;
				
		}else if(seleccion == 2){
			cout << "No hay producto para modificar, seleccione de nuevo: ";
			cin >> seleccion;
			
		}else if(seleccion == 3){
			cout << "No hay producto que listar, seleccione de nuevo: ";
			cin >> seleccion;
			
		}else if(seleccion == 4){
			cout << "No hay productos los cuales comparar, seleccione de nuevo: ";
			cin >> seleccion;
			
		}else if(seleccion == 5){
			
			while(config != 3){
				   
			
					cout << "Que desea modificar?" << endl;
					
					cout << "[IVA] 1" <<  endl;
					cout << "[Tasa de cambio] 2" <<  endl;
					cout << "[Salir] 3" <<  endl;
					
					cin >> config;
					
					switch(config){
						case 1:
							cout << "Ingrese el nuevo % de IVA en numeros enteros IVA "<< endl << "[El IVA actual es de: " << IVAact << "]"  <<  endl;
							cin >> nuevoIVA;
							
							while(nuevoIVA < 0 || nuevoIVA > 99){
								cout << "IVA invalido, ingrese de nuevo: ";
								cin >> nuevoIVA;
							}
							
							IVAact = (nuevoIVA / 100);
							
							cout << "Nuevo IVA: " << IVAact << endl;
							if(nuevoIVA == 0){
									cout << "No hay impuesto!" << endl;
							}
							
						break;
						
						case 2:
								cout << "Ingrese la nueva tasa de cambio, el formato es 00.00 "<< endl << "[La tasa de cambio actual es: " << tasabsact << "]"  <<  endl;
							cin >> nuevatasabs;
							
							while(nuevatasabs <= 0){
								cout << "Tasa invalida, ingrese de nuevo: ";
								cin >> nuevatasabs;
							}
							
							tasabsact = nuevatasabs;
							
							cout << "Nueva tasa: " << tasabsact << endl;
							
							
						break;
						
						default:
							
						break;
					
					}
					
				  }
				  config = 0;
			
				cout << "Seleccione de nuevo" << endl;
		cout << "[Agregar productos] 1" << endl << "[Modificar producto] 2" << endl << "[Listar productos] 3" << endl;
		cout << "[Estadistica] 4" << endl << "[Configuracion] 5" << endl << "[Acabar programa] 6" << endl;
		cin >> seleccion;
			
		}else if(seleccion == 6){
			bloqueo = false;
			
		}else{
			cout << "Invalido, seleccione de nuevo" << endl;
			cin >> seleccion;
		}	
	}
	
	if(seleccion == 6){
	//nada, el programa termina, raro pero bueno (pq no hay nada en el ifxd)	
	}else{
		cout << "Cuantos productos desea ingresar" << endl;
		cin >> cuantos;
	}
		int e; 
		int i;
		nombres[cuantos];
		precios[cuantos];
		descuentos[cuantos];
		cantidades[cuantos];
	do{
		
		if(marca == 2){
		cout << endl;
		cout << "Bienvenido al menu, escoja alguna de las siguientes opciones" << endl << endl;
		cout << "[Agregar un producto] 1" << endl << "[Modificar producto] 2" << endl << "[Listar productos] 3" << endl;
		cout << "[Estadistica] 4" << endl << "[Configuracion] 5" << endl << "[Acabar programa] 6" << endl;
		cin >> seleccion;
		}else{
			marca++;
		}
		if(seleccion == 5){
			config = 0;
		}
	
			switch(seleccion){
				
				case 1:
					//agregar producto
					if(primeravez == true){
				 	cout << "Escogio ingresar un producto" << endl;
				 	
				 	cout<< "Ingrese el nombre del producto: ";
							cin >> nombre;
							nombres[cuantos] = nombre;
							
							cout<< "Ingrese el precio del producto en dolares: " ;
							cin >> precio;
							precios[cuantos] = precio;
							while(precio < 0){
								cout<< "El precio ingresado no puede ser 0 ni menor, ingrese de nuevo: " ;
								cin >> precio;
								precios[cuantos] = precio;		
							}
							
							cout<< "Ingrese el descuento del producto "<< nombre << ": ";
							cin >> descuento;
							descuentos[cuantos] = descuento;	
							while(descuento < 0 || descuento > 99){
								cout<< "Ingrese de nuevo el descuento, tiene que ser un valor entre 0 y 99";
								cin >> descuento;
								descuentos[cuantos] = descuento;
							}
							if(descuento > 0){
								productoscondescuento++;
							}
							
							cout<< "Cuantas existencias del producto "<< nombre << " Va a ingresar?: ";
							cin >> cantidad;
							cantidades[cuantos] = cantidad;	
							while(cantidad < 0){
								cout<< "La cantidad ingresada no puede ser menor a 0";
								cin >> cantidad;
								cantidades[cuantos] = cantidad;
							}
							
							cuantos++;
							
							// Re verificacion de valores mayores y menores
						
									for(i = 0; i<cuantos; i++){
										
										if(i == 0){
									
											nombrepromayor = nombres[i];
											preciomayor = precios[i];
											cantidadpromayor = cantidades[i];
											nombrepromenor = nombres[i];
											preciomenor = precios[i];
											cantidadpromenor = cantidades[i];
											nombrecantmenor = nombres[i];
											nombrecantmayor = nombres[i];
										
										}else if(i >= 1){
										
										
												
											if(preciomayor < precios[i]){
												preciomayor = precios[i];
												nombrepromayor = nombres[i];
										
											}else if(preciomenor > precios[i]){
												preciomenor = precios[i];
												nombrepromenor = nombres[i];
										
											}
											
											if(cantidadpromayor < cantidades[i]){
												cantidadpromayor = cantidades[i];
												nombrecantmayor = nombres[i];	
																				
											}else if(cantidadpromenor > cantidades[i]){
												cantidadpromenor = cantidades[i];
												nombrecantmenor = nombres[i];
												
											}
			
										}
									}
							
						
					
					
					}else{
						primeravez = true;
						
						for(i = 0; i<cuantos; i++){
							
							cout<< "Ingrese el nombre del producto: ";
							cin >> nombre;
							nombres[i] = nombre;
							
							cout<< "Ingrese el precio del producto en dolares: " ;
							cin >> precio;
							precios[i] = precio;
							while(precio < 0){
								cout<< "El precio ingresado no puede ser 0 ni menor, ingrese de nuevo: " ;
								cin >> precio;
								precios[i] = precio;		
							}
							
							cout<< "Ingrese el descuento del producto "<< nombre << ": ";
							cin >> descuento;
							descuentos[i] = descuento;	
							while(descuento < 0 || descuento > 99){
								cout<< "Ingrese de nuevo el descuento, tiene que ser un valor entre 0 y 99";
								cin >> descuento;
								descuentos[i] = descuento;
							}
							if(descuento > 0){
								productoscondescuento++;
							}
							
							cout<< "Cuantas existencias del producto "<< nombre << " Va a ingresar?: ";
							cin >> cantidad;
							cantidades[i] = cantidad;	
							while(cantidad < 0){
								cout<< "La cantidad ingresada no puede ser menor a 0";
								cin >> cantidad;
								cantidades[i] = cantidad;
							}
							//mas costoso, barato, mayor menor cantidad, productos con descuento
							//Indicaciones
							if(i == 0){
								
								nombrepromayor = nombre;
								preciomayor = precio;
								cantidadpromayor = cantidad;
								nombrepromenor = nombre;
								preciomenor = precio;
								cantidadpromenor = cantidad;
								nombrecantmenor = nombre;
								nombrecantmayor = nombre;
	
							}else if(i >= 1){
								
								if(preciomayor < precio){
									preciomayor = precio;
									nombrepromayor = nombre;
							
								}else if(preciomenor > precio){
									preciomenor = precio;
									nombrepromenor = nombre;
							
								}
								
								if(cantidadpromayor < cantidad){
									cantidadpromayor = cantidad;
									nombrecantmayor = nombre;	
																	
								}else if(cantidadpromenor > cantidad){
									cantidadpromenor = cantidad;
									nombrecantmenor = nombre;
									
								}
		
							}
								
						}
							
					}
						
				break;
			
				case 2:
					//modificar producto
				
			
					cout << endl;
						for(i = 0; i<cuantos; i++){
								cout<< "producto [" << (i) << "]: " << nombres[i] << " tiene un precio de: " << precios[i] << "$" <<" tiene un descuento del "<< descuentos[i] << "%" << " y hay " << cantidades[i] << " disponibles."<< endl; 
								cout<< "El producto tiene un precio en bs de: " << (precios[i] * tasabsact) << endl;
								}
						cout << "Que producto desea modificar?" << endl;
						
						cin >> modificar;
						while(modificar<0){
								cout << "No puedes modificar un producto inexistente, ingrese de nuevo" << endl;
							cin >> modificar;
						}
					
						while(modificar >= cuantos){
							cout << "No puedes modificar un producto inexistente, ingrese de nuevo" << endl;
							cin >> modificar;
						}
						cout<< "Ingrese el nuevo nombre del producto: ";
								cin >> nombre;
								nombres[modificar] = nombre;
								
								cout<< "Ingrese el nuevo precio del producto en dolares: " ;
								cin >> precio;
								precios[modificar] = precio;
								while(precio < 0){
									cout<< "El precio ingresado no puede ser 0 ni menor, ingrese de nuevo: " ;
									cin >> precio;
									precios[modificar] = precio;		
								}
								
								cout<< "Ingrese el nuevo descuento del producto "<< nombre << ": ";
								cin >> descuento;
								descuentos[modificar] = descuento;	
								while(descuento < 0 || descuento > 99){
									cout<< "Ingrese de nuevo el descuento, tiene que ser un valor entre 0 y 99";
									cin >> descuento;
									descuentos[modificar] = descuento;
								}
								if(descuento == 0){
									productoscondescuento--;
								}else if(descuento != 0){
									productoscondescuento++;
								}
								
								cout<< "Cuantas existencias del producto "<< nombre << " habra nuevamente?: ";
								cin >> cantidad;
								cantidades[modificar] = cantidad;	
								while(cantidad < 0){
									cout<< "La cantidad ingresada no puede ser menor a 0" ;
									cin >> cantidad;
									cantidades[modificar] = cantidad;
								}
								
								
									// Re verificacion de valores mayores y menores
						
									for(i = 0; i<cuantos; i++){
										
										if(i == 0){
									
											nombrepromayor = nombres[i];
											preciomayor = precios[i];
											cantidadpromayor = cantidades[i];
											nombrepromenor = nombres[i];
											preciomenor = precios[i];
											cantidadpromenor = cantidades[i];
											nombrecantmenor = nombres[i];
											nombrecantmayor = nombres[i];
										
										}else if(i >= 1){
										
										
												
											if(preciomayor < precios[i]){
												preciomayor = precios[i];
												nombrepromayor = nombres[i];
										
											}else if(preciomenor > precios[i]){
												preciomenor = precios[i];
												nombrepromenor = nombres[i];
										
											}
											
											if(cantidadpromayor < cantidades[i]){
												cantidadpromayor = cantidades[i];
												nombrecantmayor = nombres[i];	
																				
											}else if(cantidadpromenor > cantidades[i]){
												cantidadpromenor = cantidades[i];
												nombrecantmenor = nombres[i];
												
											}
			
										}
									}		
				break;
				
				case 3:
					//lista de productos
					for(i = 0; i<cuantos; i++){
						cout<< "producto [" << (i) << "]: " << nombres[i] << " tiene un precio de: " << precios[i] << "$" <<" tiene un descuento del "<< descuentos[i] << "%" << " y hay " << cantidades[i] << " disponibles."<< endl; 
						cout<< "El producto tiene un precio en bs de: " << (precios[i] * tasabsact) << endl;
						}
				break;
				
				case 4:
					//Estadistica
					 cout << endl;
					 cout << "Se ingresaron: " << cuantos <<" productos. " << endl;
					 cout << endl;
				 	 cout << "El producto mas costoso es: " << nombrepromayor << " y tiene un precio de: " <<preciomayor << " $"<< endl;  
					 cout << "El producto menos costoso es: " << nombrepromenor << " y tiene un precio de: " <<preciomenor <<" $" <<endl;  
					 cout << "El producto con mas cantidad es: " << nombrecantmayor << " y se ingreso una cantidad de " <<cantidadpromayor << " Unidades." << endl;  
					 cout << "El producto con menos cantidad es: " << nombrecantmenor << " y se ingreso una cantidad de " <<cantidadpromenor << " Unidades." << endl; 
					 cout << "La cantidad de productos con descuento disponibles es: " << productoscondescuento << endl;
					 
					for(i = 0; i<cuantos; i++){
						totalbruto += precios[i] * cantidades[i];
						
						totalbrutobs = totalbruto * tasabsact;	
					}
					cout << "El precio bruto total es de: " << totalbruto << endl;
					cout << "El precio bruto total en BS es de: " << totalbrutobs << endl;
					
					for(i = 0; i<cuantos; i++){
						totalneto += cantidades[i] * (precios[i] - ( precios[i] * (descuentos[i] / 100) ) + (precios[i] * IVAact) ) ;
						
						totalnetobs = totalneto * tasabsact;		
					}
					cout << "El precio neto total es de: " << totalneto << endl;
					cout << "El precio neto total en BS es de: " << totalnetobs << endl;
					
					totalbruto = 0;
					totalnetobs = 0;
					totalneto = 0;
					totalnetobs = 0;
				
				break;
				
				case 5:
					//Configuraciones
			
					while(config != 3){
				   
			
						cout << "Que desea modificar?" << endl;
						
						cout << "[IVA] 1" <<  endl;
						cout << "[Tasa de cambio] 2" <<  endl;
						cout << "[Salir] 3" <<  endl;
						
						cin >> config;
						
						switch(config){
							
							case 1:
								cout << "Ingrese el nuevo % de IVA en numeros enteros IVA "<< endl << "[El IVA actual es de: " << IVAact << "]"  <<  endl;
								cin >> nuevoIVA;
								
								while(nuevoIVA < 0 || nuevoIVA > 99){
									cout << "IVA invalido, ingrese de nuevo: ";
									cin >> nuevoIVA;
								}
								
								IVAact = (nuevoIVA / 100);
								
								cout << "Nuevo IVA: " << IVAact << endl;
								if(nuevoIVA == 0){
										cout << "No hay impuesto!" << endl;
								}
								
							break;
							
							case 2:
								cout << "Ingrese la nueva tasa de cambio, el formato es 00.00 "<< endl << "[La tasa de cambio actual es: " << tasabsact << "]"  <<  endl;
								cin >> nuevatasabs;
								
								while(nuevatasabs <= 0){
									cout << "Tasa invalida, ingrese de nuevo: ";
									cin >> nuevatasabs;
								}
								
								tasabsact = nuevatasabs;
								
								cout << "Nueva tasa: " << tasabsact << endl;
		
							break;
							
							default:
								
							break;
					
						}
				  	}
				
				break;
				
				case 6:
				//EXIT
					programa = false;
					cout << "[Ha terminado el programa]" << endl;
				break;
				
				default:
						cout << "Error!, solo hay 6 opciones" << endl;
				break;
			}
			
			
			
		}while(programa == true);
		
		
}
