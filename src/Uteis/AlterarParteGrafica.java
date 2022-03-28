package Uteis;

import Janelas.JanelaDados;
import Janelas.JanelaPrincipal;

public class AlterarParteGrafica {
	
	JanelaDados janelaDados;
	JanelaPrincipal janelaPrincipal;
	
	public AlterarParteGrafica(JanelaDados janelaDados, JanelaPrincipal janelaPrincipal) {
		this.janelaDados = janelaDados;
		this.janelaPrincipal = janelaPrincipal;
	}
	
	// MOSTRAR OS VALORES NA TABELA GRAFICA
		public void adicionaItensTabelaRetaDDA(int xAux, int yAux, int tabelaLinha, int tabelaColuna) {
			int x = (xAux-janelaPrincipal.tamanhoTelaX/2);
			int y = (yAux-janelaPrincipal.tamanhoTelaY/2)*(-1);
			janelaDados.menuRetaDDA.tabela.setValueAt(x, tabelaLinha, tabelaColuna++);
			janelaDados.menuRetaDDA.tabela.setValueAt(y, tabelaLinha, tabelaColuna);
			 
		}
		
		public void adicionaItensTabelaRetaPM(int d, int xAux, int yAux, int tabelaLinha, int tabelaColuna) {
			int x = (xAux-janelaPrincipal.tamanhoTelaX/2);
			int y = (yAux-janelaPrincipal.tamanhoTelaY/2)*(-1);
			
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
		public void adicionaItensTabelaEE(int x, int y, int tabelaLinha, int tabelaColuna) {
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);//X0 = X
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);//Y0 = Y
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);//X1 = X
			janelaDados.menuCircunferenciaEE.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);//Y1 = -Y
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
		public void adicionaItensTabelaElipse(int x, int y, int tabelaLinha, int tabelaColuna) {
			janelaDados.menuElipse.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);//X0 = X
			janelaDados.menuElipse.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);//Y0 = Y
			janelaDados.menuElipse.tabela.setValueAt(x, tabelaLinha++, tabelaColuna);//X1 = X
			janelaDados.menuElipse.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);//Y1 = -Y
			janelaDados.menuElipse.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);//X2 = -X
			janelaDados.menuElipse.tabela.setValueAt(-y, tabelaLinha++, tabelaColuna);//Y2 = -Y
			janelaDados.menuElipse.tabela.setValueAt(-x, tabelaLinha++, tabelaColuna);//X3 = -X
			janelaDados.menuElipse.tabela.setValueAt(y, tabelaLinha++, tabelaColuna);//Y3 = Y
		}

}
