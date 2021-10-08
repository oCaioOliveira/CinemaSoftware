package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

/**
 * Criação da classe TelaDetalheClienteVIP, onde é criado a escolha do cliente VIP
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class TelaDetalheClienteVIP implements ActionListener, ListSelectionListener {		
	
	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel titulo;
	private JButton voltar;
	private JButton interrogacao;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	
	/// Declaração de JLists para armazenamento de dados
	private JList<String> listaClientesCadastrados;
	
	/// Declaração de dados a serem manipulados
	private String[] listaNomes = new String[1000];
	ClienteVIP cliente = new ClienteVIP();
	VendaIngresso venda = new VendaIngresso();
	VendaIngresso novaVenda = new VendaIngresso();
	private double preco;

	/** 
	 * Definir as características da interface do Menu de clientes VIPs como botões, títulos, janelas e adicioná los à janela
	 * @param c ClienteVIP que importa os dados do cliente criados no menu principal (TelaMenu)
	 * @param vi VendaIngresso que importa os dados de venda de ingresso criados no menu principal (TelaMenu) e menu de ingresso (TelaDetalheIngresso)
	 * @param nv VendaIngresso que importa os dados de venda de ingresso criados no menu de ingresso (TelaDetalheIngresso)
	 * @param p preço do ingresso importado de venda de ingresso criados no menu de ingresso (TelaDetalheIngresso)
	 */
	
	public void criaTelaDetalheClienteVIP(ClienteVIP c, VendaIngresso vi, VendaIngresso nv, double p) {
		cliente = c;
		venda = vi;
		novaVenda = nv;
		preco = p;
			
			listaNomes = cliente.visualizarNome();
			listaClientesCadastrados = new JList<String>(listaNomes);
			
			/// Cria um container e seus componentes
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			voltar = new JButton("Cancelar");
			interrogacao = new JButton("?");
			
			/// Realiza a seleção de fontes para cada um dos componentes
			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			listaClientesCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
			voltar.setFont(new Font("Arial", Font.BOLD, 17));
			interrogacao.setFont(new Font("Arial", Font.BOLD, 20));

			/// Realiza o posicionamento dos componentes
			titulo.setBounds(90, 15, 350, 30);
			panel.setBounds(40, 60, 400, 140);
			voltar.setBounds(125, 210, 150, 50);
			interrogacao.setBounds(285, 210, 50, 50);
			ScrollPane.setViewportView(listaClientesCadastrados);
			listaClientesCadastrados.setLayoutOrientation(JList.VERTICAL);
	        panel.add(ScrollPane);

			janela.setLayout(null);

			
			/// Coloca os componentes no container
			janela.add(titulo);
			janela.add(panel);
			janela.add(voltar);
			janela.add(interrogacao);

			/// Dados do container
			janela.setSize(500, 310);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.setResizable(false);

			/// Detecção de eventos
			voltar.addActionListener(this);
			interrogacao.addActionListener(this);
			listaClientesCadastrados.addListSelectionListener(this);
		
	}
	
	/**
	 * Detecta as ações e redireciona para as opções e funcionalidades possíveis
	 * @param e ActionEvent que detecta alguma ação com algum botão
	 */

	/// Detecção de eventos relacionados aos botões
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		/// Volta para a janela anterior e fecha a atual
		if (src == voltar ) janela.dispose();
			
		if (src == interrogacao) mensagemDuvida();
			
	}
	
	/**
	 * Detecta as ações e redireciona para as opções e funcionalidades possíveis
	 * @param e ListSelectionEvent que detecta alguma ação com alguma opção da lista
	 */

	/// Detecção de eventos relacionados à lista de clientes ou funcionários
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		try {
			/// Seleciona algum cliente da lista 
			if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
				cliente.aumentaUmFilmeVisto(listaClientesCadastrados.getSelectedIndex());
				venda.cadastrar(novaVenda);
				mensagemSucesso();
			}
		} catch (IndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n" + "Usuário não econtrado!\n\n", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Mostra uma mensagem para responder a dúvida sobre a funcionalidade da lista
	 */
	
	public void mensagemDuvida() {
		JOptionPane.showMessageDialog(null, "Selecione o Cliente VIP desejado escolhendo seu nome na lista.", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Mostra uma mensagem de sucesso ao selecionar clientes
	 */

	public void mensagemSucesso() {
		JOptionPane.showMessageDialog(null, "Cliente VIP selecionado com sucesso!\n"
				+ "O preço do pedido foi de "
				+ (preco - (preco*0.4)) + "0 R$.", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
}