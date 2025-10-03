package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EntradasTest {
	
	
	@Test
	public void dadoQueQueremosCrearLaClaseEntradaCuandoLaInstancioDaResultadoPositivo() {
		
		Double precio = 10.5;
		Boolean promocionesAplicadas = false;
		
		Entrada entrada = new Entrada(precio, promocionesAplicadas);
		
		Double precioEsperado = 10.5;
		Double precioObtenido = entrada.getPrecio();
		assertEquals(precioEsperado, precioObtenido);
		Boolean promocionesAplicadasEsperadas = false;
		Boolean promocionesAplicadasObtenidas = entrada.getPromocionesAplicadas();
		assertEquals(promocionesAplicadasEsperadas, promocionesAplicadasObtenidas);
	}
}
