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
	
	//--------ITENS DO MENU -----
	//menu opcoes
	JMenu menuOP = new JMenu("Opcoes");
	JMenuItem itemOP_1 = new JMenuItem("Início");
	JMenuItem itemOP_2 = new JMenuItem("Limpar tela");
	
	//menu 2d
	JMenu menu2D = new JMenu("Gráficos 2D");
	JMenuItem item2D_1 = new JMenuItem("Reta DDA");
	JMenuItem item2D_2 = new JMenuItem("Reta Ponto Médio");
	JMenuItem item2D_3 = new JMenuItem("Circunferência Equação Explícita");
	JMenuItem item2D_4 = new JMenuItem("Circunferência Método Trigonométrico");
	JMenuItem item2D_5 = new JMenuItem("Circunferência Ponto médio");
	JMenuItem item2D_6 = new JMenuItem("Elipse Ponto Médio");
	
	//menu Sair
	JMenu menuSair = new JMenu("Sair");
	JMenuItem itemSair = new JMenuItem("Sair");
	
	public JanelaDados(String titulo) {
		super(titulo);
		
		//Menu
		setJMenuBar(barra);
		
		barra.add(menuOP);
		menuOP.add(itemOP_1);
		menuOP.add(itemOP_2);
		
		barra.add(menu2D);
		menu2D.add(item2D_1);
		menu2D.add(item2D_2);
		menu2D.add(item2D_3);
		menu2D.add(item2D_4);
		menu2D.add(item2D_5);
		menu2D.add(item2D_6);
		
		barra.add(menuSair);
		menuSair.add(itemSair);
		
		//Eventos ao clicar
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		setSize (400, 800); 
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

		
	}
}
