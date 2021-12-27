/** 
 * Classe Main 
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale Ferreira.
 */

import javax.swing.JFrame;

import Janelas.JanelaConfig;

public class Main {
	
public static void main(String[] args) {		
	    
		JanelaConfig janelaConfig  = new JanelaConfig();		
		janelaConfig.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		janelaConfig.setSize (400, 500); 
		janelaConfig.setVisible (true); 
		janelaConfig.setLocationRelativeTo(null);//janela no centro da tela
		janelaConfig.setResizable(false);//não pode redimensionar janela	
	}//fim do main

}
