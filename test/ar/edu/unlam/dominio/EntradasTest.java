package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EntradasTest {

	@Test
	public void dadoQueQueremosCrearLaClaseEntradaCuandoLaInstancioDaResultadoPositivo() {

		Double precio = 500.0;

		Entrada entrada = new Entrada(precio);

		Double precioEsperado = 500.0;
		Double precioObtenido = entrada.getPrecio();
		assertEquals(precioEsperado, precioObtenido);

		assertTrue(entrada.getPromociones().isEmpty());
	}
	@Test
	public void dadoQueExisteUnaEntrada2DLaMismaNoTieneRecargoYAdemasNoTienePromociones() {
		Double precio = 500.0;
		Entrada2D entrada = new Entrada2D(precio);

		Double precioEsperado = 500.0;
		Double precioObtenido = entrada.getPrecioFinal();

		assertEquals(precioEsperado, precioObtenido);

		assertTrue(entrada.getPromociones().isEmpty());

	}
	@Test
	public void dadoQueExisteUnaEntrada3DLaMismaTieneRecargoYAdemasNoTienePromociones() {
		Double precio = 500.0;
		Entrada3D entrada = new Entrada3D(precio);

		Double precioEsperado = 750.0;
		Double precioObtenido = entrada.getPrecioFinal();

		assertEquals(precioEsperado, precioObtenido);

		assertTrue(entrada.getPromociones().isEmpty());
	}
	@Test
	public void dadoQueExisteUnaEntradaVIPLaMismaTieneRecargoYAdemasNoTienePromociones() {
		Double precio = 500.0;
		EntradaVIP entrada = new EntradaVIP(precio);

		Double precioEsperado = 900.0;
		Double precioObtenido = entrada.getPrecioFinal();

		assertEquals(precioEsperado, precioObtenido);

		assertTrue(entrada.getPromociones().isEmpty());
	}
}
