package ar.edu.unlam.dominio;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class GestorDeCine {

	private List<Pelicula> peliculas;
	private List<Funcion> funciones;

	public GestorDeCine() {
		this.funciones = new ArrayList<>();
		this.peliculas = new ArrayList<>();
	}

	public boolean agregarPelicula(Pelicula pelicula) {
		return this.peliculas.add(pelicula);
	}

	public boolean agregarFuncion(Funcion funcion) {
		return this.funciones.add(funcion);
	}

	public boolean venderEntrada(Funcion funcion, Entrada entrada) {
		return funcion.agregarEntrada(entrada);
	}

	public Double recaudacionPorDia(DayOfWeek dia) {
		Double totalRecaudacion = 0.0;

		for (Funcion funcion : funciones) {
			if (funcion.getFechaHora().getDayOfWeek() == dia) {
				for (Entrada e : funcion.getEntradas()) {
					totalRecaudacion += funcion.calcularPrecioFinal(e);
				}
			}
		}
		return totalRecaudacion;

	}

	public List<Funcion> buscarFuncionesEnSala(Sala sala) {

		List<Funcion> listaFuncionesEnSala = new ArrayList<>();

		for (Funcion funcion : funciones) {
			if (funcion.getSala().equals(sala)) {
				listaFuncionesEnSala.add(funcion);
			}
		}
		return listaFuncionesEnSala;
	}

	public ArrayList<Funcion> funcionesPorPelicula(String titulo) {
		ArrayList<Funcion> funcionesPorPelicula = new ArrayList<>();
		
		for (Funcion funcion : this.funciones) {
			Pelicula pelicula = funcion.getPelicula();
			String tituloDeLaPelicula;
			
			if (pelicula != null) {
				tituloDeLaPelicula = pelicula.getTitulo();
				if (tituloDeLaPelicula != null && tituloDeLaPelicula.equals(titulo)) {
					funcionesPorPelicula.add(funcion);
				}
			}
		}
		
		return funcionesPorPelicula;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}
	public List<Funcion> getFunciones() {
		return funciones;
	}
	public String obtenerListaDePeliculas() {
	    String lista = "\nLISTA DE PELICULAS DISPONIBLES:\n";
	    for (Pelicula pelicula : peliculas) {
	        lista += "\nID: " + pelicula.getId() + "   Titulo: " + pelicula.getTitulo();
	    }
	    return lista;
	}
	public List<Funcion> obtenerFuncionesDePelicula(Integer idPelicula) {
	    List<Funcion> funcionesDePelicula = new ArrayList<>();
	    for (Funcion funcion : funciones) {
	        if (funcion.getPelicula().getId().equals(idPelicula)&&funcion.tieneCapacidadDisponible()) {
	            funcionesDePelicula.add(funcion);
	        }
	    }
	    return funcionesDePelicula;
	}
	
	public String listarFuncionesFiltradas(List<Funcion> funcionesFiltradas) {
		String lista = "\nFUNCIONES DISPONIBLES:\n";
	    for (Funcion funcion : funcionesFiltradas) {
	        lista += "\nID: " + funcion.getId() 
	        + "		\nFecha y hora: "+ funcion.getFechaHora()
	        + "		\nSala nro: " + funcion.getSala().getId();
	    }
	    return lista;
	}
	public Funcion obtenerFuncionPorId(List<Funcion> funcionesFiltradas, Integer idFuncion) {
	    for (Funcion funcion : funcionesFiltradas) {
	        if (funcion.getId().equals(idFuncion)) {
	            return funcion;
	        }
	    }
	    return null;
	}

	public Entrada crearEntrada(Double precio, Funcion funcion, Integer tipoEntrada) {
	    Entrada entrada = null;

	    switch (tipoEntrada) {
	        case 1:
	            entrada = new Entrada2D(precio);
	            break;
	        case 2:
	            entrada = new Entrada3D(precio);
	            break;
	        case 3:
	            entrada = new EntradaVIP(precio);
	            break;
	        default:
	            return null;
	    }
	    funcion.agregarEntrada(entrada);
	    return entrada;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
