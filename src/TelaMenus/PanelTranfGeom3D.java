package TelaMenus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;

public class PanelTranfGeom3D extends JPanel {
	public PanelTranfGeom3D() {
	}

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public  ButtonGroup radiogrupo;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_8;

	
	private void PanelTranfGeom3D() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 400, 800);
		setSize(400,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Desenhar cubo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(132, 23, 124, 37);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("TRANSLA\u00C7\u00C3O");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(132, 88, 124, 31);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(35, 133, 58, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(168, 133, 58, 31);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(294, 133, 58, 31);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tx");
		lblNewLabel_1.setBounds(35, 117, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblTy = new JLabel("Ty");
		lblTy.setBounds(168, 117, 45, 13);
		frame.getContentPane().add(lblTy);
		
		JLabel lblTz = new JLabel("Tz");
		lblTz.setBounds(294, 117, 45, 13);
		frame.getContentPane().add(lblTz);
		
		JButton btnNewButton_1 = new JButton("Aplicar transla\u00E7\u00E3o");
		btnNewButton_1.setBounds(35, 174, 317, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblEscala = new JLabel("ESCALA");
		lblEscala.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEscala.setBounds(157, 215, 69, 31);
		frame.getContentPane().add(lblEscala);
		
		JLabel lblSx = new JLabel("Sx");
		lblSx.setBounds(35, 243, 45, 13);
		frame.getContentPane().add(lblSx);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(35, 259, 58, 31);
		frame.getContentPane().add(textField_3);
		
		JLabel lblSy = new JLabel("Sy");
		lblSy.setBounds(168, 243, 45, 13);
		frame.getContentPane().add(lblSy);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(168, 259, 58, 31);
		frame.getContentPane().add(textField_4);
		
		JLabel lblSz = new JLabel("Sz");
		lblSz.setBounds(294, 243, 45, 13);
		frame.getContentPane().add(lblSz);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(294, 259, 58, 31);
		frame.getContentPane().add(textField_5);
		
		JButton btnAplicarEscala = new JButton("Aplicar escala");
		btnAplicarEscala.setBounds(35, 300, 317, 21);
		frame.getContentPane().add(btnAplicarEscala);
		
		JLabel lblReflexo = new JLabel("REFLEX\u00C3O");
		lblReflexo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReflexo.setBounds(145, 343, 112, 31);
		frame.getContentPane().add(lblReflexo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Em XY");
		rdbtnNewRadioButton.setBounds(35, 387, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnEmYz = new JRadioButton("Em YZ");
		rdbtnEmYz.setBounds(157, 387, 58, 21);
		frame.getContentPane().add(rdbtnEmYz);
		
		JRadioButton rdbtnEmXz = new JRadioButton("Em XZ");
		rdbtnEmXz.setBounds(283, 387, 103, 21);
		frame.getContentPane().add(rdbtnEmXz);
		
		radiogrupo = new ButtonGroup();
		radiogrupo.add(rdbtnNewRadioButton);
		radiogrupo.add(rdbtnEmYz);
		radiogrupo.add(rdbtnEmXz);
		
		JButton btnAplicarReflexo = new JButton("Aplicar reflex\u00E3o");
		btnAplicarReflexo.setBounds(35, 414, 317, 21);
		frame.getContentPane().add(btnAplicarReflexo);
		
		JLabel lblRotao = new JLabel("ROTA\u00C7\u00C3O");
		lblRotao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRotao.setBounds(145, 458, 88, 31);
		frame.getContentPane().add(lblRotao);
		
		JButton button = new JButton("Aplicar reflex\u00E3o");
		button.setBounds(35, 552, 317, 21);
		frame.getContentPane().add(button);
		
		JRadioButton rdbtnEmZ = new JRadioButton("Em Z");
		rdbtnEmZ.setBounds(283, 485, 103, 21);
		frame.getContentPane().add(rdbtnEmZ);
		
		JRadioButton rdbtnEmY = new JRadioButton("Em Y");
		rdbtnEmY.setBounds(157, 485, 58, 21);
		frame.getContentPane().add(rdbtnEmY);
		
		JRadioButton rdbtnEmX = new JRadioButton("Em X");
		rdbtnEmX.setBounds(35, 485, 103, 21);
		frame.getContentPane().add(rdbtnEmX);
		
		JLabel lblngulo = new JLabel("\u00E2ngulo:");
		lblngulo.setBounds(116, 524, 45, 13);
		frame.getContentPane().add(lblngulo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(157, 515, 58, 31);
		frame.getContentPane().add(textField_6);
		
		JLabel lblCisalhamento = new JLabel("CISALHAMENTO");
		lblCisalhamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCisalhamento.setBounds(118, 593, 138, 31);
		frame.getContentPane().add(lblCisalhamento);
		
		JLabel lblCx = new JLabel("Cx");
		lblCx.setBounds(103, 630, 45, 13);
		frame.getContentPane().add(lblCx);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(103, 646, 58, 31);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(233, 646, 58, 31);
		frame.getContentPane().add(textField_8);
		
		JLabel lblCy = new JLabel("Cy");
		lblCy.setBounds(233, 630, 45, 13);
		frame.getContentPane().add(lblCy);
		
		JButton btnAplicarCisalhamento = new JButton("Aplicar cisalhamento");
		btnAplicarCisalhamento.setBounds(35, 687, 317, 21);
		frame.getContentPane().add(btnAplicarCisalhamento);
	}
}
