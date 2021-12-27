package Uteis;

import Janelas.JanelaDados;

public class AlterarParteGrafica {
	
	JanelaDados janelaDados;
	public AlterarParteGrafica(JanelaDados janelaDados) {
		this.janelaDados = janelaDados;
	}
	
	// MOSTRAR OS VALORES NA TABELA GRAFICA
		public void adicionaItensTabelaRetaDDA(int x, int y, int tabelaLinha, int tabelaColuna) {
			janelaDados.menuRetaDDA.tabela.setValueAt(x, tabelaLinha, tabelaColuna++);
			janelaDados.menuRetaDDA.tabela.setValueAt(y, tabelaLinha, tabelaColuna);
			 
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
