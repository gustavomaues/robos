package br.com.contaazul.robos.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.contaazul.robos.api.RoboService;
import br.com.contaazul.robos.model.Robo;
import br.com.contaazul.robos.model.Terreno;
import br.com.contaazul.robos.model.builders.RoboBuilder;

public class RoboImplTest {

	private RoboService roboService = new RoboImpl();

	private Terreno terreno4x4 = new Terreno(4, 4);

	@Test
	public void verificaEnvioComando() {

		Robo robo = new RoboBuilder().noTerreno(terreno4x4).comPosicaoInicialPadrao().get();

		roboService.enviarComandosAoRobo("MM", robo);

		assertThat(robo.informarPosicaoAtual(), is("(0, 2, N)"));
	}
	
	@Test
	public void verificaReceberPosicaoAtual() {

		Robo robo = new RoboBuilder().noTerreno(terreno4x4).comPosicaoInicialPadrao().get();

		roboService.enviarComandosAoRobo("MM", robo);

		assertThat(roboService.receberPosicaoAtual(robo), is("(0, 2, N)"));
	}

}
