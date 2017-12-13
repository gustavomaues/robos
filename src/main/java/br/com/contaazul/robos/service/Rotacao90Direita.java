package br.com.contaazul.robos.service;

import br.com.contaazul.robos.exceptions.MovimentoInvalidoException;
import br.com.contaazul.robos.model.Comando;
import br.com.contaazul.robos.model.Orientacao;
import br.com.contaazul.robos.model.Robo;

/**
 * Rotaciona o Robô em seu próprio eixo 90 graus para direita
 */
public class Rotacao90Direita implements Movimento {

	@Override
	public void movimentar(Robo robo) throws MovimentoInvalidoException {
		Orientacao novaOrientacao = (robo.getPosicao().getOrientacao().getOrientacaoAposComando(Comando.R));
		robo.getPosicao().setOrientacao(novaOrientacao);
	}

}
