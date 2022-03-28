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

public class PanelSnowFlake extends JPanel {
	
	public JTextField campoX1Y1;
	public JSlider slider;
	public JButton btnDesenhar;

	
	public PanelSnowFlake() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelSnowFlake = new JPanel();
		panelSnowFlake.setBorder(new TitledBorder(null, "Koch SnowFlake", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelSnowFlake.setBounds(10, 10, 366, 743);
		add(panelSnowFlake);
		panelSnowFlake.setLayout(null);
		
		JPanel panelConfigSnow = new JPanel();
		panelConfigSnow.setBounds(28, 22, 309, 167);
		panelConfigSnow.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelSnowFlake.add(panelConfigSnow);
		panelConfigSnow.setLayout(null);
		
		
		JLabel labelSnow = new JLabel("Interacoes");
		labelSnow.setFont(new Font("Arial", Font.ITALIC, 13));
		labelSnow.setBounds(55, 30, 70, 30);
		panelConfigSnow.add(labelSnow);
		
		JLabel labelNumInteracoes = new JLabel("1 ___ 2 ___ 3 ___ 4 ___ 5 ___ 6");
		labelNumInteracoes.setFont(new Font("Arial", Font.ITALIC, 13));
		labelNumInteracoes.setBounds(63, 46, 200, 30);
		panelConfigSnow.add(labelNumInteracoes);
		
		slider = new JSlider();
		slider.setMaximum(5);
		slider.setBounds(56, 70, 195, 28);
		panelConfigSnow.add(slider);
		
		
		btnDesenhar = new JButton("Desenhar");
		btnDesenhar.setFont(new Font("Arial", Font.BOLD, 12));
		btnDesenhar.setBounds(92, 124, 108, 33);
		panelConfigSnow.add(btnDesenhar);
					
		
		}
}
