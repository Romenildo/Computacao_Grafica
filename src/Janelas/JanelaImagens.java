package Janelas;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/** 
 * Classe Janela principal
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class JanelaImagens extends JFrame {
	
	public Boolean ativada = false;
	JLabel labelImagem1;
	
	public JPanel panelPrincipal = new JPanel();
	
	
	public JanelaImagens(String titulo) {
		super(titulo);
		panelPrincipal.setBounds(0, 0, 800, 800);
		add(panelPrincipal);
		
		
	}// fim do construtor
	
	
	
	
	public void start() {
		setSize(800, 800);
		setUndecorated(false);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ativada = true;
	}
	
	
	 
	 
	 /*
	  private void aplicarFiltro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarFiltro
	        PanelMenuFiltros menuFiltros = PanelMenuFiltros.getInstance();

	        switch (menuFiltros.getTipoAlgoritimo()) {
	            case MEDIA:
	                panelImgOutput.getGraphics().drawImage(new FiltroMedia(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            case MEDIANA:
	                panelImgOutput.getGraphics().drawImage(new FiltroMediana(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            case PASSA_ALTA_BASICO:
	                panelImgOutput.getGraphics().drawImage(new FiltroPassaAlta(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            case OPERADOR_ROBERTS:
	                panelImgOutput.getGraphics().drawImage(new FiltroRoberts(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            case OPERADOR_ROBERTS_CRUZADO:
	                panelImgOutput.getGraphics().drawImage(new FiltroRobertsCruzado(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            case OPERADOR_PEWITT:
	                panelImgOutput.getGraphics().drawImage(new FiltroPrewitt(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            case OPERADOR_SOBEL:
	                panelImgOutput.getGraphics().drawImage(new FiltroSobel(imagemMatriz, getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            case ALTO_REFORCO:
	                panelImgOutput.getGraphics().drawImage(new FiltroAltoReforco(imagemMatriz, menuFiltros.getA() ,getImgWidth(), getImgHeight()).run(), 0, 0, null);
	                break;
	            default:
	                break;
	        }
	    }
	    */
	 
	 
	
	
}
