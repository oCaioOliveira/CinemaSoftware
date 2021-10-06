package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import principal.*;

/**
 * Criação da classe TelaDetalhePessoa, onde é criado o menu de detalhes do cliente ou funcionário e suas funcionalidades
 * @author Caio César e Lucas Henrique
 * @version 1.0 (Out 2020)
 */

public class TelaDetalhePessoa implements ActionListener {

	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel labelPrimNome = new JLabel("Primeiro Nome: ");
	private JTextField valorPrimNome;
	private JLabel labelUltNome = new JLabel("Último Nome: ");
	private JTextField valorUltNome;
	private JLabel labelData = new JLabel("Data: ");
	private JTextField valorData;
	private JLabel labelCPF = new JLabel("CPF: ");
	private JTextField valorCPF;
	private JLabel labelNumCel = new JLabel("Número de Celular: ");
	private JTextField valorNumCel;
	private JLabel labelEmail = new JLabel("e-mail: ");
	private JTextField valorEmail;
	private JLabel labelGenFav = new JLabel("Gênero Favorito: ");
	private JTextField valorGenFav;
	private JLabel labelQntddFilmesVistos = new JLabel("Filmes Vistos: ");
	private JTextField valorQntddFilmesVistos;
	private JLabel labelPlanoAss = new JLabel("Plano de Assinatura: ");
	private JTextField valorPlanoAss;
	private JLabel labelFuncao = new JLabel("Função: ");
	private JTextField valorFuncao;
	private JLabel labelEndereco = new JLabel("Endereço: ");
	private JTextField valorEndereco;
	private JLabel labelSalario = new JLabel("Salário: ");
	private JTextField valorSalario;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoCancelar = new JButton("Cancelar");
	
	/// Declaração de dados a serem manipulados
	private String[] novoDado = new String[12];
	private int posicao;
	private int opcao;
	private String s;
	ClienteVIP cliente = new ClienteVIP();
	Funcionario funcionario = new Funcionario();
	TelaPessoa p = new TelaPessoa();
	
	/**
	 * Definir as características da interface do Menu de detalhes dos clientes ou funcionarios como botões, títulos, janelas e adicioná los a janela
	 * @param op inteiro que representa a opção selecionada no menu de cliente ou funcionario (TelaPessoa)
	 * @param p TelaPessoa que importa a classe Tela Pessoa
	 * @param c ClienteVIP que importa os dados do cliente criado no menu principal (TelaMenu) e menu do cliente ou funcionario (TelaPessoa)
	 * @param f Funcionario que importa os dados do funcionário criado no menu principal (TelaMenu) e menu do cliente ou funcionario (TelaPessoa)
	 * @param pos inteiro que representa a posição do cliente ou funcionario na lista do menu do cliente ou funcionario (TelaPessoa)
	 */
	
