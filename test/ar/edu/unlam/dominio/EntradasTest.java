package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class EntradasTest {
	
	
	@Test
	public void dadoQueQueremosCrearLaClaseEntradaCuandoLaInstancioDaResultadoPositivo() {
		
		Double precio = 10.5;
		Boolean promocionesAplicadas = false;
		
		Entrada entrada = new Entrada(precio);
		
		Double precioEsperado = 10.5;
		Double precioObtenido = entrada.getPrecio();
		assertEquals(precioEsperado, precioObtenido);
		Boolean promocionesAplicadasEsperadas = false;
		Boolean promocionesAplicadasObtenidas = entrada.getPromociones();
		assertEquals(promocionesAplicadasEsperadas, promocionesAplicadasObtenidas);
	}
	
	
	@Test
	public void dadoQueExisteUnaFuncionCuandoSeInstancieQueElResultadoSeaPositivo() {
		
		Double precio = 10.5;
		Boolean promocionesAplicadas = false;
		
		Entrada entrada = new Entrada(precio);
		
		Pelicula pelicula = null;
		Sala sala = null;
		LocalDateTime fechaHora = null;
		Double precioBase = entrada.getPrecio();
		
		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);
	}
	
	
	
	
	
}
