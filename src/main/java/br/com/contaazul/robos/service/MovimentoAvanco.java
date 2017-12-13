package br.com.contaazul.robos.service;

import br.com.contaazul.robos.exceptions.MovimentoInvalidoException;
import br.com.contaazul.robos.model.Robo;

/**
 * Interface de movimento que exige a pré-validação do movimento
 * 
 * @author gustavo
 *
 */
public interface MovimentoAvanco extends Movimento {

	void preValidar(Robo robo) throws MovimentoInvalidoException;

}
