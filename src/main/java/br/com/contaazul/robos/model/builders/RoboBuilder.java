package br.com.contaazul.robos.model.builders;

import java.util.Optional;

import br.com.contaazul.robos.model.Posicao;
import br.com.contaazul.robos.model.Robo;
import br.com.contaazul.robos.model.Terreno;

/**
 * Classe responsável pela construção de instâncias de Robô
 * 
 * @author gustavo
 *
 */
public class RoboBuilder {

	private Robo robo;

	public RoboBuilder() {
		this.robo = new Robo();
	}

	public RoboBuilder comPosicaoInicialPadrao() {
		this.robo.setPosicao(Optional.of(new PosicaoBuilder().getPosicaoPadrao()));
		return this;
	}
	
	public RoboBuilder comPosicao(Posicao posicao) {
		this.robo.setPosicao(Optional.of(posicao));
		return this;
	}

	public RoboBuilder noTerreno(Terreno terreno) {
		this.robo.setTerreno(terreno);
		return this;
	}

	public Robo get() {
		return this.robo;
	}

}
