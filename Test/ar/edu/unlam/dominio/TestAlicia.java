package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;	

public class TestAlicia {
	
	private Alicia alicia;
	private Alimento alimentoAgrandador;
	private Alimento alimentoAchicador;

	@Before
	public void setUp(){
		alicia = new Alicia(1000.0);
		alimentoAchicador = new Achicador(500.0, TipoAchicador.ALFAJORES, "Jorgito");
		alimentoAgrandador = new Agrandador(400.0, TipoAgrandador.BOCADITOS_DE_CHOCOLATE, "BocaditosPepe");
	}

	@Test
	public void queAlComprarUnAlimentoseDescuenteElDineroDisponible() throws DineroInsuficienteException {
		alicia.comprarAlimento(alimentoAgrandador);
		Double valorEsperado = 600.0;
		Double valorObtenido = alicia.getDinero();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = DineroInsuficienteException.class)
	public void queNoSeExcedaDelDineroDisponible() throws DineroInsuficienteException {
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAchicador);
		
	}
	
	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeAgrande() throws DineroInsuficienteException, AlturaLimiteException {
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
		Double alturaEsperada = 230.0;
		Double alturaObtenida = alicia.getAltura();
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeEncoja() throws DineroInsuficienteException, AlturaLimiteException {
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
		Double alturaEsperada = 140.0;
		Double alturaObtenida = alicia.getAltura();
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@Test (expected = AlturaLimiteException.class)
	public void queAlConsumirAlimentosVerificarQueNoSePuedaAgrandarMásDe280cm() throws AlturaLimiteException, DineroInsuficienteException {
		alicia.setDinero(9000.0);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.consumirAlimento(alimentoAgrandador);
	}
	
	@Test (expected = AlturaLimiteException.class)
	public void queAlConsumirAlimentosVerificarQueNoSePuedaAchicarMenosDe50cm() throws AlturaLimiteException, DineroInsuficienteException {
		alicia.setDinero(9000.0);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.consumirAlimento(alimentoAchicador);
	}
	
	@Test
	public void verificarQueLaColecciónDeAlimentosQuedeOrdenadaPorNombreDeManeraDescendente() throws DineroInsuficienteException {
		alicia.setDinero(9000.0);
		alicia.comprarAlimento(alimentoAchicador);
		alicia.comprarAlimento(alimentoAgrandador);
		alicia.ordenarAlimentoDescendente();
		Alimento valorObtenido = alicia.getAlimentos().get(0);
		Alimento valorEsperado = alimentoAgrandador;
		assertEquals(valorObtenido, valorEsperado);
	}

}
