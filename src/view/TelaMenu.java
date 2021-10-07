package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import principal.*;

/**
 * Criação da classe TelaMenu, onde é criado o menu principal da interface e tem a função main
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class TelaMenu implements ActionListener {
	
	/// Declaração dos componentes da GUI
	private static JFrame janela = new JFrame("Cinema");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton clienteVIP = new JButton("Cliente VIP");
	private static JButton filme = new JButton("Filme");
	private static JButton funcionario = new JButton("Funcionário");
	private static JButton sala = new JButton("Sala de Cinema");
	private static JButton ingresso = new JButton("Ingresso");
	private static JButton sair = new JButton("Sair");
	
	/// Declaração dos dados a serem manipulados
	ClienteVIP cliente = new ClienteVIP();
	Funcionario func = new Funcionario();
	SalaCinema sla = new SalaCinema();
	VendaIngresso vi = new VendaIngresso();
	Filme fil = new Filme();
	
	/**
	 * Chamar os dados pré cadastrados de ClienteVIP, Funcionario, SalaCinema, VendaIngresso e Filme, 
	 * definir as características da interface como botões, títulos, janelas e adicioná los a janela
	 */
	
	/// Construtor do menu
	public TelaMenu() {
		
		/// Realiza o pré-cadastro de dados
		cliente.dadosPreCadastradosClientes();
		func.dadosPreCadastradosFuncionario();
		sla.dadosPreCadastradosSala();
		vi.dadosPreCadastradosVendaIngresso();
		fil.dadosPreCadastradosFilmes();
		
		
		/// Realiza a seleção de fontes para cada um dos componentes
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		clienteVIP.setFont(new Font("Arial", Font.BOLD, 18));
		filme.setFont(new Font("Arial", Font.BOLD, 18));
		funcionario.setFont(new Font("Arial", Font.BOLD, 18));
		sala.setFont(new Font("Arial", Font.BOLD, 18));
		ingresso.setFont(new Font("Arial", Font.BOLD, 18));
		sair.setFont(new Font("Arial", Font.BOLD, 15));
		
		/// Realiza o posicionamento dos componentes
		titulo.setBounds(140, 0, 300, 75);
		clienteVIP.setBounds(60, 75, 150, 50);
		filme.setBounds(60, 135, 150, 50);
		funcionario.setBounds(260, 75, 150, 50);
		sala.setBounds(140, 200, 200, 50);
		ingresso.setBounds(260, 135, 150, 50);
		sair.setBounds(8, 250, 100, 30);
		
		janela.setLayout(null);
		
		/// Coloca os componentes no container
		janela.add(titulo);
		janela.add(clienteVIP);
		janela.add(filme);
		janela.add(funcionario);
		janela.add(sala);
		janela.add(ingresso);
		janela.add(sair);
		
		/// Dados do container
		janela.setSize(500, 325);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	}
	
	/**
	 * Criação da main, onde são detectadas as ações nos botões
	 * @param args parâmetro para a main
	 */
	
	/// Função main
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		/// Detecção de eventos
		clienteVIP.addActionListener(menu);
		filme.addActionListener(menu);
		funcionario.addActionListener(menu);
		sala.addActionListener(menu);
		ingresso.addActionListener(menu);
		sair.addActionListener(menu);
	}
	
	/**
	 * Detecta as ações e redireciona para as opções possíveis
	 * @param e ActionEvent que detecta alguma ação com algum botão
	 */
	
	/// Detecção de eventos
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == clienteVIP)
			new TelaPessoa().criaTelaPessoa(1, cliente, func);
		
		if(src == funcionario)
			new TelaPessoa().criaTelaPessoa(2, cliente, func);
		
		if(src == sala)
			new TelaSala().criaTelaSala(sla);
		
		if(src == filme)
			new TelaFilme().criaTelaFilme(fil);
		
		if(src == ingresso)
			new TelaIngresso().criaTelaIngresso(vi);
		
		if(src == sair)
			janela.dispose();
	}
}