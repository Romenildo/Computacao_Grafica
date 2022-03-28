package Janelas;

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

import TelaMenus.PanelCircunferenciaEE;
import TelaMenus.PanelCircunferenciaMT;
import TelaMenus.PanelCircunferenciaPM;
import TelaMenus.PanelElipse;
import TelaMenus.PanelSnowFlake;
import TelaMenus.panelCoordenadas;
import TelaMenus.panelRetaDDA;
import TelaMenus.panelRetaPontoMedio;


public class JanelaDados extends JFrame{
	JPanel panelPrincipal = new JPanel();
	
	//DECLARACAO DOS PANELs
	panelCoordenadas menuCoordenadas = new panelCoordenadas();
	public panelRetaDDA menuRetaDDA = new panelRetaDDA();
	public panelRetaPontoMedio menuRetaPontoMedio = new panelRetaPontoMedio();
	public PanelCircunferenciaEE menuCircunferenciaEE = new PanelCircunferenciaEE();
	public PanelCircunferenciaMT menuCircunferenciaMT = new PanelCircunferenciaMT();
	public PanelCircunferenciaPM menuCircunferenciaPM = new PanelCircunferenciaPM();
	public PanelElipse menuElipse = new PanelElipse();
	
	public PanelSnowFlake menuSnowFlake = new PanelSnowFlake();
	
	//DECLARACAO DOS MENUS
	JMenuBar barra = new JMenuBar();
	
	//--------ITENS DO MENU -----
	//menu opcoes
	JMenu menuOP = new JMenu("Opcoes");
	JMenuItem itemOP_inicio = new JMenuItem("Coordenadas");
	JMenuItem itemOP_limparTela = new JMenuItem("Limpar tela");
	JMenuItem itemOP_sair = new JMenuItem("Sair");
	
	//menu 2d
	JMenu menu2D = new JMenu("Gráficos 2D");
	JMenuItem item2D_retaDDA = new JMenuItem("Reta DDA");
	JMenuItem item2D_retaPM = new JMenuItem("Reta Ponto Médio");
	JMenuItem item2D_CircEE = new JMenuItem("Circunferência Equação Explícita");
	JMenuItem item2D_CircMT = new JMenuItem("Circunferência Método Trigonométrico");
	JMenuItem item2D_CircPM = new JMenuItem("Circunferência Ponto médio");
	JMenuItem item2D_Elipse = new JMenuItem("Elipse");
	
	JMenu menuMais = new JMenu("Mais");
	JMenuItem itemMais_snow = new JMenuItem("Koch SnowFlake");
	
	
	public JanelaDados(String titulo) {
		super(titulo);
		
		panelPrincipal.setBounds(100, 100, 366, 743);
		panelPrincipal.setBorder(new LineBorder(new Color(192, 192, 192), 6, true));
		add(panelPrincipal);
	
		
		//  ---ADICIONAR ITENS DAS OPCOES DO MENU
		setJMenuBar(barra);
		
		//menu opcoes
		barra.add(menuOP);
		menuOP.add(itemOP_inicio);
		menuOP.add(itemOP_limparTela);
		menuOP.add(itemOP_sair);
		
		//menu graficos2D
		barra.add(menu2D);
		menu2D.add(item2D_retaDDA);
		menu2D.add(item2D_retaPM);
		menu2D.add(item2D_CircEE);
		menu2D.add(item2D_CircMT);
		menu2D.add(item2D_CircPM);
		menu2D.add(item2D_Elipse);
		
		//menu MAIS
		barra.add(menuMais);
		menuMais.add(itemMais_snow);

		//   ---EVENTOS AO CLICAR NAS OPCOES DO MENU
		// tela das coordenadas
		itemOP_inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mudarPanelCoordenadas();
            }
        });
		//fechar o programa
		itemOP_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//tela Reta DDa
		item2D_retaDDA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mudarPanelRetaDDA();
            }
        });
		//tela reta ponto medio
		item2D_retaPM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mudarPanelRetaPontoMedio();
            }
        });
		//tela circunferencia EE
		item2D_CircEE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mudarPanelCircunferenciaEE();
            }
        });
		//tela circunferencia MT
		item2D_CircMT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mudarPanelCircunferenciaMT();
            }
        });
		//tela circunferencia PM
		item2D_CircPM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mudarPanelCircunferenciaPM();
            }
        });
		//tela Elipse
		item2D_Elipse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mudarPanelElipse();
            }
        });
		//tela koch snowflake
		itemMais_snow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mudarPanelKochSnowFlake();
            }
        });
		// --- FIM DOS EVENTOS DO MENU
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		setBounds(800, 0, 400, 800);
		setVisible (true); 
		setResizable(false);
		setLayout(null);
	
	}// fim construtor
	
	//   ----- FUNCOES PARA MUDAR O PANEL DA JANELA OPCOES
	private void mudarPanelPrincipal(JPanel panelRecebido) {
		menuRetaDDA.checkBoxMouse.setSelected(false);
		menuRetaPontoMedio.checkBoxMouse.setSelected(false);
		
		panelPrincipal.removeAll();
		panelPrincipal.repaint();
		
		panelPrincipal.setLayout(null);
		
		panelPrincipal.add(panelRecebido);
		panelPrincipal.validate();
		
	}
	
	private void mudarPanelRetaDDA() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuRetaDDA);
	}
	
	private void mudarPanelCoordenadas() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuCoordenadas);
	}
	
	private void mudarPanelRetaPontoMedio() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuRetaPontoMedio);
	}
	
	private void mudarPanelCircunferenciaEE() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuCircunferenciaEE);
	}
	
	private void mudarPanelCircunferenciaMT() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuCircunferenciaMT);
	}
	
	private void mudarPanelCircunferenciaPM() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuCircunferenciaPM);
	}
	private void mudarPanelElipse() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuElipse);
	}
	
	private void mudarPanelKochSnowFlake() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuSnowFlake);
	}
}
