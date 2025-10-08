package ar.edu.unlam.dominio;

public enum Genero {

	CIENCIA_FICCION("Ciencia ficcion"),
	TERROR("Terror"),
	COMEDIA("Comedia"), 
	ACCION("Accion"),
	AVENTURA("Aventura"),
	FANTASIA("Fantasia"),
	DOCUMENTAL("Documental"),
	DRAMA("Drama"),
	SUSPENSO("Suspenso");

	String descripcion;
	
	private Genero(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private String getDescripcion() {
		return this.descripcion;
	}
	
	public static String obtenerOpcionesDeGenero() {
		String opciones = "";
		Genero[] generos = Genero.values();
		generos = Genero.values();
		for (int i = 0; i < generos.length; i++) {
			opciones += "\n" + (i+1) + " para " + generos[i].getDescripcion();
		}
		return opciones;
	}
}