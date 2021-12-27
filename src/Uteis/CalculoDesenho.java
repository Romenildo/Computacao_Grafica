package Uteis;

//possui os principais funcoes de calculo dos desenhos
import Janelas.JanelaDados;
import Janelas.JanelaPrincipal;

public class CalculoDesenho {

	JanelaDados janelaDados;
	JanelaPrincipal janelaPrincipal;
	AlterarParteGrafica parteGrafica;
	
	public CalculoDesenho(JanelaDados janelaDados, JanelaPrincipal janelaPrincipal) {
		this.janelaDados = janelaDados;
		this.janelaPrincipal = janelaPrincipal;
		parteGrafica = new AlterarParteGrafica(janelaDados);
	}
	// ---- CALCULO DAS RETAS ----
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
				janelaPrincipal.drawPixel((int) x, (int) y);
				parteGrafica.adicionaItensTabelaRetaDDA((int)x ,(int)y,tabelaLinha++,tabelaColuna);
				
				if (coordenadas[2] > coordenadas[0]) {
					while (x < coordenadas[2]) {
						x = x + xInc;
						y = y + yInc;
						janelaPrincipal.drawPixel((int) x, (int) y);
						parteGrafica.adicionaItensTabelaRetaDDA((int)(x-janelaPrincipal.tamanhoTelaX/2) ,(int)(y-janelaPrincipal.tamanhoTelaY/2)*(-1),tabelaLinha++,tabelaColuna);
					}
				} else if (coordenadas[2] < coordenadas[0]) {
					while (x > coordenadas[2]) {
						x = x + xInc;
						y = y + yInc;
						janelaPrincipal.drawPixel((int) x, (int) y);
						parteGrafica.adicionaItensTabelaRetaDDA((int)x ,(int)y,tabelaLinha++,tabelaColuna);
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
				janelaPrincipal.drawPixel(x, y);
				parteGrafica.adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);

				// Escolhendo próximos pontos:
				if (coordenadas[2] > coordenadas[0]) {
					while (x < coordenadas[2]) {
						if (d <= 0) {
							// Escolhido ponto E (inferior)
							d = d + incE;
							x = x + 1;
							janelaPrincipal.drawPixel(x, y);
							parteGrafica.adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);

						} else {
							// Escolhido Ponto NE (superior)
							d = d + incNE;
							x = x + 1;
							y = y - 1; // usado negativo, pois as coord Y da tela crescem para baixo
							janelaPrincipal.drawPixel(x, y);
							parteGrafica.adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);
						}
					}
				} else if (coordenadas[2] < coordenadas[0]) {
					while (x > coordenadas[2]) {
						if (d <= 0) {
							// Escolhido ponto E (inferior)
							d = d + incE;
							x = x - 1;
							janelaPrincipal.drawPixel(x, y);
							parteGrafica.adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);

						} else {
							// Escolhido Ponto NE (superior)
							d = d + incNE;
							x = x - 1;
							y = y + 1;  
							janelaPrincipal.drawPixel(x, y);
							parteGrafica.adicionaItensTabelaRetaPM(d, x, y, tabelaLinha++, tabelaColuna);
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
					janelaPrincipal.drawPixel(posicaoX + x, posicaoY + y);
					janelaPrincipal.drawPixel(posicaoX + x, posicaoY - y);
					
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
						parteGrafica.adicionaItensTabelaMT(x, y, tabelaLinha,tabelaColuna++);
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

				janelaPrincipal.drawPixel(x + posicaoX ,posicaoY - y);//desenhar o centro
				ponto_circulo(x, y,posicaoX, posicaoY);
				parteGrafica.adicionaItensTabelaPM(x, y, tabelaLinha,tabelaColuna);
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
					parteGrafica.adicionaItensTabelaPM(x, y, tabelaLinha,tabelaColuna);
					janelaDados.menuCircunferenciaPM.tabela.setValueAt(d, 0, tabelaColuna++);
				}
			}
			
			public void ponto_circulo(int x, int y, int posicaoX, int posicaoY) {
				janelaPrincipal.drawPixel(x + posicaoX, posicaoY + y);
				janelaPrincipal.drawPixel(y + posicaoX, posicaoY + x);
				janelaPrincipal.drawPixel(y + posicaoX, posicaoY - x);
				janelaPrincipal.drawPixel(x + posicaoX, posicaoY - y);
				janelaPrincipal.drawPixel(-x + posicaoX, posicaoY - y);
				janelaPrincipal.drawPixel(-y + posicaoX, posicaoY - x);
				janelaPrincipal.drawPixel(-y + posicaoX, posicaoY + x);
				janelaPrincipal.drawPixel(-x + posicaoX, posicaoY + y);
			}
			//--- FIM DOS METODOS DE DESENHO 2D ---
			
}
