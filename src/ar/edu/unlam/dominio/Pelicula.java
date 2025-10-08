package ar.edu.unlam.dominio;

public class Pelicula {
	
	private static Integer contador;
	private Integer id;
	private String titulo;
	private Integer duracion;
	private Genero genero;

	public Pelicula(String titulo, Integer duracion, Genero genero) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.id=(++contador);
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nID: " + id + "   Titulo: " + titulo;
	}
	
	
	

}