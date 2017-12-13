package br.com.contaazul.robos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção a ser lançada quando há tentativa de movimento inválido
 * <p>
 * A uma requisição REST retorna o status 400.
 * 
 * @author gustavo
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MovimentoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovimentoInvalidoException() {
		super();
	}

}
