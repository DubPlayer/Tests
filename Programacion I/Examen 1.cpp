#include <iostream>
#include <math.h>
/* Hacer un programa que permita introducir:

1. Nombre
2. Fecha de nacimiento
3. 3 notas

Indicar
1. Si la persona es mayor o menor de edad
2. promedio de la nota(0-20){indicar error <0 o > 20}
3. Nota mayor, menor y si es igual a otra
4. Indicar si alguna nota es invalida

*/
using namespace std;

main(){
	
	string nombre,mayoria,validez1,validez2,validez3;
	int day,month,year,actyear,edad,iguales;
	double g1,g2,g3,mayor,menor,promedio;
	
	actyear = 2023;
	
	cout << "Ingrese su nombre: ";
	cin >> nombre;
	cout << "Ingrese su fecha de nacimiento, introduzca el dia: " << endl;
	cin >> day;
	cout << "Mes: ";
	cin >> month;
	cout << "anio: ";
	cin >> year;
	
	cout << "Ingrese la primera nota: ";
	cin >> g1;
	cout << "Ingrese la segunda nota: ";
	cin >> g2;
	cout << "Ingrese la tercera nota: ";
	cin >> g3;
	
	
	//Mayoria de edad 
	edad = actyear - year;
	if(edad >= 18 && edad <= 120){
		mayoria = "Mayor de edad";
	}else if(edad <= 17 && edad >= 0){
		mayoria = "Menor de edad";
	}else{mayoria = "Error! El anio ingresado fue invalido";
	}
	
	
	//validez de las notas
	if(g1 >= 0 && g1 <= 20){
		validez1 = " ";
	}else{validez1 = "la primera nota no fue valida";
	cout << validez1 << endl;
	}
	if(g2 >= 0 && g2 <= 20){
		validez2 = " ";
	}else{validez2 = "la segunda nota no fue valida";
	cout << validez2 << endl;
	}
	if(g3 >= 0 && g3 <= 20){
		validez3 = " ";
	}else{validez3 = "la tercera nota no fue valida";
	cout << validez3 << endl;
	}
	
	//cantidad de iguales
	if(g1 == g2 || g1 == g3 || g2 == g3){
		iguales = iguales + 2;
		if(g1 == g2 && g1 == g3 && g2 == g3)
			iguales = iguales + 1;
	}else{}
			
	//nota mayor y menor
	
	if(g1 >= g2 && g1 >= g3){
		mayor = g1;
	}else if (g2 >= g1 && g2 >= g3){
		mayor = g2;
	}else if (g3 >= g1 && g3 >= g2){
		mayor = g3;
	}else{
	}
	
	if(g1 <= g2 && g1 <= g3){
		menor = g1;
	}else if (g2 <= g1 && g2 <= g3){
		menor = g2;
	}else if (g3 <= g1 && g3 <= g2){
		menor = g3;
	}else{
	}
	cout << "La nota mayor es: " << mayor << endl;
	cout << "La nota menor es: " << menor << endl;
	
	// que notas son iguales
	if (iguales != 3){

	if(g1 == g2){
		cout << "la nota 1 y 2 son iguales"<< endl;
	}else if(g1 == g3){
		cout << "la nota 1 y 3 son iguales"<< endl;
	}else if(g2 == g1){
		cout << "la nota 2 y 1 son iguales"<< endl;
	}else if(g2 == g3){
		cout << "la nota 2 y 3 son iguales"<< endl;
	}else if(g3 == g1){
		cout << "la nota 3 y 1 son iguales"<< endl;
	}else if(g3 == g2){
		cout << "la nota 3 y 2 son iguales"<< endl;
	}else{}
	}
	
// promedio
	if (g1 >= 0 && g1 <= 20 && g2 >= 0 && g2 <= 20 && g3 >= 0 && g3 <= 20 ){
		promedio = (g1 + g2 + g3) / 3;
		cout << "Su promedio es: " << promedio << endl;
	}else{cout << " Promedio: Error! alguna nota fue invalida" << endl;
	}
	
	
	cout << "Eres: "<<  mayoria << endl;
	cout << "Cantidad de numeros iguales: " << iguales;


	
}
