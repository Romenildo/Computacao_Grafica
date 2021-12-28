package Uteis;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Janelas.JanelaPrincipal;

public class Uteis {
	JanelaPrincipal janelaPrincipal;
	public Uteis(JanelaPrincipal janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
	}
	
	public int[] pegarPosicoes(JTextField campo){
		
		int posicoes[] = {janelaPrincipal.tamanhoTelaX/2, janelaPrincipal.tamanhoTelaY/2};
		String [] stringSeparada =campo.getText().split(",");
		
		try {
			if(stringSeparada.length == 2) {
				posicoes[0] += Integer.parseInt(stringSeparada[0]);
				posicoes[1] += Integer.parseInt(stringSeparada[1])*-1;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog (null,"Parametro somente como : X,Y", "Atenção", JOptionPane.WARNING_MESSAGE);
			posicoes[0]=0;
			posicoes[1]=0;
			return posicoes;
		}
		return posicoes;
	}
	
	public int[] pegarPosicoesReta(JTextField campoInicial, JTextField campoFinal) {
		int[] coordRetaDDA = {janelaPrincipal.tamanhoTelaX/2, janelaPrincipal.tamanhoTelaY/2,janelaPrincipal.tamanhoTelaX/2, janelaPrincipal.tamanhoTelaY/2};
		
		String [] stringSeparada =campoInicial.getText().split(",");
		String [] stringSeparada2 = campoFinal.getText().split(",");
		
		try {
			if(stringSeparada.length == 2 && stringSeparada2.length == 2) {
				coordRetaDDA[0] += Integer.parseInt(stringSeparada[0]);
				coordRetaDDA[1] += Integer.parseInt(stringSeparada[1])*-1;
				coordRetaDDA[2] += Integer.parseInt(stringSeparada2[0]);
				coordRetaDDA[3] += Integer.parseInt(stringSeparada2[1])*-1;
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog (null,"Parametro somente como : X,Y", "Atenção", JOptionPane.WARNING_MESSAGE);
			for(int i =0; i<4;i++) {
				coordRetaDDA[i]=0;
			}
			return coordRetaDDA;
		}
		
		return coordRetaDDA;
	}

}
