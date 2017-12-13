package br.com.contaazul.robos.model.builders;

import br.com.contaazul.robos.model.Coordenada;
import br.com.contaazul.robos.model.Orientacao;
import br.com.contaazul.robos.model.OrientacaoNorte;
import br.com.contaazul.robos.model.Posicao;

/**
 * Classe responsável pela construção de instâncias de Posição
 * 
 * @author gustavo
 *
 */
public class PosicaoBuilder {

	public static final int posicaoXinicial = 0;
	public static final int posicaoYinicial = 0;
	public static final Orientacao orientacaoInicial = new OrientacaoNorte();

	private Posicao posicao;

	public PosicaoBuilder() {
		this.posicao = new Posicao();
	}

	public Posicao getPosicaoPadrao() {
		this.posicao.setCoordenada(new Coordenada(posicaoXinicial, posicaoYinicial));
		this.posicao.setOrientacao(orientacaoInicial);
		return this.posicao;
	}

	public PosicaoBuilder comCoordenadas(int x, int y) {
		this.posicao.setCoordenada(new Coordenada(x, y));
		return this;
	}
	
	public PosicaoBuilder comOrientacao(Orientacao orientacao) {
		this.posicao.setOrientacao(orientacao);
		return this;
	}

	public Posicao get() {
		return this.posicao;
	}

}
