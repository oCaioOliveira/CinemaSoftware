package principal;

import java.util.*;

public class Filme {

	// ----------------- ATRIBUTOS ----------------- //
	
	private String nome;
	private int duracao;
	private int classificacaoIndicativa;
	private String idioma;
	private String sinopse;
	private String genero;
	private String dataLancamento;
	private int salaTransmissao;
	private int horario;
	private String dataExib;
	private Ingresso ingresso[];
	
	public Filme(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- // 
	
	public Filme(String nomeDoFilme, int duracaoDoFilme, int classificacao, 
			String idiomaDoFilme, String sinopseFilme, String generoFilme, 
			String data_lancamento, int sala_transmissao, int hora, String dt) {
		nome = nomeDoFilme;
		duracao = duracaoDoFilme;
		classificacaoIndicativa = classificacao;
		idioma = idiomaDoFilme;
		sinopse = sinopseFilme;
		genero = generoFilme;
		dataLancamento = data_lancamento;
		salaTransmissao = sala_transmissao;
		horario = hora;
		dataExib = dt;
	}
	
	// Funcionalidades:
		
		Scanner ler = new Scanner(System.in);
		ArrayList<Filme> dadosFilmes = new ArrayList<Filme>();
		Scanner input = new Scanner(System.in);
		
	// Pré-cadastro de dados do cliente:
	
	public void dadosPreCadastradosFilmes(){
		Filme shang_chi = new Filme("Shang-Chi",135,12,"Português","Shang-Chi "
				+ "deve enfrentar o passado quando é atraído para a teia da organização Dez Anéis.", 
				"Ação","02/03/2021",2, 14,"15/03/2021");
		Filme viuva_negra = new Filme("Viúva negra",133,12,"Português","Em Viúva Negra, acompanhamos a "
				+ "vida de Natasha Romanoff (Scarlett Johansson) após os eventos de Guerra Civil. "
				+ "Se escondendo do governo norte-americano devido a sua aliança com o time do Capitão América, "
				+ "Natasha ainda precisa confrontar partes de sua história quando surge uma conspiração "
				+ "perigosa ligada ao seu passado. Perseguida por uma força que não irá parar até derrotá-la, "
				+ "ela terá que lidar com sua antiga vida de espiã, e também reencontrar membros de sua família "
				+ "que deixou para trás antes de se tornar parte dos Vingadores.",
				"Ação","02/09/2021",10, 15,"23/08/2020");
		Filme pulp_fiction = new Filme("Pulp Fiction", 152,18,"Português","Os assassinos "
				+ "Vincent e Jules passam por imprevistos ao recuperar uma mala para um mafioso. "
				+ "O boxeador Butch é pago pelo mesmo mafioso para perder uma luta, e a esposa do criminoso "
				+ "fica sob responsabilidade de Vincent por uma noite.Essas histórias se relacionam numa teia "
				+ "repleta de violência.","Ação","18/02/1995",13,12,"19/10/2021");
		Filme titanic = new Filme("Titanic", 194, 12, "Português","Jack Dawson (Leonardo DiCaprio) é um jovem "
				+ "aventureiro que, na mesa de jogo, ganha uma passagem para a primeira viagem do transatlântico Titanic."
				+ " Trata-se de um luxuoso e imponente navio, anunciado na época como inafundável, que parte para os Estados Unidos."
				+ " Nele está também Rose DeWitt Bukater (Kate Winslet), a jovem noiva de Caledon Hockley (Billy Zane). "
				+ "Rose está descontente com sua vida, já que sente-se sufocada pelos costumes da elite e não ama Caledon."
				+ " Entretanto, ela precisa se casar com ele para manter o bom nome da família, que está falida. "
				+ "Um dia, desesperada, Rose ameaça se atirar do Titanic, mas Jack consegue demovê-la da ideia. "
				+ "Pelo ato ele é convidado a jantar na primeira classe, onde começa a se tornar mais próximo de Rose."
				+ " Logo eles se apaixonam, despertando a fúria de Caledon. "
				+ "A situação fica ainda mais complicada quando o Titanic se choca com um iceberg, provocando algo que ninguém "
				+ "imaginava ser possível: o naufrágio do navio.", "Drama","16/01/1998",8,22,"04/12/2021");
		Filme gente_grande = new Filme("Gente Grande", 99,12,"Português","Cinco amigos de infância se reencontram após a morte de seu treinador."
				+ " Juntos novamente, Lenny (Adam Sandler), Eric (Kevin James), Kurt (Chris Rock), Marcus (David Spade) e Rob (Rob Schneider) "
				+ "decidem curtir o feriado de 4 de julho com suas famílias em uma casa no lago. Eles relembram os bons momentos e fazem novas "
				+ "descobertas, além de se meterem em muitas confusões.","Comédia","24/09/2010",5, 6,"16/12/2021");
	
		dadosFilmes.add(shang_chi);
		dadosFilmes.add(viuva_negra);
		dadosFilmes.add(pulp_fiction);
		dadosFilmes.add(titanic);
		dadosFilmes.add(gente_grande);
	
	}
		
	// ------------------ METODOS ------------------ //

	// Funcao para cadastrar os dados de Filme:
	public void cadastrar(Filme filme) {
		dadosFilmes.add(filme);
	}
		
	// Funcao para buscar um filme por nome e retornar aquele filme:
	public Filme buscar(String nome) {
		for(int i = 0; i < dadosFilmes.size(); i ++) 
			if(nome.equals(dadosFilmes.get(i).getNome().toUpperCase())) {
				return dadosFilmes.get(i);
			}
		return null;
	}
	
	// Funcao para cadastrar um filme vazio:
	public void cadastrarvazio() {
		Filme filme = new Filme("",0,0,"","", "","",0, 0,"");
		dadosFilmes.add(filme);
	}
	
	// Funcao para retornar que não foram encontrados resultados:
	public void produtoNaoEncontrado() {
		Filme filme = new Filme("Não foram encontrados resultados...",0,0,"","", "","",0, 0,"");
		dadosFilmes.add(filme);
	}
	
	// Funcao para buscar um Filme Especifico por nome e retornar sua posição:
	public int retornaPos(String nome) {
		for(int i = 0; i < dadosFilmes.size(); i ++) 
			if(nome.equals(dadosFilmes.get(i).getNome().toUpperCase())) {
				return i;
			}
		return -1;
	}
	
	// Funcao para editar os dados do filme:
	public void editar(Filme filme, int pos) {
		deletar(pos);
		cadastrar(filme);
	}
	
	// Funcao para deletar um filme especifico a partir de sua posicao:
	public void deletar(int pos) {
		dadosFilmes.remove(dadosFilmes.get(pos));
	}
	
	// Chamada de todos os dados de um Filme:
	public String toString() {	
		return "Nome do filme: " + nome + "\n" 
			   + "Duração: " + duracao + "\n" 
			   + "Classificação indicativa: " + classificacaoIndicativa + "\n" 
			   + "Idioma: " + idioma + "\n"
			   + "Sinopse: " + sinopse + "\n" 
			   + "Data de lançamento: " + dataLancamento + "\n"
			   + "Gênero" + genero + "\n"
			   + "Sala de transmissão: " + salaTransmissao + "\n";
	}
	
	// Funcao para visualizar o nome dos filmes e retornar um vetor de string com eles na mesma ordem do arraylist:
	public String[] visualizarNome() {
		String[] var = new String [1000];
		for(int i = 0; i < dadosFilmes.size(); i ++) {
			var[i] = dadosFilmes.get(i).getNome();
		}
		return var;
	}
	
	// Funcoes a seguir são para retornar os dados de filmes específicos dentro do arraylist com base nas suas posições (Gets):	
	public String retornaNomeFilme(int pos) {
		return dadosFilmes.get(pos).getNome();
	}
	
	public int retornaDuracao(int pos) {
		return dadosFilmes.get(pos).getDuracao();
	}
	
	public int retornaClasIndic(int pos) {
		return dadosFilmes.get(pos).getClassificacaoIndicativa();
	}
	
	public String retornaIdioma(int pos) {
		return dadosFilmes.get(pos).getIdioma();
	}
	
	public String retornaSinopse(int pos) {
		return dadosFilmes.get(pos).getSinopse();
	}
	
	public String retornaGenero(int pos) {
		return dadosFilmes.get(pos).getGenero();
	}
	
	public String retornaDataLanc(int pos) {
		return dadosFilmes.get(pos).getDataLancamento();
	}
	
	public int retornaSalaTrans(int pos) {
		return dadosFilmes.get(pos).getSalaTransmissao();
	}
	
	public int retornaHorario(int pos) {
		return dadosFilmes.get(pos).getHorario();
	}
	
	public String retornaDataExib(int pos) {
		return dadosFilmes.get(pos).getDataExibicao();
	}
		
	// ------------ GETTERS AND SETTERS ------------ //
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}
	
	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getDataLancamento() {
		return dataLancamento;
	}
	
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public int getSalaTransmissao() {
		return salaTransmissao;
	}
	
	public void setSalaTransmissao(int salaTransmissao) {
		this.salaTransmissao = salaTransmissao;
	}
	
	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public String getDataExibicao() {
		return dataExib;
	}

	public void setDataExibicao(String dataExibicao) {
		this.dataExib = dataExibicao;
	}
	
}