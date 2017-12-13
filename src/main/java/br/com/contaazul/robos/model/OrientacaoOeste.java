package br.com.contaazul.robos.model;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;

/**
 * Classe que representa uma orientação no sentido Oeste em uma direção
 * horizontal
 * 
 * @author gustavo
 *
 */
public class OrientacaoOeste extends Orientacao {

	public OrientacaoOeste() {
		super(Sentido.WEST);
	}

	/**
	 * Método que retorna uma nova orientação a partir de determinado comando,
	 * considerando o Robô atualmente na posição Oeste
	 */
	@Override
	public Orientacao getOrientacaoAposComando(Comando comando) throws ComandoInvalidoException {
		try {
			switch (comando) {
			case L:
				return new OrientacaoSul();
			case R:
				return new OrientacaoNorte();
			case M:
				return this;
			default:
				throw new ComandoInvalidoException();
			}

		} catch (NullPointerException e) {
			throw new ComandoInvalidoException();
		}
	}

}
