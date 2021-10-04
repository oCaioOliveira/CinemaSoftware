package principal;

import java.util.*;
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

	public String getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getNumCadeira() {
		return numCadeira;
	}

	public void setNumCadeira(int numCadeira) {
		this.numCadeira = numCadeira;
	}

	public char getLetraCadeira() {
		return letraCadeira;
	}

	public void setLetraCadeira(char letraCadeira) {
		this.letraCadeira = letraCadeira;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getHorarioSessao() {
		return horarioSessao;
	}

	public void setHorarioSessao(int horarioSessao) {
		this.horarioSessao = horarioSessao;
	}

	public String getDataExibicao() {
		return dataExibicao;
	}

	public void setDataExibicao(String dataExibicao) {
		this.dataExibicao = dataExibicao;
	}
		
}