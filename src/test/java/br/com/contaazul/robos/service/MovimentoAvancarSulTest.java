package br.com.contaazul.robos.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.contaazul.robos.exceptions.MovimentoInvalidoException;
import br.com.contaazul.robos.exceptions.PosicaoInvalidaException;
import br.com.contaazul.robos.model.OrientacaoSul;
import br.com.contaazul.robos.model.Posicao;
import br.com.contaazul.robos.model.Robo;
import br.com.contaazul.robos.model.Terreno;
import br.com.contaazul.robos.model.builders.PosicaoBuilder;
import br.com.contaazul.robos.model.builders.RoboBuilder;

public class MovimentoAvancarSulTest {

	private MovimentoAvanco movimento;
	
	private Terreno terreno2x2 = new Terreno(2, 2);
	
	@Before
	public void preparar() {
		movimento = new MovimentoAvancarSul();
	}
			
	@Test
	public void verificaPosicaoEsperadaAposMovimentoAvanco() {
		
		Posicao posicaoInicial = new PosicaoBuilder().comCoordenadas(0, 2).comOrientacao(new OrientacaoSul()).get();
		
		Robo robo = new RoboBuilder().noTerreno(terreno2x2).comPosicao(posicaoInicial).get();
		
		movimento.movimentar(robo);
		
		Posicao posicaoEsperada = new PosicaoBuilder().comCoordenadas(0, 1).comOrientacao(new OrientacaoSul()).get();
		
		assertThat(robo.getPosicao(), is(equalTo(posicaoEsperada)));
	}
	
	@Test(expected=MovimentoInvalidoException.class)
	public void verificaMovimentoAvancoAlemDoTamanhoDoTerreno() {
		Robo robo = new RoboBuilder().noTerreno(terreno2x2).comPosicaoInicialPadrao().get();
		
		movimento.movimentar(robo);
	}
	
	@Test(expected=PosicaoInvalidaException.class)
	public void verificaLancamentoDeErroAoTentarMovimentarSemPosicaoDefinida() {
		Robo robo = new RoboBuilder().noTerreno(terreno2x2).get();
		
		movimento.movimentar(robo);
	}
	
}
