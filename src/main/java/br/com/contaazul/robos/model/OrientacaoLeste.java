package br.com.contaazul.robos.model;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;

/**
 * Classe que representa uma orientação no sentido Leste em uma direção
 * horizontal
 * 
 * @author gustavo
 *
 */
public class OrientacaoLeste extends Orientacao {

	public OrientacaoLeste() {
		super(Sentido.EAST);
	}

	/**
	 * Método que retorna uma nova orientação a partir de uma rotação 90º para
	 * determinado sentido, considerando a orientação atual
	 */
	@Override
	public Orientacao getOrientacaoAposComando(Comando comando) throws ComandoInvalidoException {
		try {
			switch (comando) {
			case L:
				return new OrientacaoNorte();
			case R:
				return new OrientacaoSul();
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
