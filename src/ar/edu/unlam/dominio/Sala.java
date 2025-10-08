package ar.edu.unlam.dominio;

public abstract class Sala {

	Integer capacidad;
	private String tecnologia;
	Integer id;

	public Sala(Integer capacidad, String tecnologia) {
		this.capacidad = capacidad;
		this.tecnologia = tecnologia;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public String getTecnologia() {
		return this.tecnologia;
	}
	public String toString() {
	    return getTecnologia() + " -- Capacidad: " + getCapacidad();
	    	
	    }

	public Integer getId() {
		return this.id;
	}
}