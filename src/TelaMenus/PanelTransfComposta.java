package TelaMenus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelTransfComposta {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelTransfComposta window = new PanelTransfComposta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelTransfComposta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 65, 251, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Escolha as transforma\u00E7\u00F5es");
		lblNewLabel.setBounds(66, 47, 171, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(66, 108, 126, 21);
		frame.getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(66, 239, 257, 183);
		frame.getContentPane().add(list);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(66, 432, 126, 21);
		frame.getContentPane().add(btnAplicar);
	}
}
