package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Criação da classe Funcionario, seus dados pré cadastrados e seus respectivos métodos
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class Funcionario extends Pessoa {

	// ----------------- ATRIBUTOS ----------------- //
	
	private String funcao;
	private String endereco;
	private double salario;
	
	/**
	 * Criação da super
	 */
	
	public Funcionario(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- // 
	
	/**
	 * Criação do contrutor da classe Funcionario com os atributos da classe abstrata Pessoa e seus próprios atributos
	 * @param primNome uma string que contem o primeiro nome do funcionário
	 * @param ultNome uma string que contem o ultimo nome do funcionário
	 * @param data uma string que contem a data de nascimento do funcionário
	 * @param c uma string que contem o CPF do funcionário
	 * @param numCel uma string que contem o numero de celular do funcionário
	 * @param email uma string que contem o email do funcionário
	 * @param func uma string que contem a função do funcionário
	 * @param end uma string que contenha o endereço do funcionário
	 * @param sal um número do tipo double que contem o salário do funcionário
	 */
	
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
	
	/**
	 * Criação do contrutor da classe Funcionario com sobrecarga
	 * @param primNome uma string que contem o primeiro nome do funcionário
	 * @param ultNome uma string que contem o ultimo nome do funcionário
	 * @param data uma string que contem a data de nascimento do funcionário
	 * @param c uma string que contem o CPF do funcionário
	 * @param numCel uma string que contem o numero de celular do funcionário
	 * @param email uma string que contem o email do funcionário
	 */
	
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
	
	// Pré-cadastro de dados do funcionário:
	
	/**
	 * Criação de dados pré cadastrados usando o construtor do Funcionario e adição destes no ArrayList do tipo Funcionario
	 */
	
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
	
	/**
	 * Cadastro do parametro funcionario no ArrayList do tipo Funcionario, sendo inserido ao final deste Array
	 * @param funcionario um Funcionario que contem todos os dados do construtor
	 */
	
	// Funcao para cadastrar os dados de Funcionario:
	public void cadastrar(Funcionario funcionario) {
		dadosFuncionario.add(funcionario);
	}
	
	/**
	 * Cadastro de um funcionário vazio, usado normalmente para ocupar posições sem utilidade para adicionar funcionalidade na lista quando é pesquisado o CPF
	 */
	
	// Funcao para cadastrar um funcionario vazio:
	public void cadastrarvazio() {
		Funcionario func = new Funcionario("", "", "", "", "", "", "", "", 0);
		dadosFuncionario.add(func);
	}
	
	/**
	 * Cadastro de um funcionário apenas com o primeiro nome, para retornar a seguinte frase na lista da interface "Não foram encontrados resultados..."
	 */
	
	// Funcao para retornar que não foram encontrados resultados:
	public void pessoaNaoEncontrada() {
		Funcionario func = new Funcionario("Não foram encontrados resultados...", "", "", "", "", "", "", "", 0);
		dadosFuncionario.add(func);
	}
	
	/**
	 * Buscar dentro do ArrayList do tipo Funcionario o funcionário que tenha o CPF igual ao que foi recebido no parâmetro
	 * @param cpf uma string que contenha o CPF do funcionário
	 * @return um funcionário tirado de dentro do ArrayList do tipo Funcionario com o CPF igual ao parâmetro ou null, indica se o funcionário com o CPF igual foi encontrado ou não
	 */
	
	// Funcao para buscar um Funcionario Especifico por CPF e retorná-lo:
	public Funcionario buscar(String cpf) {
		for(int i = 0; i < dadosFuncionario.size(); i ++) 
			if(cpf.equals(dadosFuncionario.get(i).getCpf().replaceAll("[\\D]", ""))) {
				return dadosFuncionario.get(i);
			}
		return null;
	}
	
	/**
	 * Buscar dentro do ArrayList do tipo Funcionario o funcionário que tenha o CPF igual ao que foi recebido no parâmetro
	 * @param cpf uma string que contenha o CPF do funcionário
	 * @return a posição do funcionário tirado de dentro do ArrayList do tipo Funcionario com o CPF igual ao parâmetro ou -1, indica se o funcionário com o CPF igual foi encontrado ou não
	 */
	
	// Funcao para buscar um funcionario Especifico por CPF e retornar sua posição:
	public int retornaPos(String cpf) {
		for(int i = 0; i < dadosFuncionario.size(); i ++) 
			if(cpf.equals(dadosFuncionario.get(i).getCpf().replaceAll("[\\D]", ""))) {
				return i;
			}
		return -1;
	}
	
	/**
	 * Editar um funcionário dentro do ArrayList do tipo Funcionario usando o método de deletar o funcionário com dados antigos e adicionar um novo funcionário com os dados atualizados no Array
	 * @param funcionario um Funcionario que contenha todos os dados do construtor
	 * @param pos um inteiro que contenha a posição do funcionario no ArrayList do tipo Funcionario
	 */
	
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
	
	/**
	 * Deletar um funcionario dentro do ArrayList do tipo Funcionario usando a sua posição
	 * @param pos um inteiro que contenha a posição do funcionario no ArrayList do tipo Funcionario
	 */
	
	// Funcao para deletar um funcionario:
	public void deletar(int pos) {
		
		dadosFuncionario.remove(dadosFuncionario.get(pos));
		
	}
	
	/**
	 * Chama os atributos de funcionário de forma organizada 
	 * @return os atributos de funcionário de forma organizada
	 */
	
	
	// Chamada de todos os dados de um funcionario:
	public String toString() {	
		return "Nome do Funcionário: " + primeiroNome + " " + ultimoNome + "\n" 
			   + "Data de Nascimento: " + dataNascimento + "\n" + "CPF: " + cpf + "\n" 
			   + "Número de Celular: " + numCelular + "\n" + "E-mail:" + email + "\n" 
			   + "função: " + funcao + "\n" + "Salário: "
			   + salario + "\n" + "Endereço" + endereco + "\n";
	}
	
	/**
	 * Reune todos os primeiros nomes dos funcionários em um vetor de string de forma ordenada
	 * @return o vetor de string com todos os primeiros nomes dos funcionários de forma ordenada
	 */
	
	// Funcao para visualizar o primeiro nome dos funcionarios e retornar um vetor de string com eles na mesma ordem do arraylist:
	public String[] visualizarNome() {
		String[] var = new String [1000];
		for(int i = 0; i < dadosFuncionario.size(); i ++) {
			var[i] = dadosFuncionario.get(i).getPrimeiroNome();
		}
		return var;
	}
	
	/**
	 * Retornar o primeiro nome de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string do primeiro nome do funcionário específico
	 */
	
	// Funcoes a seguir são para retornar os dados de funcionarios específicos dentro do arraylist com base nas suas posições (Gets):
	public String retornaPrimNome(int pos) {
		return dadosFuncionario.get(pos).getPrimeiroNome();
	}
	
	/**
	 * Retornar a data de nascimento de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string da data de nascimento do funcionário específico
	 */
	
	public String retornaData(int pos) {
		return dadosFuncionario.get(pos).getDataNascimento();
	}
	
	/**
	 * Retornar o último nome de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string do último nome do funcionário específico
	 */
	
	public String retornaUltNome(int pos) {
		return dadosFuncionario.get(pos).getUltimoNome();
	}
	
	/**
	 * Retornar o CPF de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string do CPF do funcionário específico
	 */
	
	public String retornaCPF(int pos) {
		return dadosFuncionario.get(pos).getCpf();
	}
	
	/**
	 * Retornar o número de celular de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string do número de celular do funcionário específico
	 */
	
	public String retornaNumCel(int pos) {
		return dadosFuncionario.get(pos).getNumCelular();
	}
	
	/**
	 * Retornar o email de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string do email do funcionário específico
	 */
	
	public String retornaEmail(int pos) {
		return dadosFuncionario.get(pos).getEmail();
	}
	
	/**
	 * Retornar a função de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string da função do funcionário específico
	 */
	
	public String retornaFuncao(int pos) {
		return dadosFuncionario.get(pos).getFuncao();
	}
	
	/**
	 * Retornar o endereço de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return a string do endereço do funcionário específico
	 */
	
	public String retornaEndereco(int pos) {
		return dadosFuncionario.get(pos).getEndereco();
	}
	
	/**
	 * Retornar o salário de um funcionário específico dentro do ArrayList do tipo Funcionario com base na sua posição
	 * @param pos um inteiro que contenha a posição do funcionário no ArrayList do tipo Funcionario
	 * @return o número double do salário do funcionário específico
	 */
	
	public double retornaSalario(int pos) {
		return dadosFuncionario.get(pos).getSalario();
	}

	// ------------ GETTERS AND SETTERS ------------ //
	

	/**
	 * get
	 * @return a string do primeiro nome do funcionário específico
	 */
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	
	/**
	 * set
	 * @param primeiroNome uma string do primeiro nome do funcionário
	 */

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	/**
	 * get
	 * @return a string do último nome do funcionário
	 */

	public String getUltimoNome() {
		return ultimoNome;
	}
	
	/**
	 * set
	 * @param ultimoNome uma string do último nome do funcionário
	 */

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	/**
	 * get
	 * @return a string da data de nascimento do funcionário
	 */

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	/**
	 * set
	 * @param dataNascimento uma string da data de nascimento do funcionário
	 */

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	/**
	 * get
	 * @return a string do CPF do funcionário
	 */

	public String getCpf() {
		return cpf;
	}
	
	/**
	 * set
	 * @param cpf uma string do CPF do funcionário
	 */

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * get
	 * @return a string do número de celular do funcionário
	 */

	public String getNumCelular() {
		return numCelular;
	}
	
	/**
	 * set
	 * @param numCelular uma string do número de celular do funcionário
	 */

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}
	
	/**
	 * get
	 * @return a string do email do funcionário
	 */

	public String getEmail() {
		return email;
	}
	
	/**
	 * set
	 * @param email uma string do email do funcionário
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * get
	 * @return a string da função do funcionário
	 */
	
	public String getFuncao() {
		return funcao;
	}

	/**
	 * set
	 * @param funcao uma string da função do funcionário
	 */
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	/**
	 * get
	 * @return a string do endereço do funcionário
	 */
	
	public String getEndereco() {
		return endereco;
	}

	/**
	 * set
	 * @param endereco uma string do endereço do funcionário
	 */
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * get
	 * @return o double do salário do funcionario
	 */
	
	public double getSalario() {
		return salario;
	}

	/**
	 * set
	 * @param salario um double do salário do funcionário 
	 */
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}