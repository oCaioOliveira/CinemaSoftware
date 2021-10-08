package pacoteTeste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import principal.*;

/**
 * Fazer testes unitários com Datas, CPFs e ... chamando as funções de validação de cada um
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

class TesteValidador {
	Validador v = new Validador();
	
	/**
	 * Enviar strings de datas específicas para fazer testes unitários e verificar se está no formato esperado
	 */
	
	@Test
	void testValidaData() {
		assertTrue(v.validaData("23/08/2020"));
		assertFalse(v.validaData("1"));
		assertFalse(v.validaData("1234567890"));
		assertFalse(v.validaData("23/8/20/20"));
		assertFalse(v.validaData("23.08.2020"));
		assertFalse(v.validaData("2/3082/020"));
		assertFalse(v.validaData("23/0.82020"));
		assertFalse(v.validaData("43/08/2020"));
		assertFalse(v.validaData("23/28/2020"));
		assertFalse(v.validaData("23/08/4020"));
		assertFalse(v.validaData("35/08/2020"));
		assertFalse(v.validaData("25/18/2020"));
		assertFalse(v.validaData("25/08/2022"));
	}
	
	/**
	 * Enviar strings de CPFs específicos para fazer testes unitários e verificar se está no formato esperado
	 */
	
	@Test
	void testValidaCPF() {
		assertTrue(v.validaCPF("014.123.456-43"));
		assertFalse(v.validaCPF("1"));
		assertFalse(v.validaCPF("01401230456043"));
		assertFalse(v.validaCPF("0.4.123.45-6-3"));
		assertFalse(v.validaCPF("01.412.34564-3"));
		assertFalse(v.validaCPF("000.000.000-00"));
	}
}
