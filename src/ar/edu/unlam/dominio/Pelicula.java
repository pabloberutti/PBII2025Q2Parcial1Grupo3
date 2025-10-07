package ar.edu.unlam.dominio;

public class Pelicula {

	private String titulo;
	private Integer duracion;
	private Genero genero;

	public Pelicula(String titulo, Integer duracion, Genero genero) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setNombre(String nombreDeLaPeliculaACambiarNuevo) {
		this.titulo = nombreDeLaPeliculaACambiarNuevo;
	}

	public void setGenero(Genero nuevoGeneroAElegir) {
		this.genero = nuevoGeneroAElegir;
	}

	

	

}