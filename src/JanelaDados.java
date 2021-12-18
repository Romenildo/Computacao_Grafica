/** 
 * Classe Janela Dados
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class JanelaDados extends JFrame{
	
	JLabel mousePosition;
	JLabel coordenadaMundo;
	JLabel coordenadaCentralizadaNormalizada;
	
	//MENU
	JMenuBar barra = new JMenuBar();
	
	JMenu menu1 = new JMenu("opceos");
	JMenu menu2 = new JMenu("Sair");
	
	JMenuItem item1 = new JMenuItem("inicio");
	
	
	public JanelaDados(String titulo) {
		super(titulo);
		//Menu
		setJMenuBar(barra);
		barra.add(menu1);
		barra.add(menu2);
		
		menu1.add(item1);
		
		//Eventos ao clicar
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		setSize (400, 200); 
		setVisible (true); 
		setLocationRelativeTo(null);//janela no centro da tela
		setResizable(true);//pode redimensionar janela	
		setLayout(new FlowLayout(1));

		mousePosition = new JLabel();
		add(mousePosition);

		
		coordenadaCentralizadaNormalizada = new JLabel();
		add(coordenadaCentralizadaNormalizada);
		

		coordenadaMundo = new JLabel();
		add(coordenadaMundo);
		

		
		//pesquisar como adicionar scrool bar na jframe
		
	}
}
