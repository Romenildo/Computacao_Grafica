package Uteis;



import java.awt.*;
import java.awt.geom.*;
import java.util.Date;
import javax.swing.JFrame;

import Janelas.JanelaPrincipal;


public class RitmoCardiaco extends JFrame {

    private int largura;
    private int altura;
    JanelaPrincipal janelaPrincipal;

    public RitmoCardiaco(int largura, int altura, JanelaPrincipal janelaPrincipal) {
        this.largura =800;
        this.altura = 800;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void desenharRitmoCardiaco() {
    	 //largura da linha
        janelaPrincipal.ativaRitmo();

         //aplicar as rotacoes
         AffineTransform rotacaoEmY = new AffineTransform();
         rotacaoEmY.setToScale(1, -1);
         AffineTransform rotacao = new AffineTransform();
         rotacao.setToTranslation(0, altura);
         rotacaoEmY.preConcatenate(rotacao);

         //adiciona o g2d do java a rotacao
         janelaPrincipal.Transforma(rotacaoEmY);

         //desenho mover sozinho
         Rectangle2D.Double windowFrame = new Rectangle2D.Double(2, 2, largura, altura);
         Rectangle2D.Double heart = new Rectangle2D.Double(2, 2, 2, 2);
         AffineTransform singleTranslation = new AffineTransform();
         singleTranslation.setToTranslation(1, 0);
         AffineTransform accumulatedTranslation = new AffineTransform();

         // Posicao de partida
         accumulatedTranslation.setToTranslation(0, largura/2);
         janelaPrincipal.limparTela();
         
         //loop de todos os pontos
         for (int i = 0; i < largura+ 50; i++) {
        	 
        	 //adiciona a tela do desenho
         	janelaPrincipal.instanciarTela(windowFrame);
         	
             ///desenha os pixel
         	janelaPrincipal.desenharPixeis(accumulatedTranslation.createTransformedShape(heart));

             // posicoes de inclinacoes
             if (i > 80 & i <= 130 || i > 200 & i <= 220 || i > 290 & i <= 320 || i > 360 & i <= 370
                     || i > 440 & i <= 500 || i > 580 & i <= 600 || i > 660 & i <= 690 || i > 760 & i <= 800) {
                 singleTranslation.setToTranslation(0.3, 1);
             } else if (i > 130 & i <= 200 || i > 320 & i <= 360 || i > 500 & i <= 580 || i > 690 & i <= 760) {
                 singleTranslation.setToTranslation(0.3, -1);
             } else {
                 singleTranslation.setToTranslation(1, 0);
             }
             accumulatedTranslation.preConcatenate(singleTranslation);

             
         }
         //finaliza
         dispose();
     }
 
    



}