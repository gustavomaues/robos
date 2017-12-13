package br.com.contaazul.robos.model;

import java.util.List;
import java.util.stream.Collectors;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;

/**
 * Classe que disponibiliza comandos válidos para movimentação do Robô
 * 
 * @author gustavo
 *
 */
public enum Comando {

	L, R, M;

	/**
	 * Método que retorna um comando válido a partir de um char
	 * 
	 * @param comando
	 *            Comando no formado char
	 * @return
	 * @throws ComandoInvalidoException
	 *             Exceção lançada caso o comando informado seja inválido
	 */
	public static Comando getComando(char comando) throws ComandoInvalidoException {
		try {
			return Enum.valueOf(Comando.class, String.valueOf(comando));
		} catch (IllegalArgumentException e) {
			throw new ComandoInvalidoException();
		}
	}

	/**
	 * Método que retorna uma lista de comandos válidos a partir de uma String
	 * contendo uma sequência de comandos
	 * 
	 * @param entrada
	 * @return
	 * @throws ComandoInvalidoException
	 */
	public static List<Comando> convert(String entrada) throws ComandoInvalidoException {
		return entrada.chars().mapToObj(letra -> Comando.getComando((char) letra)).collect(Collectors.toList());
	}

}
