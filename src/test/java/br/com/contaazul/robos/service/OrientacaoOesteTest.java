package br.com.contaazul.robos.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;
import br.com.contaazul.robos.model.Comando;
import br.com.contaazul.robos.model.OrientacaoNorte;
import br.com.contaazul.robos.model.OrientacaoOeste;
import br.com.contaazul.robos.model.OrientacaoSul;
import br.com.contaazul.robos.model.Sentido;

public class OrientacaoOesteTest {
	
	private OrientacaoOeste orientacao;
	
	@Before
	public void preparaTeste() {
		this.orientacao = new OrientacaoOeste();
	}
	
	@Test
	public void verificaSentido() {
		assertThat(orientacao.getSentido(), is(Sentido.WEST));
	}

	@Test
	public void verificaOrientacaoAposRotacaoEsquerda() {
		assertThat(orientacao.getOrientacaoAposComando(Comando.L), is(instanceOf(OrientacaoSul.class)));
	}
	
	@Test
	public void verificaOrientacaoAposRotacaoDireita() {
		assertThat(orientacao.getOrientacaoAposComando(Comando.R), is(instanceOf(OrientacaoNorte.class)));
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
