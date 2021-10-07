package principal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Criação da classe VendaIngresso, seus dados pré cadastrados e seus respectivos métodos
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class VendaIngresso{

	// ----------------- ATRIBUTOS ----------------- //

	private String formaPagamento;
	private double precoTotal;
	private int recibo;
	private int qntddIngressos;
	private Ingresso ingresso;
	
	/**
	 * Criação da super
	 */
	
	public VendaIngresso(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- //
	
	/**
	 * Criação do construtor da classe VendaIngresso
	 * @param formaDePagamento uma string que contém a forma de pagamento do ingresso
	 * @param preco um double que contém o preço do ingresso
	 * @param rec um int que contém o número do recibo do ingresso
	 * @param i um Ingresso que contenha os dados do ingresso 
	 */
	
	public VendaIngresso(String formaDePagamento, double preco, int rec, Ingresso i) {
		formaPagamento = formaDePagamento;
		precoTotal = preco;
		recibo = rec;
		this.ingresso = i;
	} 

	// ---------------- METODOS ---------------- //
	
	// Funcionalidades:
	
	Scanner input = new Scanner(System.in);	
	Scanner ler = new Scanner(System.in);	
	Scanner lerd = new Scanner(System.in);
	Scanner lerc = new Scanner(System.in);
	ArrayList<VendaIngresso> dadosVendaIngresso = new ArrayList<VendaIngresso>();
	
	// Pré-cadastro de dados do cliente:
	
	/**
	 * Criação de dados pré cadastrados usando o construtor de VendaIngresso e adição destes no ArrayList do tipo VendaIngresso
	 */
	
	public void dadosPreCadastradosVendaIngresso() {
		Ingresso in1 = new Ingresso("Meia",2,"3D",11,'C', "Shang-Chi e a lenda dos dez anéis","Português",12,"02/09/2021");
		VendaIngresso venda1 = new VendaIngresso("Cartão", 12.0, 120549, in1);
		Ingresso in2 = new Ingresso("Inteira",10,"VIP",12,'C', "Viúva Negra","Português",12,"05/05/2020");
		VendaIngresso venda2 = new VendaIngresso("Dinheiro", 22.0, 195723, in2);
		Ingresso in3 = new Ingresso("Meia",13,"Normal",13,'E',"Pulp Fiction - Tempo de Violência","Português",23,"02/07/2019");
		VendaIngresso venda3 = new VendaIngresso("Dinheiro", 11.0, 918723, in3);
		Ingresso in4 = new Ingresso("Inteira",8,"Normal",14,'O',"TITANIC","Português",20,"07/07/2021");
		VendaIngresso venda4 = new VendaIngresso("Cartão", 36.0, 819572, in4);
		Ingresso in5 = new Ingresso("Meia",5,"Normal",15,'P',"Gente Grande","Português",16,"21/12/2010");
		VendaIngresso venda5 = new VendaIngresso("Dinheiro", 22.0, 716482, in5);
		
		dadosVendaIngresso.add(venda1);
		dadosVendaIngresso.add(venda2);
		dadosVendaIngresso.add(venda3);
		dadosVendaIngresso.add(venda4);
		dadosVendaIngresso.add(venda5);
	}
	
	// Funcao para cadastrar os dados de sala:
	
	/**
	 * Cadastro do parametro venda no ArrayList do tipo VendaIngresso, sendo inserido ao final deste Array
	 * @param venda uma VendaIngresso que contem todos os dados do construtor
	 */
	public void cadastrar(VendaIngresso venda) {
		dadosVendaIngresso.add(venda);
	}
	
	/**
	 * Chama a String precoTotal
	 * @return a string precoTotal 
	 */
	
	public String toString() {
		return "Preço total: R$" + precoTotal;
	}

	// ------------ GETTERS AND SETTERS ------------ //

	/**
	 * get
	 * @return a string da forma de pagamento da venda do ingresso específico
	 */
	
	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	/**
	 * set 
	 * @param formaPagamento uma string da forma de pagamento do ingresso
	 */

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	/**
	 * get 
	 * @return a string do preço total da venda do ingresso específico
	 */
	
	public double getPrecoTotal() {
		return precoTotal;
	}

	/**
	 * set
	 * @param precoTotal o número double do preço total da venda do ingresso específico
	 */
	
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	/**
	 * get 
	 * @return o int recibo que contém o número do recibo do ingresso específico
	 */
	
	public int getRecibo() {
		return recibo;
	}

	/**
	 * set
	 * @param recibo o número do recibo do ingresso específico
	 */
	
	public void setRecibo(int recibo) {
		this.recibo = recibo;
	}

	/**
	 * get
	 * @return o int qntddIngressos que contém a quantidade de ingressos que serão vendidos 
	 */
	
	public int getQntddIngressos() {
		return qntddIngressos;
	}

	/**
	 * set
	 * @param qntddingressos a quantidade de ingressos que serão vendidos
	 */
	
	public void setQntddIngressos(int qntddingressos) {
		this.qntddIngressos = qntddingressos;
	}

	/**
	 * get
	 * @return um Ingresso ingresso que contém o ingresso específico
	 */
	
	public Ingresso getIngresso() {
		return ingresso;
	}

	/**
	 * set
	 * @param ingresso o Ingresso específico
	 */
	
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	
}
