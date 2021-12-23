/** 
 * Classe panel Circunferencia metodo trigonometrico
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */
package TelaMenus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelCircunferenciaMT extends JPanel{
	
	public JTextField campoXY;
	public JTextField campoRaio;
	public JTable tabela;
	public JButton btnDesenhar;
	
	public PanelCircunferenciaMT() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelCircunferenciaMT = new JPanel();
		panelCircunferenciaMT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Circunfer\u00EAncia M.T", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCircunferenciaMT.setBounds(10, 10, 366, 743);
		add(panelCircunferenciaMT);
		panelCircunferenciaMT.setLayout(null);
		
		JPanel panelDesenhaCircunferenciaMT = new JPanel();
		panelDesenhaCircunferenciaMT.setBounds(28, 22, 309, 167);
		panelDesenhaCircunferenciaMT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCircunferenciaMT.add(panelDesenhaCircunferenciaMT);
		panelDesenhaCircunferenciaMT.setLayout(null);
		
		JLabel labelXY = new JLabel("X, Y");
		labelXY.setFont(new Font("Arial", Font.BOLD, 16));
		labelXY.setBounds(33, 40, 45, 13);
		panelDesenhaCircunferenciaMT.add(labelXY);
		
		campoXY = new JTextField();
		campoXY.setBounds(74, 31, 66, 33);
		panelDesenhaCircunferenciaMT.add(campoXY);
		campoXY.setColumns(10);
		
		JLabel labelRaio = new JLabel("Raio");
		labelRaio.setFont(new Font("Arial", Font.BOLD, 16));
		labelRaio.setBounds(33, 91, 45, 13);
		panelDesenhaCircunferenciaMT.add(labelRaio);
		
		campoRaio = new JTextField();
		campoRaio.setBounds(74, 81, 66, 33);
		panelDesenhaCircunferenciaMT.add(campoRaio);
		campoRaio.setColumns(10);
		
		btnDesenhar = new JButton("Desenhar");
		btnDesenhar.setFont(new Font("Arial", Font.BOLD, 12));
		btnDesenhar.setBounds(92, 124, 108, 33);
		panelDesenhaCircunferenciaMT.add(btnDesenhar);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTabela.setBounds(28, 218, 309, 381);
		panelCircunferenciaMT.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(32, 36, 209, 299);
		panelTabela.add(scrollTabela);
		
		//CRIANDO TAMANHO E TITULO DA COLUNA
		Object [][]tabelaItens =new Object[16][1000];
		tabelaItens[0][0] = "X0 = X";
		tabelaItens[1][0] = "Y0 = Y";
		tabelaItens[2][0] = "X1 = Y";
		tabelaItens[3][0] = "Y1 = X";
		tabelaItens[4][0] = "X2 = Y";
		tabelaItens[5][0] = "Y2 = -X";
		tabelaItens[6][0] = "X3 = X";
		tabelaItens[7][0] = "Y3 = -Y";
		tabelaItens[8][0] = "X4 = -X";
		tabelaItens[9][0] = "Y4 = -Y";
		tabelaItens[10][0] = "X5 = -Y";
		tabelaItens[11][0] = "Y5 = -X";
		tabelaItens[12][0] = "X6 = -Y";
		tabelaItens[13][0] = "Y6 = X";
		tabelaItens[14][0] = "X7 = -X";
		tabelaItens[15][0] = "Y7 = Y";
		
		
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
