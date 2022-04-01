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
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelRitmoCardiaco extends JPanel {
	
	public JTextField campoX1Y1;
	public JSlider slider;
	public JButton btnIniciar;

	
	public PanelRitmoCardiaco() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelRitmoCardiaco = new JPanel();
		panelRitmoCardiaco.setBorder(new TitledBorder(null, "Ritmo Cardiaco", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelRitmoCardiaco.setBounds(10, 10, 366, 300);
		add(panelRitmoCardiaco);
		panelRitmoCardiaco.setLayout(null);
		
		JPanel panelConfigRitmo = new JPanel();
		panelConfigRitmo.setBounds(28, 22, 309, 80);
		panelConfigRitmo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRitmoCardiaco.add(panelConfigRitmo);
		panelConfigRitmo.setLayout(null);
		
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 12));
		btnIniciar.setBounds(100, 28, 108, 33);
		panelConfigRitmo.add(btnIniciar);
					
		
		}
}