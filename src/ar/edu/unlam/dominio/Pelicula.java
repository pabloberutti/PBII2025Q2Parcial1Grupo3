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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public void setGenero(Genero nuevoGeneroAElegir) {
        this.genero = nuevoGeneroAElegir;
    }
}