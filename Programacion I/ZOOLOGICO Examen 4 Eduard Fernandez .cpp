#include <iostream>

using namespace std;

/*Zoologico
Examen 4 Zoologico Eduard Fernandez C.I: 30462299 
Datos
Especies (minimo 5)
Nombre string
Peso Double
Altura Double
Sexo macho/hembra
Cantidad Integer

Indicar
1.Agregar Animales
2.Listado (especie-nombre)
3.Detalle (escoger cual ver, con todo)
4.Modificar
5. agregar especie

6. Zoo(Matriz)
Animales por especie
Animales por sexo(Macho/hembra)
Animales por peso/mayor a menor)
Animales por peso(menor a mayor)
Animales por altura/mayor a menor)
Animales por altura(menor a mayor)
*/

main(){
	//valores iniciales
bool live,first;
int selection,i,specie,animalcount,sex,animalnumber,see,modify,hola,j,which,aux; 
double weight,height;
string speciename,name,genero,auxname;
string names[100];
string species[100];
int speciesid[100];
double weights[100];
double heights[100];
int animalnumbers[100];
string sexs[100];
int positiongroup[100];
string matrixspecies[50][50], matrixnames[50][50];
double matrixweights[50][50], matrixheights[50][50];

live = true;
first = true;
animalcount = 0;
species[0] = "Mamiferos"; species[1] = "Aves"; species[2] = "Reptiles"; species[3] = "Ranas y sapos"; species[4] = "Peces";
int amountspecies = 5;



	do{
	
		cout << "Bienvenido al Zoologico! que desea hacer? Escoja una opcion" << endl << endl
	
                     
			<<	"[Agregar animal]             [1]" << endl											
			<<	"[Lista completa de animales] [2]" << endl								
			<<	"[Detalles de un animal]      [3]" << endl								
			<<	"[Modificar animal ingresado] [4]" << endl								
			<<	"[Agregar nueva especie]      [5]" << endl
			<<	"[Zoologico]                  [6]" << endl
			<<	"[Terminar programa]          [7]" << endl
			<< "Seleccion: ";
		cin >> selection;
		
		switch(selection){
			
			case 1:
				//Add animal
				first = false;
					system ("cls");
				cout << "Que animal desea agregar? por favor, ingrese sus caracteristicas" << endl;
				cout << "A que especie de las ingresadas pertenece el animal? " << endl;
				
				for(i = 0; i<amountspecies; i++){
					cout << "["<< i+1 <<"]" <<species[i] << endl;
				}
				cin >> specie;
				while(specie < 0 || specie > amountspecies){
					cout << "no puede agregar una especie inexistente, ingrese de nuevo: ";
					cin >> specie;
				}
				specie--;
				
				positiongroup[animalcount] = specie;
				
				cout << "Que animal es?: ";
				cin >> name;
				names[animalcount] = name;
				
				cout << "Que peso tiene? en KG: ";
				cin >> weight;
				weights[animalcount] = weight;
				while(weight < 0){
					cout<< "Peso ingresado invalido, ingrese de nuevo: " ;
					cin >> weight;
					weights[animalcount] = weight;	
				}
				
				cout << "Que altura tiene? en metros ej 1.50m o 0.50m: ";
				cin >> height;
				heights[animalcount] = height;
				while(height < 0 || height > 6){
					cout<< "Altura ingresada invalida, ingrese de nuevo: " ;
					cin >> height;
					heights[animalcount] = height;	
				}
				
				cout <<"El animal es macho o hembra? 1 para macho, 2 para hembra: ";
				cin >> sex;
				while(sex != 1 && sex != 2){
						cout <<"solo hay dos opciones. :";
				cin >> sex;

				}
				if(sex == 1){
				sexs[animalcount] = "Macho";	
				}else if(sex == 2){
				sexs[animalcount] = "Hembra";
				}
				
				cout <<"Cuantos animales habra de estos?: ";
				cin >> animalnumber;
				while(animalnumber < 0){
					cout <<"Error, ingrese de nuevo: ";
					cin >> animalnumber;
				}
				animalnumbers[animalcount] = animalnumber;
				
				animalcount++;
				
				
				system ("cls");
				

			break;
			
			case 2:
				//List
				if(first == true){
					
					system ("cls");
					cout << "No hay animal que listar" << endl;
					system("pause");
					system ("cls");
					
				}else if(first == false){
					
						system ("cls");
					for(i = 0; i<animalcount; i++){
					cout << "["<< i+1 <<"]" << names[i] << " " << " Pertenece a la especie: " << species[positiongroup[i]] << endl;
				}
					system("pause");
					system ("cls");
			}
			break;
			
			case 3:
			//Detail
				if(first == true){
					system ("cls");
					cout << "No hay animal que mostrar con detalle" << endl;
					system("pause");
					system ("cls");
				}else if(first == false){
					system ("cls");
					cout << "Que animal desea ver de manera detallada?" << endl;
				for(i = 0; i<animalcount; i++){
					cout << "["<< i+1 <<"]" << names[i] << " " << " Pertenece a la especie: " << species[positiongroup[i]] << endl;
				}
				cin >> see;
				while(see < 1 || see > animalcount){
					cout << "no puede ingresar 0, ni un animal que no existe";
					cin >> see;
				}	
				see--;
				
				cout << "[Datos del animal]" << endl << endl
				
				<< "Nombre: " << names[see] << endl
				<< "Especie: " << species[positiongroup[see]] << endl
				<< "Peso: " << weights[see] << "Kg" <<endl
				<< "Altura: " << heights[see] << "m" << endl
				<< "Sexo: " << sexs[see] << endl
				<< "Cantidad: " << animalnumbers[see] << endl;
				
					system("pause");
					system ("cls");
				}
			
			break;
			
			case 4:
			//Modify
				if(first == true){
					system ("cls");
					cout << "No hay animal que modificar" << endl;
					system("pause");
					system ("cls");
				}else if(first == false){
				
				for(i = 0; i<animalcount; i++){
					cout << "["<< i+1 <<"]" << names[i] << " " << " Pertenece a la especie: " << species[positiongroup[i]] << endl;
				}
				cin >> modify;
				while(modify < 1 || modify > animalcount){
					cout << "Invalido, no existe, ingrese de nuevo: ";
					cin >> modify;
				}	
				modify--;
				
				//modificar especie
					cout << "A que especie de las ingresadas pertenece el animal? " << endl;
					for(i = 0; i<amountspecies; i++){
						cout << "["<< i+1 <<"]" <<species[i] << endl;
					}
					cin >> specie;
					
				while(specie > amountspecies){
					cout << "no puede agregar una especie inexistente, ingrese de nuevo: ";
					cin >> specie;
				}
				specie--;
				
				positiongroup[modify] = specie;
				//modificar especie
				
				cout << "Que animal es?: ";
				cin >> name;
				names[modify] = name;
				
				cout << "Que peso tiene? en KG: ";
				cin >> weight;
				weights[modify] = weight;
				while(weight < 0){
					cout<< "Peso ingresado invalido, ingrese de nuevo: " ;
					cin >> weight;
					weights[modify] = weight;	
				}
				
				cout << "Que altura tiene? en metros ej 1.50m o 0.50m: ";
				cin >> height;
				heights[modify] = height;
				while(height < 0 || height > 6){
					cout<< "Altura ingresada invalida, ingrese de nuevo: " ;
					cin >> height;
					heights[modify] = height;	
				}
				
				cout <<"El animal es macho o hembra? 1 para macho, 2 para hembra: ";
				cin >> sex;
				while(sex != 1 && sex != 2){
						cout <<"solo hay dos opciones. :";
				cin >> sex;

				}
				if(sex == 1){
				sexs[animalcount] = "Macho";	
				}else if(sex == 2){
				sexs[animalcount] = "Hembra";
				}
				
				cout <<"Cuantos animales habra de estos?: ";
				cin >> animalnumber;
				while(animalnumber < 0){
					cout <<"Error, ingrese de nuevo: ";
					cin >> animalnumber;
				}
				animalnumbers[modify] = animalnumber;
				
			
				
				
				system ("cls");
				
				
				}
			break;
			
			case 5:
			//Species
				system ("cls");
				cout << "[Especies actualmente disponibles]" << endl << endl;
				for(i = 0; i<amountspecies; i++){
					cout << "[" <<species[i] << "]" << endl;
				}
					cout << "Ingrese el nombre de la especie que quiere agregar: ";
					cin >> speciename;
					cout << "Se ha ingresado al sistema la especie: " << speciename << endl;
					species[amountspecies] = speciename;
					
					amountspecies++;
					system("pause");
					system ("cls");
			break;
			
			case 6:
			//Zoo
			/*Bueno, realmente solo funciona 1 y 2, no pude hacer los por peso y por altura, entiendo como es pero no me dio tiempo de acoplarlo
			y hacer que funcione en el codigo, los demas funcionan muy a medias, tiene que ingresar por el orden que desea en el momento de ingresar
			animales, si no es asi, se descontrola, si ingresa en el primer animal ej 20 y luego 30 y luego 40 funciona el menor mayor, si es al reves
			Funciona solo mayor a menor, lo mismo con altura, tengo idea de como resolverlo mas no tuve tiempo suficiente, gg
			
			*/
				if(first == true){
					system ("cls");
					cout << "No hay animal que mostrar :(" << endl;
					system("pause");
					system ("cls");
				}else if(first == false){
					
					while(hola != 7){	
					
						cout << "ZOO" << endl << endl
		                     
						<<	"[Animales por especie]               [1]" << endl											
						<<	"[Animales por sexo(Macho/hembra)]    [2]" << endl								
						<<	"[Animales por peso menor a mayor]    [3]" << endl	
						<<	"[Animales por peso mayor a menor]    [4]" << endl									
						<<	"[Animales por altura mayor a menor)] [5]" << endl								
						<<	"[Animales por altura menor a mayor)] [6]" << endl
						<<	"             > Salir <               [7]" << endl;
						
						cin >> hola;
							
							
							
								//species[0] = "Mamiferos"; species[1] = "Aves"; species[2] = "Reptiles"; species[3] = "Ranas y sapos"; species[4] = "Peces";
								switch(hola){
									
									case 1:
									//ANIMALES POR ESPECIE
										system ("cls");
									cout << "Seleccione la especie que quiere mostrar:" << endl << endl;
									for(i = 0; i<amountspecies; i++){
										cout << "["<< i+1 <<"]" << species[i] << endl;
									}	
								
									
										cin >> which;
									while(which < 0 || which > amountspecies){
										cout << "Error, ingrese de nuevo: ";
										cin >> which;
									}
										which--;
										
										
										for(i = 0; i<animalcount; i++){
											
											
											matrixspecies[0][0] = species[which];
											
		
												for(int j = 0; j<animalcount; j++){
													
													if(which == positiongroup[j]){
													
													matrixspecies[0][j+1] = names[j];
													}else{
													matrixspecies[0][j+1] = "";
													}
													
												}
												
											
											}
										
									
											for(int i = 0; i<(animalcount+1); i++){
		
												for(int j = 0; j<(animalcount+1); j++){
											
												cout << matrixspecies[i][j] << " ";
												
												}
												
												cout << "\n";
											}
												system("pause");
												system ("cls");
											
										
							
									break;
									
									case 2:
									//POR SEXO
										system ("cls");
									cout << "Que sexo quiere ver? 1 para macho 2 para hembra" << endl << endl;
									
									
										cin >> which;
									while(which < 1 || which > 2){
										cout << "Error, ingrese de nuevo: ";
										cin >> which;
									}
										
										if(which == 1){
											genero = "Macho"; 
										}else if(which == 2){
											genero = "Hembra";
										}
										
										
										for(int i = 0; i<animalcount; i++){
											
											
											matrixspecies[0][0] = genero;
											
		
												for(int j = 0; j<animalcount; j++){
													
													if(genero == sexs[j]){
													
													matrixspecies[0][j+1] = names[j];
													}else{
													matrixspecies[0][j+1] = "";
													}
													
												}
												
											
											}
										
									
											for(int i = 0; i<(animalcount+1); i++){
		
												for(int j = 0; j<(animalcount+1); j++){
											
												cout << matrixspecies[i][j] << " ";
												
												}
												
												cout << "\n";
											}
											system("pause");
											system ("cls");
			
									
									break;
									
									case 3:
									//Animal por peso menor a mayor
									
									for(int i = 0; i<animalcount; i++){
										
										for(int j = 1; j<animalcount; j++){
										
											if(weights[i]<weights[j]){
												
												aux  = weights[i];
												matrixweights[0][i+1] = weights[j];
												matrixweights[0][i] = aux;
												
												auxname = names[i];
												matrixnames[0][i+1] = names[j];
												matrixnames[0][i] = auxname;
													
											
												
											}else if(weights[i]>weights[j]){
												
													matrixweights[0][j] = weights[i];
													matrixnames[0][j] = names[i];
											}
										}
									}
									
											for(int i = 0; i<(animalcount); i++){
		
												for(int j = 0; j<(animalcount); j++){
											
												cout << matrixnames[i][j] << ": " << matrixweights[i][j] << "Kg  "; 
												
												}
												
												cout << "\n";
											}
									
									
									
									break;
									
									case 4:
											//Animal por peso menor a mayor
									
									for(int i = 0; i<animalcount; i++){
										
										for(int j = 1; j<animalcount; j++){
										
											if(weights[i]>weights[j]){
												
												aux  = weights[i];
												matrixweights[0][i+1] = weights[j];
												matrixweights[0][i] = aux;
												
												auxname = names[i];
												matrixnames[0][i+1] = names[j];
												matrixnames[0][i] = auxname;
													
											
												
											}else if(weights[i]<weights[j]){
												
													matrixweights[0][j] = weights[i];
													matrixnames[0][j] = names[i];
											}
										}
									}
									
											for(int i = 0; i<animalcount; i++){
		
												for(int j = 0; j<animalcount; j++){
											
												cout << matrixnames[i][j] << ": " << matrixweights[i][j] << "Kg  "; 
												
												}
												
												cout << "\n";
											}
									
									
									
									
									break;
									
									case 5:
										
									for(int i = 0; i<animalcount; i++){
										
										for(int j = 1; j<animalcount; j++){
										
											if(weights[i]<weights[j]){
												
												aux  = heights[i];
												matrixheights[0][i+1] = heights[j];
												matrixheights[0][i] = aux;
												
												auxname = names[i];
												matrixnames[0][i+1] = names[j];
												matrixnames[0][i] = auxname;
													
											
												
											}else if(weights[i]>weights[j]){
												
													matrixheights[0][j] = heights[i];
													matrixnames[0][j] = names[i];
											}
										}
									}
									
											for(int i = 0; i<(animalcount); i++){
		
												for(int j = 0; j<(animalcount); j++){
											
												cout << matrixnames[i][j] << ": " << matrixheights[i][j] << "m  "; 
												
												}
												
												cout << "\n";
											}
										
									break;
									
									case 6:
									
									for(int i = 0; i<animalcount; i++){
										
										for(int j = 1; j<animalcount; j++){
										
											if(weights[i]>weights[j]){
												
												aux  = heights[i];
												matrixheights[0][i+1] = heights[j];
												matrixheights[0][i] = aux;
												
												auxname = names[i];
												matrixnames[0][i+1] = names[j];
												matrixnames[0][i] = auxname;
													
											
												
											}else if(weights[i]<weights[j]){
												
													matrixheights[0][j] = heights[i];
													matrixnames[0][j] = names[i];
											}
										}
									}
									
											for(int i = 0; i<(animalcount); i++){
		
												for(int j = 0; j<(animalcount); j++){
											
												cout << matrixnames[i][j] << ": " << matrixheights[i][j] << "m  "; 
												
												}
												
												cout << "\n";
											}
									break;
									
								
									case 7:
									// termina el programa jajajajajajajajajajajaj
									break;
									
									default:
									
									cout << "error";
									break;
									
								}
							
					}	
					hola = 0;
					system("pause");
					system ("cls");
				
			}
			break;
			
			case 7:
				live = false;
				cout << "[Termino el programa]";
			break;
			
			default:
				cout << "[Vuelve a escribir]" << endl;
				system ("cls");
			break;
			
			
		}
	
	
	
	
	
	
	
	
	
	
	}while(live == true);
	
}
