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
import javax.swing.table.DefaultTableModel;

public class PanelCircunferenciaPM extends JPanel{
	
	public JTextField campoXY;
	public JTextField campoRaio;
	public JTable tabela;
	public JTextField campoD;
	public JButton btnDesenhar;
	
	public PanelCircunferenciaPM() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelCircunferenciaPM = new JPanel();
		panelCircunferenciaPM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Circunfer\u00EAncia P.M", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCircunferenciaPM.setBounds(10, 10, 366, 743);
		add(panelCircunferenciaPM);
		panelCircunferenciaPM.setLayout(null);
		
		JPanel panelDesenhaCircunferenciaPM = new JPanel();
		panelDesenhaCircunferenciaPM.setBounds(28, 22, 309, 167);
		panelDesenhaCircunferenciaPM.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCircunferenciaPM.add(panelDesenhaCircunferenciaPM);
		panelDesenhaCircunferenciaPM.setLayout(null);
		
		JLabel labelXY = new JLabel("X, Y");
		labelXY.setFont(new Font("Arial", Font.BOLD, 16));
		labelXY.setBounds(33, 40, 45, 13);
		panelDesenhaCircunferenciaPM.add(labelXY);
		
		campoXY = new JTextField();
		campoXY.setBounds(74, 31, 66, 33);
		panelDesenhaCircunferenciaPM.add(campoXY);
		campoXY.setColumns(10);
		
		JLabel labelRaio = new JLabel("Raio");
		labelRaio.setFont(new Font("Arial", Font.BOLD, 16));
		labelRaio.setBounds(33, 91, 45, 13);
		panelDesenhaCircunferenciaPM.add(labelRaio);
		
		campoRaio = new JTextField();
		campoRaio.setBounds(74, 81, 66, 33);
		panelDesenhaCircunferenciaPM.add(campoRaio);
		campoRaio.setColumns(10);
		
		btnDesenhar = new JButton("Desenhar");
		btnDesenhar.setFont(new Font("Arial", Font.BOLD, 12));
		btnDesenhar.setBounds(92, 124, 108, 33);
		panelDesenhaCircunferenciaPM.add(btnDesenhar);
		
		JLabel labelD = new JLabel("D");
		labelD.setFont(new Font("Arial", Font.BOLD, 16));
		labelD.setBounds(172, 42, 45, 13);
		panelDesenhaCircunferenciaPM.add(labelD);
		
		campoD = new JTextField();
		campoD.setColumns(10);
		campoD.setBounds(206, 31, 66, 33);
		panelDesenhaCircunferenciaPM.add(campoD);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTabela.setBounds(28, 218, 309, 381);
		panelCircunferenciaPM.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(67, 27, 172, 91);
		panelTabela.add(scrollTabela);
		
		tabela = new JTable();
		scrollTabela.setViewportView(tabela);
		tabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabela.setFont(new Font("Arial", Font.PLAIN, 12));
		tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabela.setBackground(Color.WHITE);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"X0 = X", "Y0 = Y"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(1).setMinWidth(18);
	}
	
	
}
