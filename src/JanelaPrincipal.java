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
	
	int tamanhoTelaX;
	int tamanhoTelaY;
	
	
	
	
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
	}// fim do construtor

	
	
	//----MOUSE EVENTS----
	@Override
	public void mouseClicked(MouseEvent e) {
		janelaDados.menuCoordenadas.mousePosition.setText("Mouse clicado na coordenada : [" + e.getX() + "," + e.getY() + "]");
		drawPixel(e.getX(),e.getY());
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
				+ this.janelaConfig.valorMundoXmin); // [0,28*700]+100
		float y = Math.round((ndcy * (this.janelaConfig.valorMundoYmax - this.janelaConfig.valorMundoYmin))
				+ this.janelaConfig.valorMundoYmin);
	
		janelaDados.menuCoordenadas.coordenadaMundo.setText("coordenadas do mundo : [" + x + ", " + y + "]");
		
		
		//------------COORDENADAS NORMALIZADAS ENTRE -1 E 1---------------
		
		dcx = Math.round(((variacaoX/2)-e.getX()))*-1;
        dcy = Math.round(((variacaoY/2 )-e.getY()));

		ndcx = (dcx / (ndh - 1));
        ndcy = (dcy /(ndv - 1));
		janelaDados.menuCoordenadas.coordenadaCentralizadaNormalizada.setText(String.format("Coordenadas Normalizadas: [ %.6f , %.6f]\n",ndcx,ndcy));
	}
	
	
			
	//---FUNCOES DE DESENHO----
	
	//desenhar as coordenadas de um plano cartesiano
	public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        g.setColor(Color.LIGHT_GRAY);
        
        tamanhoTelaX = janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin;
    	tamanhoTelaY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;

        g.drawLine(0, tamanhoTelaY/2, tamanhoTelaX,tamanhoTelaY/2);//linha X
        g.drawLine(tamanhoTelaX/2,0, tamanhoTelaX/2,tamanhoTelaY );//linha Y
    }
	
	public void limparTela() {
			tamanhoTelaX = janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin;
			tamanhoTelaY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;
			
			this.getGraphics().clearRect(0, 0, tamanhoTelaX, tamanhoTelaY);//apaga tudo
			this.paint(this.getGraphics());//desenha o plano Cartesiano Novamente
    }
	
	//Desenha o pixel na tela grafica
	public void drawPixel(int x, int y) {
	     Graphics g = super.getGraphics();
	     g.setColor(Color.RED);
	     g.fillRect(x, y, 5, 5);
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
	}// fim do método start

}
