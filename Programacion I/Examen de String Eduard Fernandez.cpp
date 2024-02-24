#include <iostream>
#include <string>
using namespace std;
// Eduard Fernandez CI PROGAMACION 1 
/*
Hacer un programa que permita:

1. Ingresar X cantidad de palabras
2. Ingresar texto
3. Estadistica
	Indicar
- Palabras agregadas
- Cantidad de apariciones
- mostrar texto
4. Salir

EJEMPLOS

1. a, todos, como
2. Hola a todos
3. a = 1
todos = 1 
como = 0
*/
string palabrasbus[50],word,texto,buscar,comparacion;
int vecesrep[50],repeticion = 0,espacio;
size_t lapalabra; //Size_t es el tipo de variable que puede almacenar el string::npos



main(){
	bool sys;
	bool first;
	sys = true;
	int seleccion;
	



	do{
		
		cout << "    >>>  [Programa de strings]  <<< " << endl << endl
			 << "[1] [Ingresar Palabras a buscar]  " << endl
			 << "[2]       [Ingresar texto]        " << endl
			 << "[3]        [Estadistica]          " << endl
			 << "[4]       [Apagar sistema]        " << endl;
			 
		cin >> seleccion;
		system ("cls");
		switch (seleccion){
			
			case 1:
			//Agregar palabras
		
			palabras();
	
			
			break;
			
			case 2:
			//Ingresar texto
			
			pedirtexto();
	
			break;
			
			case 3:
			//Estadistica
			
			estadistica();
	
			
			
			break;
			
			case 4:
			//Salir
			cout << "[Ha finalizado el programa]";
			sys = false;
			break; 
			
			default:
			//vuelve a ingresar men
			
				system ("cls");
					cout << "Error!" << endl;
				system ("pause");
			break;	
		}
		
	}while(sys == true);
	
}

void palabras(){
	
	
	cout << "Cuantas palabras quiere buscar?: ";
	
	cin >> repeticion;
	while(repeticion < 1){
		cout << "Error!, Vuelva a ingresar: ";
		cin >> repeticion;
	}
	

	cout << "Escriba el caracter o palabra una a una: " << endl;
	cin.ignore(); /* Por algun razon, el cin.ignore borra la primera letra de la palabra al estar dentro del loop del for, al sacarlo
	del loop, e ignorar una sola vez despues de usar el cin de repeticion funciona correctamente*/
	
	for(int i = 0; i<repeticion; i++){
		
		cout << "[" << i+1 << "]: ";
		
		
		getline(cin, word);
		
		int espacio = word.find(' ');
		
		while(espacio != -1){
		
			cout << "Vuelva a escribir la palabra, usted ingreso un espacio[" << i+1 << "]: ";
			
			
			getline(cin, word);
			espacio = word.find(' '); 
		
		}
	
		palabrasbus[i] = word;	
		
	}
	
}
void pedirtexto(){
	cin.ignore();			 //al usar getline, hay que usar ignore debido a que para llamar la funcion getline y que funcione, debemos limpiar el bufer de cin
	cout << "Ingrese el texto completo: ";
	getline(cin, texto);
}
void estadistica(){
	
	cout << "[Palabras ingresadas para buscar]" << endl << endl;
	
	for(int i = 0; i<repeticion; i++){
	
		cout << i+1 << ": " << palabrasbus[i] << endl;
				
	}
	
	if(repeticion == 0){
		
		cout << "No se ha ingresado ninguna palabra para buscar";
		
	}

	cout << endl << endl;
	
	cout << endl << "[Texto completo]: " << endl << endl << texto << endl;
	
	
	for(int i = 0; i<repeticion; i++){
		
		buscar = palabrasbus[i]; 
		lapalabra = texto.find(buscar);
		
			while(lapalabra != string::npos){
			
				vecesrep[i]++;
				lapalabra = texto.find(buscar, lapalabra + 1); // Tiene que romper el ciclo, con el +1 ocurre al encontrar la palabra q es igua
			
			}

	}
	
	cout << endl << endl << endl << "[Cantidad de veces que las palabras ingresadas aparecen en el texto]" << endl;
	for(int i = 0; i<repeticion; i++){
		cout << "[" << palabrasbus[i] << "]: " << vecesrep[i] << endl;  
	}
	
	if(repeticion == 0){
		
		cout << "No se ha ingresado ninguna palabra para buscar";
		
	}
	cout << endl << endl;
	//BORRAR DATOS
	for(int i = 0; i<repeticion; i++){
		
		vecesrep[i] = 0;
	
	
	}
		system ("pause");	
		system ("cls");
		
}
