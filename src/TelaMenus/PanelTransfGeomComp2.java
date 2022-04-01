package TelaMenus;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class PanelTransfGeomComp2 extends JPanel {

	// Atributos - Elementos visuais da tela
	public JLabel criarObjeto;
	// public JLabel numPontos;
	// public JTextField campoNumPontos;
	public JCheckBox btnCriarObjeto;

	// Seção da Tranformação simples
	public JLabel transfomacaoSimples;
	
	public JTextArea textArea;

	public JRadioButton rbTranslacao;
	public JLabel tx;
	public JTextField campoTx;
	public JLabel ty;
	public JTextField campoTy;
	public JButton btnAdicionarTranslacao;

	public final JRadioButton rbEscala;
	public JLabel sx;
	public JTextField campoSx;
	public JLabel sy;
	public JTextField campoSy;
	public JButton btnAdicionarEscala;

	public final JRadioButton rbRotacao;
	public JLabel ang;
	public JTextField campoAng;
	public JButton btnAdicionarRotacao;

	public final JRadioButton rbReflexao;
	public JComboBox combo;
	public JLabel A;
	public JTextField campoA;
	public JLabel B;
	public JTextField campoB;
	public JButton btnAdicionarReflexao;

	public final JRadioButton rbCisalhamento;
	public JLabel cx;
	public JTextField campoCx;
	public JLabel cy;
	public JTextField campoCy;
	public JButton btnAdicionarCisalhamento;

	public final ButtonGroup radiogrupo;

	// Seção Transformação composta
	//public JLabel transfomacaoComposta;
	public JButton btnAplicarTransfComposta;

	// Construtor
	public PanelTransfGeomComp2() {

		setLayout(null);
		setSize(400, 800);

		// Título Principal com bordas externas
		JPanel panelTransfGeom = new JPanel();
		panelTransfGeom.setBorder(new TitledBorder(null, "Transformações Composta", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panelTransfGeom.setBounds(10, 10, 366, 743);
		add(panelTransfGeom);
		panelTransfGeom.setLayout(null);

		// Cria uma seção com bordas para elementos do criar objeto
		// {
		JPanel secaoObjeto = new JPanel();
		secaoObjeto.setBounds(28, 22, 309, 50); // posicionamento(coluna, linha, largura, altura)
		secaoObjeto.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTransfGeom.add(secaoObjeto);
		secaoObjeto.setLayout(null);

		criarObjeto = new JLabel("Desenhar Elemento");
		criarObjeto.setBounds(110, 5, 200, 20); // posicionamento(coluna, linha, largura, altura)
		//secaoObjeto.add(criarObjeto);

		/*
		 * numPontos = new JLabel("Nº Pontos:"); numPontos.setBounds(10, 30, 200, 20);
		 * //posicionamento(coluna, linha, largura, altura) secaoObjeto.add(numPontos);
		 * 
		 * campoNumPontos = new JTextField(); campoNumPontos.setBounds(10, 50, 96, 21);
		 * secaoObjeto.add(campoNumPontos); campoNumPontos.setColumns(10);
		 */

		btnCriarObjeto = new JCheckBox("Criar Elemento");
		// btnCriarObjeto.setFont(new Font("Arial", Font.BOLD, 12));
		btnCriarObjeto.setBounds(10, 5, 150, 33);
		secaoObjeto.add(btnCriarObjeto);
		
		JPanel area = new JPanel();
		area.setBounds(28, 80, 309, 60); // posicionamento(coluna, linha, largura, altura)
		area.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTransfGeom.add(area);
		area.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(43, 100, 300,40);
		textArea.setVisible(true);
		add(textArea);
		
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(43, 100, 300, 40);
		add(sp);
		
		// }fim da seção

		// Cria uma seção com bordas para as Transformações Simples
		// {
		JPanel secaoTransfSimples = new JPanel();
		secaoTransfSimples.setBounds(28, 150, 309, 480); // posicionamento(coluna, linha, largura, altura)
		secaoTransfSimples.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTransfGeom.add(secaoTransfSimples);
		secaoTransfSimples.setLayout(null);

		transfomacaoSimples = new JLabel("Transformação Simples");
		transfomacaoSimples.setBounds(90, 5, 300, 20); // posicionamento(coluna, linha, largura, altura)
		secaoTransfSimples.add(transfomacaoSimples);

		// Translação:
		rbTranslacao = new JRadioButton("Translação", false);// marcado
		rbTranslacao.setBounds(10, 30, 200, 20); // posicionamento(coluna, linha, largura, altura)

		tx = new JLabel("Tx:");
		tx.setBounds(40, 60, 200, 20);
		secaoTransfSimples.add(tx);

		campoTx = new JTextField();
		campoTx.setBounds(60, 60, 50, 21);// 60 60 50 21
		campoTx.setColumns(10);
		secaoTransfSimples.add(campoTx);

		ty = new JLabel("Ty:");
		ty.setBounds(130, 60, 200, 20);
		secaoTransfSimples.add(ty);

		campoTy = new JTextField();
		campoTy.setBounds(150, 60, 50, 21);
		campoTy.setColumns(10);
		secaoTransfSimples.add(campoTy);
		
		btnAdicionarTranslacao = new JButton("+");
		btnAdicionarTranslacao.setBounds(240, 60, 50, 21);// posicionamento(coluna, linha, largura, altura)
		secaoTransfSimples.add(btnAdicionarTranslacao);

		// Escala:
		rbEscala = new JRadioButton("Escala", false);
		rbEscala.setBounds(10, 100, 200, 20); // posicionamento(coluna, linha, largura, altura)

		sx = new JLabel("Sx:");
		sx.setBounds(40, 130, 200, 20);
		secaoTransfSimples.add(sx);

		campoSx = new JTextField();
		campoSx.setBounds(60, 130, 50, 21);
		campoSx.setColumns(10);
		secaoTransfSimples.add(campoSx);

		sy = new JLabel("Sy:");
		sy.setBounds(130, 130, 200, 20);
		secaoTransfSimples.add(sy);

		campoSy = new JTextField();
		campoSy.setBounds(150, 130, 50, 21);
		campoSy.setColumns(10);
		secaoTransfSimples.add(campoSy);
		
		btnAdicionarEscala = new JButton("+");
		btnAdicionarEscala.setBounds(240, 130, 50, 21);// posicionamento(coluna, linha, largura, altura)
		secaoTransfSimples.add(btnAdicionarEscala);

		// Rotação:
		rbRotacao = new JRadioButton("Rotação", false);
		rbRotacao.setBounds(10, 190, 200, 20); // posicionamento(coluna, linha, largura, altura)

		ang = new JLabel("Ang:");
		ang.setBounds(40, 220, 200, 20);
		secaoTransfSimples.add(ang);

		campoAng = new JTextField();
		campoAng.setBounds(70, 220, 50, 21);
		campoAng.setColumns(10);
		secaoTransfSimples.add(campoAng);
		
		btnAdicionarRotacao = new JButton("+");
		btnAdicionarRotacao.setBounds(240, 220, 50, 21);// posicionamento(coluna, linha, largura, altura)
		secaoTransfSimples.add(btnAdicionarRotacao);

		// Reflexão
		rbReflexao = new JRadioButton("Reflexão", false);
		rbReflexao.setBounds(10, 280, 200, 20); // posicionamento(coluna, linha, largura, altura)

		String[] tiposReflexao = { "Em X", "Em Y", "Em torno da origem", "Em torno da reta Y=X",
				"Em torno da reta qualquer" };
		combo = new JComboBox(tiposReflexao);
		combo.setBounds(40, 310, 200, 21);
		secaoTransfSimples.add(combo);

		A = new JLabel("A:");
		A.setBounds(40, 340, 200, 20);
		secaoTransfSimples.add(A);

		campoA = new JTextField();
		campoA.setBounds(60, 340, 50, 21);
		campoA.setColumns(10);
		secaoTransfSimples.add(campoA);

		B = new JLabel("B:");
		B.setBounds(140, 340, 300, 20);
		secaoTransfSimples.add(B);

		campoB = new JTextField();
		campoB.setBounds(160, 340, 50, 21);
		campoB.setColumns(10);
		secaoTransfSimples.add(campoB);
		
		btnAdicionarReflexao = new JButton("+");
		btnAdicionarReflexao.setBounds(240, 340, 50, 21);// posicionamento(coluna, linha, largura, altura)
		secaoTransfSimples.add(btnAdicionarReflexao);

		// Cisalhamento
		rbCisalhamento = new JRadioButton("Cisalhamento", false);
		rbCisalhamento.setBounds(10, 400, 200, 20); // posicionamento(coluna, linha, largura, altura)

		cx = new JLabel("Cx:");
		cx.setBounds(40, 430, 370, 20);
		secaoTransfSimples.add(cx);

		campoCx = new JTextField();
		campoCx.setBounds(60, 430, 50, 21);
		campoCx.setColumns(10);
		secaoTransfSimples.add(campoCx);

		cy = new JLabel("Cy:");
		cy.setBounds(140, 430, 370, 20);
		secaoTransfSimples.add(cy);

		campoCy = new JTextField();
		campoCy.setBounds(160, 430, 50, 21);
		campoCy.setColumns(10);
		secaoTransfSimples.add(campoCy);
		
		btnAdicionarCisalhamento = new JButton("+");
		btnAdicionarCisalhamento.setBounds(240, 430, 50, 21);// posicionamento(coluna, linha, largura, altura)
		secaoTransfSimples.add(btnAdicionarCisalhamento);

		secaoTransfSimples.add(rbTranslacao);
		secaoTransfSimples.add(rbEscala);
		secaoTransfSimples.add(rbRotacao);
		secaoTransfSimples.add(rbReflexao);
		secaoTransfSimples.add(rbCisalhamento);
		// Cria grupo de botões que apenas 1 pode ser selecionado
		radiogrupo = new ButtonGroup();
		radiogrupo.add(btnCriarObjeto);
		radiogrupo.add(rbTranslacao);
		radiogrupo.add(rbEscala);
		radiogrupo.add(rbRotacao);
		radiogrupo.add(rbReflexao);
		radiogrupo.add(rbCisalhamento);
		


		// } fim da seção transformações simples

		// Cria uma seção com bordas para as Transformações Compostas
		// {
		JPanel secaoTransfComposta = new JPanel();
		secaoTransfComposta.setBounds(28, 640, 309, 70); // posicionamento(coluna, linha, largura, altura)
		secaoTransfComposta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTransfGeom.add(secaoTransfComposta);
		secaoTransfComposta.setLayout(null);

		//transfomacaoComposta = new JLabel("Transformação Composta");
		//transfomacaoComposta.setBounds(90, 5, 300, 20); // posicionamento(coluna, linha, largura, altura)
		//secaoTransfComposta.add(transfomacaoComposta);

		btnAplicarTransfComposta = new JButton("Aplicar");
		btnAplicarTransfComposta.setBounds(80, 20, 150, 33);// posicionamento(coluna, linha, largura, altura)
		secaoTransfComposta.add(btnAplicarTransfComposta);
		// } fim da seção da transformação composta
	}
}
