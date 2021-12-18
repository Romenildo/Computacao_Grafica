/** 
 * Classe Janela Dados
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.FailedLoginException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import TelaMenus.panelRetaDDA;


public class JanelaDados extends JFrame{
	JPanel panelPrincipal = new JPanel();
	
	JLabel mousePosition;
	JLabel coordenadaMundo;
	JLabel coordenadaCentralizadaNormalizada;
	
	panelRetaDDA menuRetaDDA = new panelRetaDDA();
	
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
		
		panelPrincipal.setBounds(100, 100, 366, 743);
		panelPrincipal.setBorder(new LineBorder(new Color(192, 192, 192), 6, true));
		add(panelPrincipal);
		
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
		item2D_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mudarPanelRetaDDA();
            }
        });
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 400, 800);
		setVisible (true); 
		setResizable(false);//pode redimensionar janela	
		setLayout(null);
		mousePosition = new JLabel();
		panelPrincipal.add(mousePosition);

		coordenadaCentralizadaNormalizada = new JLabel();
		panelPrincipal.add(coordenadaCentralizadaNormalizada);
		
		coordenadaMundo = new JLabel();
		panelPrincipal.add(coordenadaMundo);
	
	}
	
	//Funcoes
	private void mudarPanelPrincipal(JPanel panelRecebido) {
		panelPrincipal.removeAll();
		panelPrincipal.repaint();
		
		panelPrincipal.setLayout(new FlowLayout());
		//mudar layout grid ou felx
		panelPrincipal.add(panelRecebido);
		panelPrincipal.validate();
	}
	
	private void mudarPanelRetaDDA() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuRetaDDA);
	}
	
	
}
