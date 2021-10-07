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

}
