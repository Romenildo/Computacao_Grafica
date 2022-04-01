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
import java.util.ArrayList;
import java.util.List;

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
	List<Integer> coordenadasObjeto = new ArrayList<>();
	List<Integer> coordenadasObjetoTransformado = new ArrayList<>();
	
	//global
	public static int tamanhoTelaX;
	public static int tamanhoTelaY;

	public JanelaPrincipal(String titulo) {
		super(titulo);
		
		this.janelaConfig = new JanelaConfig();
		this.janelaDados  = new JanelaDados("Computação Gráfica - Dados");	
		this.calculoDesenho = new CalculoDesenho(janelaDados,this);
		this.uteis = new Uteis(this);
		this.KochSnowflake = new Koch_Snowflake(this);
		this.ritmoCardiaco = new RitmoCardiaco(tamanhoTelaX,tamanhoTelaY,this);
		
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
		
		//ACOES TRANSFORMACOES
		// Adicionar translação após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarTranslacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbTranslacao.isSelected()) {
					System.out.println("Translação");
					transladarComp(coordenadasObjetoTransformado);
					String nome = "Translação";
					janelaDados.menuTransfGeomComp.textArea.append(nome+ "Tx: "+janelaDados.menuTransfGeomComp.campoTx.getText()+ " Ty: " +janelaDados.menuTransfGeomComp.campoTy.getText() + "\n");
				}
			}

		});

		// Adicionar escala após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarEscala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbEscala.isSelected()) {
					System.out.println("Escala");
					escalarComp(coordenadasObjetoTransformado);
					String nome = "Escala";
					janelaDados.menuTransfGeomComp.textArea.append(nome+ " Sx: "+janelaDados.menuTransfGeomComp.campoSx.getText()+ " Sy: " +janelaDados.menuTransfGeomComp.campoSy.getText() + "\n");
				}
			}
		});

		// Adicionar rotação após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarRotacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbRotacao.isSelected()) {
					System.out.println("Rotação");
					rotacionarComp(coordenadasObjetoTransformado);
					String nome = "Rotação";
					janelaDados.menuTransfGeomComp.textArea.append(nome+ " ângulo: "+janelaDados.menuTransfGeomComp.campoAng.getText()+"\n");
				}
			}
		});

		// Adicionar cisalhamento após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarCisalhamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbCisalhamento.isSelected()) {
					System.out.println("Cisalhamento");
					cisalharComp(coordenadasObjetoTransformado);
					String nome = "Cisalhamento";
					janelaDados.menuTransfGeomComp.textArea.append(nome+ " Cx: "+janelaDados.menuTransfGeomComp.campoCx.getText()+ " Cy: " +janelaDados.menuTransfGeomComp.campoCy.getText() + "\n");
				}
			}
		});

		// Adicionar Reflexão em X após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarReflexao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbReflexao.isSelected()
						&& janelaDados.menuTransfGeomComp.combo.getSelectedItem().equals("Em X")) {
					System.out.println("Reflexão em X");
					reflexaoEixoXComp(coordenadasObjetoTransformado);
					String nome = "Reflexão em X";	
					janelaDados.menuTransfGeomComp.textArea.append(nome+"\n");
				}
			}
		});

		// Adicionar Reflexão em Y após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarReflexao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbReflexao.isSelected()
						&& janelaDados.menuTransfGeomComp.combo.getSelectedItem().equals("Em Y")) {
					System.out.println("Reflexão em Y");
					reflexaoEixoYComp(coordenadasObjetoTransformado);
					String nome = "Reflexão em Y";	
					janelaDados.menuTransfGeomComp.textArea.append(nome+"\n");
				}
			}
		});

		// Adicionar Reflexão em torno da origem após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarReflexao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbReflexao.isSelected()
						&& janelaDados.menuTransfGeomComp.combo.getSelectedItem().equals("Em torno da origem")) {
					System.out.println("Reflexão em torno da origem");
					reflexaoEmTornoOrigemComp(coordenadasObjetoTransformado);
					String nome = "Reflexão em torno da origem";	
					janelaDados.menuTransfGeomComp.textArea.append(nome+"\n");
				}
			}
		});

		// Adicionar Reflexão em torno da rete Y=X após apertar botão
		janelaDados.menuTransfGeomComp.btnAdicionarReflexao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDados.menuTransfGeomComp.rbReflexao.isSelected()
						&& janelaDados.menuTransfGeomComp.combo.getSelectedItem().equals("Em torno da reta Y=X")) {
					System.out.println("Reflexão em torno da reta Y = X");
					reflexaoEmTornoRetaYXComp(coordenadasObjetoTransformado);
					String nome = "Reflexão em torno de uma reta qualquer";	
					janelaDados.menuTransfGeomComp.textArea.append(nome+"\n");
				}
			}
		});

		// Aplicar transformações:
		janelaDados.menuTransfGeomComp.btnAplicarTransfComposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
				redesenharObjetoTransformadoLista(coordenadasObjetoTransformado);
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
		
		//TRANSFORMACOES
		if (janelaDados.menuTransfGeom.btnCriarObjeto.isSelected()
				|| janelaDados.menuTransfGeomComp.btnCriarObjeto.isSelected()) {

			coordPoligono[ponteiroCoordPoligono] = e.getX();
			coordPoligono[ponteiroCoordPoligono + 1] = e.getY();
			coordenadasObjeto.add(e.getX());
			coordenadasObjeto.add(e.getY());
			coordenadasObjetoTransformado.add(e.getX());
			coordenadasObjetoTransformado.add(e.getY());

			ponteiroCoordPoligono = ponteiroCoordPoligono + 2;

			if (ponteiroCoordPoligono == 4) {

				calculoDesenho.desenharRetaDDA(coordPoligono);

				coordPoligono[0] = coordPoligono[2];
				coordPoligono[1] = coordPoligono[3];
				ponteiroCoordPoligono = 2;

				for (int i = 0; i < coordenadasObjeto.size(); i++) {
					System.out.println("Valor " + i + ": " + coordenadasObjeto.get(i));
					System.out.println("Valor Transf " + i + ": " + coordenadasObjetoTransformado.get(i));
				}

			}

		}
		
		// --------------------------------------------------------
		// Criar objeto transladado
		if (janelaDados.menuTransfGeom.rbTranslacao.isSelected()) {
			int[] objetoTransladado = transladar(coordenadasObjeto);
			printarCoordObjetoConsole(objetoTransladado);
			redesenharObjetoTransformado(objetoTransladado);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto Escalado
		if (janelaDados.menuTransfGeom.rbEscala.isSelected()) {
			int[] objetoEscalado = escalar(coordenadasObjeto);
			printarCoordObjetoConsole(objetoEscalado);
			redesenharObjetoTransformado(objetoEscalado);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto Cisalhado
		if (janelaDados.menuTransfGeom.rbCisalhamento.isSelected()) {
			int[] objetoCisalhado = cisalhar(coordenadasObjeto);
			printarCoordObjetoConsole(objetoCisalhado);
			redesenharObjetoTransformado(objetoCisalhado);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto Rotacionado
		if (janelaDados.menuTransfGeom.rbRotacao.isSelected()) {
			int[] objetoRotacionado = rotacionar(coordenadasObjeto);
			printarCoordObjetoConsole(objetoRotacionado);
			redesenharObjetoTransformado(objetoRotacionado);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto Reflexão Eixo X
		if (janelaDados.menuTransfGeom.rbReflexao.isSelected()
				&& janelaDados.menuTransfGeom.combo.getSelectedItem().equals("Em X")) {
			int[] objetoRefletivoEixoX = reflexaoEixoX(coordenadasObjeto);
			printarCoordObjetoConsole(objetoRefletivoEixoX);
			redesenharObjetoTransformado(objetoRefletivoEixoX);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto Reflexão Eixo Y
		if (janelaDados.menuTransfGeom.rbReflexao.isSelected()
				&& janelaDados.menuTransfGeom.combo.getSelectedItem().equals("Em Y")) {
			int[] objetoRefletivoEixoY = reflexaoEixoY(coordenadasObjeto);
			printarCoordObjetoConsole(objetoRefletivoEixoY);
			redesenharObjetoTransformado(objetoRefletivoEixoY);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto Reflexão Em torno da origem
		// ---------------------------------------------------------
		if (janelaDados.menuTransfGeom.rbReflexao.isSelected()
				&& janelaDados.menuTransfGeom.combo.getSelectedItem().equals("Em torno da origem")) {
			int[] objetoRefletivoEmTornoOrigem = reflexaoEmTornoOrigem(coordenadasObjeto);
			printarCoordObjetoConsole(objetoRefletivoEmTornoOrigem);
			redesenharObjetoTransformado(objetoRefletivoEmTornoOrigem);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto: Reflexão Em torno da reta Y=X
		// ---------------------------------------------------------
		if (janelaDados.menuTransfGeom.rbReflexao.isSelected()
				&& janelaDados.menuTransfGeom.combo.getSelectedItem().equals("Em torno da reta Y=X")) {
			int[] objetoRefletivoEmTornoRetaYX = reflexaoEmTornoRetaYX(coordenadasObjeto);
			printarCoordObjetoConsole(objetoRefletivoEmTornoRetaYX);
			redesenharObjetoTransformado(objetoRefletivoEmTornoRetaYX);
		}
		// --------------------------------------------------------

		// --------------------------------------------------------
		// Criar objeto: Reflexão Em torno da reta qualquer
		// ---------------------------------------------------------
		if (janelaDados.menuTransfGeom.rbReflexao.isSelected()
				&& janelaDados.menuTransfGeom.combo.getSelectedItem().equals("Em torno da reta qualquer")) {
			int[] objetoRefletivoEmTornoRetaQualquer = reflexaoEmTornoRetaQualquer(coordenadasObjeto);
			printarCoordObjetoConsole(objetoRefletivoEmTornoRetaQualquer);
			redesenharObjetoTransformado(objetoRefletivoEmTornoRetaQualquer);
		}
		// --------

		// ##################################################################################################################################

		// --------------------------------------------------------
		// Criar cubo
		// ---------------------------------------------------------
		if (janelaDados.menuTransfGeom3D.btnCriarObjeto.isSelected()) {
			// paintComponent(this.getGraphics());
			// AQUI
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			int[] coordCubo = { 0, 0, 0, 100, 0, 0, 100, 100, 0, 0, 100, 0, 0, 0, -100, 100, 0, -100, 100, 100, 100, 0,
					100, -100 };
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
	
	
	//TRANSFORMACOES
	// Transladar para origem
		public int[] transladarOrigem(List<Integer> array) {
			int[] coordenadasObjetoTransladado = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) - array.get(0));
				} else {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) - array.get(1));
				}
			}
			return coordenadasObjetoTransladado;
		}// fim transladar origem

		// Transladar para origem
		public int[] transladarOrigem2(int[] array) {
			int[] coordenadasObjetoTransladado = new int[array.length];

			for (int i = 0; i < array.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoTransladado[i] = (int) (array[i] - array[0]);
				} else {
					coordenadasObjetoTransladado[i] = (int) (array[i] - array[1]);
				}
			}
			return coordenadasObjetoTransladado;
		}// fim transladar origem2

		// Transladar para ponto original
		public int[] transladarPontoOriginal(int[] array) {
			int[] coordenadasObjetoTransladado = new int[array.length];

			for (int i = 0; i < array.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoTransladado[i] = (int) (array[i] + coordenadasObjeto.get(0));
				} else {
					// coordenadasObjetoTransladado[i] = coordenadasObjeto.get(i) +
					// Integer.valueOf(valorTy);
					coordenadasObjetoTransladado[i] = (int) (array[i] + coordenadasObjeto.get(1));
				}
			}
			return coordenadasObjetoTransladado;
		}// fim transladar origem

		public int[] transladarPontoOriginalComp(int[] array) {
			int[] coordenadasObjetoTransladado = new int[array.length];

			for (int i = 0; i < array.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoTransladado[i] = (int) (array[i] + coordenadasObjetoTransformado.get(0));
				} else {
					coordenadasObjetoTransladado[i] = (int) (array[i] + coordenadasObjetoTransformado.get(1));
				}
			}
			return coordenadasObjetoTransladado;
		}// fim transladar origem

		public int[] coordCentroTela(List<Integer> array) {
			int[] coordCentroTela = new int[array.size()];
			int dimensãoX = (janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin);
			int dimensãoY = (janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin);
			System.out.println("Dimensão X:" + dimensãoX);
			System.out.println("Dimensão Y:" + dimensãoY);

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0 || i == 0) {
					coordCentroTela[i] = (int) (array.get(i) - dimensãoX / 2);
				} else {
					coordCentroTela[i] = (int) (array.get(i) - dimensãoY / 2) * -1;
				}
			}
			return coordCentroTela;
		}

		public int[] coordOriginal(int[] array) {
			int[] coordOriginal = new int[array.length];
			int dimensãoX = (janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin);
			int dimensãoY = (janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin);
			System.out.println("Dimensão X:" + dimensãoX);
			System.out.println("Dimensão Y:" + dimensãoY);

			for (int i = 0; i < array.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordOriginal[i] = (int) (array[i] + dimensãoX / 2);
				} else {
					coordOriginal[i] = (int) (array[i] - dimensãoY / 2) * -1;
				}
			}
			return coordOriginal;
		}
		
		public void paintComponent(Graphics g) {
			super.paint(g);
			this.setBackground(Color.white);
			g.setColor(Color.LIGHT_GRAY);

			g.drawRect(400, 400, 100, 100);
			g.drawRect(400 + 50, 400 + 50, 100, 100);

			g.drawLine(getWidth() / 10, getHeight() / 10, (getWidth() / 10) + 50, (getHeight() / 10) + 50);
			g.drawLine(getWidth() / 10, (getHeight() / 10) + 100, (getWidth() / 10) + 50, (getHeight() / 10) + 50 + 100);
			g.drawLine((getWidth() / 10) + 100, getHeight() / 10, (getWidth() / 10) + 50 + 100, (getHeight() / 10) + 50);
			g.drawLine((getWidth() / 10) + 100, (getHeight() / 10) + 100, (getWidth() / 10) + 100 + 50,
					(getHeight() / 10) + 100 + 50);
		}
		
		// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

		// Printar coordenadas do objeto no console
		public void printarCoordObjetoConsole(int[] array) {
			for (int i = 0; i < array.length; i++) {
				System.out.println("Novo Valor " + i + ": " + array[i]);
			}
		}

		// Redesenhar objeto transformado
		public void redesenharObjetoTransformado(int[] array) {
			int cont = 0;
			for (int k = 0; k < ((array.length) / 2) - 1; k++) {
				int[] doisPontos = new int[4];
				doisPontos[0] = array[cont];
				doisPontos[1] = array[cont + 1];
				doisPontos[2] = array[cont + 2];
				doisPontos[3] = array[cont + 3];
				cont = cont + 2;
				calculoDesenho.desenharRetaDDA(doisPontos);
			}
		}

		// Redesenhar objeto transformado
		public void redesenharObjetoTransformadoLista(List<Integer> lista) {
			int cont = 0;
			for (int k = 0; k < ((lista.size()) / 2) - 1; k++) {
				int[] doisPontos = new int[4];
				doisPontos[0] = lista.get(cont);
				doisPontos[1] = lista.get(cont + 1);
				doisPontos[2] = lista.get(cont + 2);
				doisPontos[3] = lista.get(cont + 3);
				cont = cont + 2;
				calculoDesenho.desenharRetaDDA(doisPontos);
			}
		}

		// Transladar objeto:
		public int[] transladar(List<Integer> array) {
			limparTela();
			double valorTx = Double.parseDouble(janelaDados.menuTransfGeom.campoTx.getText());
			double valorTy = Double.parseDouble(janelaDados.menuTransfGeom.campoTy.getText());

			System.out.println("ok");
			int[] coordenadasObjetoTransladado = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) + valorTx);

				} else {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) + valorTy);

				}
			}
			return coordenadasObjetoTransladado;
		}

		// Transladar objeto:
		public List<Integer> transladarComp(List<Integer> array) {
			double valorTxComp = Double.parseDouble(janelaDados.menuTransfGeomComp.campoTx.getText());
			double valorTyComp = Double.parseDouble(janelaDados.menuTransfGeomComp.campoTy.getText());

			int[] coordenadasObjetoTransladado = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) + valorTxComp);
				} else {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) + valorTyComp);
				}
			}
			for (int j = 0; j < array.size(); j++) {
				array.set(j, coordenadasObjetoTransladado[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("translação " + j + ": " + array.get(j));
			}

			return coordenadasObjetoTransformado;
		}

		// Escalar objeto:
		public int[] escalar(List<Integer> array) {
			limparTela();
			double valorTx = Double.parseDouble(janelaDados.menuTransfGeom.campoSx.getText());
			double valorTy = Double.parseDouble(janelaDados.menuTransfGeom.campoSy.getText());
			// transladar para origem:
			int[] arrayCoordOrigem = transladarOrigem(coordenadasObjeto);

			int[] coordenadasObjetoEscalado = new int[arrayCoordOrigem.length];

			for (int i = 0; i < arrayCoordOrigem.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoEscalado[i] = (int) (arrayCoordOrigem[i] * valorTx);
				} else {
					coordenadasObjetoEscalado[i] = (int) (arrayCoordOrigem[i] * valorTy);
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem = transladarPontoOriginal(coordenadasObjetoEscalado);

			for (int j = 0; j < array.size(); j++) {
				System.out.println("escala " + j + ": " + array.get(j));
			}

			return arrayCoordPontoOrigem;
		}

		public List<Integer> escalarComp(List<Integer> array) {
			double valorTx = Double.parseDouble(janelaDados.menuTransfGeomComp.campoSx.getText());
			double valorTy = Double.parseDouble(janelaDados.menuTransfGeomComp.campoSy.getText());
			System.out.println("Aplicando escala no objeto");
			// transladar para origem:
			int[] arrayCoordOrigem = transladarOrigem(array);

			int[] coordenadasObjetoEscalado = new int[arrayCoordOrigem.length];

			for (int i = 0; i < arrayCoordOrigem.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoEscalado[i] = (int) (arrayCoordOrigem[i] * valorTx);
				} else {
					coordenadasObjetoEscalado[i] = (int) (arrayCoordOrigem[i] * valorTy);
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem = transladarPontoOriginalComp(coordenadasObjetoEscalado);

			for (int j = 0; j < array.size(); j++) {
				array.set(j, arrayCoordPontoOrigem[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("Escala " + j + ": " + array.get(j));
			}
			return array;
		}

		public int[] cisalhar(List<Integer> array) {
			limparTela();
			double campoCx = Double.parseDouble(janelaDados.menuTransfGeom.campoCx.getText());
			double campoCy = Double.parseDouble(janelaDados.menuTransfGeom.campoCy.getText());

			// transladar para origem:
			int[] arrayCoordOrigem = transladarOrigem(array);

			int[] coordenadasObjetoCisalhado = new int[arrayCoordOrigem.length];

			for (int i = 0; i < arrayCoordOrigem.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoCisalhado[i] = (int) (arrayCoordOrigem[i] + (campoCx * arrayCoordOrigem[i + 1]));
				} else {
					coordenadasObjetoCisalhado[i] = (int) (arrayCoordOrigem[i] + (campoCy * arrayCoordOrigem[i - 1]));
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem = transladarPontoOriginal(coordenadasObjetoCisalhado);

			return arrayCoordPontoOrigem;
		}

		public List<Integer> cisalharComp(List<Integer> array) {
			double campoCx = Double.parseDouble(janelaDados.menuTransfGeomComp.campoCx.getText());
			double campoCy = Double.parseDouble(janelaDados.menuTransfGeomComp.campoCy.getText());

			// transladar para origem:
			int[] arrayCoordOrigem = transladarOrigem(array);

			int[] coordenadasObjetoCisalhado = new int[arrayCoordOrigem.length];

			for (int i = 0; i < arrayCoordOrigem.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoCisalhado[i] = (int) (arrayCoordOrigem[i] + (campoCx * arrayCoordOrigem[i + 1]));
				} else {
					coordenadasObjetoCisalhado[i] = (int) (arrayCoordOrigem[i] + (campoCy * arrayCoordOrigem[i - 1]));
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem = transladarPontoOriginalComp(coordenadasObjetoCisalhado);

			for (int j = 0; j < array.size(); j++) {
				array.set(j, arrayCoordPontoOrigem[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("Cisalhamento " + j + ": " + array.get(j));
			}

			return array;
		}

		public int[] rotacionar(List<Integer> array) {
			limparTela();
			double campoAng = Double.parseDouble(janelaDados.menuTransfGeom.campoAng.getText());

			// transladar para origem:
			int[] arrayCoordOrigem = transladarOrigem(array);

			int[] coordenadasObjetoRotacionado = new int[arrayCoordOrigem.length];

			for (int i = 0; i < arrayCoordOrigem.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoRotacionado[i] = (int) (arrayCoordOrigem[i] * Math.cos(Math.toRadians(campoAng))
							- arrayCoordOrigem[i + 1] * Math.sin(Math.toRadians(campoAng)));
				} else {
					coordenadasObjetoRotacionado[i] = (int) (arrayCoordOrigem[i] * Math.cos(Math.toRadians(campoAng))
							+ arrayCoordOrigem[i - 1] * Math.sin(Math.toRadians(campoAng)));
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem = transladarPontoOriginal(coordenadasObjetoRotacionado);

			return arrayCoordPontoOrigem;
		}

		public List<Integer> rotacionarComp(List<Integer> array) {
			double campoAng = Double.parseDouble(janelaDados.menuTransfGeomComp.campoAng.getText());

			// transladar para origem:
			int[] arrayCoordOrigem = transladarOrigem(array);

			int[] coordenadasObjetoRotacionado = new int[arrayCoordOrigem.length];

			for (int i = 0; i < arrayCoordOrigem.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoRotacionado[i] = (int) (arrayCoordOrigem[i] * Math.cos(Math.toRadians(campoAng))
							- arrayCoordOrigem[i + 1] * Math.sin(Math.toRadians((campoAng*-1))));
				} else {
					coordenadasObjetoRotacionado[i] = (int) (arrayCoordOrigem[i] * Math.cos(Math.toRadians(campoAng))
							+ arrayCoordOrigem[i - 1] * Math.sin(Math.toRadians((campoAng*-1))));
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem = transladarPontoOriginalComp(coordenadasObjetoRotacionado);

			for (int j = 0; j < array.size(); j++) {
				array.set(j, arrayCoordPontoOrigem[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("rotação " + j + ": " + array.get(j));
			}

			return array;
		}

		public int[] reflexaoEixoX(List<Integer> array) {
			System.out.println("Reflexão em X");
			limparTela();

			int[] coordenadasObjetoReflexaoEmX = new int[coordenadasObjeto.size()];

			for (int i = 0; i < coordenadasObjeto.size(); i++) {
				if (i % 2 != 0) {
					int alturaTelaEmY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;
					if (coordenadasObjeto.get(i) < (alturaTelaEmY) / 2) {
						coordenadasObjetoReflexaoEmX[i] = (int) (coordenadasObjeto.get(i)
								+ ((alturaTelaEmY) / 2 - coordenadasObjeto.get(i)) * 2);
					} else {
						coordenadasObjetoReflexaoEmX[i] = (int) alturaTelaEmY - coordenadasObjeto.get(i);
					}
				} else {
					coordenadasObjetoReflexaoEmX[i] = coordenadasObjeto.get(i);
				}
			}
			return coordenadasObjetoReflexaoEmX;
		}

		public List<Integer> reflexaoEixoXComp(List<Integer> array) {
			int[] coordenadasObjetoReflexaoEmX = new int[array.size()];
			for (int i = 0; i < array.size(); i++) {
				if (i % 2 != 0) {
					int alturaTelaEmY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;
					if (array.get(i) < (alturaTelaEmY) / 2) {
						coordenadasObjetoReflexaoEmX[i] = (int) (array.get(i) + ((alturaTelaEmY) / 2 - array.get(i)) * 2);
					} else {
						coordenadasObjetoReflexaoEmX[i] = (int) alturaTelaEmY - array.get(i);
					}
				} else {
					coordenadasObjetoReflexaoEmX[i] = array.get(i);
				}
			}

			for (int j = 0; j < array.size(); j++) {
				array.set(j, coordenadasObjetoReflexaoEmX[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("reflexão em X " + j + ": " + array.get(j));
			}

			return array;
		}

		public int[] reflexaoEixoY(List<Integer> array) {
			System.out.println("Reflexão em Y");
			limparTela();

			int[] coordenadasObjetoReflexaoEmY = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0 || i == 0) {
					int larguraTelaEmX = janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin;
					if (array.get(i) < (larguraTelaEmX) / 2) {
						coordenadasObjetoReflexaoEmY[i] = (int) (larguraTelaEmX / 2
								+ ((larguraTelaEmX) / 2 - array.get(i)));
					} else {
						coordenadasObjetoReflexaoEmY[i] = (int) larguraTelaEmX - array.get(i);
					}
				} else {
					coordenadasObjetoReflexaoEmY[i] = array.get(i);
				}
			}
			return coordenadasObjetoReflexaoEmY;
		}

		public List<Integer> reflexaoEixoYComp(List<Integer> array) {
			int[] coordenadasObjetoReflexaoEmY = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0 || i == 0) {
					int larguraTelaEmX = janelaConfig.valorDispositivoXmax - janelaConfig.valorDispositivoXmin;
					if (array.get(i) < (larguraTelaEmX) / 2) {
						coordenadasObjetoReflexaoEmY[i] = (int) (larguraTelaEmX / 2
								+ ((larguraTelaEmX) / 2 - array.get(i)));
					} else {
						coordenadasObjetoReflexaoEmY[i] = (int) larguraTelaEmX - array.get(i);
					}
				} else {
					coordenadasObjetoReflexaoEmY[i] = array.get(i);
				}
			}

			for (int j = 0; j < array.size(); j++) {
				array.set(j, coordenadasObjetoReflexaoEmY[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("reflexão em Y " + j + ": " + array.get(j));
			}
			return array;
		}

		public int[] reflexaoEmTornoOrigem(List<Integer> array) {
			System.out.println("Reflexão em torno da origem");
			limparTela();

			int[] coordCentroDeTela = coordCentroTela(array);
			int[] coordCentroDeTelaRefletido = new int[coordCentroDeTela.length];

			int[] coordenadasObjetoReflexaoEmTornoDaOrigem = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				coordCentroDeTelaRefletido[i] = (int) ((coordCentroDeTela[i]) * (-1));
			}

			int[] coordOriginal = coordOriginal(coordCentroDeTelaRefletido);

			return coordOriginal;
		}

		public List<Integer> reflexaoEmTornoOrigemComp(List<Integer> array) {

			int[] coordCentroDeTela = coordCentroTela(array);
			int[] coordCentroDeTelaRefletido = new int[coordCentroDeTela.length];

			int[] coordenadasObjetoReflexaoEmTornoDaOrigem = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				coordCentroDeTelaRefletido[i] = (int) ((coordCentroDeTela[i]) * (-1));
			}

			int[] coordOriginal = coordOriginal(coordCentroDeTelaRefletido);

			for (int j = 0; j < array.size(); j++) {
				array.set(j, coordOriginal[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("reflexão em torno da origem " + j + ": " + array.get(j));
			}

			return array;
		}

		public int[] reflexaoEmTornoRetaYX(List<Integer> array) {
			System.out.println("Reflexão em torno da reta Y=X");
			limparTela();

			int[] coordCentroDeTela = coordCentroTela(array);
			int[] coordCentroDeTelaRefletido = new int[coordCentroDeTela.length];

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0) {
					coordCentroDeTelaRefletido[i] = (int) (coordCentroDeTela[i + 1]);
				} else {
					coordCentroDeTelaRefletido[i] = (int) (coordCentroDeTela[i - 1]);
				}
			}
			int[] coordOriginal = coordOriginal(coordCentroDeTelaRefletido);

			return coordOriginal;
		}

		public List<Integer> reflexaoEmTornoRetaYXComp(List<Integer> array) {
			int[] coordCentroDeTela = coordCentroTela(array);
			int[] coordCentroDeTelaRefletido = new int[coordCentroDeTela.length];

			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0) {
					coordCentroDeTelaRefletido[i] = (int) (coordCentroDeTela[i + 1]);
				} else {
					coordCentroDeTelaRefletido[i] = (int) (coordCentroDeTela[i - 1]);
				}
			}
			int[] coordOriginal = coordOriginal(coordCentroDeTelaRefletido);

			for (int j = 0; j < array.size(); j++) {
				array.set(j, coordOriginal[j]);
			}

			for (int j = 0; j < array.size(); j++) {
				System.out.println("reflexão em torno da reta Y=X " + j + ": " + array.get(j));
			}

			return array;
		}

		public int[] reflexaoEmTornoRetaQualquer(List<Integer> array) {
			System.out.println("Reflexão em torno da reta qualquer");
			limparTela();

			double a = Double.parseDouble(janelaDados.menuTransfGeom.campoA.getText());
			double b = Double.parseDouble(janelaDados.menuTransfGeom.campoB.getText());

			// transladar objeto Ty = B
			int[] coordenadasObjetoTransladado = new int[array.size()];
			for (int i = 0; i < array.size(); i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) + 0);

				} else {
					coordenadasObjetoTransladado[i] = (int) (array.get(i) + b);

				}
			}
			

			// Rotacionar no angulo = arctg(A)
			// transladar para origem:
			int[] arrayCoordOrigem = transladarOrigem2(coordenadasObjetoTransladado);

			int[] coordenadasObjetoRotacionado = new int[arrayCoordOrigem.length];

			for (int i = 0; i < arrayCoordOrigem.length; i++) {
				if (i % 2 == 0 || i == 0) {
					coordenadasObjetoRotacionado[i] = (int) (arrayCoordOrigem[i] * Math.cos((Math.atan(a))
							- arrayCoordOrigem[i + 1] * Math.sin((Math.atan(a)))));
				} else {
					coordenadasObjetoRotacionado[i] = (int) (arrayCoordOrigem[i] * Math.cos((Math.atan(a)))
							+ arrayCoordOrigem[i - 1] * Math.sin((Math.atan(a))));
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem = transladarPontoOriginal(coordenadasObjetoRotacionado);
			
			
			// Reflexão em torno o eixo X
			int[] coordenadasObjetoReflexaoEmX = new int[arrayCoordPontoOrigem.length];

			for (int i = 0; i < arrayCoordPontoOrigem.length; i++) {
				if (i % 2 != 0) {
					int alturaTelaEmY = janelaConfig.valorDispositivoYmax - janelaConfig.valorDispositivoYmin;
					if (arrayCoordPontoOrigem[i] < (alturaTelaEmY) / 2) {
						coordenadasObjetoReflexaoEmX[i] = (int) (arrayCoordPontoOrigem[i]
								+ ((alturaTelaEmY) / 2 - arrayCoordPontoOrigem[i]) * 2);
					} else {
						coordenadasObjetoReflexaoEmX[i] = (int) alturaTelaEmY - arrayCoordPontoOrigem[i];
					}
				} else {
					coordenadasObjetoReflexaoEmX[i] = arrayCoordPontoOrigem[i];
				}
			}

			// Rotacionar no angulo = arctg(-A)
			// transladar para origem:
			int[] arrayCoordOrigem2 = transladarOrigem2(coordenadasObjetoReflexaoEmX);

			int[] coordenadasObjetoRotacionado2 = new int[arrayCoordOrigem2.length];

			for (int m = 0; m < arrayCoordOrigem2.length; m++) {
				if (m % 2 == 0 || m == 0) {
					coordenadasObjetoRotacionado2[m] = (int) (arrayCoordOrigem2[m]
							* Math.cos((Math.atan(a * (-1)))
									- arrayCoordOrigem2[m + 1] * Math.sin((Math.atan(a * (-1))))));
				} else {
					coordenadasObjetoRotacionado2[m] = (int) (arrayCoordOrigem2[m]
							* Math.cos((Math.atan(a * (-1))))
							+ arrayCoordOrigem2[m - 1] * Math.sin((Math.atan(a * (-1)))));
				}
			}
			// Voltar para ponto original
			int[] arrayCoordPontoOrigem2 = transladarPontoOriginal(coordenadasObjetoRotacionado2);

			// transladar objeto Ty = -B
			int[] coordenadasObjetoTransladado2 = new int[arrayCoordPontoOrigem2.length];
			for (int n = 0; n < arrayCoordPontoOrigem2.length; n++) {
				if (n % 2 == 0 || n == 0) {
					coordenadasObjetoTransladado2[n] = (int) (arrayCoordPontoOrigem2[n] + 0);

				} else {
					coordenadasObjetoTransladado2[n] = (int) (arrayCoordPontoOrigem2[n] - b);

				}
			}
			
			return coordenadasObjetoTransladado2;
		}

		public List<Integer> transformarArrayEmArrayList(int[] array) {
			List<Integer> lista = new ArrayList<>();
			for (int i = 0; i < array.length; i++) {
				lista.add(array[i]);
			}
			return lista;
		}

		public int[] transformarArrayListEmArray(List<Integer> lista) {
			int[] array = new int[lista.size()];
			for (int i = 0; i < lista.size(); i++) {
				array[i] = lista.get(i);
			}
			return array;
		}

		public void atualizarListaTransformada(List<Integer> lista) {
			coordenadasObjetoTransformado.clear();
			for (int i = 0; i < lista.size(); i++) {
				coordenadasObjetoTransformado.add(lista.get(i));
			}
		}

	
}
