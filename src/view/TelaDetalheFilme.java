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

/**
 * Criação da classe TelaDetalheFilme, onde é criado o menu de detalhes do filme e suas funcionalidades
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class TelaDetalheFilme implements ActionListener {
	
	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel labelNomeFilme = new JLabel("Nome do Filme: ");
	private JTextField valorNomeFilme;
	private JLabel labelDurFilme = new JLabel("Duração do Filme: ");
	private JTextField valorDurFilme;
	private JLabel labelClasIndic = new JLabel("Classificação Indicativa: ");
	private JTextField valorClasIndic;
	private JLabel labelIdioma = new JLabel("Idioma do Filme: ");
	private JTextField valorIdioma;
	private JLabel labelSinopse = new JLabel("Sinopse: ");
	private JTextField valorSinopse;
	private JLabel labelGenero = new JLabel("Gênero: ");
	private JTextField valorGenero;
	private JLabel labelDataLanc = new JLabel("Data de Lançamento: ");
	private JTextField valorDataLanc;
	private JLabel labelSalaTrans = new JLabel("Sala de Transmissão: ");
	private JTextField valorSalaTrans;
	private JLabel labelHora = new JLabel("Horário de Exibição: ");
	private JTextField valorHora;
	private JLabel labelDataExib = new JLabel("Data de Exibição: ");
	private JTextField valorDataExib;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoCancelar = new JButton("Cancelar");

	/// Declaração de dados a serem manipulados
	private String[] novoDado = new String[11];
	private int posicao;
	private int opcao;
	private String s;
	Filme filme = new Filme();
	
	/**
	 * Definir as características da interface do Menu de detalhes do filme como botões, títulos, janelas e adicioná los a janela
	 * @param op inteiro que representa a opção selecionada no menu de filme (TelaFilme)
	 * @param p TelaFilme que importa a classe Tela Filme
	 * @param f Filme que importa os dados do filme criados no menu principal (TelaMenu) e menu do filme (TelaFilme)
	 * @param pos inteiro que representa a posição do filme na lista do menu do filme (TelaFilme)
	 */
	
	public void criarTelaDetalheFilme(int op, 
		TelaFilme p, Filme f, int pos) {
		
		this.opcao = op;
		this.posicao = pos;
		filme = f;

		/* "op" é uma variável que define se o programa está trabalhando
		com o cadastro de filmes, se op = 1, ou com alteração/exclusão
		de filmes, se op = 2.                                           */ 
		
		if (op == 1) s = "Cadastro do Filme";
		if (op == 2) s = "Detalhes do Filme";

		/// Cria um container
		janela = new JFrame(s);

		if (op == 1) {
			/// Cria os componentes do container
			valorNomeFilme = new JTextField(200);
			valorDurFilme = new JTextField(200);
			valorClasIndic = new JTextField(200);
			valorIdioma = new JTextField(200);
			valorSinopse = new JTextField(200);
			valorGenero = new JTextField(200);
			valorDataLanc = new JTextField(200);	
			valorSalaTrans = new JTextField(200);
			valorHora = new JTextField(200);
			valorDataExib = new JTextField(200);
			
		} else if (op == 2) { 
			/// Cria os componentes do container
			valorNomeFilme = new JTextField(filme.retornaNomeFilme(posicao), 200);
			valorDurFilme = new JTextField(String.valueOf(filme.retornaDuracao(posicao)),200);
			valorClasIndic = new JTextField(String.valueOf(filme.retornaClasIndic(posicao)), 200);
			valorIdioma = new JTextField(filme.retornaIdioma(posicao), 200);
			valorSinopse = new JTextField(filme.retornaSinopse(posicao), 200);
			valorGenero = new JTextField(filme.retornaGenero(posicao), 200);
			valorDataLanc = new JTextField(filme.retornaDataLanc(posicao), 200);	
			valorSalaTrans = new JTextField(String.valueOf(filme.retornaSalaTrans(posicao)), 200);
			valorHora = new JTextField(String.valueOf(filme.retornaHorario(posicao)), 200);
			valorDataExib = new JTextField(filme.retornaDataExib(posicao), 200);

		} 
		
		/// Realiza o posicionamento dos componentes
		labelNomeFilme.setBounds(10, 10, 150, 25);
		valorNomeFilme.setBounds(145, 10, 180, 25);
		labelClasIndic.setBounds(5, 40, 150, 25);
		valorClasIndic.setBounds(145, 40, 180, 25);
		labelDurFilme.setBounds(10, 70, 180, 25);
		valorDurFilme.setBounds(145, 70, 180, 25);		
		labelIdioma.setBounds(10, 100, 150, 25);
		valorIdioma.setBounds(145, 100, 180, 25);
		labelSinopse.setBounds(10, 130, 150, 25);
		valorSinopse.setBounds(145, 130, 180, 25);
		labelGenero.setBounds(10, 160, 150, 25);
		valorGenero.setBounds(145, 160, 180, 25);
		labelDataLanc.setBounds(10, 190, 150, 25);
		valorDataLanc.setBounds(145, 190, 180, 25);
		labelSalaTrans.setBounds(10, 220, 150, 25);
		valorSalaTrans.setBounds(145, 220, 180, 25);
		labelHora.setBounds(10, 250, 150, 25);
		valorHora.setBounds(145, 250, 180, 25);
		labelDataExib.setBounds(10, 280, 150, 25);
		valorDataExib.setBounds(145, 280, 180, 25);

		/// Caso de alteração/remoção
		if (op == 2) {
			
			/// Realiza o posicionamento dos componentes exclusivos.
			botaoSalvar.setBounds(175, 320, 150, 50);
			botaoExcluir.setBounds(10, 320, 150, 50);
			
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
			botaoSalvar.setBounds(175, 320, 150, 50);
			botaoCancelar.setBounds(10, 320, 150, 50);
			
			/// Realiza a seleção de fontes para os botões "salvar" e "cancelar"
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));
			
			/// Coloca os componentes exclusivos no container
			this.janela.add(botaoSalvar);
			this.janela.add(botaoCancelar);
		}

		/// Coloca os componentes no container
		this.janela.add(labelNomeFilme);
		this.janela.add(valorNomeFilme);
		this.janela.add(labelIdioma);
		this.janela.add(valorIdioma);
		this.janela.add(labelSinopse);
		this.janela.add(valorSinopse);
		this.janela.add(labelDurFilme);
		this.janela.add(valorDurFilme);
		this.janela.add(labelClasIndic);
		this.janela.add(valorClasIndic);
		this.janela.add(labelGenero);
		this.janela.add(valorGenero);
		this.janela.add(labelDataLanc);
		this.janela.add(valorDataLanc);
		this.janela.add(labelSalaTrans);
		this.janela.add(valorSalaTrans);
		this.janela.add(labelHora);
		this.janela.add(valorHora);
		this.janela.add(labelDataExib);
		this.janela.add(valorDataExib);
		this.janela.add(botaoSalvar);
		

		this.janela.setLayout(null);

		/// Dados do container
		this.janela.setSize(365, 420);
		this.janela.setVisible(true);
		this.janela.setLocationRelativeTo(null);
		this.janela.setResizable(false);

		/// Detecção de eventos
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoCancelar.addActionListener(this);
	}

	/**
	 * Detecta as ações e redireciona para as opções e funcionalidades possíveis
	 * @param e ActionEvent que detecta alguma ação com algum botão
	 */
	
	/// Detecção de eventos relacionados aos dados do filme
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {				
				novoDado[0] = valorNomeFilme.getText();
				novoDado[1] = valorIdioma.getText();
				novoDado[2] = valorSinopse.getText();
				novoDado[3] = valorDurFilme.getText();
				novoDado[4] = valorClasIndic.getText();
				novoDado[5] = valorGenero.getText();
				novoDado[6] = valorDataLanc.getText();
				novoDado[7] = valorSalaTrans.getText();
				novoDado[8] = valorHora.getText();
				novoDado[9] = valorDataExib.getText();

				/// Caso de erro em cadastro de filme
				if ((opcao == 1 || opcao == 2) && ("".equals(novoDado[0]) || "".equals(novoDado[1]) || "".equals(novoDado[2]) || 
						"".equals(novoDado[3].replaceAll("[\\D]", "")) || "".equals(novoDado[4].replaceAll("[\\D]", "")) ||
						"".equals(novoDado[5]) || "".equals(novoDado[6]) ||"".equals(novoDado[7].replaceAll("[\\D]", "")) || 
						"".equals(novoDado[8].replaceAll("[\\D]", "")) || "".equals(novoDado[9]))) {
					mensagemErroCadastro();
				}
				
				/// Caso de cadastramento
				else if (opcao == 1) {	
					Filme novoFilme = new Filme(novoDado[0], Integer.parseInt(novoDado[3]), 
							Integer.parseInt(novoDado[4]), novoDado[1], novoDado[2], 
							novoDado[5], novoDado[6], Integer.parseInt(novoDado[7]), 
							Integer.parseInt(novoDado[8]), novoDado[9]);
					
					filme.cadastrar(novoFilme);
					mensagemSucessoCadastro();
				}
				
				/// Caso de alteração/remoção
				else if (opcao == 2) {
					Filme attFilme = new Filme(novoDado[0], Integer.parseInt(novoDado[3]), 
							Integer.parseInt(novoDado[4]), novoDado[1], novoDado[2], 
							novoDado[5], novoDado[6], Integer.parseInt(novoDado[7]), 
							Integer.parseInt(novoDado[8]), novoDado[9]);
					
					filme.editar(attFilme, posicao);
					mensagemSucessoCadastro();
				}
				
		}

		/// Exclui o filme
		if(src == botaoExcluir) {
			if (opcao == 2) {
				filme.deletar(posicao);
				mensagemSucessoExclusao();
			}
		}
		
		/// Cancela o cadastramento e fecha a janela
		if(src == botaoCancelar) janela.dispose();
	}

	/**
	 * Mostra uma mensagem para indicar que houve sucesso na exclusão de dados
	 */
	
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * Mostra uma mensagem para indicar que houve sucesso no cadastro ou salvamento de dados
	 */
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Mostra uma mensagem para indicar que houve falha no cadastro ou salvamento de dados do filme e apresentar as possíveis causas
	 */
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1- Nem todos os campos foram preenchidos; \n"
				+ "2- Duração do filme, classificação indicativa,"
				+ "sala de transmissão\n e horário de exibição não contém apenas números;", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}

}