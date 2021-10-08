package principal;

/**
 * Verifica se os dados fornecidos estão no formato e requisitos esperados
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class Validador {
	
	/**
	 * Verifica se a data fornecida está no formato esperado. São feitas as seguintes verificações:
	 * (1) se a data tem 10 caracteres
	 * (2) se a data tem 8 caracteres numéricos
	 * (3) se o 3° e o 6° caractere são "/"
	 * (4) se o primeiro caractere de dias está entre 0 e 3
	 * (5) se o primeiro caracter de meses está entre 0 e 1
	 * (6) se o primeiro caractere de anos está entre 1 e 2
	 * (7) se os caracteres de dias estão entre 1 e 31
	 * (8) se os caracteres de meses estão entre 1 e 12
	 * (9) se os caracteres de anos estão entre 1888 e 2021
	 * @param data uma string que representa uma data a ser verificada
	 * @return um boolean (Verdadeiro ou falso), false caso reprove em algum teste e true caso passe em todos
	 */

	public boolean validaData(String data) {
		// Verifica se existem exatos 10 caracteres
		if (data.length() != 10) { 
			return false;
		}
		
		// Verifica se existem exatos 8 caracteres numéricos
		if (data.replaceAll("[\\D]", "").length() != 8) { 
			return false;
		}
		
		// Verifica se existem 2 "/" em posições específicas
		if (data.substring(2, 3).indexOf("/") != 0 || data.substring(5, 6).indexOf("/") != 0) { 
			return false;
		}
		
		// Verifica se os dias estão entre 1 e 31
		if (Integer.parseInt(data.substring(0, 2)) < 1 || Integer.parseInt(data.substring(0, 2)) > 31) { 
			return false;
		}
		// Verifica se os meses estão entre 1 e 12
		if (Integer.parseInt(data.substring(3, 5)) < 1 || Integer.parseInt(data.substring(3, 5)) > 12) {
			return false;
		}
		
		// Verifica se os anos estão entre 1888 e 2021
		if (Integer.parseInt(data.substring(6, 10)) < 1888 || Integer.parseInt(data.substring(6, 10)) > 2021) { 
			return false;
		}

		return true;
	}
	
	/**
	 * Verifica se o CPF fornecido está no formato esperado. São feitas as seguintes verificações:
	 * (1) se o CPF tem 14 caracteres
	 * (2) se o CPF tem 11 caracteres numéricos
	 * (3) se o 4° e o 8° caractere são "." e o 12° caractere "-"
	 * (4) se os caracteres numéricos não são todos repetidos
	 * @param cpf uma string que representa um CPF a ser verificado
	 * @return um boolean (Verdadeiro ou falso), false caso reprove em algum teste e true caso passe em todos
	 */
	
	public boolean validaCPF(String cpf) {
		// Tamanho da string de CPF em caracteres
		if (cpf.length() != 14) 
			return false;
		
		// Tamanho da string de CPF em caracteres numéricos
		if (cpf.replaceAll("[\\D]", "").length() != 11) 
			return false;
		
		// Verifica se existem 2 "." e 1 "-" em posições específicas
		if (cpf.substring(3, 4).indexOf(".") != 0 || cpf.substring(7, 8).indexOf(".") != 0 || 
				cpf.substring(11, 12).indexOf("-") != 0) 
			return false;
		
		// Verifica se o CPF não tem todos os números iguais
		if (cpf.replaceAll("[\\D]", "").equals("00000000000") || cpf.replaceAll("[\\D]", "").equals("11111111111") ||
				cpf.replaceAll("[\\D]", "").equals("22222222222") || cpf.replaceAll("[\\D]", "").equals("33333333333") ||
				cpf.replaceAll("[\\D]", "").equals("44444444444") || cpf.replaceAll("[\\D]", "").equals("55555555555") ||
				cpf.replaceAll("[\\D]", "").equals("66666666666") || cpf.replaceAll("[\\D]", "").equals("77777777777") ||
				cpf.replaceAll("[\\D]", "").equals("88888888888") || cpf.replaceAll("[\\D]", "").equals("99999999999"))
			return false;
		
		return true;
	}
	
	/**
	 * Verifica se o hora fornecido está no formato esperado. São feitas as seguintes verificações:
	 * (1) se a hora tem 5 caracteres
	 * (2) se a hora tem 4 caracteres numéricos
	 * (3) se o 3° caracter é ":"
	 * (4) se o horário está de acordo com o horário de funcionamento do cinema
	 * (5) se o horário está de acordo com o formato de horas escolhido (de 00h até 23h)
	 * (6) se o horário está de acordo com o formato de minutos escolhido (de 00min até 59min)
	 * @param hora uma string que representa uma hora a ser verificada
	 * @return um boolean (Verdadeiro ou falso), false caso reprove em algum teste e true caso passe em todos
	 */
	
	public boolean validaHora(String hora) {
		// Tamanho da string de horas em caracteres
		if (hora.length() != 5) {
			return false;
		}
		
		// Tamanho da string de horas em caracteres numéricos
		if (hora.replaceAll("[\\D]", "").length() != 4) { 
			return false;
		}
		
		// Verifica se existe ":" no 3° caracter
		if (hora.substring(2, 3).indexOf(":") != 0) {
			return false;
		}
		
		// Cinema não está aberto entre as 03h e as 10h
		if (Integer.parseInt(hora.substring(0, 2)) > 2 && Integer.parseInt(hora.substring(0, 2)) < 11) { 
			return false;
		}
		
		// Formato do relógio das horas
		if (Integer.parseInt(hora.substring(0, 2)) < 0 || Integer.parseInt(hora.substring(0, 2)) > 23) {
			return false;
		}
		
		// Formato do relógio dos minutos
		if (Integer.parseInt(hora.substring(3, 5)) < 0 || Integer.parseInt(hora.substring(3, 5)) > 59) {
			return false;
		}
		
		return true;
	}
	
}
