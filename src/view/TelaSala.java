package view;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaSala implements ActionListener, ListSelectionListener {	
	
	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroSala;
	private JButton refreshSala;
	private JButton voltar;
	private JButton pesquisa;
	private JButton interrogacao;
	private JTextField campoBusca;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	
	/// Declaração de JList para armazenamento de dados
	private JList<String> listaSalasCadastradas;
	
	/// Declaração de dados a serem manipulados
	private String nome;
	private int p;
	SalaCinema sala = new SalaCinema();
	
	public void criaTelaSala(SalaCinema s){
		sala = s;
		
		/// Cria um container e seus componentes
		janela = new JFrame("Salas");
		campoBusca = new JTextField(200);
		listaSalasCadastradas = new JList<String>(sala.visualizarNum());
		titulo = new JLabel("Salas Cadastradas");
		cadastroSala = new JButton("Cadastrar");
		refreshSala = new JButton("Atualizar Lista");
		voltar = new JButton("Voltar");
		pesquisa = new JButton("Buscar");
		interrogacao = new JButton("?");
	
		/// Realiza a seleção de fontes para cada um dos componentes
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		cadastroSala.setFont(new Font("Arial", Font.BOLD, 17));
		refreshSala.setFont(new Font("Arial", Font.BOLD, 17));
		voltar.setFont(new Font("Arial", Font.BOLD, 17));
		pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		interrogacao.setFont(new Font("Arial", Font.BOLD, 20));
		listaSalasCadastradas.setFont(new Font("Arial", Font.BOLD, 15));
		
		/// Realiza o posicionamento dos componentes
        titulo.setBounds(90, 15, 350, 30);
        cadastroSala.setBounds(166, 280, 150, 50);
		refreshSala.setBounds(326, 280, 150, 50);
		voltar.setBounds(7, 280, 150, 50);
		pesquisa.setBounds(260, 70, 100, 25);
		campoBusca.setBounds(60, 70, 185, 25);
		interrogacao.setBounds(370, 70, 50, 25);
		panel.setBounds(40, 110, 400, 140);
		ScrollPane.setViewportView(listaSalasCadastradas);
		listaSalasCadastradas.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane);
	
		janela.setLayout(null);
	
		/// Coloca os componentes no container
		janela.add(titulo);
		janela.add(cadastroSala);
		janela.add(refreshSala);
		janela.add(voltar);
		janela.add(pesquisa);
		janela.add(panel);
		janela.add(campoBusca);
		janela.add(interrogacao);
	
		/// Dados do container
		janela.setSize(500, 390);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	
		/// Detecção de eventos
		cadastroSala.addActionListener(this);
		refreshSala.addActionListener(this);
		voltar.addActionListener(this);
		pesquisa.addActionListener(this);
		interrogacao.addActionListener(this);
		listaSalasCadastradas.addListSelectionListener(this);
		
	
	}

	/// Detecção de eventos relacionados aos botões
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		/// Cadastro de sala
		if(src == cadastroSala)
			new TelaDetalheSala().criarTelaDetalheSala(1, this, sala, 0);

		/// Atualiza a lista de salas
		if(src == refreshSala) {
			listaSalasCadastradas.setListData(sala.visualizarNum());			
			listaSalasCadastradas.updateUI();
		}
		
		/// Volta para a janela anterior e fecha a atual
		if (src == voltar) janela.dispose();
		
		/// Mecanismo de pesquisa
		if (src == pesquisa) {
			SalaCinema sl = new SalaCinema();
			nome = campoBusca.getText().replaceAll("[\\D]", "");
			p = sala.retornaPos(nome);
			if (p == -1) {
				sl.produtoNaoEncontrado();
				listaSalasCadastradas.setListData(sl.visualizarNum());
				listaSalasCadastradas.updateUI();
				
			} else {
				for (int i = 0; i < p; i ++) sl.cadastrarvazio();
				sl.cadastrar(sala.buscar(nome));
				listaSalasCadastradas.setListData(sl.visualizarNum());
				listaSalasCadastradas.updateUI();
			}
		}
		
		if (src == interrogacao) mensagemDuvida();

	}
	

	/// Detecção de eventos relacionados à lista de salas
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		try {
			if(e.getValueIsAdjusting() && src == listaSalasCadastradas) {
				new TelaDetalheSala().criarTelaDetalheSala(2, this, sala,
						listaSalasCadastradas.getSelectedIndex());
			}
		} catch (IndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(null,"ERRO!\n" + "Usuário não econtrado!\n\n", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void mensagemDuvida() {
		JOptionPane.showMessageDialog(null, "Digite o número da sala desejado na barra de busca.", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}