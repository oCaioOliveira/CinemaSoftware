package principal;
import java.util.*;
public class SalaCinema {
	
	// ----------------- ATRIBUTOS ----------------- //
	
	private String numSala;
	private String tipoSala;
	private int qntddCadeiras;
	private String formato;
	private int qnddLinhasCadeiras;
	private int qnddColunasCadeiras;
	private boolean cadeiraVaga;
	private Ingresso ingresso[];
	
	public SalaCinema(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- //
	
	public SalaCinema(String numero_sala, String tipo_sala, int qtd_cadeiras, String formato_sala, int qtd_linhas, int qtd_colunas, boolean cadeira_vaga) {
		numSala = numero_sala;
		tipoSala = tipo_sala;
		qntddCadeiras = qtd_cadeiras;
		formato = formato_sala;
		qnddLinhasCadeiras = qtd_linhas;
		qnddColunasCadeiras = qtd_colunas;
		cadeiraVaga = cadeira_vaga; 
	}
	
	// ------------- DADOS PRÉ-CADASTRADOS ----------//
	Scanner input = new Scanner(System.in);	
	ArrayList<SalaCinema> dadosSala = new ArrayList<SalaCinema>();
	
	public void dadosPreCadastradosSala(){
		
		SalaCinema sala1 = new SalaCinema("Sala 1","3D",90,"Quadrado",15,6, true);
		SalaCinema sala2 = new SalaCinema("Sala 2","VIP",50,"Quadrado",25,5,false);
		SalaCinema sala3 = new SalaCinema("Sala 3","Normal",80,"Piramide",20,4,true);
		SalaCinema sala4 = new SalaCinema("Sala 4","Normal",100,"Quadrado",25,5,false);
		SalaCinema sala5 = new SalaCinema("Sala 5","Normal",100,"Quadrado",25,5,true);
		
		dadosSala.add(sala1);
		dadosSala.add(sala2);
		dadosSala.add(sala3);
		dadosSala.add(sala4);
		dadosSala.add(sala5);
		
	}
	
	// ------------------ METODOS ------------------ //

	// Funcao para cadastrar os dados da Sala de Cinema:
	public void cadastrar(SalaCinema sala) {
		dadosSala.add(sala);
	}
	
	// Funcao para cadastrar uma sala vazia:
	public void cadastrarvazio() {
		SalaCinema sala = new SalaCinema("","", 0,"",0,0,false);
		dadosSala.add(sala);
	}
	
	// Funcao para retornar que não foram encontrados resultados:
	public void produtoNaoEncontrado() {
		SalaCinema sala = new SalaCinema("Não foram encontrados resultados...","", 0,"",0,0,false);
		dadosSala.add(sala);
	}

	// Funcao para editar os dados da sala de Cinema:
	public void editar(SalaCinema sala, int pos) {
		deletar(pos);
		cadastrar(sala);
		
//				dadosSala.get(pos).numSala = sala.numSala;
//				dadosSala.get(pos).tipoSala = sala.tipoSala;
//				dadosSala.get(pos).qntddCadeiras = sala.qntddCadeiras;
//				dadosSala.get(pos).formato = sala.formato;
//				dadosSala.get(pos).qnddLinhasCadeiras = sala.qnddLinhasCadeiras;
//				dadosSala.get(pos).qnddColunasCadeiras = sala.qnddColunasCadeiras;
//				dadosSala.get(pos).cadeiraVaga = sala.cadeiraVaga;
	}
	
	// Funcao para deletar uma Sala:
	public void deletar(int pos) {
		dadosSala.remove(dadosSala.get(pos));
	}

	// Chamada de todos os dados de uma sala:
	public String toString() {	
		return "Número da sala: " + numSala + "\n" 
			   + "Tipo da sala: " + tipoSala + "\n" 
			   + "Quantidade de cadeiras: " + qntddCadeiras + "\n" 
			   + "Formato: " + formato + "\n"
			   + "Quantidade de linhas: " + qnddLinhasCadeiras + "\n"
			   + "Quantidade de colunas: " + qnddColunasCadeiras + "\n"
			   + "Cadeiras vagas: " + cadeiraVaga + "\n";
			  
	}
	
	// Funcao para buscar uma sala Especifico pelo seu numero e retorná-la:
	public SalaCinema buscar(String salaNum) {
		for(int i = 0; i < dadosSala.size(); i ++) 
			if(salaNum.equals(dadosSala.get(i).getNumSala().replaceAll("[\\D]", ""))) {
				return dadosSala.get(i);
			}
		return null;
	}
	
	// Funcao para buscar uma sala Especifico pelo seu numero e retornar sua posicao:
	public int retornaPos(String salaNum) {
		for(int i = 0; i < dadosSala.size(); i ++) 
			if(salaNum.equals(dadosSala.get(i).getNumSala().replaceAll("[\\D]", ""))) {
				return i;
			}
		return -1;
	}
	
	// Funcao para visualizar o numero das salas e retornar um vetor de string com eles na mesma ordem do arraylist:
	public String[] visualizarNum() {
		String[] var = new String [1000];
		for(int i = 0; i < dadosSala.size(); i ++) {
			var[i] = String.valueOf(dadosSala.get(i).getNumSala());
		}
		return var;
	}
		
	// Funcoes a seguir são para retornar os dados de salas específicas dentro do arraylist com base nas suas posições (Gets):
	public String retornaNumSala(int pos) {
		return dadosSala.get(pos).getNumSala();
	}
	
	public String retornaTipoSala(int pos) {
		return dadosSala.get(pos).getTipoSala();
	}
	
	public int retornaQntddCadeiras(int pos) {
		return dadosSala.get(pos).getQntddCadeiras();
	}
	
	public String retornaFormato(int pos) {
		return dadosSala.get(pos).getFormato();
	}
	
	public int retornaQntddLinhasCadeiras(int pos) {
		return dadosSala.get(pos).getQnddLinhasCadeiras();
	}
	
	public int retornaQntddColunasCadeiras(int pos) {
		return dadosSala.get(pos).getQnddColunasCadeiras();
	} 
	
	public boolean retornaCadeiraVaga(int pos) {
		return dadosSala.get(pos).isCadeiraVaga();
	} 

	// ------------ GETTERS AND SETTERS ------------ //
	

	public String getNumSala() {
		return numSala;
	}

	public void setNumSala(String numSala) {
		this.numSala = numSala;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getQntddCadeiras() {
		return qntddCadeiras;
	}

	public void setQntddCadeiras(int qntddCadeiras) {
		this.qntddCadeiras = qntddCadeiras;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public int getQnddLinhasCadeiras() {
		return qnddLinhasCadeiras;
	}

	public void setQnddLinhasCadeiras(int qnddLinhasCadeiras) {
		this.qnddLinhasCadeiras = qnddLinhasCadeiras;
	}

	public int getQnddColunasCadeiras() {
		return qnddColunasCadeiras;
	}

	public void setQnddColunasCadeiras(int qnddColunasCadeiras) {
		this.qnddColunasCadeiras = qnddColunasCadeiras;
	}

	public boolean isCadeiraVaga() {
		return cadeiraVaga;
	}

	public void setCadeiraVaga(boolean cadeiraVaga) {
		this.cadeiraVaga = cadeiraVaga;
	}

}