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

public class PanelProcessamento extends JPanel {
	
	public JTable tabela;
	public JCheckBox checkBoxMouse;
	public JButton btnAtivarProcesso;
	public JComboBox comboBox;
	//campos de valores
	public JTextField campoGamma;
	public JTextField campoLog;
	public JTextField campoSigma;
	public JTextField campoW;
	public JTextField campoTarget;
	public JTextField campoA;
	public JTextField campoB;
	
	
	public PanelProcessamento() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelProcesso = new JPanel();
		panelProcesso.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Processamentos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcesso.setBounds(10, 10, 366, 743);
		add(panelProcesso);
		panelProcesso.setLayout(null);
		
		//Panel com os dados do x,y
		JPanel panelSelecionaProcesso = new JPanel();
		panelSelecionaProcesso.setBounds(28, 22, 309, 140);
		panelSelecionaProcesso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelProcesso.add(panelSelecionaProcesso);
		panelSelecionaProcesso.setLayout(null);
		
		
		JLabel escolhaOperacao = new JLabel("Escolha o Processo");
		escolhaOperacao.setFont(new Font("Arial", Font.BOLD, 11));
		escolhaOperacao.setBounds(40, 38, 140, 13);
		panelSelecionaProcesso.add(escolhaOperacao);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1- Negativo", "2- Gamma", "3- Logaritmo", "4- Trans. de intensidade", "5- Trans. faixa Dinamica", "6- Trans. Linear"}));
		comboBox.setBounds(40, 58, 210, 21);
		panelSelecionaProcesso.add(comboBox);
		
		
		btnAtivarProcesso = new JButton("AtivarProcesso");
		btnAtivarProcesso.setFont(new Font("Arial", Font.BOLD, 12));
		btnAtivarProcesso.setBounds(70, 90, 140, 20);
		panelSelecionaProcesso.add(btnAtivarProcesso);
		
		//panel GAMMA
		JPanel panelValor = new JPanel();
		panelValor.setBounds(28, 170, 309, 60);
		panelValor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gamma", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcesso.add(panelValor);
		panelValor.setLayout(null);
				
		JLabel labelA = new JLabel(" valor de c: (0<= c >= 1) ");
		labelA.setFont(new Font("Arial", Font.BOLD, 13));
		labelA.setBounds(30, 30, 180, 13);
		panelValor.add(labelA);
				
		campoGamma= new JTextField();
		campoGamma.setBounds(170, 27, 45, 21);//98 180
		panelValor.add(campoGamma);
		campoGamma.setColumns(6);	
		
		
		//panel Logaritmo
		JPanel panelLog = new JPanel();
		panelLog.setBounds(28, 230, 309, 60);
		panelLog.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "logaritma", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcesso.add(panelLog);
		panelLog.setLayout(null);
								
		JLabel labelLog = new JLabel("Valor de a: ");
		labelLog.setFont(new Font("Arial", Font.BOLD, 13));
		labelLog.setBounds(30, 30, 180, 13);
		panelLog.add(labelLog);
								
		campoLog= new JTextField();
		campoLog.setBounds(100, 27, 45, 21);//98 180
		panelLog.add(campoLog);
		campoLog.setColumns(6);	
		
		
		//panel Transferencia de intensidade
		JPanel panelIntensidade = new JPanel();
		panelIntensidade.setBounds(28, 290, 309, 80);
		panelIntensidade.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Trans. de intensidade", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcesso.add(panelIntensidade);
		panelIntensidade.setLayout(null);
						
		JLabel labelSigma = new JLabel("Sigma: ");
		labelSigma.setFont(new Font("Arial", Font.BOLD, 13));
		labelSigma.setBounds(30, 30, 180, 13);
		panelIntensidade.add(labelSigma);
						
		campoSigma= new JTextField();
		campoSigma.setBounds(80, 27, 45, 21);
		panelIntensidade.add(campoSigma);
		campoSigma.setColumns(6);	
		
		JLabel labelW = new JLabel("W: ");
		labelW.setFont(new Font("Arial", Font.BOLD, 13));
		labelW.setBounds(40, 55, 180, 13);
		panelIntensidade.add(labelW);
						
		campoW= new JTextField();
		campoW.setBounds(80, 50, 45, 21);
		panelIntensidade.add(campoW);
		campoW.setColumns(6);
		
		
		//panel Faixa Dinamica
		JPanel panelTarget = new JPanel();
		panelTarget.setBounds(28, 370, 309, 60);
		panelTarget.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Trans. Faixa Dinamica", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcesso.add(panelTarget);
		panelTarget.setLayout(null);
										
		JLabel labelTarget = new JLabel("Valor de w_target: ");
		labelTarget.setFont(new Font("Arial", Font.BOLD, 13));
		labelTarget.setBounds(30, 30, 180, 13);
		panelTarget.add(labelTarget);
										
		campoTarget= new JTextField();
		campoTarget.setBounds(150, 27, 45, 21);
		panelTarget.add(campoTarget);
		campoTarget.setColumns(6);	
		
		//panel Faixa Dinamica
		JPanel panelLinear = new JPanel();
		panelLinear.setBounds(28, 430, 309, 60);
		panelLinear.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Trans. linear", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcesso.add(panelLinear);
		panelLinear.setLayout(null);
												
		JLabel labelA1 = new JLabel(" A: ");
		labelA1.setFont(new Font("Arial", Font.BOLD, 13));
		labelA1.setBounds(30, 30, 180, 13);
		panelLinear.add(labelA1);
												
		campoA= new JTextField();
		campoA.setBounds(55, 27, 45, 21);
		panelLinear.add(campoA);
		campoA.setColumns(6);	
		
		JLabel labelB1 = new JLabel(" B: ");
		labelB1.setFont(new Font("Arial", Font.BOLD, 13));
		labelB1.setBounds(120, 30, 180, 13);
		panelLinear.add(labelB1);
												
		campoB= new JTextField();
		campoB.setBounds(145, 27, 45, 21);
		panelLinear.add(campoB);
		campoB.setColumns(6);	

	}
	
}
