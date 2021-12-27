package TelaMenus;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class panelRetaDDA extends JPanel {
	
	public JTextField campoX1Y1;
	public JTextField campoX2Y2;
	public JTextField campoLength;
	public JTextField campoXinc;
	public JTextField campoYinc;
	public JTable tabela;
	public JButton btnDesenhar;
	public JCheckBox checkBoxMouse;

	
	public panelRetaDDA() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelRetaDDA = new JPanel();
		panelRetaDDA.setBorder(new TitledBorder(null, "Reta DDA", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelRetaDDA.setBounds(10, 10, 366, 743);
		add(panelRetaDDA);
		panelRetaDDA.setLayout(null);
		
		JPanel panelDesenhaReta = new JPanel();
		panelDesenhaReta.setBounds(28, 22, 309, 167);
		panelDesenhaReta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRetaDDA.add(panelDesenhaReta);
		panelDesenhaReta.setLayout(null);
		
		checkBoxMouse = new JCheckBox("Desenhar ao clicar");
		checkBoxMouse.setFont(new Font("Arial", Font.BOLD, 13));
		checkBoxMouse.setBounds(75, 17, 145, 21);
		panelDesenhaReta.add(checkBoxMouse);
		
		JLabel labelX1Y1 = new JLabel("X1, Y1");
		labelX1Y1.setFont(new Font("Arial", Font.BOLD, 13));
		labelX1Y1.setBounds(49, 59, 45, 13);
		panelDesenhaReta.add(labelX1Y1);
		
		campoX1Y1 = new JTextField();
		campoX1Y1.setBounds(104, 55, 96, 21);
		panelDesenhaReta.add(campoX1Y1);
		campoX1Y1.setColumns(10);
		
		JLabel labelX2Y2 = new JLabel("X2, Y2");
		labelX2Y2.setFont(new Font("Arial", Font.BOLD, 13));
		labelX2Y2.setBounds(49, 98, 45, 13);
		panelDesenhaReta.add(labelX2Y2);
		
		campoX2Y2 = new JTextField();
		campoX2Y2.setBounds(104, 95, 96, 19);
		panelDesenhaReta.add(campoX2Y2);
		campoX2Y2.setColumns(10);
		
		btnDesenhar = new JButton("Desenhar");
		btnDesenhar.setFont(new Font("Arial", Font.BOLD, 12));
		btnDesenhar.setBounds(92, 124, 108, 33);
		panelDesenhaReta.add(btnDesenhar);
		
		JPanel panelDadosReta = new JPanel();
		panelDadosReta.setBounds(28, 192, 309, 116);
		panelDadosReta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRetaDDA.add(panelDadosReta);
		panelDadosReta.setLayout(null);
		
		JLabel labelLenght = new JLabel("Lenght");
		labelLenght.setFont(new Font("Arial", Font.BOLD, 13));
		labelLenght.setBounds(86, 19, 58, 16);
		panelDadosReta.add(labelLenght);
		
		JLabel labelXinc = new JLabel("Xinc");
		labelXinc.setFont(new Font("Arial", Font.BOLD, 13));
		labelXinc.setBounds(96, 45, 45, 13);
		panelDadosReta.add(labelXinc);
		
		JLabel labelYinc = new JLabel("Yinc");
		labelYinc.setFont(new Font("Arial", Font.BOLD, 13));
		labelYinc.setBounds(99, 68, 45, 13);
		panelDadosReta.add(labelYinc);
		
		campoLength = new JTextField();
		campoLength.setBounds(139, 18, 52, 19);
		panelDadosReta.add(campoLength);
		campoLength.setColumns(10);
		
		campoXinc = new JTextField();
		campoXinc.setBounds(139, 42, 52, 19);
		panelDadosReta.add(campoXinc);
		campoXinc.setColumns(10);
		
		campoYinc = new JTextField();
		campoYinc.setBounds(139, 65, 62, 19);
		panelDadosReta.add(campoYinc);
		campoYinc.setColumns(10);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTabela.setBounds(28, 318, 309, 415);
		panelRetaDDA.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(90, 15, 128, 348);
		panelTabela.add(scrollTabela);
		
		//CRIANDO TAMANHO E TITULO DA COLUNA
		Object [][]tabelaItens =new Object[1000][2];	
		String []tabelaTitulo = {"X","Y"};

		tabela = new JTable();
		tabela.setFont(new Font("Arial", Font.PLAIN, 15));
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setDefaultEditor(Object.class, null);
		tabela.setModel(new DefaultTableModel(tabelaItens,tabelaTitulo) );
				
		// CENTRALIZAR OS ITENS DA TABELA
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );	
		for(int i=0;i<2;i++){
			tabela.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			tabela.getColumnModel().getColumn(i).setPreferredWidth(55);
		}
		scrollTabela.setViewportView(tabela);
						
		
		}
}
