package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.GestorDeCine;

public class EntradasInterfaz {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
	
		
		GestorDeCine gestor = new GestorDeCine();

		

		Integer opcion = 0;
		do {
			mostrar("\n=======SISTEMA DE CINE=======");
			mostrar("\n1. Gestionar peliculas");
			mostrar("2. Gestionar funciones");
			mostrar("3. Vender entradas");
			mostrar("4. Recaudacion por dia");
			mostrar("5. Salir");
			mostrar("\nIngrese una opcion");

			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:
				mostrar("Opción 1: Gestionar películas");
				mostrarMenuGestionarPeliculas(gestor);
				break;
			case 2:
				mostrar("Opción 2: Gestionar funciones");
				mostrarMenuGestionarFunciones(gestor);
				break;
			case 3:
				mostrar("Opción 3: Vender entradas");
				mostrarMenuVenderEntradas(gestor);
				break;
			case 4:
				mostrar("Opción 4: Recaudación por día");
				mostrarMenuRecaudacionPorDia(gestor);
				break;
			case 5:
				mostrar("Vuelva pronto!");
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
			mostrar("\n1. Consultar recaudacion de un dia especifico");
			mostrar("2. Consultar recaudacion total semanal");
			mostrar("3. Volver al menu principal");
			
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				mostrar("--Consultar recaudacion de un dia especifico--");
				//Logica
				break;
			case 2:
				mostrar("--Consultar recaudacion total semanal--");
				//Logica
				break;
			case 3:
				mostrar("--Volviendo al menu principal--");
				break;
			default:
				mostrar("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 3);
		
		
	}

	private static void mostrarMenuVenderEntradas(GestorDeCine gestor) {
		Integer opcion=0;
		do{
			mostrar("\n1. Vender entrada 2D");
			mostrar("2. Vender entrada 3D");
			mostrar("3. Vender entrada VIP");
			mostrar("4. Ver entradas vendidas de una funcion");
			mostrar("5. Volver al menu principal");
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				mostrar("--Vender entrada 2D--");
				//Logica
				break;
			case 2:
				mostrar("--Vender entrada 3D--");
				//Logica
				break;
			case 3:
				mostrar("--Vender entrada VIP--");
				//Logica
				break;
			case 4:
				mostrar("--Ver entradas vendidas de una funcion--");
				//Logica
				break;
			case 5:
				mostrar("--Volviendo al menu principal--");
				break;
			default:
				mostrar("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 5);
		
		
	}

	private static void mostrarMenuGestionarFunciones(GestorDeCine gestor) {
		Integer opcion=0;
		do{
			mostrar("\n1. Agregar funcion");
			mostrar("2. Eliminar funcion");
			mostrar("3. Listar funciones por pelicula");
			mostrar("4. Buscar funciones por fecha");
			mostrar("5. Volver al menu principal");
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				mostrar("--Agregar funcion--");
				//Logica
				break;
			case 2:
				mostrar("--Eliminar funcion--");
				//Logica
				break;
			case 3:
				mostrar("--Listar funciones por pelicula--");
				//Logica
				break;
			case 4:
				mostrar("--Buscar funciones por fecha--");
				//Logica
				break;
			case 5:
				mostrar("--Volviendo al menu principal--");
				break;
			default:
				mostrar("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 5);
		
		
	}


	private static void mostrarMenuGestionarPeliculas(GestorDeCine gestor) {
		
		Integer opcion=0;
		do{
			mostrar("\n1. Agregar película");
			mostrar("2. Modificar nombre de película");
			mostrar("3. Cambiar género");
			mostrar("4. Eliminar película");
			mostrar("5. Volver al menú principal");
			opcion = teclado.nextInt();
			
			switch (opcion) {

			case 1:
				mostrar("--Agregar Pelicula--");
				//Logica
				break;
			case 2:
				mostrar("--Modificar nombre de pelicula--");
				//Logica
				break;
			case 3:
				mostrar("--Cambiar genero--");
				//Logica
				break;
			case 4:
				mostrar("--Eliminar pelicula--");
				//Logica
				break;
			case 5:
				mostrar("--Volviendo al menu principal--");
				break;
			default:
				mostrar("Opción inválida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 5);
	}
	
	
	//Metodos adicionales
	
	private static void mostrar(String mensaje) {
		System.out.println(mensaje);
	}
	private static int ingresarInt(String mensaje) {
		mostrar(mensaje);
		return teclado.nextInt();
	}
	private static String ingresarString(String mensaje) {
		mostrar(mensaje);
		return teclado.nextLine();
	}

}
