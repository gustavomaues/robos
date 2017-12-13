package br.com.contaazul.robos.controller;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;
import br.com.contaazul.robos.exceptions.MovimentoInvalidoException;

public class RoboControllerTest {

	private RoboController roboController;
	
	@Before
	public void inicia() {
		roboController = new RoboController();
	}
	
	@Test(expected=ComandoInvalidoException.class)
	public void comandoInvalidoTest() {
		roboController.enviarComandos("MSMMM");
	}
	
	@Test
	public void movimentosValidosFrenteTest() {
		String resultado = roboController.enviarComandos("MMMM");
		Assert.assertThat("(0, 4, N)", is(equalTo(resultado)));
	}
	
	@Test(expected=MovimentoInvalidoException.class)
	public void movimentosInvalidosFrenteTest() {
		roboController.enviarComandos("MMMMM");
	}
	
	@Test
	public void movimentosValidosLesteTest() {
		String resultado = roboController.enviarComandos("RMMMM");
		Assert.assertThat("(4, 0, E)", is(equalTo(resultado)));
	}
	
	@Test(expected=MovimentoInvalidoException.class)
	public void movimentosInvalidosLestTest() {
		roboController.enviarComandos("RMMMMM");
	}
	
	@Test
	public void movimentosValidosSulTest() {
		String resultado = roboController.enviarComandos("MMMMRRMMMM");
		Assert.assertThat("(0, 0, S)", is(equalTo(resultado)));
	}
	
	@Test(expected=MovimentoInvalidoException.class)
	public void movimentosInvalidosSulTest() {
		roboController.enviarComandos("RRM");
	}
	
	@Test
	public void movimentosValidosOesteTest() {
		String resultado = roboController.enviarComandos("RMMMMRRMM");
		Assert.assertThat("(2, 0, W)", is(equalTo(resultado)));
	}
	
	@Test(expected=MovimentoInvalidoException.class)
	public void movimentosInvalidosOesteTest() {
		roboController.enviarComandos("LM");
	}

}
