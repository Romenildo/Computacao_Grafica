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
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class panelRetaPontoMedio extends JPanel {
	
	private JTextField campoX1Y1;
	private JTextField campoX2Y2;
	private JTextField campoD;
	private JTextField campoDx;
	private JTextField campoDy;
	private JTable tabela;
	private JTextField campoINCe;
	private JTextField campoINCne;
	
	
	public panelRetaPontoMedio() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new LineBorder(new Color(192, 192, 192), 6, true));
		add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel panelRetaPM = new JPanel();
		panelRetaPM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reta Ponto M\u00E9dio", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRetaPM.setBounds(10, 10, 366, 743);
		panelPrincipal.add(panelRetaPM);
		panelRetaPM.setLayout(null);
		
		JPanel panelDesenhaReta = new JPanel();
		panelDesenhaReta.setBounds(28, 22, 309, 167);
		panelDesenhaReta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRetaPM.add(panelDesenhaReta);
		panelDesenhaReta.setLayout(null);
		
		JCheckBox checkBox = new JCheckBox("Desenhar ao clicar");
		checkBox.setFont(new Font("Arial", Font.BOLD, 13));
		checkBox.setBounds(75, 17, 145, 21);
		panelDesenhaReta.add(checkBox);
		
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
		
		JButton btnDesenhar = new JButton("Desenhar");
		btnDesenhar.setFont(new Font("Arial", Font.BOLD, 12));
		btnDesenhar.setBounds(92, 124, 108, 33);
		panelDesenhaReta.add(btnDesenhar);
		
		JPanel panelDadosReta = new JPanel();
		panelDadosReta.setBounds(28, 192, 309, 80);
		panelDadosReta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRetaPM.add(panelDadosReta);
		panelDadosReta.setLayout(null);
		
		JLabel labelD = new JLabel("D");
		labelD.setFont(new Font("Arial", Font.BOLD, 13));
		labelD.setBounds(52, 19, 27, 16);
		panelDadosReta.add(labelD);
		
		JLabel labelDx = new JLabel("Dx");
		labelDx.setFont(new Font("Arial", Font.BOLD, 13));
		labelDx.setBounds(200, 21, 45, 13);
		panelDadosReta.add(labelDx);
		
		JLabel labelDy = new JLabel("Dy");
		labelDy.setFont(new Font("Arial", Font.BOLD, 13));
		labelDy.setBounds(200, 53, 45, 13);
		panelDadosReta.add(labelDy);
		
		campoD = new JTextField();
		campoD.setBounds(62, 18, 52, 19);
		panelDadosReta.add(campoD);
		campoD.setColumns(10);
		
		campoDx = new JTextField();
		campoDx.setBounds(222, 18, 62, 19);
		panelDadosReta.add(campoDx);
		campoDx.setColumns(10);
		
		campoDy = new JTextField();
		campoDy.setBounds(222, 50, 62, 19);
		panelDadosReta.add(campoDy);
		campoDy.setColumns(10);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTabela.setBounds(28, 352, 309, 381);
		panelRetaPM.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(67, 27, 172, 348);
		panelTabela.add(scrollTabela);
		
		tabela = new JTable();
		scrollTabela.setViewportView(tabela);
		tabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabela.setFont(new Font("Arial", Font.PLAIN, 12));
		tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabela.setBackground(Color.WHITE);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"D", "X", "Y"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(28, 282, 309, 60);
		panelRetaPM.add(panel);
		panel.setLayout(null);
		
		JLabel labelINCe = new JLabel("INCe");
		labelINCe.setFont(new Font("Arial", Font.BOLD, 13));
		labelINCe.setBounds(41, 10, 45, 13);
		panel.add(labelINCe);
		
		JLabel labelINCne = new JLabel("INCne");
		labelINCne.setFont(new Font("Arial", Font.BOLD, 13));
		labelINCne.setBounds(168, 10, 45, 13);
		panel.add(labelINCne);
		
		campoINCe = new JTextField();
		campoINCe.setBounds(41, 33, 58, 19);
		panel.add(campoINCe);
		campoINCe.setColumns(10);
		
		campoINCne = new JTextField();
		campoINCne.setBounds(168, 33, 58, 19);
		panel.add(campoINCne);
		campoINCne.setColumns(10);
		tabela.getColumnModel().getColumn(1).setMinWidth(18);
	}
	
}
