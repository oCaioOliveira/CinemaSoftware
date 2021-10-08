package pacoteTeste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import principal.*;


class TesteValidador {
	Validador v = new Validador();
	
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
	
	@Test
	void testValidaCPF() {
		assertTrue(v.validaCPF("014.123.456-43"));
		assertFalse(v.validaCPF("1"));
		assertFalse(v.validaCPF("01401230456043"));
		assertFalse(v.validaCPF("0.4.123.45-6-3"));
		assertFalse(v.validaCPF("01.412.34564-3"));
		assertFalse(v.validaCPF("000.000.000-00"));
	}
	
	@Test
	void testValidaHora() {
		assertTrue(v.validaHora("14:30"));
		assertFalse(v.validaHora("1"));
		assertFalse(v.validaHora("14030"));
		assertFalse(v.validaHora("14/30"));
		assertFalse(v.validaHora("06:30"));
		assertFalse(v.validaHora("26:30"));
		assertFalse(v.validaHora("16:70"));
	}
}
