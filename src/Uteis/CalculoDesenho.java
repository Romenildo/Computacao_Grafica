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
		parteGrafica = new AlterarParteGrafica(janelaDados, janelaPrincipal);
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
				parteGrafica.adicionaItensTabelaRetaDDA((int)x ,(int)y, tabelaLinha++,tabelaColuna);
				
				if (coordenadas[2] > coordenadas[0]) {
					while (x < coordenadas[2]) {
						x = x + xInc;
						y = y + yInc;
						janelaPrincipal.drawPixel((int) x, (int) y);
						parteGrafica.adicionaItensTabelaRetaDDA((int)x ,(int)y ,tabelaLinha++,tabelaColuna);
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
				int dy = Math.abs(coordenadas[3] - coordenadas[1]);
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
					parteGrafica.adicionaItensTabelaEE(x, y, tabelaLinha, tabelaColuna);
					
					tabelaLinha = 0;
					tabelaColuna++;
				}	
			}
			
			//CIRCUNFERENCIA COM METODO TRIGONOMETRICO
				public void desenhaCircunferenciaMT(int raio, int posicaoX, int posicaoY) {
					int tabelaLinha = 0;
					int tabelaColuna = 1;
					int x ,y;
					
					for(int teta = 0; teta <= 45; teta++) {
						
						x = (int) Math.round(raio * Math.cos(Math.toRadians(teta)));
						y = (int) Math.round(raio * Math.sin(Math.toRadians(teta)));
					
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
			
			//DESENHO ELIPSE apostila
			public void desenharElipse(int posX, int posY, int diametro, int altura){
				int tabelaLinha = 0, tabelaColuna = 1;
				int x,y;
				float d1,d2;
				int a = diametro, b=altura;
				/* Valores iniciais */ //b altura a diametro
				x = 0;
				y = b;
				
				d1 = (float) (b * b - a * a * b + a * a / 4.0);
				pontos_Elipse(x, y, posX, posY, tabelaLinha, tabelaColuna);
				tabelaColuna++;
				
				while(a * a * (y - 0.5) > b * b * (x + 1)){
					//REGIAO 1 CIMA/ESQUEDA
					if (d1 < 0) {
						d1 = d1 + b * b * (2 * x + 3);
						x++;
					}else{
						d1 = d1 + b * b * (2 * x + 3) + a * a * (-2 * y + 2);
						x++;
						y--;
					}
					pontos_Elipse(x, y, posX, posY, tabelaLinha, tabelaColuna);	
					tabelaColuna++;
					}
				d2 = (float) (b * b * (x + 0.5) * (x + 0.5) + a * a * (y - 1) * (y - 1) - a * a * b * b);
				
				while(y > 0){
					//REGIAO 2 BAIXO/DIREITA
					if (d2 < 0){
						d2 = d2 + b * b * (2 * x + 2) + a * a * (-2 * y + 3);
						x++;
						y--;
					}else{
						d2 = d2 + a * a * (-2 * y + 3);
						y--;
					}
					pontos_Elipse(x, y, posX, posY, tabelaLinha, tabelaColuna);
					tabelaColuna++;
					}
			}
			
			public void pontos_Elipse(int x, int y, int posicaoX, int posicaoY, int tabelaLinha, int tabelaColuna) {
				
				janelaPrincipal.drawPixel(x + posicaoX, posicaoY + y);
				janelaPrincipal.drawPixel(x + posicaoX, posicaoY - y);
				janelaPrincipal.drawPixel(-x + posicaoX, posicaoY - y);
				janelaPrincipal.drawPixel(-x + posicaoX, posicaoY + y);
				tabelaLinha = 0;
				parteGrafica.adicionaItensTabelaElipse(x, y, tabelaLinha, tabelaColuna);

			}
			//--- FIM DOS METODOS DE DESENHO 2D ---

}
