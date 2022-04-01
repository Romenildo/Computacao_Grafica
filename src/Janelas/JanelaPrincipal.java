package Janelas;

import java.awt.BasicStroke;

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
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Uteis.CalculoDesenho;
import Uteis.Koch_Snowflake;
import Uteis.RitmoCardiaco;
import Uteis.Uteis;

public class JanelaPrincipal extends JFrame implements MouseListener, MouseMotionListener {

	JanelaConfig janelaConfig;
	JanelaDados janelaDados;
	JanelaPrincipal principal = this;
	CalculoDesenho calculoDesenho;
	Koch_Snowflake KochSnowflake;
	RitmoCardiaco ritmoCardiaco;
	
	Uteis uteis;
	int[] coordPoligono = new int[4];
	int ponteiroCoordPoligono = 0;
	int[] coordPoligonoPM = new int[4];
	int ponteiroCoordPoligonoPM = 0;
	
	//global
	public static int tamanhoTelaX;
	public static int tamanhoTelaY;

	public JanelaPrincipal(String titulo) {
		super(titulo);
		
		this.janelaConfig = new JanelaConfig();
		this.janelaDados  = new JanelaDados("Computa��o Gr�fica - Dados");	
		this.calculoDesenho = new CalculoDesenho(janelaDados,this);
		this.uteis = new Uteis(this);
		this.KochSnowflake = new Koch_Snowflake(this);
		this.ritmoCardiaco = new RitmoCardiaco(tamanhoTelaX,tamanhoTelaY,this);
		
		// --- A��ES DAS JANELAS ---
		//limpar tela ao clicar na opcao
		janelaDados.itemOP_limparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		
		//desenhar a RETA DDA ao clicar no botao desenhar
		janelaDados.menuRetaDDA.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] coordRetaDDA = uteis.pegarPosicoesReta(janelaDados.menuRetaDDA.campoX1Y1, janelaDados.menuRetaDDA.campoX2Y2);
				//chama a funcao de desenho
				calculoDesenho.desenharRetaDDA(coordRetaDDA);
				
			}
		});
		
		//desenhar a RETA Ponto Medio ao clicar no botao desenhar(nao sequencial)
		janelaDados.menuRetaPontoMedio.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] coordRetaPM = uteis.pegarPosicoesReta(janelaDados.menuRetaPontoMedio.campoX1Y1, janelaDados.menuRetaPontoMedio.campoX2Y2);
				//chama a funcao de desenho
				calculoDesenho.desenharRetaPontoMedio(coordRetaPM);
			}
		});
			
		//desenhar a circunferencia (EQUACAO EXPLICITA) ao clicar no botao desenhar
		janelaDados.menuCircunferenciaEE.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicoes[] = uteis.pegarPosicoes(janelaDados.menuCircunferenciaEE.campoXY);
				int raio = Integer.parseInt(janelaDados.menuCircunferenciaEE.campoRaio.getText());
				
				//chama a funcao de desenho
				calculoDesenho.desenhaCircunferenciaEE(raio,posicoes[0],posicoes[1]);
			}
		});
		
		
			//desenhar a circunferencia (METODO TRIGONOMETRICO) ao clicar no botao desenhar
		janelaDados.menuCircunferenciaMT.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicoes[] = uteis.pegarPosicoes(janelaDados.menuCircunferenciaMT.campoXY);
				int raio = Integer.parseInt(janelaDados.menuCircunferenciaMT.campoRaio.getText());
					
				//chama a funcao de desenho
				calculoDesenho.desenhaCircunferenciaMT(raio,posicoes[0],posicoes[1]);
			}
		});
			
			//desenhar a circunferencia (PONTO MEDIO) ao clicar no botao desenhar
		janelaDados.menuCircunferenciaPM.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicoes[] = uteis.pegarPosicoes(janelaDados.menuCircunferenciaPM.campoXY);
				int raio = Integer.parseInt(janelaDados.menuCircunferenciaPM.campoRaio.getText());
					
				//chama a funcao de desenho
				calculoDesenho.desenhaCircunferenciaPM(raio,posicoes[0],posicoes[1]);
			}
		});
		janelaDados.menuElipse.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicoes[] = uteis.pegarPosicoes(janelaDados.menuElipse.campoXY);
				int diametro = Integer.parseInt(janelaDados.menuElipse.campoDiametro.getText());
				int altura = Integer.parseInt(janelaDados.menuElipse.campoAltura.getText());
					
				//chama a funcao de desenho
				calculoDesenho.desenharElipse(posicoes[0],posicoes[1], diametro, altura);
			}
		});
		
		
		janelaDados.menuSnowFlake.btnDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int interacoes = janelaDados.menuSnowFlake.slider.getValue();
				limparTela();
				KochSnowflake.DesenharSnowFlake(interacoes);
				
			}
		});
		
		janelaDados.menuRitmoCardiaco.btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limparTela();
				ritmoCardiaco.desenharRitmoCardiaco();
				
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
				calculoDesenho.desenharRetaDDA(coordPoligono);
				
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
			
			janelaDados.menuRetaPontoMedio.campoX1Y1.setText((coordPoligono[0]-tamanhoTelaX/2) +","+ ((coordPoligono[1]-tamanhoTelaY/2)*(-1)));
			if ( ponteiroCoordPoligono == 4) {	
				
				janelaDados.menuRetaPontoMedio.campoX2Y2.setText((coordPoligono[2]-tamanhoTelaX/2)+","+ ((coordPoligono[3]-tamanhoTelaY/2)*(-1)));
				calculoDesenho.desenharRetaPontoMedio(coordPoligono);
				
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
		janelaDados.menuCoordenadas.mousePosition.setText("O Mouse est� fora da janela de acesso");
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
		dcx = Math.round(((tamanhoTelaX/2)-e.getX())*2)*-1;
        dcy = Math.round(((tamanhoTelaY/2 )-e.getY())*2);
        
       //COORDENADAS NORMALIZADAS (ENTRE -1 E 1)
		ndcx = (dcx / (ndh - 1));
        ndcy = (dcy /(ndv - 1));
		janelaDados.menuCoordenadas.coordenadaCentralizadaNormalizada.setText(String.format("Coordenadas Normalizadas: [ %.2f , %.2f]\n",ndcx,ndcy));
		
		//COORDENADAS CARTESIANAS
		dcx = Math.round(((tamanhoTelaX/2)-e.getX()))*-1;
        dcy = Math.round(((tamanhoTelaY/2 )-e.getY()));
        ndcx = (dcx / (ndh - 1));
        ndcy = (dcy /(ndv - 1));
		janelaDados.menuCoordenadas.coordenadaCartesiana.setText("Coordenadas Cartesiana : [" + dcx + ", " + dcy + "]");
		
	}// --- fim das eventos de mouse
	
	public void drawPixel(int x, int y) {
		//Desenha o pixel na tela grafica
		Graphics g = super.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 1, 1);
	}
	
	public void limparTela() {
			this.getGraphics().clearRect(0, 0, tamanhoTelaX, tamanhoTelaY);//apaga tudo
			this.paint(this.getGraphics());//desenha o plano Cartesiano Novamente
			
			for(int i = 0; i<4;i++) {
				coordPoligono[i]=0;
				coordPoligonoPM[i]=0;
			}
			ponteiroCoordPoligono = 0;
			ponteiroCoordPoligonoPM = 0;
    }
	
	
	
	
	public void drawLine(int xi, int yi, int xf, int yf) {
		//Desenha o lina do snowflake na tela grafica
		int[] coordRetaDDA = {xi,yi,xf,yf};
		calculoDesenho.desenharRetaDDA(coordRetaDDA);
	
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
	
	
	public void ativaRitmo() {
		
		Graphics g = super.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
	
		 g2d.setStroke(new BasicStroke(1.0f));
	 
	}
	
	
	public void Transforma(AffineTransform yUp) {
		//Desenha o lina do snowflake na tela grafica
		Graphics g = super.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
	    g2d.transform(yUp);
	}
	public void instanciarTela(Rectangle2D.Double windowFrame) {
		//Desenha o lina do snowflake na tela grafica
		Graphics g = super.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		
		 g2d.draw(windowFrame);
	}
	public void desenharPixeis(Shape shape) {
		//Desenha o lina do snowflake na tela grafica
		Graphics g = super.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		 g2d.draw(shape);
	}
	
	
}
