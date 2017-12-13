package br.com.contaazul.robos.service;

import java.util.List;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;
import br.com.contaazul.robos.exceptions.MovimentoInvalidoException;
import br.com.contaazul.robos.model.Comando;
import br.com.contaazul.robos.model.Robo;

/**
 * Classe Façade de Movimento que objetiva selecionar e executar a classe de
 * movimento correspondente a cada comando
 * 
 * @author gustavo
 *
 */
public class MovimentoFacade {

	public void movimentar(Robo robo, String comandosEnviados)
			throws MovimentoInvalidoException, ComandoInvalidoException {
		List<Comando> comandos = Comando.convert(comandosEnviados);

		comandos.forEach(comando -> getMovimentoPorComando(robo, comando).movimentar(robo));
	}

	private Movimento getMovimentoPorComando(Robo robo, Comando comando) {
		switch (comando) {
		case L:
			return new Rotacao90Esquerda();
		case R:
			return new Rotacao90Direita();
		case M:
			return getMovimentoAvanco(robo);
		}
		throw new ComandoInvalidoException();
	}

	private Movimento getMovimentoAvanco(Robo robo) {

		switch (robo.getPosicao().getOrientacao().getSentido()) {
		case NORTH:
			return new MovimentoAvancarNorte();
		case SOUTH:
			return new MovimentoAvancarSul();
		case EAST:
			return new MovimentoAvancarLeste();
		case WEST:
			return new MovimentoAvancarOeste();
		}
		throw new MovimentoInvalidoException();
	}
}
