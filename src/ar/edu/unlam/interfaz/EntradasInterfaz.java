package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Genero;
import ar.edu.unlam.dominio.GestorDeCine;
import ar.edu.unlam.dominio.Pelicula;

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
				agregarPelicula(gestor);
				break;
			case 2:
				System.out.println("--Modificar nombre de pelicula--");
				modificarNombreDePelicula(gestor);
				break;
			case 3:
				System.out.println("--Cambiar genero--");
				modificarGeneroDePelicula(gestor);
				break;
			case 4:
				System.out.println("--Eliminar pelicula--");
				eliminarPelicula(gestor);
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

	private static void eliminarPelicula(GestorDeCine gestor) {
		//Logica
		mostrarPeliculasCreadas(gestor);
		
		teclado.nextLine(); // Limpieza de buffer
		
		System.out.println("\nIngrese el nombre de la pelicula a elimnar: ");
		String nombreDeLaPeliculaAEliminar = teclado.nextLine().trim();
		
		Boolean seElimino = false;
		
//				Intenté hacer el bucle de la siguiente manera pero me tiró un java.util.ConcurrentModificationException
//				for (Pelicula cadaPelicula : gestor.getPeliculas()) {
//					if (cadaPelicula.getTitulo().equals(nombreDeLaPeliculaAEliminar)) {
//						gestor.getPeliculas().remove(cadaPelicula);
//						seElimino = true;
//					}
//				}
//				Aparentemente, no puedo eliminar un objeto en medio del bucle... la solucion que encontré es hacerlo en un for convencional
		
		for (int i = 0; i < gestor.getPeliculas().size(); i++) {
			Pelicula cadaPelicula = gestor.getPeliculas().get(i);
			if (cadaPelicula.getTitulo().equals(nombreDeLaPeliculaAEliminar)) {
				gestor.getPeliculas().remove(i);
				seElimino = true;
			}
		}
		
		if (!seElimino) {
			System.out.println("La pelicula no se ha eliminado. Intente nuevamente.");
		} else {
			System.out.println("La pelicula se ha eliminado exitosamente.");
		}
	}

	private static void modificarGeneroDePelicula(GestorDeCine gestor) {
		//Logica
		mostrarPeliculasCreadas(gestor);
		
		teclado.nextLine(); // Limpieza de buffer
		
		System.out.println("\nIngrese el nombre de la pelicula a cambiar el genero: ");
		String nombreDeLaPeliculaACambiarElGenero = teclado.nextLine().trim();
		
		Genero nuevoGeneroAElegir = elegirGenero();
		
		Boolean seCambio2 = false;
		for (Pelicula cadaPelicula : gestor.getPeliculas()) {
			if (cadaPelicula.getTitulo().equals(nombreDeLaPeliculaACambiarElGenero)) {
				cadaPelicula.setGenero(nuevoGeneroAElegir);
				seCambio2 = true;
			}
		}
		
		if (!seCambio2) {
			System.out.println("El genero de la pelicula no se ha cambiado. Intente nuevamente.");
		} else {
			System.out.println("El genero de la pelicula se ha cambiado exitosamente.");
		}
	}

	private static void modificarNombreDePelicula(GestorDeCine gestor) {
		//Logica
		mostrarPeliculasCreadas(gestor);
		
		teclado.nextLine(); // Limpieza de buffer
		
		System.out.println("\nIngrese el nombre de la pelicula a cambiar: ");
		String nombreDeLaPeliculaACambiar = teclado.nextLine().trim();
		
		System.out.println("\nIngrese el nombre nuevo: ");
		String nombreDeLaPeliculaACambiarNuevo = teclado.nextLine().trim();
		
		Boolean seCambio = false;
		for (Pelicula cadaPelicula : gestor.getPeliculas()) {
			if (cadaPelicula.getTitulo().equals(nombreDeLaPeliculaACambiar)) {
				cadaPelicula.setNombre(nombreDeLaPeliculaACambiarNuevo);
				seCambio = true;
			}
		}
		
		if (!seCambio) {
			System.out.println("La pelicula no se ha cambiado. Intente nuevamente.");
		} else {
			System.out.println("La pelicula se ha cambiado exitosamente.");
		}
	}

	private static void agregarPelicula(GestorDeCine gestor) {
		//Logica
		// Le pedimos el nombre de la peli
		String nombreDeLaPeliculaParaValidar;
		boolean seValido = false;
		teclado.nextLine(); // Limpieza de buffer
		do {
			System.out.println("\nIngrese el nombre de la pelicula:");
			nombreDeLaPeliculaParaValidar = teclado.nextLine();
			if (!nombreDeLaPeliculaParaValidar.trim().isEmpty()) {
				seValido = true;
				System.out.println("Se ha validado el nombre de la pelicula correctamente.");
			} else {
				System.out.println("Error. No puede ingresar un nombre vacio. Intente nuevamente.");
			}
		} while(!seValido);
		
		String nombreDeLaPelicula = nombreDeLaPeliculaParaValidar;
		
		// Le pedimos la duración de la pelicula
		Integer duracionDeLaPeliculaParaValidar;
		boolean seValido2 = false;
		
		do {
			System.out.println("\nIngrese la duracion de la pelicula (en minutos):");
			duracionDeLaPeliculaParaValidar = teclado.nextInt();
			if (duracionDeLaPeliculaParaValidar > 0) {
				seValido2 = true;
				System.out.println("Se ha validado la duracion de la pelicula correctamente.");
			} else {
				System.out.println("Error. Una pelicula debe durar al menos 1 minuto. Intente nuevamente.");
			}
		} while(!seValido2);
		
		Integer duracionDeLaPelicula = duracionDeLaPeliculaParaValidar;
		
		// Le pedimos que elija el genero de la pelicula
		Genero generoElegido = elegirGenero();
		
		// Agrupamos cada dato
		Pelicula peliculaParaCrear = new Pelicula(nombreDeLaPelicula, duracionDeLaPelicula, generoElegido);
		
		Boolean seAgrego = gestor.agregarPelicula(peliculaParaCrear);
		
		if (!seAgrego) {
			System.out.println("\nLa pelicula no se ha agregado. Intente nuevamente.");
		} else {
			System.out.println("\nLa pelicula se ha agregado exitosamente.");
		}
	}

	private static void mostrarPeliculasCreadas(GestorDeCine gestor) {
		System.out.println("Las peliculas creadas son: ");
		for (Pelicula cadaPelicula : gestor.getPeliculas()) {
			System.out.println(cadaPelicula.getTitulo() + " - " + cadaPelicula.getDuracion() + " minutos - " + cadaPelicula.getGenero());
		}
	}

	private static Genero elegirGenero() {
		Integer opcionGenero;
		Genero generoElegido;
		System.out.println("\nUsted tiene que seleccionar el genero de la pelicula");
		do {
			System.out.println("Seleccione una opcion");
			System.out.println("" + Genero.obtenerOpcionesDeGenero());
			opcionGenero = teclado.nextInt();
			if (opcionGenero < 1 || opcionGenero > Genero.values().length) {
				System.out.println("Error. Elija un numero correcto.");
			}
		} while (opcionGenero < 1 || opcionGenero > Genero.values().length);
		
		generoElegido = Genero.values()[opcionGenero - 1];
		System.out.println("\nEl genero se ha elegido correctamente.");
		return generoElegido;
	}

}
