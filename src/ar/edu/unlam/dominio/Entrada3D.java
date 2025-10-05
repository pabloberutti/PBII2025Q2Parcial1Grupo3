package ar.edu.unlam.dominio;

public class Entrada3D extends Entrada {

	public Entrada3D(Double precio) {
		super(precio + RECARGO_3D);
	}

	private static final double RECARGO_3D = 250;
	
	
}