	public void criarTelaDetalhePessoa(int op, 
		TelaPessoa p, ClienteVIP c, Funcionario f, int pos) {
		
		this.opcao = op;
		this.posicao = pos;
		cliente = c;
		funcionario = f;

		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Cadastro de Funcionário";
		if (op == 3) s = "Detalhes de Cliente";
		if (op == 4) s = "Detalhes de Funcionário";

		/// Cria um container
		janela = new JFrame(s);

		
		if (op == 1) {
			/// Cria os componentes do container
			valorPrimNome = new JTextField(200);
			valorUltNome = new JTextField(200);
			valorData = new JTextField(200);
			valorCPF = new JTextField(200);
			valorNumCel = new JTextField(200);
			valorEmail = new JTextField(200);
			valorGenFav = new JTextField(200);	
			valorQntddFilmesVistos = new JTextField(200);
			valorPlanoAss = new JTextField(200);
			valorFuncao = new JTextField(200);	
			valorEndereco = new JTextField(200);
			valorSalario = new JTextField(200);
			
		} else if (op == 2) {
			/// Cria os componentes do container
			valorPrimNome = new JTextField(200);
			valorUltNome = new JTextField(200);
			valorData = new JTextField(200);
			valorCPF = new JTextField(200);
			valorNumCel = new JTextField(200);
			valorEmail = new JTextField(200);
			valorGenFav = new JTextField(200);	
			valorQntddFilmesVistos = new JTextField(200);
			valorPlanoAss = new JTextField(200);
			valorFuncao = new JTextField(200);	
			valorEndereco = new JTextField(200);
			valorSalario = new JTextField(200);
			
		} else if (op == 3) {
			/// Recebe o valor de cada variável
			valorPrimNome = new JTextField(cliente.retornaPrimNome(posicao), 200);
			valorUltNome = new JTextField(cliente.retornaUltNome(posicao),200);
			valorData = new JTextField(cliente.retornaData(posicao), 200);
			valorCPF = new JTextField(cliente.retornaCPF(posicao), 200);
			valorNumCel = new JTextField(cliente.retornaNumCel(posicao), 200);
			valorEmail = new JTextField(cliente.retornaEmail(posicao), 200);
			valorGenFav = new JTextField(cliente.retornaGenFav(posicao), 200);	
			valorQntddFilmesVistos = new JTextField(String.valueOf
					(cliente.retornaQntddFilmesVistos(posicao)), 200);
			valorPlanoAss = new JTextField(cliente.retornaPlanoAss(posicao), 200);
			valorFuncao = new JTextField(200);	
			valorEndereco = new JTextField(200);
			valorSalario = new JTextField(200);

		} else if (op == 4) { 
			/// Recebe o valor de cada variável
			valorPrimNome = new JTextField(funcionario.retornaPrimNome(posicao), 200);
			valorUltNome = new JTextField(funcionario.retornaUltNome(posicao),200);
			valorData = new JTextField(funcionario.retornaData(posicao), 200);
			valorCPF = new JTextField(funcionario.retornaCPF(posicao), 200);
			valorNumCel = new JTextField(funcionario.retornaNumCel(posicao), 200);
			valorEmail = new JTextField(funcionario.retornaEmail(posicao), 200);
			valorFuncao = new JTextField(funcionario.retornaFuncao(posicao), 200);	
			valorEndereco = new JTextField(funcionario.retornaEndereco(posicao), 200);
			valorSalario = new JTextField(String.valueOf
					(funcionario.retornaSalario(posicao)), 200);
			valorGenFav = new JTextField( 200);	
			valorQntddFilmesVistos = new JTextField(200);
			valorPlanoAss = new JTextField(200);

		} 
		
		/// Realiza o posicionamento dos componentes
		labelPrimNome.setBounds(10, 10, 150, 25);
		valorPrimNome.setBounds(145, 10, 185, 25);
		labelData.setBounds(10, 40, 150, 25);
		valorData.setBounds(145, 40, 185, 25);
		labelUltNome.setBounds(10, 70, 180, 25);
		valorUltNome.setBounds(145, 70, 185, 25);		
		labelCPF.setBounds(10, 100, 150, 25);
		valorCPF.setBounds(145, 100, 185, 25);
		labelNumCel.setBounds(10, 130, 150, 25);
		valorNumCel.setBounds(145, 130, 185, 25);
		labelEmail.setBounds(10, 160, 150, 25);
		valorEmail.setBounds(145, 160, 185, 25);
		labelGenFav.setBounds(10, 190, 150, 25);
		valorGenFav.setBounds(145, 190, 185, 25);
		labelQntddFilmesVistos.setBounds(10, 220, 180, 25);
		valorQntddFilmesVistos.setBounds(145, 220, 185, 25);		
		labelPlanoAss.setBounds(10, 250, 150, 25);
		valorPlanoAss.setBounds(145, 250, 185, 25);
		labelFuncao.setBounds(10, 190, 150, 25);
		valorFuncao.setBounds(145, 190, 185, 25);
		labelEndereco.setBounds(10, 220, 150, 25);
		valorEndereco.setBounds(145, 220, 185, 25);
		labelSalario.setBounds(10, 250, 150, 25);
		valorSalario.setBounds(145, 250, 185, 25);

		/// Coloca os componentes no container caso Cliente
		if (op == 1 || op == 3 ) {
			this.janela.add(labelGenFav);
			this.janela.add(valorGenFav);
			this.janela.add(labelQntddFilmesVistos);
			this.janela.add(valorQntddFilmesVistos);
			this.janela.add(labelPlanoAss);
			this.janela.add(valorPlanoAss);

		}

		/// Coloca os componentes no container caso Funcionário
		if (op == 2 || op == 4) {
			this.janela.add(labelFuncao);
			this.janela.add(valorFuncao);
			this.janela.add(labelEndereco);
			this.janela.add(valorEndereco);
			this.janela.add(labelSalario);
			this.janela.add(valorSalario);
		}

		/// Caso de alteração/remoção
		if (op == 3 || op == 4) {
			
			/// Realiza o posicionamento dos componentes exclusivos.
			botaoSalvar.setBounds(180, 290, 150, 50);
			botaoExcluir.setBounds(10, 290, 150, 50);
			
			/// Realiza a seleção de fontes para os botões "salvar" e "excluir"
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoExcluir.setFont(new Font("Arial", Font.BOLD, 18));
			
			/// Coloca os componentes exclusivos no container
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
		}
		
		/// Caso de cadastramento
		if (op == 1 || op  == 2) {
			
			/// Realiza o posicionamento dos componentes exclusivos.
			botaoSalvar.setBounds(180, 290, 150, 50);
			botaoCancelar.setBounds(10, 290, 150, 50);
			
			/// Realiza a seleção de fontes para os botões "salvar" e "cancelar"
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));
			
