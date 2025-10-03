package ar.edu.unlam.dominio;

public class EntradaVIP extends Entrada{

	public EntradaVIP(Double precio) {
		super(precio + COSTO_VIP);
	}
	
	private static final double COSTO_VIP = 400;

	
}
