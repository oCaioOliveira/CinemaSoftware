package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Funcionario extends Pessoa {

	// ----------------- ATRIBUTOS ----------------- //
	
	private String funcao;
	private String endereco;
	private double salario;
	
	public Funcionario(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- // 
	
	// Sobrecarga
	public Funcionario(String primNome, String ultNome, String data, String c, String numCel, String email, String func, String end, double sal) {
		primeiroNome = primNome;
		ultimoNome = ultNome;
		dataNascimento = data;
		cpf = c;
		numCelular = numCel;
		this.email = email;
		funcao = func;
		endereco = end;
		salario = sal;
	}
	
	public Funcionario(String primNome, String ultNome, String data, String c, String numCel, String email) {
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
	Scanner lerd = new Scanner(System.in);	
	ArrayList<Funcionario> dadosFuncionario = new ArrayList<Funcionario>();
	
	// Pré-cadastro de dados do cliente:
	
	public void dadosPreCadastradosFuncionario() {
		Funcionario funcionario1 = new Funcionario("Junior", "Filho", "17/11/1991", "543.767.236-63", "(61)-99145-4832", "juniorFilho@hotmail.com", "Atendente", "Residencial Vivace", 3000.0);
		Funcionario funcionario2 = new Funcionario("Nicole", "Soares", "18/12/1988", "934.931.192-04", "(61)-99716-8092", "nicoleSoares@hotmail.com", "Atendente", "Samambaia", 3500.0);
		Funcionario funcionario3 = new Funcionario("Sofia", "Oliveira", "09/05/1981", "943.019.861-09", "(62)-98874-9901", "sofiaOliveira@gmail.com", "Atendente", "Taguatinga", 3500.0);
		Funcionario funcionario4 = new Funcionario("Paulo", "Molares", "11/08/1992", "923.958.105-75", "(61)-98884-9104", "pauloMolares@hotmail.com", "Atendente", "Sudoeste", 3000.0);
		Funcionario funcionario5 = new Funcionario("Rodolfo", "Mimosa", "08/06/1972", "765.087.432-01", "(61)-98780-9809", "rodolfoMimosa@hotmail.com", "Gerente", "Ceilândia", 4000.5);
		
		dadosFuncionario.add(funcionario1);
		dadosFuncionario.add(funcionario2);
		dadosFuncionario.add(funcionario3);
		dadosFuncionario.add(funcionario4);
		dadosFuncionario.add(funcionario5);
	}
	
	// ------------------ METODOS ------------------ //
	
	// Funcao para cadastrar os dados de Funcionario:
	public void cadastrar(Funcionario funcionario) {
		dadosFuncionario.add(funcionario);
	}
	
	// Funcao para cadastrar um funcionario vazio:
	public void cadastrarvazio() {
		Funcionario func = new Funcionario("", "", "", "", "", "", "", "", 0);
		dadosFuncionario.add(func);
	}
	
	// Funcao para retornar que não foram encontrados resultados:
	public void produtoNaoEncontrado() {
		Funcionario func = new Funcionario("Não foram encontrados resultados...", "", "", "", "", "", "", "", 0);
		dadosFuncionario.add(func);
	}
	
	// Funcao para buscar um Funcionario Especifico por CPF e retorná-lo:
	public Funcionario buscar(String cpf) {
		for(int i = 0; i < dadosFuncionario.size(); i ++) 
			if(cpf.equals(dadosFuncionario.get(i).getCpf().replaceAll("[\\D]", ""))) {
				return dadosFuncionario.get(i);
			}
		return null;
	}
	
	// Funcao para buscar um funcionario Especifico por CPF e retornar sua posição:
	public int retornaPos(String cpf) {
		for(int i = 0; i < dadosFuncionario.size(); i ++) 
			if(cpf.equals(dadosFuncionario.get(i).getCpf().replaceAll("[\\D]", ""))) {
				return i;
			}
		return -1;
	}
	
	// Funcao para editar os dados de funcionario:
	public void editar(Funcionario funcionario, int pos) {
		deletar(pos);
		cadastrar(funcionario);
		
//			dadosFuncionario.get(pos).email = funcionario.email;
//			dadosFuncionario.get(pos).funcao = funcionario.funcao;
//			dadosFuncionario.get(pos).numCelular = funcionario.numCelular;
//			dadosFuncionario.get(pos).salario = funcionario.salario;
//			dadosFuncionario.get(pos).endereco = funcionario.endereco;
	}
	
	// Funcao para deletar um funcionario:
	public void deletar(int pos) {
		
		dadosFuncionario.remove(dadosFuncionario.get(pos));
		
	}
	
	// Chamada de todos os dados de um funcionario:
	public String toString() {	
		return "Nome do Funcionário: " + primeiroNome + " " + ultimoNome + "\n" 
			   + "Data de Nascimento: " + dataNascimento + "\n" + "CPF: " + cpf + "\n" 
			   + "Número de Celular: " + numCelular + "\n" + "E-mail:" + email + "\n" 
			   + "função: " + funcao + "\n" + "Salário: "
			   + salario + "\n" + "Endereço" + endereco + "\n";
	}
	
	// Funcao para visualizar o primeiro nome dos funcionarios e retornar um vetor de string com eles na mesma ordem do arraylist:
	public String[] visualizarNome() {
		String[] var = new String [1000];
		for(int i = 0; i < dadosFuncionario.size(); i ++) {
			var[i] = dadosFuncionario.get(i).getPrimeiroNome();
		}
		return var;
	}
	
	// Funcoes a seguir são para retornar os dados de funcionarios específicos dentro do arraylist com base nas suas posições (Gets):
	public String retornaPrimNome(int pos) {
		return dadosFuncionario.get(pos).getPrimeiroNome();
	}
	
	public String retornaData(int pos) {
		return dadosFuncionario.get(pos).getDataNascimento();
	}
	
	public String retornaUltNome(int pos) {
		return dadosFuncionario.get(pos).getUltimoNome();
	}
	
	public String retornaCPF(int pos) {
		return dadosFuncionario.get(pos).getCpf();
	}
	
	public String retornaNumCel(int pos) {
		return dadosFuncionario.get(pos).getNumCelular();
	}
	
	public String retornaEmail(int pos) {
		return dadosFuncionario.get(pos).getEmail();
	}
	
	public String retornaFuncao(int pos) {
		return dadosFuncionario.get(pos).getFuncao();
	}
	
	public String retornaEndereco(int pos) {
		return dadosFuncionario.get(pos).getEndereco();
	}
	
	public double retornaSalario(int pos) {
		return dadosFuncionario.get(pos).getSalario();
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
	
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
