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

import TelaMenus.JanelaFiltros;
import TelaMenus.JanelaHistograma;
import TelaMenus.JanelaMorfologicos;
import TelaMenus.JanelaMorfologicosBinario;
import TelaMenus.JanelaOperacoes;
import TelaMenus.JanelaProcessamento;
import TelaMenus.PanelCircunferenciaEE;
import TelaMenus.PanelCircunferenciaMT;
import TelaMenus.PanelCircunferenciaPM;
import TelaMenus.PanelElipse;
import TelaMenus.PanelFiltros;
import TelaMenus.PanelHistograma;
import TelaMenus.PanelMorfologico;
import TelaMenus.PanelMorfologicoBinario;
import TelaMenus.PanelOperacoes;
import TelaMenus.PanelProcessamento;
import TelaMenus.PanelRitmoCardiaco;
import TelaMenus.PanelSnowFlake;
import TelaMenus.PanelTransfGeom;
import TelaMenus.PanelTransfGeom3D;
import TelaMenus.PanelTransfGeomComp2;
import TelaMenus.panelCoordenadas;
import TelaMenus.panelRetaDDA;
import TelaMenus.panelRetaPontoMedio;
import Uteis.RitmoCardiaco;



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
	public PanelFiltros menuFiltro = new PanelFiltros();
	public PanelOperacoes menuOperacoes = new PanelOperacoes();
	public PanelProcessamento menuProcessamento = new PanelProcessamento();
	public PanelHistograma menuHistograma = new PanelHistograma();
	public PanelMorfologico menuMorfologico = new PanelMorfologico();
	public PanelMorfologicoBinario menuMorfologicoBinario = new PanelMorfologicoBinario();
	
	
	public JanelaFiltros janelaFiltro = new JanelaFiltros();
	public JanelaOperacoes janelaOperacao = new JanelaOperacoes();
	public JanelaProcessamento janelaProcessamento = new JanelaProcessamento();
	public JanelaHistograma janelaHistograma = new JanelaHistograma();
	public JanelaMorfologicos janelaMorfologico= new JanelaMorfologicos();
	public JanelaMorfologicosBinario janelaMorfologicoBinario= new JanelaMorfologicosBinario();
	
	JanelaImagens janelaImagens = new JanelaImagens("imagens");  
	
	public PanelSnowFlake menuSnowFlake = new PanelSnowFlake();
	public PanelRitmoCardiaco menuRitmoCardiaco = new PanelRitmoCardiaco();
	
	//TRANSFORMACOES
	public PanelTransfGeom menuTransfGeom = new PanelTransfGeom();
	public PanelTransfGeomComp2 menuTransfGeomComp = new PanelTransfGeomComp2();
	public PanelTransfGeom3D menuTransfGeom3D = new PanelTransfGeom3D();
	
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
	JMenuItem item2D_TransfGeom = new JMenuItem("Transformações Geométricas");
	JMenuItem item2D_TransfGeomComp = new JMenuItem("Transformações Geométricas Compostas");
	
	// menu 3d
	JMenu menu3D = new JMenu("Gráficos 3D");
	JMenuItem item3D_TransfGeom = new JMenuItem("Transformações Geométricas(Incompleto)");
		
	//menu imagens
	JMenu menuImagens = new JMenu("Imagens");
	JMenuItem itemImg_filtros = new JMenuItem("Filtros");
	JMenuItem itemImg_operacoes = new JMenuItem("Operações");
	JMenuItem itemImg_processos = new JMenuItem("Processos");
	JMenuItem itemImg_histograma = new JMenuItem("Equalizar");
	JMenuItem itemImg_morfologico = new JMenuItem("Operadores Morfologicos- Cinza");
	JMenuItem itemImg_morfologicoBinario = new JMenuItem("Operadores Morfologicos- Binario");
	
	//menu mais
	JMenu menuMais = new JMenu("Mais");
	JMenuItem itemMais_snow = new JMenuItem("Koch SnowFlake");
	JMenuItem itemMais_ritmo = new JMenuItem("Ritmo Cardiaco");
	
	
	
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
		menu2D.add(item2D_TransfGeom);
		menu2D.add(item2D_TransfGeomComp);

		// menu graficos3D
		barra.add(menu3D);
		menu3D.add(item3D_TransfGeom);
		
		//menu Imagens
		barra.add(menuImagens);
		menuImagens.add(itemImg_filtros);
		menuImagens.add(itemImg_operacoes);
		menuImagens.add(itemImg_processos);
		menuImagens.add(itemImg_histograma);
		menuImagens.add(itemImg_morfologico);
		menuImagens.add(itemImg_morfologicoBinario);
		
		//menu MAIS
		barra.add(menuMais);
		menuMais.add(itemMais_snow);
		menuMais.add(itemMais_ritmo);


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
		// tela Transformações Geométricas
		item2D_TransfGeom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarPanelTransfGeom();
			}
		});

		// tela Transformações Geométricas
		item2D_TransfGeomComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarPanelTransfGeomComp();
			}
		});

		// tela Transformações Geométricas 3D
		item3D_TransfGeom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarPanelTransfGeom3D();
			}
		});
		
		//tela Filtros
		itemImg_filtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         mudarPanelFiltros();
		    }
		 });
		
		//tela operacoes
		itemImg_operacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  mudarPanelOperacoes();
			}
		});
		//tela processamento
		itemImg_processos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarPanelProcessamento();
			}
		});
		//tela histograma
		itemImg_histograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarPanelHistograma();
			}
		});
		//tela Morfologico
		itemImg_morfologico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarPanelMorfologia();
			}
		});
		itemImg_morfologicoBinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarPanelMorfologiaBinario();
			}
		});
	
		
		//tela koch snowflake
		itemMais_snow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mudarPanelKochSnowFlake();
            }
        });
		//tela Ritmo Cardiaco
		itemMais_ritmo.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		    	 mudarPanelRitmoCardiaco();
		     }
		 });
		
		//evento imagens
		
		menuFiltro.btnAplicarFiltro.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		double coefA =0;
	    		
	    		int indiceSelecionado = menuFiltro.comboBox.getSelectedIndex();
	    		if(indiceSelecionado == 9) {
	    			coefA = Double.valueOf(menuFiltro.campoA.getText());
	    		}
	    		janelaFiltro.aplicarFiltros(evt, indiceSelecionado, coefA);
	    	}	
	     });
		menuOperacoes.btnAplicarOperacao.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		int indiceSelecionado = menuOperacoes.comboBox.getSelectedIndex();
	    		janelaOperacao.aplicarOperacoes(evt, indiceSelecionado);
	    	}	
	     });
		menuProcessamento.btnAtivarProcesso.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		double gamma=0, w_target = 0;
	    		int a_log=10, sigma=0, w=0, a_linear=0, b_linear=0;
	    		int indiceSelecionado = menuProcessamento.comboBox.getSelectedIndex();

	    		if(indiceSelecionado == 1) {
	    			gamma = Double.valueOf(menuProcessamento.campoGamma.getText());
	    		}
	    		if(indiceSelecionado == 2) {
	    			//logaritmo
	    			a_log = Integer.valueOf(menuProcessamento.campoLog.getText());
	    		}
	    		if(indiceSelecionado == 3) {
	    			//intensidade
	    			sigma = Integer.valueOf(menuProcessamento.campoSigma.getText());
	    			w = Integer.valueOf(menuProcessamento.campoW.getText());
	    		}
	    		if(indiceSelecionado == 4) {
	    			//faixa dinamica
	    			w_target = Integer.valueOf(menuProcessamento.campoTarget.getText());
	    		}
	    		if(indiceSelecionado == 5) {
	    			//faixa dinamica
	    			a_linear= Integer.valueOf(menuProcessamento.campoA.getText());
	    			b_linear = Integer.valueOf(menuProcessamento.campoB.getText());
	    		}
	    		
	    		janelaProcessamento.aplicarProcessamentos(evt, indiceSelecionado,gamma, a_log,sigma, w, w_target, a_linear, b_linear);
	    	}	
	     });
		menuHistograma.btnIniciarHistograma.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		janelaHistograma.iniciarEqualizacao(evt);
	    	}	
	     });
		
		menuMorfologico.btnAplicaMorfologia.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		int indiceSelecionado = menuMorfologico.comboBox.getSelectedIndex();
	    		janelaMorfologico.aplicarMorfologia(evt, indiceSelecionado);
	    	}	
	     });
		menuMorfologicoBinario.btnAplicaMorfologia.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		int indiceSelecionado = menuMorfologicoBinario.comboBox.getSelectedIndex();
	    		
	    		int pixel_desejado = Integer.valueOf(menuMorfologicoBinario.campoPixel.getText());

	    		if(pixel_desejado==0 || pixel_desejado==255) {
	    			janelaMorfologicoBinario.aplicarMorfologia(evt, indiceSelecionado, pixel_desejado);
	    		}
	    		
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
	
	private void mudarPanelVisualizacao(JPanel panelRecebido) {
		
		if(janelaImagens.ativada==false) {
			janelaImagens.start();
			janelaImagens.ativada = true;
		}
		 
		janelaImagens.panelPrincipal.removeAll();
		janelaImagens.panelPrincipal.repaint();
		
		janelaImagens.panelPrincipal.setLayout(null);
		janelaImagens.panelPrincipal.add(panelRecebido);
		janelaImagens.panelPrincipal.validate();
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
	private void mudarPanelTransfGeom() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuTransfGeom);
	}
	
	private void mudarPanelTransfGeomComp() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuTransfGeomComp);
	}

	private void mudarPanelTransfGeom3D() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuTransfGeom3D);
	}
	private void mudarPanelElipse() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuElipse);
	}
	private void mudarPanelFiltros() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuFiltro);
		mudarPanelVisualizacao(janelaFiltro);
	}
	private void mudarPanelOperacoes() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuOperacoes);
		mudarPanelVisualizacao(janelaOperacao);
	}
	private void mudarPanelProcessamento() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuProcessamento);
		mudarPanelVisualizacao(janelaProcessamento);
	}
	private void mudarPanelHistograma() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuHistograma);
		mudarPanelVisualizacao(janelaHistograma);
	}
	private void mudarPanelMorfologia() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuMorfologico);
		mudarPanelVisualizacao(janelaMorfologico);
	}
	private void mudarPanelMorfologiaBinario() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuMorfologicoBinario);
		mudarPanelVisualizacao(janelaMorfologicoBinario);
		menuMorfologicoBinario.campoPixel.setText("0");
	}
	
	private void mudarPanelKochSnowFlake() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuSnowFlake);
	}
	private void mudarPanelRitmoCardiaco() {
		panelPrincipal.setVisible(true);
		mudarPanelPrincipal(menuRitmoCardiaco);
	}
}
