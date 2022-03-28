package TelaMenus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelFiltros extends JPanel {
	
	public JTable tabela;
	public JCheckBox checkBoxMouse;
	public JButton btnAplicarFiltro;
	
	
	public PanelFiltros() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelFiltros = new JPanel();
		panelFiltros.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltros.setBounds(10, 10, 366, 743);
		add(panelFiltros);
		panelFiltros.setLayout(null);
		
		//Panel com os dados do x,y
		JPanel panelSelecionaFiltros = new JPanel();
		panelSelecionaFiltros.setBounds(28, 22, 309, 107);
		panelSelecionaFiltros.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFiltros.add(panelSelecionaFiltros);
		panelSelecionaFiltros.setLayout(null);
		
		
		JLabel esolhaFiltro = new JLabel("Escolha o Filtro");
		esolhaFiltro.setFont(new Font("Arial", Font.BOLD, 11));
		esolhaFiltro.setBounds(40, 38, 140, 13);
		panelSelecionaFiltros.add(esolhaFiltro);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1- Media", "2- Mediana", "3- Passa alta basico ", "4- Operador de Robert's - X ", "5- Operador de Robert's - Y ", "6- Operador de Prewitt ", "7- Alto Reforço ", "8- Operador de Sobel "}));
		comboBox.setBounds(40, 58, 210, 21);
		panelSelecionaFiltros.add(comboBox);
		
		//Panel com os dados diametro e altura
		JPanel panelMatriz = new JPanel();
		panelMatriz.setBounds(28, 135, 309, 400);
		panelMatriz.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFiltros.add(panelMatriz);
		panelMatriz.setLayout(null);
	
		
		JLabel labelMatriz = new JLabel("Matriz de Convolucao:");
		labelMatriz.setFont(new Font("Arial", Font.BOLD, 11));
		labelMatriz.setBounds(70, 24, 140, 13);
		panelMatriz.add(labelMatriz);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(32, 36, 209, 190);
		panelMatriz.add(scrollTabela);
		
		
		
		//CRIANDO TAMANHO E TITULO DA COLUNA
		Object [][]tabelaItens =new Object[8][1000];
		tabelaItens[0][0] = "X0 = X";
		tabelaItens[1][0] = "Y0 = Y";
		tabelaItens[2][0] = "X1 = X";
		tabelaItens[3][0] = "Y1 = -Y";
		tabelaItens[4][0] = "X2 = -X";
		tabelaItens[5][0] = "Y2 = -Y";
		tabelaItens[6][0] = "X3 = -X";
		tabelaItens[7][0] = "Y3 =  Y";
		
		String []tabelaTitulo = new String[1000];
		tabelaTitulo[0] = "-";
		for(int i = 1; i < 1000; i++) {
			tabelaTitulo[i] = String.valueOf(i);
		}
		
		tabela = new JTable();
		tabela.setFont(new Font("Arial", Font.PLAIN, 15));
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setDefaultEditor(Object.class, null);
		tabela.setModel(new DefaultTableModel(tabelaItens,tabelaTitulo) );
		
		// CENTRALIZAR OS ITENS DA TABELA
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				
		for(int i=0;i<tabelaItens.length;i++){
	         tabela.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
	         tabela.getColumnModel().getColumn(i).setPreferredWidth(55);
	        }
		scrollTabela.setViewportView(tabela);
		
		btnAplicarFiltro = new JButton("Aplicar Filtro");
		btnAplicarFiltro.setFont(new Font("Arial", Font.BOLD, 12));
		btnAplicarFiltro.setBounds(92, 230, 108, 20);
		panelMatriz.add(btnAplicarFiltro);
		

	}
	
}
