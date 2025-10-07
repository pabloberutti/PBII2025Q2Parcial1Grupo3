package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.GestorDeCine;

public class EntradasInterfaz {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
	
		
		GestorDeCine gestor = new GestorDeCine();

		

		Integer opcion = 0;
		do {
			System.out.println("\n=======SISTEMA DE CINE=======");
			System.out.println("\n1. Gestionar peliculas");
			System.out.println("2. Gestionar funciones");
			System.out.println("3. Vender entradas");
			System.out.println("4. Recaudacion por dia");
			System.out.println("5. Salir");
			System.out.println("\nIngrese una opcion");

			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:
				System.out.println("Opción 1: Gestionar películas");
				mostrarMenuGestionarPeliculas(gestor);
				break;
			case 2:
				System.out.println("Opción 2: Gestionar funciones");
				mostrarMenuGestionarFunciones(gestor);
				break;
			case 3:
				System.out.println("Opción 3: Vender entradas");
				mostrarMenuVenderEntradas(gestor);
				break;
			case 4:
				System.out.println("Opción 4: Recaudación por día");
				mostrarMenuRecaudacionPorDia(gestor);
				break;
			case 5:
				System.out.println("Vuelva pronto!");
				break;
			default:
				System.out.println("Opción inválida, intente nuevamente.");
				break;
			}

		} while (opcion != 5);

		teclado.close();

	}

	private static void mostrarMenuRecaudacionPorDia(GestorDeCine gestor) {
		Integer opcion=0;
		do{
			System.out.println("\n1. Consultar recaudacion de un dia especifico");
			System.out.println("2. Consultar recaudacion total semanal");
			System.out.println("3. Volver al menu principal");
			
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				System.out.println("--Consultar recaudacion de un dia especifico--");
				//Logica
				break;
			case 2:
				System.out.println("--Consultar recaudacion total semanal--");
				//Logica
				break;
			case 3:
				System.out.println("--Volviendo al menu principal--");
				break;
			default:
				System.out.println("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 3);
		
		
	}

	private static void mostrarMenuVenderEntradas(GestorDeCine gestor) {
		Integer opcion=0;
		do{
			System.out.println("\n1. Vender entrada 2D");
			System.out.println("2. Vender entrada 3D");
			System.out.println("3. Vender entrada VIP");
			System.out.println("4. Ver entradas vendidas de una funcion");
			System.out.println("5. Volver al menu principal");
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				System.out.println("--Vender entrada 2D--");
				//Logica
				break;
			case 2:
				System.out.println("--Vender entrada 3D--");
				//Logica
				break;
			case 3:
				System.out.println("--Vender entrada VIP--");
				//Logica
				break;
			case 4:
				System.out.println("--Ver entradas vendidas de una funcion--");
				//Logica
				break;
			case 5:
				System.out.println("--Volviendo al menu principal--");
				break;
			default:
				System.out.println("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 5);
		
		
	}

	private static void mostrarMenuGestionarFunciones(GestorDeCine gestor) {
		Integer opcion=0;
		do{
			System.out.println("\n1. Agregar funcion");
			System.out.println("2. Eliminar funcion");
			System.out.println("3. Listar funciones por pelicula");
			System.out.println("4. Buscar funciones por fecha");
			System.out.println("5. Volver al menu principal");
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				System.out.println("--Agregar funcion--");
				//Logica
				break;
			case 2:
				System.out.println("--Eliminar funcion--");
				//Logica
				break;
			case 3:
				System.out.println("--Listar funciones por pelicula--");
				//Logica
				break;
			case 4:
				System.out.println("--Buscar funciones por fecha--");
				//Logica
				break;
			case 5:
				System.out.println("--Volviendo al menu principal--");
				break;
			default:
				System.out.println("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 5);
		
		
	}


	private static void mostrarMenuGestionarPeliculas(GestorDeCine gestor) {
		
		Integer opcion=0;
		do{
			System.out.println("\n1. Agregar película");
			System.out.println("2. Modificar nombre de película");
			System.out.println("3. Cambiar género");
			System.out.println("4. Eliminar película");
			System.out.println("5. Volver al menú principal");
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				System.out.println("--Agregar Pelicula--");
				//Logica
				break;
			case 2:
				System.out.println("--Modificar nombre de pelicula--");
				//Logica
				break;
			case 3:
				System.out.println("--Cambiar genero--");
				//Logica
				break;
			case 4:
				System.out.println("--Eliminar pelicula--");
				//Logica
				break;
			case 5:
				System.out.println("--Volviendo al menu principal--");
				break;
			default:
				System.out.println("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 5);
		
		
	}

}
