/** 
 * Classe Janela principal
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;



public class JanelaPrincipal extends JFrame implements MouseListener, MouseMotionListener {

	JanelaConfig janelaConfig;
	JanelaDados janelaDados;
	JanelaPrincipal principal = this;
	int[] coordReta = new int[4]; 
	int[] coordPoligono = new int[4];
	int ponteiroCoordReta = 0; 
	int ponteiroCoordPoligono = 0;
	
	//global
	static int tamanhoTelaX;
	static int tamanhoTelaY;

	public JanelaPrincipal(String titulo) {
		super(titulo);
		
		this.janelaConfig = new JanelaConfig();
		this.janelaDados  = new JanelaDados("Computação Gráfica - Dados");	
    	
		// --- AÇÕES DAS JANELAS ---
		//limpar tela ao clicar na opcao
		janelaDados.itemOP_limparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		//desenhar a RETA DDA ao clicar no botao desenhar
		janelaDados.menuRetaDDA.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] coordRetaDDA = {tamanhoTelaX/2, tamanhoTelaY/2,tamanhoTelaX/2, tamanhoTelaY/2};
				
				String [] stringSeparada =janelaDados.menuRetaDDA.campoX1Y1.getText().split(",");
				String [] stringSeparada2 = janelaDados.menuRetaDDA.campoX2Y2.getText().split(",");
				
				if(stringSeparada.length == 2 && stringSeparada2.length == 2) {
					coordRetaDDA[0] += Integer.parseInt(stringSeparada[0]);
					coordRetaDDA[1] += Integer.parseInt(stringSeparada[1])*-1;
					coordRetaDDA[2] += Integer.parseInt(stringSeparada2[0]);
					coordRetaDDA[3] += Integer.parseInt(stringSeparada2[1])*-1;
				}else {
					System.out.println("parametro errado somente x,y");
				}
				
				//chama a funcao de desenho
				desenharRetaDDA(coordRetaDDA);
			}
		});
		//desenhar a RETA Ponto Medio ao clicar no botao desenhar
				janelaDados.menuRetaPontoMedio.btnDesenhar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int[] coordRetaPM = {tamanhoTelaX/2, tamanhoTelaY/2,tamanhoTelaX/2, tamanhoTelaY/2};
						
						String [] stringSeparada =janelaDados.menuRetaPontoMedio.campoX1Y1.getText().split(",");
						String [] stringSeparada2 = janelaDados.menuRetaPontoMedio.campoX2Y2.getText().split(",");
						
						if(stringSeparada.length == 2 && stringSeparada2.length == 2) {
							coordRetaPM[0] += Integer.parseInt(stringSeparada[0]);
							coordRetaPM[1] += Integer.parseInt(stringSeparada[1])*-1;
							coordRetaPM[2] += Integer.parseInt(stringSeparada2[0]);
							coordRetaPM[3] += Integer.parseInt(stringSeparada2[1])*-1;
						}else {
							System.out.println("parametro errado somente x,y");
						}
						
						//chama a funcao de desenho
						desenharRetaPontoMedio(coordRetaPM);
					}
				});
			
		//desenhar a circunferencia (EQUACAO EXPLICITA) ao clicar no botao desenhar
		janelaDados.menuCircunferenciaEE.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pegar os valores dos campos graficos
				int posicoes[] = {tamanhoTelaX/2, tamanhoTelaY/2};
				String [] stringSeparada =janelaDados.menuCircunferenciaMT.campoXY.getText().split(",");
				if(stringSeparada.length == 2) {
					posicoes[0] += Integer.parseInt(stringSeparada[0]);
					posicoes[1] += Integer.parseInt(stringSeparada[1])*-1;
				}else {
					System.out.println("parametro errado somente x,y");
				}
				int raio = Integer.parseInt(janelaDados.menuCircunferenciaMT.campoRaio.getText());
				
				//chama a funcao de desenho
				desenhaCircunferenciaMT(raio,posicoes[0],posicoes[1]);
			}
		});
		
			//desenhar a circunferencia (METODO TRIGONOMETRICO) ao clicar no botao desenhar
			janelaDados.menuCircunferenciaMT.btnDesenhar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//pegar os valores dos campos graficos
					int posicoes[] = {tamanhoTelaX/2, tamanhoTelaY/2};
					String [] stringSeparada =janelaDados.menuCircunferenciaMT.campoXY.getText().split(",");
					if(stringSeparada.length == 2) {
						posicoes[0] += Integer.parseInt(stringSeparada[0]);
						posicoes[1] += Integer.parseInt(stringSeparada[1])*-1;
					}else {
						System.out.println("parametro errado somente x,y");
					}
					int raio = Integer.parseInt(janelaDados.menuCircunferenciaMT.campoRaio.getText());
					
					//chama a funcao de desenho
					desenhaCircunferenciaMT(raio,posicoes[0],posicoes[1]);
				}
			});
			
			//desenhar a circunferencia (PONTO MEDIO) ao clicar no botao desenhar
			janelaDados.menuCircunferenciaPM.btnDesenhar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//pegar os valores dos campos graficos
					int posicoes[] = {tamanhoTelaX/2, tamanhoTelaY/2};
					String [] stringSeparada =janelaDados.menuCircunferenciaPM.campoXY.getText().split(",");
					if(stringSeparada.length == 2) {
						posicoes[0] += Integer.parseInt(stringSeparada[0]);
						posicoes[1] += Integer.parseInt(stringSeparada[1])*-1;
					}else {
						System.out.println("parametro errado somente x,y");
					}
					int raio = Integer.parseInt(janelaDados.menuCircunferenciaPM.campoRaio.getText());
					
					//chama a funcao de desenho
					desenhaCircunferenciaPM(raio,posicoes[0],posicoes[1]);
				}
			});
	}// fim do construtor

	//	----MOUSE EVENTS----
	@Override
	public void mouseClicked(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("Mouse clicado na coordenada : [" + e.getX() + "," + e.getY() + "]");
		drawPixel(e.getX(),e.getY());
		//Reta DDA
		if(janelaDados.menuRetaDDA.checkBoxMouse.isSelected()) {
			coordPoligono[ponteiroCoordPoligono] = e.getX();
			coordPoligono[ponteiroCoordPoligono + 1] = e.getY();
			ponteiroCoordPoligono = ponteiroCoordPoligono + 2;
			janelaDados.menuRetaDDA.campoX1Y1.setText((coordPoligono[0]-tamanhoTelaX/2) +","+ ((coordPoligono[1]-tamanhoTelaY/2)*(-1)));
			if ( ponteiroCoordPoligono == 4) {	
				
				janelaDados.menuRetaDDA.campoX2Y2.setText((coordPoligono[2]-tamanhoTelaX/2)+","+ ((coordPoligono[3]-tamanhoTelaY/2)*(-1)));
				
				desenharRetaDDA(coordPoligono);
				
				coordPoligono[0] = coordPoligono[2];
				coordPoligono[1] = coordPoligono[3];
				ponteiroCoordPoligono = 2;
			}
		}
		//Reta Ponto medio
		if(janelaDados.menuRetaPontoMedio.checkBoxMouse.isSelected()) {
			coordPoligono[ponteiroCoordPoligono] = e.getX();
			coordPoligono[ponteiroCoordPoligono + 1] = e.getY();
			ponteiroCoordPoligono = ponteiroCoordPoligono + 2;
			
			janelaDados.menuRetaPontoMedio.campoX1Y1.setText((coordPoligono[0]-tamanhoTelaX/2) +","+ (coordPoligono[2]+tamanhoTelaY/2));
			if ( ponteiroCoordPoligono == 4) {	
				janelaDados.menuRetaPontoMedio.campoX2Y2.setText((coordPoligono[1]-tamanhoTelaX/2)+","+ (coordPoligono[3]+tamanhoTelaY/2));
				
				desenharRetaPontoMedio(coordPoligono);
				
				coordPoligono[0] = coordPoligono[2];
				coordPoligono[1] = coordPoligono[3];
				ponteiroCoordPoligono = 2;
			}
		}
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("Coordenada atual do mouse : [" + e.getX() + "," + e.getY() + "]");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("O Mouse está fora da janela de acesso");
		janelaDados.menuCoordenadas.coordenadaMundo.setText("");
		janelaDados.menuCoordenadas.coordenadaCentralizadaNormalizada.setText("");
		janelaDados.menuCoordenadas.coordenadaCartesiana.setText("");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("Coordenadas do dispositivo : [" + e.getX() + "," + e.getY() + "]");
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("Mouse arrastado nas coordenadas : [" + e.getX() + "," + e.getY() + "]");
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("Mouse pressionado nas coordenadas : [" + e.getX() + "," + e.getY() + "]");
	}

	//PRINCIPAL
	@Override
	public void mouseMoved(MouseEvent e) {
		//	---------CALCULO DAS COORDENADAS-------
		
		//COORDENADAS DO DISPOSITIVO (ENTRE 0 E TAMANHO DA TELA)
		float dcx = Math.round((e.getX() + this.janelaConfig.valorDispositivoXmin));//300
        float dcy =  Math.round((e.getY() + this.janelaConfig.valorDispositivoYmin));// 300
		janelaDados.menuCoordenadas.mousePosition.setText("Coordenadas do dispositivo : [" + dcx + ", " + dcy + "]");
		
		// CALCULO TRANSFORMACAO COORDENADAS NORMAL PARA MUNDO
		float ndh = tamanhoTelaX;// 700
		float ndv = tamanhoTelaY;// 700
		
		float ndcx = (dcx / (ndh - 1));
        float ndcy = (dcy /(ndv - 1));
		
		float x = Math.round((ndcx * (this.janelaConfig.valorMundoXmax - this.janelaConfig.valorMundoXmin))
				+ this.janelaConfig.valorMundoXmin)-1; // [0,28*700]+100
		float y = Math.round((ndcy * (this.janelaConfig.valorMundoYmax - this.janelaConfig.valorMundoYmin))
				+ this.janelaConfig.valorMundoYmin)-1;
	
		janelaDados.menuCoordenadas.coordenadaMundo.setText("coordenadas do mundo : [" + x + ", " + y + "]");
		
		//COORDENADAS CARTESIANAS(CENTRALIZADA 0,0)
		dcx = Math.round(((tamanhoTelaX/2)-e.getX()))*-1;
        dcy = Math.round(((tamanhoTelaY/2 )-e.getY()));
        
       //COORDENADAS NORMALIZADAS (ENTRE -1 E 1)
		ndcx = (dcx / (ndh - 1));
        ndcy = (dcy /(ndv - 1));
		janelaDados.menuCoordenadas.coordenadaCentralizadaNormalizada.setText(String.format("Coordenadas Normalizadas: [ %.6f , %.6f]\n",ndcx,ndcy));
		janelaDados.menuCoordenadas.coordenadaCartesiana.setText("Coordenadas Cartesiana : [" + dcx + ", " + dcy + "]");
		
	}// --- fim das eventos de mouse
	
	//		---FUNCOES DE DESENHO----
	
	public void limparTela() {
			this.getGraphics().clearRect(0, 0, tamanhoTelaX, tamanhoTelaY);//apaga tudo
			this.paint(this.getGraphics());//desenha o plano Cartesiano Novamente
    }
	// --- RETAS ---
	// RETA DDA
		public void desenharRetaDDA(int[] coordenadas) {
			
			int tabelaLinha=0;
			int tabelaColuna=0;
			
			double length = Math.max(Math.abs(coordenadas[2] - coordenadas[0]), Math.abs(coordenadas[3] - coordenadas[1]));
			janelaDados.menuRetaDDA.campoLength.setText(String.valueOf(length));
			
			double xInc = (coordenadas[2] - coordenadas[0]) / length;
			double yInc = (coordenadas[3] - coordenadas[1]) / length;
			janelaDados.menuRetaDDA.campoXinc.setText(String.format("%.4f", xInc));
			janelaDados.menuRetaDDA.campoYinc.setText(String.format("%.4f", yInc*(-1)));
			
			double x = Math.round(coordenadas[0]);
			double y = Math.round(coordenadas[1]);
			drawPixel((int) x, (int) y);
			adicionaItensTabelaRetaDDA((int)x ,(int)y,tabelaLinha++,tabelaColuna);
			
			if (coordenadas[2] > coordenadas[0]) {
				while (x < coordenadas[2]) {
					x = x + xInc;
					y = y + yInc;
					drawPixel((int) x, (int) y);
					adicionaItensTabelaRetaDDA((int)x ,(int)y,tabelaLinha++,tabelaColuna);
				}
			} else if (coordenadas[2] < coordenadas[0]) {
				while (x > coordenadas[2]) {
					x = x + xInc;
					y = y + yInc;
					drawPixel((int) x, (int) y);
					adicionaItensTabelaRetaDDA((int)x ,(int)y,tabelaLinha++,tabelaColuna);
				}
			}
		}
		
	// RETA PONTO MÉDIO
		public void desenharRetaPontoMedio(int[] coordenadas) {
			int tabelaLinha = 0;
			int tabelaColuna = 0;
			
			int dx = Math.abs(coordenadas[2] - coordenadas[0]);
			int dy = Math.abs(coordenadas[3] - coordenadas[1]);// 1º octante
			janelaDados.menuRetaPontoMedio.campoDx.setText(String.valueOf(dx));
			janelaDados.menuRetaPontoMedio.campoDy.setText(String.valueOf(dy));
			
			int d = (2 * dy) - dx;
			janelaDados.menuRetaPontoMedio.campoD.setText(String.valueOf(d));

			// Incremento:
			int incE = 2 * dy;
			int incNE = 2 * (dy - dx);
			janelaDados.menuRetaPontoMedio.campoINCe.setText(String.valueOf(incE));
			janelaDados.menuRetaPontoMedio.campoINCne.setText(String.valueOf(incNE));

			// Ponto inicial:
			int x = coordenadas[0];
			int y = coordenadas[1];
			drawPixel(x, y);
			adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);

			// Escolhendo próximos pontos:
			if (coordenadas[2] > coordenadas[0]) {
				while (x < coordenadas[2]) {
					if (d <= 0) {
						// Escolhido ponto E (inferior)
						d = d + incE;
						x = x + 1;
						drawPixel(x, y);
						adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);

					} else {
						// Escolhido Ponto NE (superior)
						d = d + incNE;
						x = x + 1;
						y = y - 1; // usado negativo, pois as coord Y da tela crescem para baixo
						drawPixel(x, y);
						adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);
					}
				}
			} else if (coordenadas[2] < coordenadas[0]) {
				while (x > coordenadas[2]) {
					if (d <= 0) {
						// Escolhido ponto E (inferior)
						d = d + incE;
						x = x - 1;
						drawPixel(x, y);
						adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);

					} else {
						// Escolhido Ponto NE (superior)
						d = d + incNE;
						x = x - 1;
						y = y + 1;  
						drawPixel(x, y);
						adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);
					}
				}
			}

		}// fim da desenharRetaPontoMedio

	//  	--- METODOS DE DESENHO DAS CIRCUNFERENCIAS  2D ---
	
	//CIRCUNFERENCIA EQUACAO EXPLICITA
	public void desenhaCircunferenciaEE(int raio, int posicaoX, int posicaoY) {
		int tabelaLinha = 0;
		int tabelaColuna = 1;
		
		int x ,y;
		int raio2 = (raio* raio);
		
		for(x = -raio; x<= raio; x++) {
			y = (int) Math.round(Math.sqrt(raio2 - x*x));
			drawPixel(posicaoX + x, posicaoY + y);
			drawPixel(posicaoX + x, posicaoY - y);
			
			//mostrar dados na tabela
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);//X0 = X
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);//Y0 = Y
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);//X1 = X
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);//Y1 = -Y
			tabelaLinha = 0;
			tabelaColuna++;
		}	
	}
	
	//CIRCUNFERENCIA COM METODO TRIGONOMETRICO
		public void desenhaCircunferenciaMT(int raio, int posicaoX, int posicaoY) {
			int tabelaLinha = 0;
			int tabelaColuna = 1;
			
			int x ,y;
			
			for(int teta = 0; teta<= 45; teta++) {
				y = (int) Math.round(raio * Math.cos(Math.toRadians(teta)));
				x = (int) Math.round(raio * Math.sin(Math.toRadians(teta)));
				
				ponto_circulo(x,y,posicaoX,posicaoY);
				adicionaItensTabelaMT(x, y, tabelaLinha,tabelaColuna++);
			}
		}
		
	//CIRCUNFERENCIA DE PONTO MEDIO
	public void desenhaCircunferenciaPM(int raio, int posicaoX, int posicaoY) {
		int tabelaColuna = 1;
		int tabelaLinha = 1;
		
		int x = 0;
		int y = raio;
		double d = 5/4 - raio;
		
		janelaDados.menuCircunferenciaPM.campoD.setText(String.valueOf(d));

		drawPixel(x + posicaoX ,posicaoY - y);//desenhar o centro
		ponto_circulo(x, y,posicaoX, posicaoY);
		adicionaItensTabelaPM(x, y, tabelaLinha,tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(d, 0, tabelaColuna++);

		while(y > x) {
			if(d<0) {//escolha E
				d += 2 * x + 3;
			}else {//escolhe SE
				d += 2 * (x - y) + 5;
				y--;
			}
			x++;
			ponto_circulo(x, y,posicaoX, posicaoY);
			adicionaItensTabelaPM(x, y, tabelaLinha,tabelaColuna);
			janelaDados.menuCircunferenciaPM.tabela.setValueAt(d, 0, tabelaColuna++);
		}
	}
	
	public void ponto_circulo(int x, int y, int posicaoX, int posicaoY) {
		drawPixel(x + posicaoX, posicaoY + y);
		drawPixel(y + posicaoX, posicaoY + x);
		drawPixel(y + posicaoX, posicaoY - x);
		drawPixel(x + posicaoX, posicaoY - y);
		drawPixel(-x + posicaoX, posicaoY - y);
		drawPixel(-y + posicaoX, posicaoY - x);
		drawPixel(-y + posicaoX, posicaoY + x);
		drawPixel(-x + posicaoX, posicaoY + y);
	}
	//--- FIM DOS METODOS DE DESENHO 2D ---
	
	
	
	public void drawPixel(int x, int y) {
		//Desenha o pixel na tela grafica
		Graphics g = super.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 1, 1);
	}
		
	public void start() {
		//inicia a classe
		addMouseListener(this);
		addMouseMotionListener(this);
		tamanhoTelaX = janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin;
    	tamanhoTelaY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;
		setSize(tamanhoTelaX, tamanhoTelaY);
		setUndecorated(false);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		//desenha as linhas das coordenadas Cartesianas
        super.paint(g);
        this.setBackground(Color.white);
        g.setColor(Color.LIGHT_GRAY);
         
        g.drawLine(0, tamanhoTelaY/2, tamanhoTelaX,tamanhoTelaY/2);//linha X
        g.drawLine(tamanhoTelaX/2,0, tamanhoTelaX/2,tamanhoTelaY );//linha Y
    }
	
	
	// MOSTRAR OS VALORES NA TABELA GRAFICA
	public void adicionaItensTabelaRetaDDA(int x, int y, int tabelaLinha, int tabelaColuna) {
		janelaDados.menuRetaDDA.tabela.setValueAt(x-tamanhoTelaX/2, tabelaLinha, tabelaColuna++);
		janelaDados.menuRetaDDA.tabela.setValueAt((y-tamanhoTelaY/2)*(-1), tabelaLinha, tabelaColuna);
		 
	}
	
	public void adicionaItensTabelaRetaPM(int d, int x, int y, int tabelaLinha, int tabelaColuna) {
		janelaDados.menuRetaPontoMedio.tabela.setValueAt(d, tabelaLinha, tabelaColuna++);
		janelaDados.menuRetaPontoMedio.tabela.setValueAt(x, tabelaLinha, tabelaColuna++);
		janelaDados.menuRetaPontoMedio.tabela.setValueAt(y, tabelaLinha, tabelaColuna);
		 
	}
	public void adicionaItensTabelaPM(int x, int y, int tabelaLinha, int tabelaColuna) {
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaPM.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);	 
	}
	public void adicionaItensTabelaMT(int x, int y, int tabelaLinha, int tabelaColuna) {
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);
		janelaDados.menuCircunferenciaMT.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);	 
	}
	
	
}
