package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import principal.Filme;

public class TelaFilmeCartaz implements ActionListener{	
	
	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel titulo;
	private JButton seta;
	private JButton sinopse1;
	private JButton sinopse2;
	private JButton sinopse3;
	private JButton sinopse4;
	ImageIcon image1 = new ImageIcon(getClass().getResource("shang.png"));
	ImageIcon image2 = new ImageIcon(getClass().getResource("viuva.jpg"));
	ImageIcon image3 = new ImageIcon(getClass().getResource("pulp.jpg"));
	ImageIcon image4 = new ImageIcon(getClass().getResource("gente.jpg"));
	private JLabel imagem1 = new JLabel(image1);
	private JLabel imagem2 = new JLabel(image2);
	private JLabel imagem3 = new JLabel(image3);
	private JLabel imagem4 = new JLabel(image4);
	Filme filme = new Filme();
	
	public void criarTelaFilmeCartaz (Filme f){
		filme = f;
		
		/// Cria um container e seus componentes
		janela = new JFrame("Filmes");
		titulo = new JLabel("Filmes em Cartaz");
		seta = new JButton("<");
		sinopse1 = new JButton("Shang-Chi");
		sinopse2 = new JButton("Viúva Negra");
		sinopse3 = new JButton("Pulp Fiction");
		sinopse4 = new JButton("Gente Grande");
		
		/// Realiza a seleção de fontes para cada um dos componentes
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		sinopse1.setFont(new Font("Arial", Font.BOLD, 15));
		sinopse2.setFont(new Font("Arial", Font.BOLD, 15));
		sinopse3.setFont(new Font("Arial", Font.BOLD, 15));
		sinopse4.setFont(new Font("Arial", Font.BOLD, 14));
		//titulo.setForeground(Color.white);
		seta.setFont(new Font("Arial", Font.BOLD, 15));
		
	
		/// Realiza o posicionamento dos componentes
		titulo.setBounds(110, 15, 350, 30);
		sinopse1.setBounds(45, 65, 120, 35);
		sinopse2.setBounds(145, 270, 120, 35);
		sinopse3.setBounds(245, 65, 120, 35);
		sinopse4.setBounds(330, 270, 140, 35);
		seta.setBounds(10, 160, 45, 40);
		imagem1.setBounds(65, 110, 80, 150);
		imagem2.setBounds(165, 110, 80, 150);
		imagem3.setBounds(265, 110, 80, 150);
		imagem4.setBounds(365, 110, 80, 150);
		
		janela.setLayout(null);
		
		
		/// Coloca os componentes no container
		janela.add(titulo);
		janela.add(sinopse1);
		janela.add(sinopse2);
		janela.add(sinopse3);
		janela.add(sinopse4);
		janela.add(seta);
		janela.add(imagem1);
		janela.add(imagem2);
		janela.add(imagem3);
		janela.add(imagem4);
	
		/// Dados do container
		janela.setSize(500, 390);
		sinopse1.setVisible(false);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		//janela.getContentPane().setBackground(Color.black);
	
		/// Detecção de eventos
		seta.addActionListener(this);
		sinopse1.addActionListener(this);
		sinopse2.addActionListener(this);
		sinopse3.addActionListener(this);
		sinopse4.addActionListener(this);
		
	}

	/// Detecção de eventos relacionados aos botões
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == seta) janela.dispose();
		
		if (src == sinopse1) mensagemSinopse1();
		
		if (src == sinopse2) mensagemSinopse2();
		
		if (src == sinopse3) mensagemSinopse3();
		
		if (src == sinopse4) mensagemSinopse4();

	}
	
	public void mensagemSinopse1() {
		if (filme.retornaPos("SHANG-CHI") == -1) JOptionPane.showMessageDialog(null, "ERRO!\nEsse filme foi deletado", null, 
				JOptionPane.ERROR_MESSAGE);
		else JOptionPane.showMessageDialog(null, "Sinopse: " + filme.retornaSinopse(filme.retornaPos("SHANG-CHI")), null, 
				JOptionPane.DEFAULT_OPTION);
	}
	
	public void mensagemSinopse2() {
		if (filme.retornaPos("VIÚVA NEGRA") == -1) JOptionPane.showMessageDialog(null, "ERRO!\nEsse filme foi deletado", null, 
				JOptionPane.ERROR_MESSAGE);
		else JOptionPane.showMessageDialog(null, "Sinopse: " + filme.retornaSinopse(filme.retornaPos("VIÚVA NEGRA")), null, 
				JOptionPane.DEFAULT_OPTION);
	}	
	
	public void mensagemSinopse3() {
		if (filme.retornaPos("PULP FICTION") == -1) JOptionPane.showMessageDialog(null, "ERRO!\nEsse filme foi deletado", null, 
				JOptionPane.ERROR_MESSAGE);
		else JOptionPane.showMessageDialog(null, "Sinopse: " + filme.retornaSinopse(filme.retornaPos("PULP FICTION")), null, 
				JOptionPane.DEFAULT_OPTION);
	}	
	
	public void mensagemSinopse4() {
		if (filme.retornaPos("GENTE GRANDE") == -1) JOptionPane.showMessageDialog(null, "ERRO!\nEsse filme foi deletado", null, 
				JOptionPane.ERROR_MESSAGE);
		else JOptionPane.showMessageDialog(null, "Sinopse: " + filme.retornaSinopse(filme.retornaPos("GENTE GRANDE")), null, 
				JOptionPane.DEFAULT_OPTION);
	}	

}