			/// Coloca o componente exclusivo no container
			this.janela.add(botaoSalvar);
		}

		/// Coloca os componentes no container
		this.janela.add(labelPrimNome);
		this.janela.add(valorPrimNome);
		this.janela.add(labelCPF);
		this.janela.add(valorCPF);
		this.janela.add(labelNumCel);
		this.janela.add(valorNumCel);
		this.janela.add(labelUltNome);
		this.janela.add(valorUltNome);
		this.janela.add(labelData);
		this.janela.add(valorData);
		this.janela.add(labelEmail);
		this.janela.add(valorEmail);
		this.janela.add(botaoSalvar);
		this.janela.add(botaoCancelar);

		this.janela.setLayout(null);

		/// Dados do container
		this.janela.setSize(365, 390);
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
	
	/// Detecção de eventos relacionados aos dados da Pessoa
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {				
			novoDado[0] = valorPrimNome.getText();
			novoDado[1] = valorCPF.getText();
			novoDado[2] = valorNumCel.getText();
			novoDado[3] = valorUltNome.getText();
			novoDado[4] = valorData.getText();
			novoDado[5] = valorEmail.getText();
			novoDado[6] = valorGenFav.getText();
			novoDado[7] = valorQntddFilmesVistos.getText();
			novoDado[8] = valorPlanoAss.getText();
			novoDado[9] = valorFuncao.getText();
			novoDado[10] = valorEndereco.getText();
			novoDado[11] = valorSalario.getText();
				
			/// Caso de erro em cadastro de cliente
			if ((opcao == 1 || opcao == 3) && ("".equals(novoDado[0]) || "".equals(novoDado[1]) || "".equals(novoDado[2]) || "".equals(novoDado[3]) || "".equals(novoDado[4]) ||
					"".equals(novoDado[5]) || "".equals(novoDado[6]) ||"".equals(novoDado[7].replaceAll("[\\D]", "")) || "".equals(novoDado[8]))) {
				mensagemErroCadastroCliente();
			}
			
			/// Caso de erro em cadastro de funcionario
			else if ((opcao == 2 || opcao == 4) && ("".equals(novoDado[0]) || "".equals(novoDado[1]) || "".equals(novoDado[2]) || "".equals(novoDado[4]) ||
					"".equals(novoDado[5]) || "".equals(novoDado[9].replaceAll("[\\D]", "")) ||"".equals(novoDado[10]) || "".equals(novoDado[11]))) {
				mensagemErroCadastroFuncionario();
			}
			
			/// Caso de cadastramento
			else if (opcao == 1) {
				ClienteVIP novoCliente = new ClienteVIP(novoDado[0], novoDado[3], 
						novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[6], 
						Integer.parseInt(novoDado[7]), novoDado[8]);
				cliente.cadastrar(novoCliente);
				mensagemSucessoCadastro();
			} 
			
			/// Caso de cadastramento
			else if (opcao == 2){
				Funcionario novoFuncionario = new Funcionario(novoDado[0], novoDado[3], 
						novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[9], 
						novoDado[10], Double.parseDouble(novoDado[11]));
				funcionario.cadastrar(novoFuncionario);
				mensagemSucessoCadastro();
			} 
			
			/// Caso de alteração/remoção
			else if (opcao == 3) {
				ClienteVIP attCliente = new ClienteVIP(novoDado[0], novoDado[3], 
						novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[6], 
						Integer.parseInt(novoDado[7]), novoDado[8]);
				cliente.editar(attCliente, posicao);
				mensagemSucessoCadastro();
			} 
			
			/// Caso de alteração/remoção
			else if (opcao == 4) {
				Funcionario attFuncionario = new Funcionario(novoDado[0], novoDado[3], 
						novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[9], 
						novoDado[10], Double.parseDouble(novoDado[11]));
				funcionario.editar(attFuncionario, posicao);
				mensagemSucessoCadastro();
			}

		}

		/// Exclui a pessoa
		if(src == botaoExcluir) {

			/// Caso cliente
			if (opcao == 3) {
				cliente.deletar(posicao);
				mensagemSucessoExclusao();
			}
			
			/// Caso funcionário
			if (opcao == 4){ //exclui professor
				funcionario.deletar(posicao);
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
	 * Mostra uma mensagem para indicar que houve falha no cadastro ou salvamento de dados de cliente e apresentar as possíveis causas
	 */
	
	public void mensagemErroCadastroCliente() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1- Nem todos os campos foram preenchidos; \n"
				+ "2- Filmes Vistos não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Mostra uma mensagem para indicar que houve falha no cadastro ou salvamento de dados de funcionário e apresentar as possíveis causas
	 */
	
	public void mensagemErroCadastroFuncionario() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1- Nem todos os campos foram preenchidos; \n"
				+ "2- Salário não contém apenas números;", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}

}