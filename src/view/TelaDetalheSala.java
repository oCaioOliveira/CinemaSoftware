package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import principal.*;

public class TelaDetalheSala implements ActionListener {

	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel labelNumSala = new JLabel("Número da Sala: ");
	private JTextField valorNumSala;
	private JLabel labelTipoSala = new JLabel("Tipo de Sala: ");
	private JTextField valorTipoSala;
	private JLabel labelQntddCadeiras = new JLabel("Número de Cadeiras: ");
	private JTextField valorQntddCadeiras;
	private JLabel labelFormSala = new JLabel("Formato da Sala: ");
	private JTextField valorFormSala;
	private JLabel labelQntddColunas = new JLabel("Colunas de cadeiras: ");
	private JTextField valorQntdColunas;
	private JLabel labelQntddLinhas = new JLabel("Linhas de cadeiras: ");
	private JTextField valorQntddLinhas;
	private JLabel labelCadeiraVaga = new JLabel("Cadeira Vaga: ");
	private JTextField valorCadeiraVaga;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoCancelar = new JButton("Cancelar");
	private JButton botaoSalvar = new JButton("Salvar");
	
	/// Declaração de dados a serem manipulados
	private String[] novoDado = new String[8];
	private int posicao;
	private int opcao;
	private String s;
	SalaCinema sala = new SalaCinema();
	
	public void criarTelaDetalheSala(int op, 
		TelaSala p, SalaCinema sla, int pos) {
		
		this.opcao = op;
		this.posicao = pos;
		sala = sla;

		if (op == 1) s = "Cadastro de Sala";
		if (op == 2) s = "Detalhes de Sala";

		/// Cria um container
		janela = new JFrame(s);

		
		/// Caso de cadastramento
		if (op == 1) {
			/// Cria os componentes do container
			valorNumSala = new JTextField(200);
			valorTipoSala = new JTextField(200);
			valorQntddCadeiras = new JTextField(200);
			valorFormSala = new JTextField(200);
			valorQntdColunas = new JTextField(200);
			valorQntddLinhas = new JTextField(200);
			valorCadeiraVaga = new JTextField(200);	
			
		} 
		/// Caso de alteração/remoção
		else if (op == 2) { 
			/// Recebe o valor de cada variável
			valorNumSala = new JTextField(sala.retornaNumSala(posicao), 200);
			valorTipoSala = new JTextField(sala.retornaTipoSala(posicao),200);
			valorQntddCadeiras = new JTextField(String.valueOf(sala.retornaQntddCadeiras(posicao)), 200);
			valorFormSala = new JTextField(sala.retornaFormato(posicao), 200);
			valorQntdColunas = new JTextField(String.valueOf(sala.retornaQntddColunasCadeiras(posicao)), 200);
			valorQntddLinhas = new JTextField(String.valueOf(sala.retornaQntddLinhasCadeiras(posicao)), 200);
			valorCadeiraVaga = new JTextField(String.valueOf(sala.retornaCadeiraVaga(posicao)), 200);	

		}
		
		/// Realiza o posicionamento dos componentes
		labelNumSala.setBounds(10, 10, 150, 25);
		valorNumSala.setBounds(145, 10, 185, 25);
		labelQntddCadeiras.setBounds(10, 40, 150, 25);
		valorQntddCadeiras.setBounds(145, 40, 185, 25);
		labelTipoSala.setBounds(10, 70, 180, 25);
		valorTipoSala.setBounds(145, 70, 185, 25);		
		labelFormSala.setBounds(10, 100, 150, 25);
		valorFormSala.setBounds(145, 100, 185, 25);
		labelQntddColunas.setBounds(10, 130, 150, 25);
		valorQntdColunas.setBounds(145, 130, 185, 25);
		labelQntddLinhas.setBounds(10, 160, 150, 25);
		valorQntddLinhas.setBounds(145, 160, 185, 25);
		labelCadeiraVaga.setBounds(10, 190, 150, 25);
		valorCadeiraVaga.setBounds(145, 190, 185, 25);

		/// Caso de alteração/remoção
		if (op == 2) {
			
			/// Realiza o posicionamento dos componentes exclusivos.
			botaoSalvar.setBounds(180, 198, 150, 50);
			botaoExcluir.setBounds(10, 198, 150, 50);
			
			/// Realiza a seleção de fontes para os botões "salvar" e "excluir"
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoExcluir.setFont(new Font("Arial", Font.BOLD, 18));
			
			/// Coloca os componentes exclusivos no container
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
		}
		
		/// Caso de cadastramento
		if (op == 1) {
			
			/// Realiza o posicionamento dos componentes exclusivos.
			botaoSalvar.setBounds(180, 198, 150, 50);
			botaoCancelar.setBounds(10, 198, 150, 50);
			
			/// Realiza a seleção de fontes para os botões "salvar" e "cancelar"
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));
			
