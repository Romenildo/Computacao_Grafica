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
		
		
        inicioX = (janelaPrincipal.tamanhoTelaX - 500d) / 2;
        inicioY = (janelaPrincipal.tamanhoTelaY - 300d) / 2;
        
    }

    public void DesenharSnowFlake(int interacoes) {
        inicioX = (janelaPrincipal.tamanhoTelaX - 500d) / 2;
        inicioY = (janelaPrincipal.tamanhoTelaY - 300d) / 2;

        int passos = interacoes;
        int tamanho = (int) (500 / (Math.pow(3, passos)));

        kochSnowflake(passos, tamanho);
        angulo += 120;
        kochSnowflake(passos, tamanho);
        angulo += 120;
        kochSnowflake(passos, tamanho);
    }

    public void kochSnowflake(int passos, int tamanho) {

        if (passos == 0) {

            double endX = (Math.cos(Math.toRadians(angulo)) * tamanho + inicioX);
            double endY = (Math.sin(Math.toRadians(angulo)) * tamanho + inicioY);

           // g2.setStroke(new BasicStroke(2));
            
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