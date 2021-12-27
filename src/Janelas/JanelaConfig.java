package Janelas;

/** 
 * Classe Janela Config
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class JanelaConfig extends JFrame {
	
	JLabel CoordenadasDoMundo;
	JLabel CoordenadasDoMundoXmin;//TEXTo
	JLabel CoordenadasDoMundoXmax;
	JLabel CoordenadasDoMundoYmin;
	JLabel CoordenadasDoMundoYmax;
	JTextField ValorCoordDoMundoXmin;
	JTextField ValorCoordDoMundoXmax;//campo em branco
	JTextField ValorCoordDoMundoYmin;
	JTextField ValorCoordDoMundoYmax;
	
	JLabel CoordenadasDoDispositivo;
	JLabel CoordenadasDoDispositivoXmin;
	JLabel CoordenadasDoDispositivoXmax;
	JLabel CoordenadasDoDispositivoYmin;
	JLabel CoordenadasDoDispositivoYmax;
	JTextField ValorCoordDoDispositivoXmin;
	JTextField ValorCoordDoDispositivoXmax;
	JTextField ValorCoordDoDispositivoYmin;
	JTextField ValorCoordDoDispositivoYmax;
	
	JButton BtSalvar;
	
	JanelaPrincipal janelaPrincipal;
	int valorDispositivoXmin;
	int valorDispositivoXmax;//pega o valor do input
	int valorDispositivoYmin;
	int valorDispositivoYmax;
	int valorMundoXmin;
	int valorMundoXmax;
	int valorMundoYmin;
	int valorMundoYmax;
	
	public JanelaConfig() {
		super("Cadastro de Coordenadas");
		Container tela = getContentPane();
		setLayout(null); 
		//atribuição de valores para os JLabels
		CoordenadasDoMundo = new JLabel("COORDENADAS DO MUNDO");
		CoordenadasDoMundoXmin = new JLabel("Informe as coordenadas do mundo - eixo Xmin: ");
		CoordenadasDoMundoXmax = new JLabel("Informe as coordenadas do mundo - eixo Xmax: ");
		CoordenadasDoMundoYmin = new JLabel("Informe as coordenadas do mundo - eixo Ymin: ");
		CoordenadasDoMundoYmax = new JLabel("Informe as coordenadas do mundo - eixo Ymax: ");
		
		CoordenadasDoDispositivo = new JLabel("COORDENADAS DO DISPOSITIVO");
		CoordenadasDoDispositivoXmin = new JLabel("Informe as coordenadas do dispositivo - eixo Xmin: ");
		CoordenadasDoDispositivoXmax = new JLabel("Informe as coordenadas do dispositivo - eixo Xmax: ");
		CoordenadasDoDispositivoYmin = new JLabel("Informe as coordenadas do dispositivo - eixo Ymin: ");
		CoordenadasDoDispositivoYmax = new JLabel("Informe as coordenadas do dispositivo - eixo Ymax: ");
		
		//atribuição dos valores para os JTextsFilds
		ValorCoordDoMundoXmin = new JTextField(50);
		ValorCoordDoMundoXmax = new JTextField(50);
		ValorCoordDoMundoYmin = new JTextField(50);		
		ValorCoordDoMundoYmax = new JTextField(50);
		ValorCoordDoDispositivoXmin = new JTextField(50);
		ValorCoordDoDispositivoXmax = new JTextField(50);
		ValorCoordDoDispositivoYmin = new JTextField(50);
		ValorCoordDoDispositivoYmax = new JTextField(50);
		
		//atribui um botão ao JFrame
		BtSalvar = new JButton("Salvar");
		
        //define os posicionamentos e as larguras de cada JLabel 
		CoordenadasDoMundo.setBounds(40,20,300,20);
		CoordenadasDoMundoXmin.setBounds(40,40,300,20);
		CoordenadasDoMundoXmax.setBounds(40,80,300,20);
		CoordenadasDoMundoYmin.setBounds(40,120,300,20);		
		CoordenadasDoMundoYmax.setBounds(40,160,300,20);	
		ValorCoordDoMundoXmin.setBounds(40,60,100,20);
		ValorCoordDoMundoXmax.setBounds(40,100,100,20);
		ValorCoordDoMundoYmin.setBounds(40,140,100,20);
		ValorCoordDoMundoYmax.setBounds(40,180,100,20);
		
		
		CoordenadasDoDispositivo.setBounds(40,210,300,20);
		CoordenadasDoDispositivoXmin.setBounds(40,230,300,20);
		CoordenadasDoDispositivoXmax.setBounds(40,270,300,20);
		CoordenadasDoDispositivoYmin.setBounds(40,310,300,20);		
		CoordenadasDoDispositivoYmax.setBounds(40,350,300,20);
		ValorCoordDoDispositivoXmin.setBounds(40,250,100,20);
		ValorCoordDoDispositivoXmax.setBounds(40,290,100,20);
		ValorCoordDoDispositivoYmin.setBounds(40,330,100,20);	
		ValorCoordDoDispositivoYmax.setBounds(40,370,100,20);
		
		BtSalvar.setBounds(40,400,200,30);		
		
		//adiciona os JLabels acima na janela
        tela.add(CoordenadasDoMundo);
        tela.add(CoordenadasDoMundoXmin);
        tela.add(CoordenadasDoMundoXmax);
        tela.add(CoordenadasDoMundoYmin);
        tela.add(CoordenadasDoMundoYmax);
        tela.add(ValorCoordDoMundoXmin);
        tela.add(ValorCoordDoMundoXmax);
        tela.add(ValorCoordDoMundoYmin);
        tela.add(ValorCoordDoMundoYmax);
        tela.add(CoordenadasDoDispositivo);
        tela.add(CoordenadasDoDispositivoXmin);
        tela.add(CoordenadasDoDispositivoXmax);
        tela.add(CoordenadasDoDispositivoYmin);
        tela.add(CoordenadasDoDispositivoYmax);
        tela.add(ValorCoordDoDispositivoXmin);
        tela.add(ValorCoordDoDispositivoXmax);
        tela.add(ValorCoordDoDispositivoYmin);
        tela.add(ValorCoordDoDispositivoYmax);
        tela.add(BtSalvar);
        
       //Listening do botão Salvar
        BtSalvar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                    	JanelaConfig jc = new JanelaConfig(); 
                    	jc.valorDispositivoXmin = Integer.parseInt(ValorCoordDoDispositivoXmin.getText());
                    	jc.valorDispositivoXmax = Integer.parseInt(ValorCoordDoDispositivoXmax.getText());     
                        jc.valorDispositivoYmin = Integer.parseInt(ValorCoordDoDispositivoYmin.getText()); 
                        jc.valorDispositivoYmax = Integer.parseInt(ValorCoordDoDispositivoYmax.getText());
                        if(jc.valorDispositivoXmax == jc.valorDispositivoXmin || jc.valorDispositivoYmax == jc.valorDispositivoYmin) {
                        	JOptionPane.showMessageDialog (null,"Tela com dimensão zero!", "Atenção", JOptionPane.WARNING_MESSAGE);
                        	throw new  ArithmeticException("Tela com uma das dimensões zero");                        	
                        }
                        jc.valorMundoXmin = Integer.parseInt(ValorCoordDoMundoXmin.getText());   
                        jc.valorMundoXmax = Integer.parseInt(ValorCoordDoMundoXmax.getText());
                        jc.valorMundoYmin = Integer.parseInt(ValorCoordDoMundoYmin.getText());
                        jc.valorMundoYmax = Integer.parseInt(ValorCoordDoMundoYmax.getText());                        
                        JOptionPane.showMessageDialog(null, "Coordenadas cadastradas com sucesso!");     
                        
                        janelaPrincipal = new JanelaPrincipal("Computação Gráfica - Coordenadas");   
                        janelaPrincipal.janelaConfig = jc;
                        janelaPrincipal.start();                            
                    }
                });
	}//fim do construtor	

}