			/// Coloca o componente exclusivo no container
			this.janela.add(botaoSalvar);
		}

		/// Coloca os componentes no container
		this.janela.add(labelNumSala);
		this.janela.add(valorNumSala);
		this.janela.add(labelFormSala);
		this.janela.add(valorFormSala);
		this.janela.add(labelQntddColunas);
		this.janela.add(valorQntdColunas);
		this.janela.add(labelTipoSala);
		this.janela.add(valorTipoSala);
		this.janela.add(labelQntddCadeiras);
		this.janela.add(valorQntddCadeiras);
		this.janela.add(labelQntddLinhas);
		this.janela.add(valorQntddLinhas);
		this.janela.add(botaoSalvar);
		this.janela.add(botaoCancelar);

		this.janela.setLayout(null);

		/// Dados do container
		this.janela.setSize(365, 300);
		this.janela.setVisible(true);
		this.janela.setLocationRelativeTo(null);
		this.janela.setResizable(false);

		/// Detecção de eventos
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoCancelar.addActionListener(this);
	}


	/// Detecção de eventos relacionados aos dados do filme
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {				
				novoDado[0] = valorNumSala.getText();
				novoDado[1] = valorFormSala.getText();
				novoDado[2] = valorQntdColunas.getText();
				novoDado[3] = valorTipoSala.getText();
				novoDado[4] = valorQntddCadeiras.getText();
				novoDado[5] = valorQntddLinhas.getText();
				novoDado[6] = valorCadeiraVaga.getText();

				/// Caso de erro em cadastro de filme
				if ((opcao == 1 || opcao == 2) && ("".equals(novoDado[0]) || "".equals(novoDado[1]) || "".equals(novoDado[2].replaceAll("[\\D]", "")) || 
						"".equals(novoDado[3]) || "".equals(novoDado[4].replaceAll("[\\D]", "")) ||
						"".equals(novoDado[5].replaceAll("[\\D]", "")))) {
					mensagemErroCadastro();
				}
				
				/// Caso de cadastramento
				else if (opcao == 1) {
					SalaCinema novasala = new SalaCinema(novoDado[0], novoDado[3], 
							Integer.parseInt(novoDado[4]), novoDado[1], Integer.parseInt(novoDado[5]), 
							Integer.parseInt(novoDado[2]), false);
					
					sala.cadastrar(novasala);
					mensagemSucessoCadastro();
				} 
				
				/// Caso de alteração/remoção
				else if (opcao == 2) {
					SalaCinema attsala = new SalaCinema(novoDado[0], novoDado[3], 
							Integer.parseInt(novoDado[4]), novoDado[1], Integer.parseInt(novoDado[5]), 
							Integer.parseInt(novoDado[2]), false);
					
					sala.editar(attsala, posicao);
					mensagemSucessoCadastro();
				}
				
		}
		
		/// Exclui a sala
		if(src == botaoExcluir) {
			if (opcao == 2) {
				sala.deletar(posicao);
				mensagemSucessoExclusao();
			}
		}
		
		/// Cancela o cadastramento e fecha a janela
		if(src == botaoCancelar) janela.dispose();
		
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1- Nem todos os campos foram preenchidos; \n"
				+ "2- Quantidade de linhas, colunas e cadeiras"
				+ " não contém apenas números;", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}

}