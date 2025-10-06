package ar.edu.unlam.dominio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
	// Terminé de agregar los atributos
	private Pelicula pelicula;
	private Sala sala;
	private LocalDateTime fechaHora;
	private Double precioBase;
	private List<Entrada> entradas;

	public Funcion(Pelicula pelicula, Sala sala, LocalDateTime fechaHora, Double precioBase) {
		this.pelicula = pelicula;
		this.sala = sala;
		this.fechaHora = fechaHora;
		this.precioBase = precioBase;
		this.entradas = new ArrayList<>();
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public Sala getSala() {
		return sala;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public Boolean esNocturna() {
		Boolean esNocturna = false;
		// Pasamos la fechaHora a solo hora y le decimos que si esa hora está despues de
		// las 20, es nocturna.
		if (this.fechaHora.toLocalTime().isAfter(LocalTime.of(20, 0))) {
			esNocturna = true;
		}

		return esNocturna;
	}

	public Boolean esMiercoles() {
		Boolean esMiercoles = false;
		// Pasamos la fechaHora a solo fecha y le decimos que si esa fecha tiene como
		// dia de la semana al miercoles, que verifique true al boolean esMiercoles.
		if (this.fechaHora.toLocalDate().getDayOfWeek() == DayOfWeek.WEDNESDAY) {
			esMiercoles = true;
		}

		return esMiercoles;
	}

	public boolean agregarEntrada(Entrada entrada) {

		if (entradas.size() >= sala.getCapacidad()) {
			return false;
		}

		return this.entradas.add(entrada);

	}

	public List<Entrada> getEntradas() {
		return entradas;
	}
	
	

}