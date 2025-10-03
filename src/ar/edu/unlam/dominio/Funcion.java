package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Funcion {
	
	

	public Funcion(Pelicula pelicula, Sala sala, LocalDateTime fechaHora, Double precioBase) {
		this.pelicula = pelicula;
		this.sala = sala;
		this.fechaHora = fechaHora;
		this.precioBase = precioBase;
	}

}
