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

public class PanelOperacoes extends JPanel {
	
	public JTable tabela;
	public JCheckBox checkBoxMouse;
	public JButton btnAplicarOperacao;
	public JComboBox comboBox;
	
	
	public PanelOperacoes() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelFiltros = new JPanel();
		panelFiltros.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Operacoes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltros.setBounds(10, 10, 366, 743);
		add(panelFiltros);
		panelFiltros.setLayout(null);
		
		//Panel com os dados do x,y
		JPanel panelSelecionaOperacao = new JPanel();
		panelSelecionaOperacao.setBounds(28, 22, 309, 140);
		panelSelecionaOperacao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFiltros.add(panelSelecionaOperacao);
		panelSelecionaOperacao.setLayout(null);
		
		
		JLabel escolhaOperacao = new JLabel("Escolha a operacao");
		escolhaOperacao.setFont(new Font("Arial", Font.BOLD, 11));
		escolhaOperacao.setBounds(40, 38, 140, 13);
		panelSelecionaOperacao.add(escolhaOperacao);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1- Soma", "2- Subtracao", "3- Multiplicacao", "4- Divisao", "5- OR", "6- AND", "7- XOR"}));
		comboBox.setBounds(40, 58, 210, 21);
		panelSelecionaOperacao.add(comboBox);
		
		
		btnAplicarOperacao = new JButton("Aplicar operacao");
		btnAplicarOperacao.setFont(new Font("Arial", Font.BOLD, 12));
		btnAplicarOperacao.setBounds(70, 90, 140, 20);
		panelSelecionaOperacao.add(btnAplicarOperacao);
		

	}
	
}
