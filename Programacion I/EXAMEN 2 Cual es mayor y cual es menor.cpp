/*Hacer un inventario con los datos:

1.Nombre 
2.Precio
3.Cantidad

{X cantidad de productos}

Indicar

1.Producto mas y menos costoso {nombre y precio}
2.Producto mas y menos cantidad {nombre y cant}
3. total de productos
4. continuar o finalizar

*/

#include <iostream>

using namespace std;
//apagado o encendido
int terminar,productos,precio,cantidadpro,preciomayor,cantidadpromenor,preciomenor,cantidadpromayor;
string nombrepro,nombrepromayor,nombrepromenor,nombrecantmayor,nombrecantmenor;
bool sistema = true;
main(){
	
		cout<< "Bienvenido al inventario, cuantos productos desea ingresar?: ";
		cin >> productos;
			cout << endl; 
	do{
	
		for(int cantidad = 0; cantidad<productos; cantidad++){
				
			cout<< "Ingrese el nombre del producto: ";
			cin >> nombrepro;
		
			cout<< "Ingrese el precio del producto en dolares: ";
			cin >> precio;
		
			while(precio < 0){
				cout<< "El precio ingresado no puede ser 0 ni menor, ingrese de nuevo: ";
				cin >> precio;
			}
			cout<< "Cuantas existencias del producto "<< nombrepro << " va a ingresar?: ";
			cin >> cantidadpro;	
			while(cantidadpro < 0){
				cout<< "El precio ingresado no puede ser 0 ni menor, ingrese de nuevo: ";
				cin >> cantidadpro;
			}
			cout << endl;  
			//Indicaciones
			if(cantidad == 0){
				
				nombrepromayor = nombrepro;
				preciomayor = precio;
				cantidadpromayor = cantidadpro;
				nombrecantmayor = nombrepro;
				nombrepromenor = nombrepro;
				preciomenor = precio;
				cantidadpromenor = cantidadpro;
				nombrecantmenor = nombrepro;
			
				
			}else if(cantidad >= 1){
				
				if(preciomayor < precio){
					preciomayor = precio;
					nombrepromayor = nombrepro;
			
				}else if(preciomenor > precio){
					preciomenor = precio;
					nombrepromenor = nombrepro;
			
				}
				
				if(cantidadpromayor < cantidadpro){
					cantidadpromayor = cantidadpro;
					nombrecantmayor = nombrepro;
				
				
				}else if(cantidadpromenor > cantidadpro){
					cantidadpromenor = cantidadpro;
					nombrecantmenor = nombrepro;
				
				}
				
			}
			
				
			}
			cout << endl;  
			cout << "El producto mas costoso es: " << nombrepromayor << " y tiene un precio de: " <<preciomayor << " Dolares"<< endl;  
			cout << "El producto menos costoso es: " << nombrepromenor << " y tiene un precio de: " <<preciomenor <<" Dolares" <<endl;  
			cout << "El producto con mas cantidad es: " << nombrecantmayor << " y se ingreso una cantidad de " <<cantidadpromayor << endl;  
			cout << "El producto con menos cantidad es: " << nombrecantmenor << " y se ingreso una cantidad de " <<cantidadpromenor << endl;
			cout << endl;    
	
		cout<< "Desea terminar el programa?: 1 para si, cualquier otra cosa para no: ";
		cin >> terminar;
		if(terminar == 1){
			sistema = false;
		}
		
	}while(sistema == true);
	
	
	
}
