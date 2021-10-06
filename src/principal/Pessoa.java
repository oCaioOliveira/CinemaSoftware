package principal;

import java.util.Date;

/**
 * Criação da classe abstrata Pessoa, seus atributos e seus gets e sets
 * @author Caioc
 * @version 1.0 (Out 2020)
 */

public abstract class Pessoa {
	
	// ----------------- ATRIBUTOS ----------------- //
	
	protected String primeiroNome;
	protected String ultimoNome;
	protected String dataNascimento;
	protected String cpf;
	protected String numCelular;
	protected String email;
	
	/**
	 * Criação da super
	 */
	
	public Pessoa() {
		super(); 
	}
		
	// ---------------- CONSTRUTOR ---------------- //
		

	// ------------ GETTERS AND SETTERS ------------ //

	/**
	 * get
	 * @return a string do primeiro nome do cliente específico
	 */
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	
	/**
	 * set
	 * @param primeiroNome uma string do primeiro nome do cliente
	 */

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	/**
	 * get
	 * @return a string do último nome do cliente
	 */

	public String getUltimoNome() {
		return ultimoNome;
	}
	
	/**
	 * set
	 * @param ultimoNome uma string do último nome do cliente
	 */

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	/**
	 * get
	 * @return a string da data de nascimento do cliente
	 */

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	/**
	 * set
	 * @param dataNascimento uma string da data de nascimento do cliente
	 */

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	/**
	 * get
	 * @return a string do CPF do cliente
	 */

	public String getCpf() {
		return cpf;
	}
	
	/**
	 * set
	 * @param cpf uma string do CPF do cliente
	 */

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * get
	 * @return a string do número de celular do cliente
	 */

	public String getNumCelular() {
		return numCelular;
	}
	
	/**
	 * set
	 * @param numCelular uma string do número de celular do cliente
	 */

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}
	
	/**
	 * get
	 * @return a string do email do cliente
	 */

	public String getEmail() {
		return email;
	}
	
	/**
	 * set
	 * @param email uma string do email do cliente
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * get
	 * @return a string do gênero favorito do cliente
	 */
		
}
