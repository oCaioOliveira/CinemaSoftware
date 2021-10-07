package principal;

import java.util.*;

/**
 * Criação da classe Ingresso, seus dados pré cadastrados e seus respectivos métodos
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class Ingresso {

	// ----------------- ATRIBUTOS ----------------- //
	
	private String tipoIngresso;
	private int numSala;
	private String tipoSala;
	private int numCadeira;
	private char letraCadeira;
	private String nomeFilme;
	private String idioma;
	private int horarioSessao;
	private String dataExibicao;
	private VendaIngresso venda[];
	 
	// ---------------- CONSTRUTOR ---------------- //
	
	/**
	 * Criação do contrutor da classe Ingresso com os seus próprios atributos
	 * @param tipo_ingresso uma string que contem o tipo de ingresso
	 * @param num_sala um inteiro que contem o número da sala do ingresso
	 * @param tipo_sala uma string que contem o tipo de sala do ingresso
	 * @param num_cadeira um inteiro que contem o número da cadeira do ingresso
	 * @param letra_cadeira uma char que contem a letra da cadeira do ingresso
	 * @param nomeDoFilme uma string quem contem o nome do filme do ingresso
	 * @param idiomaFilme uma string quem contem o idioma do filme do ingresso
	 * @param hora um inteiro quem contem o horário do filme do ingresso
	 * @param data_exibicao uma string quem contem a data de exibição do filme do ingresso
	 */

	public Ingresso(String tipo_ingresso, int num_sala, String tipo_sala, int num_cadeira, 
			char letra_cadeira, String nomeDoFilme, String idiomaFilme, int hora, 
			String data_exibicao) {
		tipoIngresso = tipo_ingresso;
		numSala = num_sala;
		tipoSala = tipo_sala;
		numCadeira = num_cadeira;
		letraCadeira = letra_cadeira;
		nomeFilme = nomeDoFilme;
		idioma = idiomaFilme;
		horarioSessao = hora;
		dataExibicao = data_exibicao;
	}
		
	// ------------------ METODOS ------------------ //
	
	// Funcionalidades:
	Scanner scan = new Scanner(System.in);
		
	// ------------ GETTERS AND SETTERS ------------ //

	/**
	 * get
	 * @return a string do tipo de ingresso
	 */
	
	public String getTipoIngresso() {
		return tipoIngresso;
	}

	/**
	 * set
	 * @param tipoIngresso uma string do tipo de ingresso
	 */

	
	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}
	
	/**
	 * get
	 * @return o inteiro do número da sala do ingresso
	 */

	public int getNumSala() {
		return numSala;
	}
	
	/**
	 * set
	 * @param numSala um inteiro do número da sala do ingresso
	 */

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}
	
	/**
	 * get
	 * @return a string do tipo de sala do ingresso
	 */

	public String getTipoSala() {
		return tipoSala;
	}
	
	/**
	 * set
	 * @param tipoSala uma string do tipo de sala do ingresso
	 */

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	/**
	 * get
	 * @return o inteiro do número da cadeira do ingresso
	 */
	
	public int getNumCadeira() {
		return numCadeira;
	}
	
	/**
	 * set
	 * @param numCadeira um inteiro do número da cadeira do ingresso
	 */

	public void setNumCadeira(int numCadeira) {
		this.numCadeira = numCadeira;
	}
	
	/**
	 * get
	 * @return uma char da letra da cadeira do ingresso
	 */

	public char getLetraCadeira() {
		return letraCadeira;
	}
	
	/**
	 * set
	 * @param letraCadeira uma char da letra da cadeira do ingresso
	 */

	public void setLetraCadeira(char letraCadeira) {
		this.letraCadeira = letraCadeira;
	}
	
	/**
	 * get
	 * @return uma string do nome do filme do ingresso
	 */

	public String getNomeFilme() {
		return nomeFilme;
	}
	
	/**
	 * set
	 * @param nomeFilme uma string do nome do filme do ingresso
	 */

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	/**
	 * get
	 * @return uma string do idioma do filme do ingresso
	 */

	public String getIdioma() {
		return idioma;
	}
	
	/**
	 * set
	 * @param idioma uma string do idioma do filme do ingresso
	 */

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * get
	 * @return um inteiro do horário de sessão do filme do ingresso
	 */

	public int getHorarioSessao() {
		return horarioSessao;
	}
	
	/**
	 * set
	 * @param horarioSessao um inteiro do horário de sessão do filme do ingresso
	 */

	public void setHorarioSessao(int horarioSessao) {
		this.horarioSessao = horarioSessao;
	}
	
	/**
	 * get
	 * @return uma string da data de exibição do filme do ingresso
	 */

	public String getDataExibicao() {
		return dataExibicao;
	}
	
	/**
	 * set
	 * @param dataExibicao uma string da data de exibição do filme do ingresso
	 */

	public void setDataExibicao(String dataExibicao) {
		this.dataExibicao = dataExibicao;
	}
		
}