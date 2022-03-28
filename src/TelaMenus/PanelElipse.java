package TelaMenus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class PanelElipse extends JPanel {
	
	public JTextField campoXY;
	public JTextField campoDiametro;
	public JTextField campoAltura;
	public JTable tabela;
	public JCheckBox checkBoxMouse;
	public JButton btnDesenhar;
	
	
	public PanelElipse() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelElipse = new JPanel();
		panelElipse.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Elipse", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelElipse.setBounds(10, 10, 366, 743);
		add(panelElipse);
		panelElipse.setLayout(null);
		
		//Panel com os dados do x,y
		JPanel panelDesenhaElipse = new JPanel();
		panelDesenhaElipse.setBounds(28, 22, 309, 77);
		panelDesenhaElipse.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelElipse.add(panelDesenhaElipse);
		panelDesenhaElipse.setLayout(null);
		
		
		JLabel labelXY = new JLabel("X, Y");
		labelXY.setFont(new Font("Arial", Font.BOLD, 13));
		labelXY.setBounds(55, 38, 45, 13);
		panelDesenhaElipse.add(labelXY);
		
		campoXY = new JTextField();
		campoXY.setBounds(98, 32, 96, 21);
		panelDesenhaElipse.add(campoXY);
		campoXY.setColumns(10);
		
		
		//Panel com os dados diametro e altura
		JPanel panelDadosElipse = new JPanel();
		panelDadosElipse.setBounds(28, 116, 309, 110);
		panelDadosElipse.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelElipse.add(panelDadosElipse);
		panelDadosElipse.setLayout(null);
	
		
		JLabel labelDiametro = new JLabel("DIAMETRO");
		labelDiametro.setFont(new Font("Arial", Font.BOLD, 13));
		labelDiametro.setBounds(70, 21, 70, 13);
		panelDadosElipse.add(labelDiametro);
		
		JLabel labelAltura = new JLabel("ALTURA");
		labelAltura.setFont(new Font("Arial", Font.BOLD, 13));
		labelAltura.setBounds(70, 53,70, 13);
		panelDadosElipse.add(labelAltura);
		
		campoDiametro = new JTextField();
		campoDiametro.setBounds(145, 18, 62, 19);
		panelDadosElipse.add(campoDiametro);
		campoDiametro.setColumns(10);
		
		campoAltura = new JTextField();
		campoAltura.setBounds(145, 50, 62, 19);
		panelDadosElipse.add(campoAltura);
		campoAltura.setColumns(10);
		
		btnDesenhar = new JButton("Desenhar");
		btnDesenhar.setFont(new Font("Arial", Font.BOLD, 12));
		btnDesenhar.setBounds(92, 75, 108, 33);
		panelDadosElipse.add(btnDesenhar);
		
		
		//Panel Tabela
		JPanel panelTabela = new JPanel();
		panelTabela.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTabela.setBounds(28, 218, 309, 190);
		panelElipse.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(32, 36, 209, 190);
		panelTabela.add(scrollTabela);
		
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
		

	}
	
}
