package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Set;

public class Entrada {

	private Double precio;
	private Set<Promocion> promociones;

	public Entrada(Double precio) {
		this.precio = precio;
		this.promociones = new HashSet<>();
	}

	public void aplicarPromocion(Promocion promocion) {
		promociones.add(promocion);
	}

	public Double getPrecio() {
		return precio;
	}

	public Double getPrecioFinal() {
		Double precioFinal = precio;
		for (Promocion promo : promociones) {
			precioFinal = promo.aplicar(precioFinal);
		}
		return precioFinal;
	}

	public Set<Promocion> getPromociones() {
		return promociones;
	}
}
