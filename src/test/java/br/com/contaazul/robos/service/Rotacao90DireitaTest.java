package br.com.contaazul.robos.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.contaazul.robos.model.OrientacaoLeste;
import br.com.contaazul.robos.model.OrientacaoNorte;
import br.com.contaazul.robos.model.OrientacaoOeste;
import br.com.contaazul.robos.model.OrientacaoSul;
import br.com.contaazul.robos.model.Robo;
import br.com.contaazul.robos.model.Terreno;
import br.com.contaazul.robos.model.builders.PosicaoBuilder;
import br.com.contaazul.robos.model.builders.RoboBuilder;

public class Rotacao90DireitaTest {

	private RoboBuilder roboBuilder;

	private PosicaoBuilder posicaoBuilder;

	Rotacao90Direita rotacao90Direita = new Rotacao90Direita();

	@Before
	public void prepara() {
		roboBuilder = new RoboBuilder().noTerreno(new Terreno(2, 2));
		posicaoBuilder = new PosicaoBuilder().comCoordenadas(0, 0);
	}

	@Test
	public void verificaResultadoRotacaoQuantoAoNorte() {

		Robo robo = roboBuilder.comPosicaoInicialPadrao().get();

		rotacao90Direita.movimentar(robo);

		assertThat(robo.getPosicao().getOrientacao(), is(new OrientacaoLeste()));
	}

	@Test
	public void verificaResultadoRotacaoQuantoAoLeste() {

		Robo robo = roboBuilder.comPosicao(posicaoBuilder.comOrientacao(new OrientacaoLeste()).get()).get();

		rotacao90Direita.movimentar(robo);

		assertThat(robo.getPosicao().getOrientacao(), is(new OrientacaoSul()));
	}

	@Test
	public void verificaResultadoRotacaoQuantoAoSul() {

		Robo robo = roboBuilder.comPosicao(posicaoBuilder.comOrientacao(new OrientacaoSul()).get()).get();

		rotacao90Direita.movimentar(robo);

		assertThat(robo.getPosicao().getOrientacao(), is(new OrientacaoOeste()));
	}

	@Test
	public void verificaResultadoRotacaoQuantoAoOeste() {

		Robo robo = roboBuilder.comPosicao(posicaoBuilder.comOrientacao(new OrientacaoOeste()).get()).get();

		rotacao90Direita.movimentar(robo);

		assertThat(robo.getPosicao().getOrientacao(), is(new OrientacaoNorte()));
	}

}
