package br.com.contaazul.robos.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.contaazul.robos.exceptions.MovimentoInvalidoException;
import br.com.contaazul.robos.exceptions.PosicaoInvalidaException;
import br.com.contaazul.robos.model.OrientacaoNorte;
import br.com.contaazul.robos.model.Posicao;
import br.com.contaazul.robos.model.Robo;
import br.com.contaazul.robos.model.Terreno;
import br.com.contaazul.robos.model.builders.PosicaoBuilder;
import br.com.contaazul.robos.model.builders.RoboBuilder;

public class MovimentoAvancarNorteTest {

	private MovimentoAvanco movimento;
	
	private Terreno terreno2x2 = new Terreno(2, 2);
	
	@Before
	public void preparar() {
		movimento = new MovimentoAvancarNorte();
	}
			
	@Test
	public void verificaPosicaoEsperadaAposMovimentoAvanco() {
		Robo robo = new RoboBuilder().noTerreno(terreno2x2).comPosicaoInicialPadrao().get();
		
		movimento.movimentar(robo);
		
		Posicao posicaoEsperada = new PosicaoBuilder().comCoordenadas(0, 1).comOrientacao(new OrientacaoNorte()).get();
		
		assertThat(robo.getPosicao(), is(equalTo(posicaoEsperada)));
		
		assertThat(robo.informarPosicaoAtual(), is(equalTo("(0, 1, N)")));
	}
	
	@Test(expected=MovimentoInvalidoException.class)
	public void verificaMovimentoAvancoAlemDoTamanhoDoTerreno() {
		Robo robo = new RoboBuilder().noTerreno(terreno2x2).comPosicaoInicialPadrao().get();
		
		movimento.movimentar(robo);
		movimento.movimentar(robo);
	}
	
	@Test(expected=PosicaoInvalidaException.class)
	public void verificaLancamentoDeErroAoTentarMovimentarSemPosicaoDefinida() {
		Robo robo = new RoboBuilder().noTerreno(terreno2x2).get();
		
		movimento.movimentar(robo);
		
	}
	
}
