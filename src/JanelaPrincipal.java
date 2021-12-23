/** 
 * Classe Janela principal
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class JanelaPrincipal extends JFrame implements MouseListener, MouseMotionListener {

	JanelaConfig janelaConfig;
	JanelaDados janelaDados;
	JanelaPrincipal principal = this;
	
	static int tamanhoTelaX;
	static int tamanhoTelaY;

	public JanelaPrincipal(String titulo) {
		super(titulo);
		
		this.janelaConfig = new JanelaConfig();
		this.janelaDados  = new JanelaDados("Computação Gráfica - Dados");	
    	
		//Adicionados
			janelaDados.itemOP_limparTela.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limparTela();
				}
			});
			
			
			// AÇÕES DAS JANELAS DAS CIRCUNFERENCIAS
			janelaDados.menuCircunferenciaEE.btnDesenhar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int posicoes[] = {tamanhoTelaX/2, tamanhoTelaY/2};
					String [] stringSeparada =janelaDados.menuCircunferenciaEE.campoXY.getText().split(",");
					System.out.println(stringSeparada[0]+ " " + stringSeparada[1]);
					if(stringSeparada.length == 2) {
						posicoes[0] += Integer.parseInt(stringSeparada[0]);
						posicoes[1] += Integer.parseInt(stringSeparada[1])*-1;
					}else {
						System.out.println("parametro errado somente x,y");
					}
					int raio = Integer.parseInt(janelaDados.menuCircunferenciaEE.campoRaio.getText());
					
					System.out.println(stringSeparada[0]+ " " + stringSeparada[1]);
					desenhaCircunferenciaEE(raio,posicoes[0],posicoes[1]);
				}
			});
			
			janelaDados.menuCircunferenciaMT.btnDesenhar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int posicoes[] = {tamanhoTelaX/2, tamanhoTelaY/2};
					String [] stringSeparada =janelaDados.menuCircunferenciaMT.campoXY.getText().split(",");
					if(stringSeparada.length == 2) {
						posicoes[0] += Integer.parseInt(stringSeparada[0]);
						posicoes[1] += Integer.parseInt(stringSeparada[1]);
					}else {
						System.out.println("parametro errado somente x,y");
					}
					int raio = Integer.parseInt(janelaDados.menuCircunferenciaMT.campoRaio.getText());
					
					desenhaCircunferenciaMT(raio,posicoes[0],posicoes[1]);
				}
			});
			
			janelaDados.menuCircunferenciaPM.btnDesenhar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int posicoes[] = {tamanhoTelaX/2, tamanhoTelaY/2};
					String [] stringSeparada =janelaDados.menuCircunferenciaPM.campoXY.getText().split(",");
					if(stringSeparada.length == 2) {
						posicoes[0] += Integer.parseInt(stringSeparada[0]);
						posicoes[1] += Integer.parseInt(stringSeparada[1]);
					}else {
						System.out.println("parametro errado somente x,y");
					}
					int raio = Integer.parseInt(janelaDados.menuCircunferenciaPM.campoRaio.getText());
					
					desenhaCircunferenciaPM(raio,posicoes[0],posicoes[1]);
				}
			});
	}// fim do construtor

	
	
	//----MOUSE EVENTS----
	@Override
	public void mouseClicked(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("Mouse clicado na coordenada : [" + e.getX() + "," + e.getY() + "]");
		drawPixel(e.getX(),e.getY());
		
		desenhaCircunferenciaPM(100,e.getX(),e.getY());
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
		
		int variacaoX = janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin;
		int variacaoY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;
		
		//---------CALCULO DAS COORDENADAS-------
		//Coordenadas do dispositivo
		float dcx = Math.round((e.getX() + this.janelaConfig.valorDispositivoXmin));//300
        float dcy =  Math.round((e.getY() + this.janelaConfig.valorDispositivoYmin));// 300
		janelaDados.menuCoordenadas.mousePosition.setText("Coordenadas do dispositivo : [" + dcx + ", " + dcy + "]");
		
		// Cálculo das transformações da coordenada normal para mundo:
		float ndh = variacaoX;// 700
		float ndv = variacaoY;// 700
		
		float ndcx = (dcx / (ndh - 1));
        float ndcy = (dcy /(ndv - 1));
		
		float x = Math.round((ndcx * (this.janelaConfig.valorMundoXmax - this.janelaConfig.valorMundoXmin))
				+ this.janelaConfig.valorMundoXmin)-1; // [0,28*700]+100
		float y = Math.round((ndcy * (this.janelaConfig.valorMundoYmax - this.janelaConfig.valorMundoYmin))
				+ this.janelaConfig.valorMundoYmin)-1;
	
		janelaDados.menuCoordenadas.coordenadaMundo.setText("coordenadas do mundo : [" + x + ", " + y + "]");
		
		//------------COORDENADAS NORMALIZADAS ENTRE -1 E 1---------------
		dcx = Math.round(((variacaoX/2)-e.getX()))*-1;
        dcy = Math.round(((variacaoY/2 )-e.getY()));

		ndcx = (dcx / (ndh - 1));
        ndcy = (dcy /(ndv - 1));
		janelaDados.menuCoordenadas.coordenadaCentralizadaNormalizada.setText(String.format("Coordenadas Normalizadas: [ %.6f , %.6f]\n",ndcx,ndcy));
		
		//Cartesiana
		janelaDados.menuCoordenadas.coordenadaCartesiana.setText("Coordenadas Cartesiana : [" + dcx + ", " + dcy + "]");
		
	}
	
	
			
	//---FUNCOES DE DESENHO----
	
	//desenhar as coordenadas de um plano cartesiano
	public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        g.setColor(Color.LIGHT_GRAY);
         
        g.drawLine(0, tamanhoTelaY/2, tamanhoTelaX,tamanhoTelaY/2);//linha X
        g.drawLine(tamanhoTelaX/2,0, tamanhoTelaX/2,tamanhoTelaY );//linha Y
    }
	
	public void limparTela() {
			
			this.getGraphics().clearRect(0, 0, tamanhoTelaX, tamanhoTelaY);//apaga tudo
			this.paint(this.getGraphics());//desenha o plano Cartesiano Novamente
    }
	
	//Desenha o pixel na tela grafica
	public void drawPixel(int x, int y) {
	     Graphics g = super.getGraphics();
	     g.setColor(Color.RED);
	     g.fillRect(x, y, 1, 1);
	}
	
	//---Comecar a janela de coordenadas---
	
	public void start() {
		addMouseListener(this); // listens for own mouse and
		addMouseMotionListener(this); // mouse-motion events
		setSize((this.janelaConfig.valorDispositivoXmax - this.janelaConfig.valorDispositivoXmin),
				(this.janelaConfig.valorDispositivoYmax - this.janelaConfig.valorDispositivoYmin));
		setUndecorated(false);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tamanhoTelaX = janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin;
    	tamanhoTelaY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;
	}// fim do método start
	
	//Metodos de desenho
	//Circunferencia
	//Equacao explicita
	public void desenhaCircunferenciaEE(int raio, int posicaoX, int posicaoY) {
		
		int tabelaLinha = 0;
		int tabelaColuna = 1;
		int x ,y;
		int raio2 = (raio* raio);
		System.out.println(posicaoX + " " + posicaoY);
		
		for(x = -raio; x<= raio; x++) {
			y = (int) Math.round(Math.sqrt(raio2 - x*x));
			drawPixel(posicaoX + x, posicaoY + y);
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);
			drawPixel(posicaoX + x, posicaoY - y);
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);
			tabelaLinha = 0;
			tabelaColuna++;
		}	
	}
	//Equacao trigonometrica
		public void desenhaCircunferenciaMT(int raio, int posicaoX, int posicaoY) {
			int tabelaLinha = 0;
			int tabelaColuna = 1;
			
			int x ,y;
			
			for(int i = -raio; i<= raio; i++) {
				y = (int) Math.round(raio * Math.cos(Math.toRadians(i)));
				x = (int) Math.round(raio * Math.sin(Math.toRadians(i)));
				desenhaCirculoDePontos(x,y,posicaoX,posicaoY);
				adicionaItensTabelaPM(x, y, tabelaLinha,tabelaColuna++);
			}
		}
		
	//Ponto medio
	public void desenhaCircunferenciaPM(int raio, int posicaoX, int posicaoY) {
		int x = 0;
		int y = raio;
		double d = 5/4 - raio;
		int tabelaColuna = 1;
		int tabelaLinha = 1;
		
		janelaDados.menuCircunferenciaPM.campoD.setText(String.valueOf(d));

		drawPixel(x + posicaoX ,posicaoY - y);//desenhar o centro
		desenhaCirculoDePontos(x, y,posicaoX, posicaoY);
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
			desenhaCirculoDePontos(x, y,posicaoX, posicaoY);
			adicionaItensTabelaPM(x, y, tabelaLinha,tabelaColuna);
			janelaDados.menuCircunferenciaPM.tabela.setValueAt(d, 0, tabelaColuna++);
		}
	}
	
	public void desenhaCirculoDePontos(int x, int y, int posicaoX, int posicaoY) {
		drawPixel(x + posicaoX, posicaoY + y);
		drawPixel(y + posicaoX, posicaoY + x);
		drawPixel(y + posicaoX, posicaoY - x);
		drawPixel(x + posicaoX, posicaoY - y);
		drawPixel(-x + posicaoX, posicaoY - y);
		drawPixel(-y + posicaoX, posicaoY - x);
		drawPixel(-y + posicaoX, posicaoY + x);
		drawPixel(-x + posicaoX, posicaoY + y);
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
