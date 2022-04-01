package Uteis;

import javax.swing.JPanel;

import Janelas.JanelaDados;
import Janelas.JanelaPrincipal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;



public class Koch_Snowflake extends JPanel {
	
	JanelaDados janelaDados;
	JanelaPrincipal janelaPrincipal;
	
    private double inicioX;
    private double inicioY;
    private double angulo;

    public Koch_Snowflake(JanelaPrincipal janelaPrincipal) {
    	this.janelaDados = janelaDados;
		this.janelaPrincipal = janelaPrincipal;
		
		
    }

    public void DesenharSnowFlake(int interacoes) {
    	angulo =0;
    	//posicao do inicio do desenho
        inicioX = (janelaPrincipal.tamanhoTelaX ) / 4;
        inicioY = (janelaPrincipal.tamanhoTelaY ) / 4;

        int passos = interacoes;//quantidade de interações nos triagolos
        
        int tamanho = (int) (500 / (Math.pow(3, passos)));
        
        kochSnowflake(passos, tamanho);
        angulo += 120;
        kochSnowflake(passos, tamanho);
        angulo += 120;
        kochSnowflake(passos, tamanho);
    }

    public void kochSnowflake(int passos, int tamanho) {

        if (passos == 0) {

        	//linha antes de rotacionar
            double endX = (Math.cos(Math.toRadians(angulo)) * tamanho + inicioX);
            double endY = (Math.sin(Math.toRadians(angulo)) * tamanho + inicioY);

            
            janelaPrincipal.drawLine((int) inicioX, (int) inicioY, (int) endX, (int) endY);

            inicioX = endX;
            inicioY = endY;

        } else {
            kochSnowflake(passos - 1, tamanho);
            angulo -= 60;
            kochSnowflake(passos - 1, tamanho);
            angulo += 120;
            kochSnowflake(passos - 1, tamanho);
            angulo -= 60;
            kochSnowflake(passos - 1, tamanho);
        }
    }
}