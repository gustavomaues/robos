package br.com.contaazul.robos.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;
import br.com.contaazul.robos.model.Comando;

public class ComandoTest {

	@Test
	public void comandosValidosTest() {
		String comandos = "MMLMR";

		List<Comando> resultado = Comando.convert(comandos);

		for (int i = 0; i < comandos.length(); i++) {
			assertThat(String.valueOf(comandos.charAt(i)), is(equalTo(resultado.get(i).name())));
		}
	}

	@Test(expected = ComandoInvalidoException.class)
	public void comandosInvalidosTest() {
		Comando.convert("MMCMR");
	}

}
