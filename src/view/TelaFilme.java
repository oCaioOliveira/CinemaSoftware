package view;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

/**
 * Cria��o da classe TelaFilme, onde � criado o menu do filme e suas funcionalidades
 * @author Caio C�sar e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class TelaFilme implements ActionListener, ListSelectionListener {	
	
	/// Declara��o dos componentes da GUI
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilme;
	private JButton refreshFilme;
	private JButton voltar;
	private JButton pesquisa;
	private JButton interrogacao;
	private JButton seta;
	private JTextField campoBusca;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	
	/// Declara��o de JList para armazenamento de dados
	private JList<String> listaFilmesCadastrados;
	
	/// Declara��o de dados a serem manipulados
	private String[] listaFilmes = new String[1000];
	private String nome;
	private int p;
	Filme filme = new Filme();
	
	/**
	 * Definir as caracter�sticas da interface do Menu de filmes como bot�es, t�tulos, janelas e adicion� los � janela
	 * @param f Filme que importa os dados do filme criados no menu principal (TelaMenu)
	 */
	
	public void criaTelaFilme(Filme f){
		filme = f;
		
		listaFilmes = filme.visualizarNome();
		listaFilmesCadastrados = new JList<String>(listaFilmes);
		
		/// Cria um container e seus componentes
		janela = new JFrame("Filmes");
		titulo = new JLabel("Filmes Cadastrados");
		cadastroFilme = new JButton("Cadastrar");
		refreshFilme = new JButton("Atualizar Lista");
		voltar = new JButton("Voltar");
		pesquisa = new JButton("Buscar");
		interrogacao = new JButton("?");
		seta = new JButton(">");
		campoBusca = new JTextField(200);
		
		/// Realiza a sele��o de fontes para cada um dos componentes
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		//titulo.setForeground(Color.white);
		cadastroFilme.setFont(new Font("Arial", Font.BOLD, 17));
		refreshFilme.setFont(new Font("Arial", Font.BOLD, 17));
		voltar.setFont(new Font("Arial", Font.BOLD, 17));
		pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		interrogacao.setFont(new Font("Arial", Font.BOLD, 20));
		seta.setFont(new Font("Arial", Font.BOLD, 15));
		listaFilmesCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
		
	
		/// Realiza o posicionamento dos componentes
		titulo.setBounds(90, 15, 350, 30);
		cadastroFilme.setBounds(166, 280, 150, 50);
		refreshFilme.setBounds(326, 280, 150, 50);
		voltar.setBounds(7, 280, 150, 50);
		panel.setBounds(20, 110, 400, 140);
		pesquisa.setBounds(260, 70, 100, 25);
		campoBusca.setBounds(60, 70, 185, 25);
		interrogacao.setBounds(370, 70, 50, 25);
		seta.setBounds(429, 160, 45, 40);
		ScrollPane.setViewportView(listaFilmesCadastrados);
		listaFilmesCadastrados.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane);
	
		janela.setLayout(null);
		
		
		/// Coloca os componentes no container
		janela.add(titulo);
		janela.add(cadastroFilme);
		janela.add(refreshFilme);
		janela.add(panel);
		janela.add(voltar);
		janela.add(pesquisa);
		janela.add(campoBusca);
		janela.add(interrogacao);
		janela.add(seta);
	
		/// Dados do container
		janela.setSize(500, 390);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		//janela.getContentPane().setBackground(Color.black);
	
		/// Detec��o de eventos
		cadastroFilme.addActionListener(this);
		refreshFilme.addActionListener(this);
		voltar.addActionListener(this);
		pesquisa.addActionListener(this);
		interrogacao.addActionListener(this);
		seta.addActionListener(this);
		listaFilmesCadastrados.addListSelectionListener(this);
		
	}

	/**
	 * Detecta as a��es e redireciona para as op��es e funcionalidades poss�veis
	 * @param e ActionEvent que detecta alguma a��o com algum bot�o
	 */

	/// Detec��o de eventos relacionados aos bot�es
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		/// Cadastro de filme
		if(src == cadastroFilme)
			new TelaDetalheFilme().criarTelaDetalheFilme(1, this, filme, 0);

		/// Atualiza a lista de filmes
		if(src == refreshFilme) {
			listaFilmesCadastrados.setListData(filme.visualizarNome());			
			listaFilmesCadastrados.updateUI();
		}
		
		/// Volta para a janela anterior e fecha a atual
		if (src == voltar ) janela.dispose();
		
		if (src == pesquisa) {
			Filme f = new Filme();
			nome = campoBusca.getText().toUpperCase();
			p = filme.retornaPos(nome);
			if (p == -1) {
				f.produtoNaoEncontrado();
				listaFilmesCadastrados.setListData(f.visualizarNome());
				listaFilmesCadastrados.updateUI();
				
			} else {
				for (int i = 0; i < p; i ++) f.cadastrarvazio();
				f.cadastrar(filme.buscar(nome));
				listaFilmesCadastrados.setListData(f.visualizarNome());
				listaFilmesCadastrados.updateUI();
			}
		}
		
		if (src == interrogacao) mensagemDuvida();
		
		if (src == seta) new TelaFilmeCartaz().criarTelaFilmeCartaz(filme);

	}
	
	/**
	 * Detecta as a��es e redireciona para as op��es e funcionalidades poss�veis
	 * @param e ListSelectionEvent que detecta alguma a��o com alguma op��o da lista
	 */
	
	/// Detec��o de eventos relacionados � lista de filmes
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		try {
			/// Seleciona algum filme da lista para editar
			if(e.getValueIsAdjusting() && src == listaFilmesCadastrados) {
				new TelaDetalheFilme().criarTelaDetalheFilme(2, this, filme,
						listaFilmesCadastrados.getSelectedIndex());
			}
		} catch (IndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n" + "Usu�rio n�o econtrado!\n\n", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Mostra uma mensagem para responder a d�vida sobre como pesquisar no campo de busca
	 */
	
	public void mensagemDuvida() {
		JOptionPane.showMessageDialog(null, "Digite o nome do filme desejado na barra de busca.", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}

}