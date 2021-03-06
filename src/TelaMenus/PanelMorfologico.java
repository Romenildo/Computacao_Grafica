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

public class PanelMorfologico extends JPanel {
	
	public JCheckBox checkBoxMouse;
	public JButton btnAplicaMorfologia;
	public JComboBox comboBox;
	
	
	public PanelMorfologico() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelMorfologico = new JPanel();
		panelMorfologico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMorfologico.setBounds(10, 10, 366, 743);
		add(panelMorfologico);
		panelMorfologico.setLayout(null);
		
		//Panel com os dados do x,y
		JPanel panelSelecionaMorfologia = new JPanel();
		panelSelecionaMorfologia.setBounds(28, 22, 309, 140);
		panelSelecionaMorfologia.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMorfologico.add(panelSelecionaMorfologia);
		panelSelecionaMorfologia.setLayout(null);
		
		
		JLabel labelEscolha = new JLabel("Escolha o Operador");
		labelEscolha.setFont(new Font("Arial", Font.BOLD, 11));
		labelEscolha.setBounds(40, 38, 140, 13);
		panelSelecionaMorfologia.add(labelEscolha);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1- Eros?o", "2- Dilata??o", "3- Abertura ", "4- Fechamento ", "5- Gradiente ", "6- Operacao Top Hat ", "7- Operacao Bottom Hat "}));
		comboBox.setBounds(40, 58, 210, 21);
		panelSelecionaMorfologia.add(comboBox);
	
		
		//botao
		
		btnAplicaMorfologia = new JButton("Aplicar Operacao");
		btnAplicaMorfologia.setFont(new Font("Arial", Font.BOLD, 12));
		btnAplicaMorfologia.setBounds(70, 90, 140, 20);
		panelSelecionaMorfologia.add(btnAplicaMorfologia);
		

	}
	
}
