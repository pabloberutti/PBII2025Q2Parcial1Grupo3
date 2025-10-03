package ar.edu.unlam.dominio;

public class Entrada {

	private Double precio;
	private Boolean promocionesAplicadas;

	public Entrada(Double precio, Boolean promocionesAplicadas) {
		this.precio = precio;
		this.promocionesAplicadas = promocionesAplicadas;
	}

	public Double getPrecio() {
		return precio;
	}

	public Boolean getPromocionesAplicadas() {
		return promocionesAplicadas;
	}
}
