package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class EntradasTest {

	@Test
	public void dadoQueCreamosUnaEntrada2DLaMismaDeberiaTenerPrecioBaseYNingunaPromocion() {

		Double Precio = 10.5;
		Boolean promocionesAplicadas = false;

		// Definimos a Entrada como abstracta, por lo cual cambiamos la instancia de
		// Entrada a Entrada2D (a modo de ejemplo)
		Entrada entrada = new Entrada2D(Precio);

		Double precioEsperado = 10.5;
		Double precioObtenido = entrada.getPrecio();
		assertEquals(precioEsperado, precioObtenido);
		// Modificamos la comparación al tamaño del set
		Integer promocionesAplicadasEsperadas = 0;
		Integer promocionesAplicadasObtenidas = entrada.getPromociones().size();
		assertEquals(promocionesAplicadasEsperadas, promocionesAplicadasObtenidas);
	}

	@Test
	public void dadoQueInstanciamosUnaEntrada3DLaMismaDeberiaTenerComoPrecioFinalElRecargo() {
		Double Precio = 100.0;
		Entrada3D entrada3D = new Entrada3D(Precio);

		// el recargo de 3D es 20%
		Double precioEsperado = Precio * 1.2;
		Double precioObtenido = entrada3D.getPrecioFinal();

		assertEquals(precioEsperado, precioObtenido, 0.01);
	}

	@Test
	public void dadoQueCreamosUnaEntradaVIPLaMismaDeberiaTenerComoPrecioFinalUnCostoAdicionalFijo() {
		Double Precio = 150.0;
		EntradaVIP entradaVIP = new EntradaVIP(Precio);

		// el costo adicional fijo VIP es 50
		Double precioEsperado = Precio + 50.0;
		Double precioObtenido = entradaVIP.getPrecioFinal();

		assertEquals(precioEsperado, precioObtenido, 0.01);
	}

	@Test
	public void dadoQueSeAplicanVariasPromocionesElPrecioFinalDeberiaResponderADichosDescuentos() {
		Double Precio = 200.0;
		Entrada2D entrada = new Entrada2D(Precio);

		Promocion promo1 = new PagoEfectivo(15.0);
		Promocion promo2 = new PagoTarjeta(10.0);

		entrada.aplicarPromocion(promo1);
		entrada.aplicarPromocion(promo2);

		// el precio final seria el precio de la entrada - 25% - 5%
		Double precioEsperado = Precio * 0.85 * 0.90;
		Double precioObtenido = entrada.getPrecioFinal();

		assertEquals(precioEsperado, precioObtenido, 0.01);
	}

	@Test
	public void dadoQueSeEstanAplicandoDosVecesLaMismaPromocionSoloSeDeberiaDeAplicarUna() {
		Double Precio = 100.0;
		Entrada2D entrada = new Entrada2D(Precio);

		Promocion promo3 = new PagoTarjeta(10.0);
		entrada.aplicarPromocion(promo3);
		entrada.aplicarPromocion(promo3);

		assertEquals(1, entrada.getPromociones().size());

		Double precioEsperado = Precio * 0.9;
		Double precioObtenido = entrada.getPrecioFinal();
		assertEquals(precioEsperado, precioObtenido, 0.01);
	}

	@Test
	public void dadoQueExisteUnaFuncionCuandoSeInstancieLosAtributosDeberianDeSerCorrectos() {

		Double precio = 10.5;
		Boolean promocionesAplicadas = false;

		// Definimos a Entrada como abstracta, por lo cual cambiamos la instancia de
		// Entrada a Entrada2D (a modo de ejemplo)
		Entrada entrada = new Entrada2D(precio);

		Pelicula pelicula = new Pelicula("Matrix", 120, Genero.ACCION);
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 8, 18, 20);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);

		// Agregamos los assert
		Pelicula peliculaEsperada = pelicula;
		Pelicula peliculaObtenida = funcion.getPelicula();
		assertEquals(peliculaEsperada, peliculaObtenida);
		Sala salaEsperada = sala;
		Sala salaObtenida = funcion.getSala();
		assertEquals(salaEsperada, salaObtenida);
		LocalDateTime fechaHoraEsperada = fechaHora;
		LocalDateTime fechaHoraObtenida = funcion.getFechaHora();
		assertEquals(fechaHoraEsperada, fechaHoraObtenida);
		Double precioBaseEsperado = entrada.getPrecio();
		Double precioBaseObtenido = funcion.getPrecioBase();
		assertEquals(precioBaseEsperado, precioBaseObtenido);
	}

	@Test
	public void dadoQueExisteUnaSalaParaVerLaPeliculaCuandoInstanciamosLaClaseSalaSeInstanciaCorrectamente() {
		Integer capacidad = 100;

		// Definimos a Sala como abstracta, por lo cual cambiamos la instancia de Sala a
		// Sala2D (a modo de ejemplo)
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

	// Pasemos a verificar si una funcion es un miercoles (ya que estas tienen
	// descuento)
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

	@Test
	public void dadoQueHayEntradasVendidasLaRecaudacionPorDiaDebeEstarCorrecta() {

		GestorDeCine gestor = new GestorDeCine();
		Entrada2D entrada = new Entrada2D(100.0);
		Pelicula pelicula = null;
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 01, 15, 00, 00);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);
		
		gestor.agregarFuncion(funcion);
		
		funcion.agregarEntrada(entrada);
		
		gestor.venderEntrada(funcion, entrada);
		
		Double valorEsperado = 200.0;
		
		assertEquals(valorEsperado, gestor.recaudacionPorDia(fechaHora.getDayOfWeek()));

	}

}
