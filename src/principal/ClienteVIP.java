package principal;

import java.util.*;

public class ClienteVIP extends Pessoa {
	
	// ----------------- ATRIBUTOS ----------------- //
	
	private String generoFavorito;
	private int qntddFilmesVistos;
	private String planoAssinatura;
	
	public ClienteVIP(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- // 
	
	// Sobrecarga
	public ClienteVIP(String primNome, String ultNome, String data, String c, String numCel, String email, String genFav, int qntddFilmesVistos, String planAss) {
		primeiroNome = primNome;
		ultimoNome = ultNome;
		dataNascimento = data;
		cpf = c;
		numCelular = numCel;
		this.email = email;
		generoFavorito = genFav;
		this.qntddFilmesVistos = qntddFilmesVistos;
		planoAssinatura = planAss;
	}
	
	public ClienteVIP(String primNome, String ultNome, String data, String c, String numCel, String email) {
		primeiroNome = primNome;
		ultimoNome = ultNome;
		dataNascimento = data;
		cpf = c;
		numCelular = numCel;
		this.email = email;
	}
	
	// Funcionalidades:
	
	Scanner input = new Scanner(System.in);	
	Scanner ler = new Scanner(System.in);
	ArrayList<ClienteVIP> dadosCliente = new ArrayList<ClienteVIP>();
	
	// Pré-cadastro de dados do cliente:
	
	public void dadosPreCadastradosClientes() {
		ClienteVIP cliente1 = new ClienteVIP("Caio", "Oliveira", "19/10/2001", "014.123.456-43", "(61)-99321-4506", "caioOliveira@hotmail.com", "Ação", 5, "Mensal");
		ClienteVIP cliente2 = new ClienteVIP("Lucas", "Queiroz", "23/08/2001", "324.576.472-04", "(61)-99431-4792", "lucasQueiroz@hotmail.com", "Comédia", 3, "Anual");
		ClienteVIP cliente3 = new ClienteVIP("Joana", "Barboza", "01/01/1999", "577.165.890-81", "(62)-98232-9175", "joanaBarboza@gmail.com", "Aventura", 10, "Semestral");
		ClienteVIP cliente4 = new ClienteVIP("Maicon", "Torres", "10/09/2002", "768.019.355-91", "(61)-98651-0194", "maiconTorres@hotmail.com", "Terror", 2, "Mensal");
		ClienteVIP cliente5 = new ClienteVIP("Maria", "Monaliza", "07/12/1998", "943.987.185-01", "(62)-99184-0192", "mariaMonaliza@hotmail.com", "Policial", 20, "Mensal");
		
		dadosCliente.add(cliente1);
		dadosCliente.add(cliente2);
		dadosCliente.add(cliente3);
		dadosCliente.add(cliente4);
		dadosCliente.add(cliente5);

	}
	

	
	// ------------------ METODOS ------------------- //
	
	// Funcao para cadastrar os dados de Cliente:
	public void cadastrar(ClienteVIP cliente) {
		dadosCliente.add(cliente);
	}
	
	// Funcao para cadastrar um cliente vazio:
	public void cadastrarvazio() {
		ClienteVIP cliente = new ClienteVIP("", "", "", "", "", "", "", 0, "");
		dadosCliente.add(cliente);
	}
	
	// Funcao para retornar que não foram encontrados resultados:
	public void produtoNaoEncontrado() {
		ClienteVIP cliente = new ClienteVIP("Não foram encontrados resultados...", "", "", "", "", "", "", 0, "");
		dadosCliente.add(cliente);
	}
	
	// Funcao para buscar um Cliente Especifico por CPF e retorná-lo:
	public ClienteVIP buscar(String cpf) {
		for(int i = 0; i < dadosCliente.size(); i ++) 
			if(cpf.equals(dadosCliente.get(i).getCpf().replaceAll("[\\D]", ""))) {
				return dadosCliente.get(i);
			}
		return null;
	}
	
	// Funcao para buscar um Cliente Especifico por CPF e retornar sua posição:
	public int retornaPos(String cpf) {
		for(int i = 0; i < dadosCliente.size(); i ++) 
			if(cpf.equals(dadosCliente.get(i).getCpf().replaceAll("[\\D]", ""))) {
				return i;
			}
		return -1;
	}
	
	// Funcao para editar um Cliente:
	public void editar(ClienteVIP cliente, int pos) {
		deletar(pos);
		cadastrar(cliente);
		
//		dadosCliente.get(pos).email = cliente.email;
//		dadosCliente.get(pos).generoFavorito = cliente.generoFavorito;
//		dadosCliente.get(pos).numCelular = cliente.numCelular;
//		dadosCliente.get(pos).planoAssinatura = cliente.planoAssinatura;
//		dadosCliente.get(pos).qntddFilmesVistos = cliente.qntddFilmesVistos;
	}
	
	// Funcao para deletar um Cliente:
	public void deletar(int pos) {
		dadosCliente.remove(dadosCliente.get(pos));
	}
	
	// Chamada de todos os dados de um Cliente:
	public String toString() {	
		return "Nome do cliente VIP: " + primeiroNome + " " + ultimoNome + "\n" 
			   + "Data de Nascimento: " + dataNascimento + "\n" + "CPF: " + cpf + "\n" 
			   + "Número de Celular: " + numCelular + "\n" + "E-mail:" + email + "\n" 
			   + "Gênero Favorito: " + generoFavorito + "\n" + "Quantidade de Filmes Vistos: "
			   + qntddFilmesVistos + "\n" + "Plano de Assinatura: " + planoAssinatura + "\n";
	}
	
	// Funcao para visualizar o primeiro nome dos clientes e retornar um vetor de string com eles na mesma ordem do arraylist:
	public String[] visualizarNome() {
		String[] var = new String [1000];
		for(int i = 0; i < dadosCliente.size(); i ++) {
			var[i] = dadosCliente.get(i).getPrimeiroNome();
		}
		return var;
	}
	
	// Funcoes a seguir são para retornar os dados de clientes específicos dentro do arraylist com base nas suas posições (Gets):
	public String retornaPrimNome(int pos) {
			return dadosCliente.get(pos).getPrimeiroNome();
	}
	
	public String retornaData(int pos) {
		return dadosCliente.get(pos).getDataNascimento();
	}
	
	public String retornaUltNome(int pos) {
		return dadosCliente.get(pos).getUltimoNome();
	}
	
	public String retornaCPF(int pos) {
		return dadosCliente.get(pos).getCpf();
	}
	
	public String retornaNumCel(int pos) {
		return dadosCliente.get(pos).getNumCelular();
	}
	
	public String retornaEmail(int pos) {
		return dadosCliente.get(pos).getEmail();
	}
	
	public String retornaGenFav(int pos) {
		return dadosCliente.get(pos).getGeneroFavorito();
	}
	
	public int retornaQntddFilmesVistos(int pos) {
		return dadosCliente.get(pos).getQntddFilmesVistos();
	}
	
	public String retornaPlanoAss(int pos) {
		return dadosCliente.get(pos).getPlanoAssinatura();
	}
	
	// ------------ GETTERS AND SETTERS ------------ //
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGeneroFavorito() {
		return generoFavorito;
	}
	
	public void setGeneroFavorito(String generoFavorito) {
		this.generoFavorito = generoFavorito;
	}
	
	public int getQntddFilmesVistos() {
		return qntddFilmesVistos;
	}
	
	public void setQntddFilmesVistos(int qntddFilmesVistos) {
		this.qntddFilmesVistos = qntddFilmesVistos;
	}
	
	public String getPlanoAssinatura() {
		return planoAssinatura;
	}
	
	public void setPlanoAssinatura(String planoAssinatura) {
		this.planoAssinatura = planoAssinatura;
	}
		
	
}
