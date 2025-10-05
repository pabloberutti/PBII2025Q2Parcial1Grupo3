package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class EntradasTest {
	
	
	@Test
	public void dadoQueQueremosCrearLaClaseEntradaCuandoLaInstancioDaResultadoPositivo() {
		
		Double precio = 10.5;
		Boolean promocionesAplicadas = false;
		
		// Definimos a Entrada como abstracta, por lo cual cambiamos la instancia de Entrada a Entrada2D (a modo de ejemplo)
		Entrada entrada = new Entrada2D(precio);
		
		Double precioEsperado = 10.5;
		Double precioObtenido = entrada.getPrecio();
		assertEquals(precioEsperado, precioObtenido);
		// Modificamos la comparación al tamaño del set
		Integer promocionesAplicadasEsperadas = 0;
		Integer promocionesAplicadasObtenidas = entrada.getPromociones().size();
		assertEquals(promocionesAplicadasEsperadas, promocionesAplicadasObtenidas);
	}
	
	
	@Test
	public void dadoQueExisteUnaFuncionCuandoSeInstancieQueElResultadoSeaPositivo() {
		
		Double precio = 10.5;
		Boolean promocionesAplicadas = false;
		
		// Definimos a Entrada como abstracta, por lo cual cambiamos la instancia de Entrada a Entrada2D (a modo de ejemplo)
		Entrada entrada = new Entrada2D(precio);
		
		Pelicula pelicula = null;
		Sala sala = null;
		LocalDateTime fechaHora = null;
		Double precioBase = entrada.getPrecio();
		
		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);
		
		// Agregamos los assert
		Pelicula peliculaEsperada = null;
		Pelicula peliculaObtenida = funcion.getPelicula();
		assertEquals(peliculaEsperada, peliculaObtenida);
		Sala salaEsperada = null;
		Sala salaObtenida = funcion.getSala();
		assertEquals(salaEsperada, salaObtenida);
		LocalDateTime fechaHoraEsperada = null;
		LocalDateTime fechaHoraObtenida = funcion.getFechaHora();
		assertEquals(fechaHoraEsperada, fechaHoraObtenida);
		Double precioBaseEsperado = entrada.getPrecio();
		Double precioBaseObtenido = funcion.getPrecioBase();
		assertEquals(precioBaseEsperado, precioBaseObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaSalaParaVerLaPeliculaCuandoInstanciamosLaClaseSalaSeInstanciaCorrectamente() {
		Integer capacidad = 100;
		
		// Definimos a Sala como abstracta, por lo cual cambiamos la instancia de Sala a Sala2D (a modo de ejemplo)
		Sala sala = new Sala2D(capacidad);
		
		Integer capacidadEsperada = 100;
		Integer capacidadObtenida = sala.getCapacidad();
		assertEquals(capacidadEsperada, capacidadObtenida);
	}
	
	@Test
	public void dadoQueExisteUnaSala2dEstaDebeTenerUnaCaracteristicaDistintivaDeLasDemas() {
		Integer capacidad = 100;
		
		Sala2D sala = new Sala2D(capacidad);
		
		String tecnologiaEsperada = "Proyeccion digital 2D estandar";
		String tecnologiaObtenida = sala.getTecnologia();
		assertEquals(tecnologiaEsperada, tecnologiaObtenida);
	}
	
	// Pasemos a verificar si una funcion es nocturna (ya que estas tienen recargo)
	@Test
	public void dadoQueUnaFuncionSeConsideraNocturnaDespuesDeLas20HorasCuandoHayaUnaFuncionALas21HorasEstaDebeVerificarseComoNocturna() {
		Entrada2D entrada = new Entrada2D(100.0);
		
		Pelicula pelicula = null;
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 04, 21, 57, 00);
		Double precioBase = entrada.getPrecio();
		
		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);
		
		Boolean esNocturna = funcion.esNocturna();
		
		assertTrue(esNocturna);
	}
	
	@Test
	public void dadoQueUnaFuncionSeConsideraNocturnaDespuesDeLas20HorasCuandoHayaUnaFuncionALas15HorasEstaDebeVerificarseComoQueNoEsNocturna() {
		Entrada2D entrada = new Entrada2D(100.0);
		
		Pelicula pelicula = null;
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 04, 15, 00, 00);
		Double precioBase = entrada.getPrecio();
		
		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);
		
		Boolean esNocturna = funcion.esNocturna();
		
		assertFalse(esNocturna);
	}
	
	// Pasemos a verificar si una funcion es un miercoles (ya que estas tienen descuento)
	@Test
	public void dadoQueLasFuncionesDeLosMiercolesTienenDescuentoCuandoHayUnaFuncionUnMiercolesEstaDebeVerificarseComoMiercoles() {
		Entrada2D entrada = new Entrada2D(100.0);
		
		Pelicula pelicula = null;
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 01, 15, 00, 00);
		Double precioBase = entrada.getPrecio();
		
		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);
		
		Boolean esMiercoles = funcion.esMiercoles();
		
		assertTrue(esMiercoles);
	}

}
