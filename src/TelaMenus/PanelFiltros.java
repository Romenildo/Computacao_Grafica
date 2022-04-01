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
	public JComboBox comboBox;
	public JTextField campoA;
	
	
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
		panelSelecionaFiltros.setBounds(28, 22, 309, 140);
		panelSelecionaFiltros.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFiltros.add(panelSelecionaFiltros);
		panelSelecionaFiltros.setLayout(null);
		
		
		JLabel esolhaFiltro = new JLabel("Escolha o Filtro");
		esolhaFiltro.setFont(new Font("Arial", Font.BOLD, 11));
		esolhaFiltro.setBounds(40, 38, 140, 13);
		panelSelecionaFiltros.add(esolhaFiltro);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1- Media", "2- Mediana", "3- Passa alta basico ", "4- Operador de Robert's - X ", "5- Operador de Robert's - Y ","6- Operador de Robert's XY", "7- Operador de Prewitt - X", "8- Operador de Prewitt - Y" ,"9- Operador de Prewitt - XY", "10- Alto Reforço ", "11- Operador de Sobel",}));
		comboBox.setBounds(40, 58, 210, 21);
		panelSelecionaFiltros.add(comboBox);
	
		
		//botao
		
		btnAplicarFiltro = new JButton("Aplicar Filtro");
		btnAplicarFiltro.setFont(new Font("Arial", Font.BOLD, 12));
		btnAplicarFiltro.setBounds(70, 90, 140, 20);
		panelSelecionaFiltros.add(btnAplicarFiltro);
		
		
		//panel A
		JPanel panelValor = new JPanel();
		panelValor.setBounds(28, 170, 309, 60);
		panelValor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtro Alto reforco", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltros.add(panelValor);
		panelValor.setLayout(null);
		
		JLabel labelA = new JLabel(" A: ");
		labelA.setFont(new Font("Arial", Font.BOLD, 13));
		labelA.setBounds(30, 30, 45, 13);
		panelValor.add(labelA);
		
		campoA= new JTextField();
		campoA.setBounds(50, 27, 45, 21);//98 180
		panelValor.add(campoA);
		campoA.setColumns(6);
		

	}
	
}
