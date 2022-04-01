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

public class PanelMorfologicoBinario extends JPanel {
	
	public JCheckBox checkBoxMouse;
	public JButton btnAplicaMorfologia;
	public JComboBox comboBox;
	public JTextField campoPixel;
	
	
	public PanelMorfologicoBinario() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelMorfologico = new JPanel();
		panelMorfologico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Morfologico binario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1- Erosão", "2- Dilatação", "3- Abertura ", "4- Fechamento ", "5- Gradiente ", "6- Contorno Interno ", "7- Contorno Externo ", "8- Operacao Top Hat ", "9- Operacao Bottom Hat","10- Original"}));
		comboBox.setBounds(40, 58, 210, 21);
		panelSelecionaMorfologia.add(comboBox);
	
		
		//botao
		
		btnAplicaMorfologia = new JButton("Aplicar Operacao");
		btnAplicaMorfologia.setFont(new Font("Arial", Font.BOLD, 12));
		btnAplicaMorfologia.setBounds(70, 90, 140, 20);
		panelSelecionaMorfologia.add(btnAplicaMorfologia);
		
		//panel Pixel
		JPanel panelValor = new JPanel();
		panelValor.setBounds(28, 170, 309, 60);
		panelValor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pixel", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMorfologico.add(panelValor);
		panelValor.setLayout(null);
						
		JLabel labelA = new JLabel(" Valor desejado: ( 0  ||  255) ");
		labelA.setFont(new Font("Arial", Font.BOLD, 13));
		labelA.setBounds(30, 30, 180, 13);
		panelValor.add(labelA);
						
		campoPixel= new JTextField();
		campoPixel.setBounds(200, 27, 45, 21);
		panelValor.add(campoPixel);
		campoPixel.setColumns(6);	
		

	}
	
}
