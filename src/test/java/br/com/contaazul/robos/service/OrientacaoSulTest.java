package br.com.contaazul.robos.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;
import br.com.contaazul.robos.model.Comando;
import br.com.contaazul.robos.model.OrientacaoLeste;
import br.com.contaazul.robos.model.OrientacaoOeste;
import br.com.contaazul.robos.model.OrientacaoSul;
import br.com.contaazul.robos.model.Sentido;

public class OrientacaoSulTest {
	
	private OrientacaoSul orientacao;
	
	@Before
	public void preparaTeste() {
		this.orientacao = new OrientacaoSul();
	}
	
	@Test
	public void verificaSentido() {
		assertThat(orientacao.getSentido(), is(Sentido.SOUTH));
	}

	@Test
	public void verificaOrientacaoAposRotacaoEsquerda() {
		assertThat(orientacao.getOrientacaoAposComando(Comando.L), is(instanceOf(OrientacaoLeste.class)));
	}
	
	@Test
	public void verificaOrientacaoAposRotacaoDireita() {
		assertThat(orientacao.getOrientacaoAposComando(Comando.R), is(instanceOf(OrientacaoOeste.class)));
	}
	
	@Test
	public void verificaOrientacaoAposAvanco() {
		assertThat(orientacao.getOrientacaoAposComando(Comando.M), is(instanceOf(orientacao.getClass())));
	}
	
	@Test(expected=ComandoInvalidoException.class)
	public void verificaLancamentoDeErroAposComandoInvalido() {
		orientacao.getOrientacaoAposComando(null);
	}

}
