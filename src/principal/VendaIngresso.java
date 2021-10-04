package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class VendaIngresso{

	// ----------------- ATRIBUTOS ----------------- //

	private String formaPagamento;
	private double precoTotal;
	private int recibo;
	private int qntddIngressos;
	private Ingresso ingresso;
	
	public VendaIngresso(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- //
	
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
	public void cadastrar(VendaIngresso venda) {
		dadosVendaIngresso.add(venda);
	}
	
	public String toString() {
		return "Preço total: R$" + precoTotal;
	}

	// ------------ GETTERS AND SETTERS ------------ //

	
	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getRecibo() {
		return recibo;
	}

	public void setRecibo(int recibo) {
		this.recibo = recibo;
	}

	public int getQntddIngressos() {
		return qntddIngressos;
	}

	public void setQntddIngressos(int qntddingressos) {
		this.qntddIngressos = qntddingressos;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	
}
