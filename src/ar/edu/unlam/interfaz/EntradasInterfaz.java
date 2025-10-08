package ar.edu.unlam.interfaz;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import ar.edu.unlam.dominio.Entrada;
import ar.edu.unlam.dominio.Funcion;
import ar.edu.unlam.dominio.GestorDeCine;
import ar.edu.unlam.dominio.Pelicula;

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
			mostrar("4. Recaudacion por tiempo");
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
				mostrarMenuVenderEntradas(gestor);
				break;
			case 4:
				mostrarMenuRecaudacionPorTiempo(gestor);
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

	private static void mostrarMenuRecaudacionPorTiempo(GestorDeCine gestor) {
		Integer opcion=0;
		do{
			mostrar( "\n1. Consultar recaudacion de un dia especifico"
					+"\n2. Consultar recaudacion total semanal"
					+"\n3. Volver al menu principal");
			
			opcion = ingresarInt("Ingrese una opcion");
			
			switch (opcion) {

			case 1:
			    int dia = ingresarInt("Ingrese el dia: ");
			    int mes = ingresarInt("Ingrese el mes: ");
			    int anio = ingresarInt("Ingrese el año: ");
			    LocalDate fecha = LocalDate.of(anio, mes, dia);
			    Double recaudacionDia = gestor.recaudacionPorDia(fecha);
			    mostrar("Recaudacion total del dia " + fecha + ": $" + recaudacionDia);
			    break;

			case 2:
			    Double totalSemana = gestor.recaudacionSemanal();
			    mostrar("Recaudacion total de la semana actual: $" + totalSemana);
			    break;
			case 3:
				mostrar("--Volviendo al menu principal--");
				break;
			default:
				mostrar("Error. Opcion invalida, intente nuevamente.");
				break;
			}

			
		}while(opcion != 3);
		
		
	}

	private static void mostrarMenuVenderEntradas(GestorDeCine gestor) {
		Integer opcion=0;
		do{
			mostrar("\n1. Vender entrada"
			+"\n2. Ver entradas vendidas de una funcion"
			+"\n3. Volver al menu principal");
			opcion = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcion) {

			case 1:
				mostrar("===VENTA DE ENTRADAS===");
				Double precio = ingresarDouble("Ingrese el precio base de la entrada");

				int tipoEntrada;
				do {
				    mostrar("\nSeleccione el tipo de entrada:"
				        + "\n1. 2D (sin recargo)"
				        + "\n2. 3D (+20%)"
				        + "\n3. VIP (+$50)");
				    tipoEntrada = ingresarInt("Ingrese una opción: ");
				    teclado.nextLine();
				    if (tipoEntrada < 1 || tipoEntrada > 3) {
				        mostrar("Error. opcion invalida.\n");
				    }
				} while (tipoEntrada < 1 || tipoEntrada > 3);
				
				
			    // Mostrar peliculas disponibles
			    mostrar(gestor.obtenerListaDePeliculas());
			    Integer idPelicula = ingresarInt("Ingrewse el ID de la pelicula deseada");

			    // Mostrar funciones disponibles de esa pelicula
			    List<Funcion> funciones = gestor.obtenerFuncionesDePelicula(idPelicula);
			    if (funciones.isEmpty()) {
			        mostrar("No hay funciones disponibles para esa pelicula.");
			        break;
			    }
			    //Muestra las funciones disponibles para dicha peliccula
			    mostrar(gestor.listarFuncionesFiltradas(funciones));
			    // Buscar la función seleccionada
			    Funcion funcionSeleccionada=gestor.obtenerFuncionPorId(funciones, ingresarInt("Ingrese el id de la funcion deseada"));
			    if (funcionSeleccionada == null) {
			        mostrar("Funcion no encontrada.");
			        break;
			    }
				if (funcionSeleccionada.tieneCapacidadDisponible()) {
					// Crear la entrada
					Entrada entrada = gestor.crearEntrada(precio, funcionSeleccionada,tipoEntrada);
					// Vender (agregar) la entrada a la función
					gestor.venderEntrada(funcionSeleccionada, entrada);
					mostrar("Entrada vendida correctamente: $" + entrada.getPrecioFinal());
					break;
				}
				mostrar("No hay mas capacidad disponible para esta función");
				break;
			case 2:
				mostrar("Volviendo al menu principal...");
				break;
			default:
				mostrar("Opcion invalida, intente nuevamente.");
				break;
			}
		}while(opcion != 2);
		
		
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
	
	private static Double ingresarDouble(String mensaje) {
		mostrar(mensaje);
		return teclado.nextDouble();
	}

}
