package ar.edu.unlam.dominio;

public abstract class Sala {
	private static Integer contador;
	private Integer id;
	private Integer capacidad;
	private String tecnologia;

	public Sala(Integer capacidad, String tecnologia) {
		this.capacidad = capacidad;
		this.tecnologia = tecnologia;
		this.id=(++contador);
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public String getTecnologia() {
		return this.tecnologia;
	}

	public Integer getId() {
		return id;
	}

}