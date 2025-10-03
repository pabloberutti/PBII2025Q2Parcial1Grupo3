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

}
