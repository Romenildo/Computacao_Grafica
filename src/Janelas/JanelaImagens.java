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
	
	
	 
	 
	 
	
	
}
