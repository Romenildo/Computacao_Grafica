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

public class PanelHistograma extends JPanel {
	
	public JTable tabela;
	public JCheckBox checkBoxMouse;
	public JButton btnIniciarHistograma;
	public JComboBox comboBox;
	
	
	public PanelHistograma() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelHistograma = new JPanel();
		panelHistograma.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Histograma", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHistograma.setBounds(10, 10, 366, 743);
		add(panelHistograma);
		panelHistograma.setLayout(null);
		
		//Panel com os dados do x,y
		JPanel panelInicializa = new JPanel();
		panelInicializa.setBounds(28, 22, 309, 100);
		panelInicializa.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHistograma.add(panelInicializa);
		panelInicializa.setLayout(null);
		
		
		JLabel labelIniciar = new JLabel("Iniciar a Equialização");
		labelIniciar.setFont(new Font("Arial", Font.BOLD, 11));
		labelIniciar.setBounds(40, 38, 140, 13);
		panelInicializa.add(labelIniciar);
		
		
		
		btnIniciarHistograma = new JButton("iniciar");
		btnIniciarHistograma.setFont(new Font("Arial", Font.BOLD, 12));
		btnIniciarHistograma.setBounds(70, 60, 140, 20);
		panelInicializa.add(btnIniciarHistograma);
		

	}
	
}
