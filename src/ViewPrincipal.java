import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Canvas;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class ViewPrincipal {

	private JFrame frmCoordenadas;
	private JTextField campoXY;
	private JTextField campoRaio;
	private JTable tabela;
	private JTextField campoD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal window = new ViewPrincipal();
					window.frmCoordenadas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoordenadas = new JFrame();
		frmCoordenadas.setTitle("Coordenadas");
		frmCoordenadas.setBounds(100, 100, 400, 800);
		frmCoordenadas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoordenadas.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new LineBorder(new Color(192, 192, 192), 6, true));
		frmCoordenadas.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel panelCircunferenciaPM = new JPanel();
		panelCircunferenciaPM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Circunfer\u00EAncia P.M", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCircunferenciaPM.setBounds(10, 10, 366, 743);
		panelPrincipal.add(panelCircunferenciaPM);
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
		
		JButton btnDesenhar = new JButton("Desenhar");
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
		scrollTabela.setBounds(31, 25, 222, 91);
		panelTabela.add(scrollTabela);
		
		tabela = new JTable();
		tabela.setRowSelectionAllowed(false);
		scrollTabela.setViewportView(tabela);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setFont(new Font("Arial", Font.PLAIN, 12));
		tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabela.setBackground(Color.WHITE);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"a", "b"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabela.getColumnModel().getColumn(1).setMinWidth(18);
	}
}
