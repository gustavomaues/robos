package br.com.contaazul.robos.service;

import br.com.contaazul.robos.api.RoboService;
import br.com.contaazul.robos.model.Robo;

/**
 * Implentação da interface de acesso aos Robôs
 * 
 * @author gustavo
 *
 */
public class RoboImpl implements RoboService {

	@Override
	public void enviarComandosAoRobo(String comandos, Robo robo) {
		MovimentoFacade movimento = new MovimentoFacade();
		movimento.movimentar(robo, comandos);
	}

	@Override
	public String receberPosicaoAtual(Robo robo) {
		return robo.informarPosicaoAtual();
	}

}
