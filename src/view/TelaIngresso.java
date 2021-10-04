package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import principal.*;

public class TelaIngresso implements ActionListener {	
	
	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel titulo;
	private JButton proximo;
	private JButton voltar;
	private JLabel labelQntddIngressos = new JLabel("Quantidade de Ingressos: ");
	private JTextField valorQntddIngressos;
	
	/// Declaração dos dados a serem manipulados
	private int qntddIngressos;
	VendaIngresso venda = new VendaIngresso();
	private int i = 0;
	
	public void criaTelaIngresso(VendaIngresso v){
		venda = v;
	
		/// Cria um container e seus componentes
		janela = new JFrame("Venda de Ingresso");
		titulo = new JLabel("Cadastro de Venda");
		proximo = new JButton("Próximo");
		voltar = new JButton("Voltar");
		valorQntddIngressos = new JTextField(200);
		
		/// Realiza a seleção de fontes para cada um dos componentes
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		proximo.setFont(new Font("Arial", Font.BOLD, 18));
		voltar.setFont(new Font("Arial", Font.BOLD, 18));
		labelQntddIngressos.setFont(new Font("Arial", Font.BOLD, 18));
		
		/// Realiza o posicionamento dos componentes
		titulo.setBounds(90, 15, 350, 30);
		labelQntddIngressos.setBounds(20, 80, 300, 100);
		valorQntddIngressos.setBounds(255, 118, 180, 25);
		proximo.setBounds(250, 210, 150, 50);
		voltar.setBounds(50, 210, 150, 50);
	
		janela.setLayout(null);
	
		/// Coloca os componentes no container
		janela.add(titulo);
		janela.add(proximo);
		janela.add(voltar);
		this.janela.add(labelQntddIngressos);
		this.janela.add(valorQntddIngressos);

		/// Dados do container
		janela.setSize(500, 325);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		
		/// Detecção de eventos
		proximo.addActionListener(this);
		voltar.addActionListener(this);
		
		
	}

	/// Detecção de eventos relacionados aos botões
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
			/// Leva o usuário para a próxima página
			if(src == proximo) {
				if ("".equals(valorQntddIngressos.getText().replaceAll("[\\D]", ""))) mensagemErro();
				
				else {
					qntddIngressos = Integer.parseInt(valorQntddIngressos.getText());
					while (i < qntddIngressos) {
						new TelaDetalheIngresso().criarTelaDetalheIngresso(this, venda);
						i ++;
					}
					janela.dispose();
				}
			}
			
			/// Volta para a janela anterior e fecha a atual
			if (src == voltar ) janela.dispose();
	
	}
	
	public void mensagemErro() {
		JOptionPane.showMessageDialog(null, "ERRO!\n" + "Digite um número antes de prosseguir.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}