package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

	// Hay que hacer un metodo que aplique el recargo de la noche y/o el descuento
	// de los miercoles
	@Test
	public void dadoQueLasFuncionesPuedenTenerRecargosODescuentosPorDiaYHorarioHayQueAplicarEsosDescuentosEnElPrecio() {
		Entrada2D entrada = new Entrada2D(100.0);

		Pelicula pelicula = null;
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 01, 22, 00, 00);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);

		Double precioConReglasEsperado = 55.0; // Se le aumenta 10% por ser de noche (110) y hay 50% de descuento por
												// ser miercoles (55)
		Double precioConReglasObtenido = funcion.calcularPrecioConReglas();
		assertEquals(precioConReglasEsperado, precioConReglasObtenido);
	}

	@Test
	public void dadoQueAgregamosPeliculasYFuncionesSeDebenGuardarCorrectamente() {

		GestorDeCine gestor = new GestorDeCine();
		Pelicula pelicula = new Pelicula("It", 120, Genero.TERROR);
		Pelicula pelicula2 = new Pelicula("Rapidos y Furiosos", 120, Genero.ACCION);
		Entrada3D entrada = new Entrada3D(100.0);
		Sala3D sala3d = new Sala3D(10);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 05, 15, 00);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala3d, fechaHora, precioBase);
		Funcion funcion2 = new Funcion(pelicula2, sala3d, fechaHora, precioBase);

		boolean seAgregoPeli1 = gestor.agregarPelicula(pelicula);
		boolean seAgregoPeli2 = gestor.agregarPelicula(pelicula2);
		boolean seAgregoLaFuncionPeli1 = gestor.agregarFuncion(funcion);
		boolean seAgregoFuncionPeli2 = gestor.agregarFuncion(funcion2);

		assertTrue(seAgregoPeli1);
		assertTrue(seAgregoPeli2);
		assertTrue(seAgregoLaFuncionPeli1);
		assertTrue(seAgregoFuncionPeli2);
	}

	@Test
	public void dadoQueVendemosEntradasDeUnaSalaUnaVezQueSeLlenaDebeNoSeDebenVenderMasEntradas() {

		// Creamos las clases
		GestorDeCine gestor = new GestorDeCine();
		Pelicula pelicula = new Pelicula("It", 120, Genero.TERROR);

		Entrada3D entrada = new Entrada3D(100.0);
		Sala3D sala3d = new Sala3D(3);

		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 05, 15, 00);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala3d, fechaHora, precioBase);

		// Agregamos funcion y pelicula
		gestor.agregarPelicula(pelicula);
		gestor.agregarFuncion(funcion);

		// Vendemos entradas hasta llegar al maximo de la sala
		boolean venderEntrada1 = gestor.venderEntrada(funcion, entrada);
		boolean venderEntrada2 = gestor.venderEntrada(funcion, entrada);
		boolean venderEntrada3 = gestor.venderEntrada(funcion, entrada);
		boolean venderEntrada4 = gestor.venderEntrada(funcion, entrada);

		assertTrue(venderEntrada1);
		assertTrue(venderEntrada2);
		assertTrue(venderEntrada3);
		assertFalse(venderEntrada4);
	}

	@Test
	public void dadoQueHayEntradasVendidasDeUnaFuncionLaRecaudacionPorDiaDebeEstarCorrecta() {

		// Creamos las clases
		GestorDeCine gestor = new GestorDeCine();
		Entrada2D entrada = new Entrada2D(100.0);
		Pelicula pelicula = new Pelicula("Son Como niños", 150, Genero.COMEDIA);
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 01, 15, 00, 00);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);

		// agregamos la funcion al gestor
		gestor.agregarFuncion(funcion);

		// Agregamos y vendemos la entrada
		funcion.agregarEntrada(entrada);

		gestor.venderEntrada(funcion, entrada);

		// Verificacion
		Double valorEsperado = 100.0; // El precio final hay que cambiarlo a 100 (antes 200) porque ahora contempla
										// que hay 50% los miercoles

		assertEquals(valorEsperado, gestor.recaudacionPorDia(fechaHora.getDayOfWeek()));

	}

	@Test
	public void dadoQueTenemosFuncionesEnSala3dObtengoUnaListaDeLasMisma() {

		GestorDeCine gestor = new GestorDeCine();
		Entrada3D entrada = new Entrada3D(100.0);
		Pelicula pelicula = new Pelicula("Son Como niños", 150, Genero.COMEDIA);
		Pelicula pelicula2 = new Pelicula("it", 120, Genero.TERROR);
		Pelicula pelicula3 = new Pelicula("Rapidos y Furiosos", 120, Genero.ACCION);

		Sala3D sala3d = new Sala3D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 01, 15, 00, 00);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala3d, fechaHora, precioBase);
		Funcion funcion2 = new Funcion(pelicula2, sala3d, fechaHora, precioBase);
		Funcion funcion3 = new Funcion(pelicula3, sala3d, fechaHora, precioBase);

		gestor.agregarFuncion(funcion3);
		gestor.agregarFuncion(funcion2);
		gestor.agregarFuncion(funcion);

		List<Funcion> listaFunciones3d = gestor.buscarFuncionesEnSala(sala3d);

		Integer valorEsperado = 3;
		Integer valorObtenido = listaFunciones3d.size();

		assertEquals(valorEsperado, valorObtenido);

	}

	// Nos falta tener en cuenta para aplicar el precio final, las promos en la
	// forma de pago de la entrada
	@Test
	public void dadoQueHayQueCalcularElPrecioFinalDeUnaFuncionPorElDiaHorarioYFormaDePagoHayQueHacerUnMetodoCorrespondiente() {
		Entrada2D entrada = new Entrada2D(100.0);
		Promocion promoEfectivo = new PagoEfectivo(15.0);
		entrada.aplicarPromocion(promoEfectivo);

		Pelicula pelicula = null;
		Sala2D sala = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 05, 22, 00, 00);
		Double precioBase = entrada.getPrecio();

		Funcion funcion = new Funcion(pelicula, sala, fechaHora, precioBase);

		Double precioFinalEsperado = 93.5; // 100 de base, al ser de noche sumamos 10% queda en 110 y al ser efectivo
											// hay que restarle el 15% queda 93.5
		Double precioFinalObtenido = funcion.calcularPrecioFinal(entrada);
		assertEquals(precioFinalEsperado, precioFinalObtenido);
	}
	// Deberiamos seguir este procedimiento:
	// Instanciamos la entrada con su precio --> definimos el precio base con
	// getPrecio() sin contemplar desc ni recargos --> aplicamos los desc/recargo
	// conb calcularPrecioFinal(entrada).

	@Test
	public void dadoQueUnaPeliculaPuedeTenerMuchasFuncionesEnDistintasSalasYHorariosNecesitoSaberEnQueFuncionesEstaLaPeliculaIT() {
		GestorDeCine gestor = new GestorDeCine();

		// Vamos a definir un precio sin promo para hacerlo mas rapido
		Entrada3D entrada = new Entrada3D(150.0);
		Double precioBase = entrada.getPrecio();

		Pelicula pelicula = new Pelicula("Son Como niños", 150, Genero.COMEDIA);
		Pelicula pelicula2 = new Pelicula("IT", 120, Genero.TERROR);
		Pelicula pelicula3 = new Pelicula("Rapidos y Furiosos", 120, Genero.ACCION);

		Sala3D sala3d = new Sala3D(100);
		SalaImax salaImax = new SalaImax(150);

		// Hacemos distintos horarios para las funciones
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 06, 10, 00, 00);
		LocalDateTime fechaHora2 = LocalDateTime.of(2025, 10, 06, 15, 00, 00);
		LocalDateTime fechaHora3 = LocalDateTime.of(2025, 10, 06, 18, 00, 00);
		LocalDateTime fechaHora4 = LocalDateTime.of(2025, 10, 06, 21, 00, 00);

		Funcion funcion = new Funcion(pelicula, sala3d, fechaHora, precioBase);
		Funcion funcion2 = new Funcion(pelicula2, salaImax, fechaHora2, precioBase);
		Funcion funcion3 = new Funcion(pelicula3, salaImax, fechaHora3, precioBase);
		Funcion funcion4 = new Funcion(pelicula2, sala3d, fechaHora4, precioBase);

		gestor.agregarFuncion(funcion);
		gestor.agregarFuncion(funcion2);
		gestor.agregarFuncion(funcion3);
		gestor.agregarFuncion(funcion4);

		// Hacemos una ArrayList para que agrupe todas las funciones de pelis de it
		ArrayList<Funcion> funcionesDeIT = new ArrayList<Funcion>();

		funcionesDeIT = gestor.funcionesPorPelicula("IT");

		Integer funcionesEsperadas = 2;
		Integer funcionesObtenidas = funcionesDeIT.size();
		assertEquals(funcionesEsperadas, funcionesObtenidas);
	}

	@Test
	public void dadoQueUnaFuncionNoTuvoEntradasLaRecaudacionTieneQueSerCero() {
		GestorDeCine gestor = new GestorDeCine();

		Pelicula pelicula = new Pelicula("Son Como niños", 150, Genero.COMEDIA);
		Sala3D sala3d = new Sala3D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 06, 15, 00, 00);

		Funcion funcion = new Funcion(pelicula, sala3d, fechaHora, 150.0);
		gestor.agregarFuncion(funcion);

		Double recaudacionEsperada = 0.0;
		Double recaudacionObtenida = gestor.recaudacionPorDia(fechaHora.getDayOfWeek());

		assertEquals(recaudacionEsperada, recaudacionObtenida);

	}

	@Test
	public void dadoQueUnaFuncionEsNocturnaYEsMiercolesSeCalculaPrecioCorrecto() {
		GestorDeCine gestor = new GestorDeCine();
	
		Pelicula pelicula = new Pelicula("IT", 120, Genero.TERROR);
		Sala2D sala2d = new Sala2D(100);
		LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 8, 22, 0, 0);
		Double precioBase = 150.0;
		
		Funcion funcion = new Funcion(pelicula, sala2d, fechaHora, precioBase);

		Boolean esMiercoles = funcion.esMiercoles();
		assertTrue(esMiercoles);
		Boolean esNocturna = funcion.esNocturna();
		assertTrue(esNocturna);
		
		Entrada2D entrada = new Entrada2D(150.0);
		
		Double precioEsperado = (precioBase * 1.10) * 0.5;

		Double precioObtenido = funcion.calcularPrecioFinal(entrada);

		assertEquals(precioEsperado, precioObtenido);

	}
}
