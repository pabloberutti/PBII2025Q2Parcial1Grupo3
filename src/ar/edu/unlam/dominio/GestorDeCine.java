package ar.edu.unlam.dominio;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

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
					totalRecaudacion += e.getPrecioFinal();
				}
			}
		}
		return totalRecaudacion;

	}

}
