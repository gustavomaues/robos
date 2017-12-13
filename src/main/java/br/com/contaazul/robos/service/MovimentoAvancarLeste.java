package br.com.contaazul.robos.service;

import br.com.contaazul.robos.exceptions.MovimentoInvalidoException;
import br.com.contaazul.robos.model.Robo;

/**
 * Classe responsável pelo avanço de um robô no sentido leste, caso haja
 * possibilidade de movimento
 * 
 * @author gustavo
 *
 */
public class MovimentoAvancarLeste implements MovimentoAvanco {

	@Override
	public void movimentar(Robo robo) throws MovimentoInvalidoException {
		preValidar(robo);
		robo.getPosicao().getCoordenada().avancarX();
	}

	@Override
	public void preValidar(Robo robo) throws MovimentoInvalidoException {
		if (robo.getPosicao().getCoordenada().getX() >= robo.getTerreno().getLadoX() - 1) {
			throw new MovimentoInvalidoException();
		}
	}

}
