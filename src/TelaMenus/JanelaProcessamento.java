package TelaMenus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;





public class JanelaProcessamento extends JPanel {
	
	JPanel panelPrincipal = new JPanel();
	public JButton btnSelecionarImg;
	JPanel imagemInicial;
	JPanel imagemProcessada;
	public int [][] matrizImagem;
	private static int imgAltura;
	private static int imgLargura;
	
	public JanelaProcessamento() {
		
		setLayout(null);
		setSize(800,800);
		
		JPanel panelProcessamento = new JPanel();
		panelProcessamento.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Processamentos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcessamento.setBounds(0, 0, 800, 800);
		add(panelProcessamento);
		panelProcessamento.setLayout(null);
		
		//Local da Imagem para ser filtrada
		imagemInicial = new JPanel();
		imagemInicial.setBounds(280, 60, 256, 256);
		imagemInicial.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imagem a ser Processada", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcessamento.add(imagemInicial);
		
		//botao para selecionar a imagem
	    btnSelecionarImg = new JButton("SelecionarImagem");
	    btnSelecionarImg .setFont(new Font("Arial", Font.BOLD, 11));
	    btnSelecionarImg .setBounds(300, 345, 200, 20);
	    btnSelecionarImg.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		selecionarImagem(evt);
	    	}	
	     });
		panelProcessamento.add(btnSelecionarImg);
		
		JLabel labelProcessada = new JLabel("Imagem Processada:");
		labelProcessada.setFont(new Font("Arial", Font.BOLD, 12));
		labelProcessada.setBounds(360, 390, 100, 13);
		panelProcessamento.add(labelProcessada);
		
		//Local da imagem filtrada
		imagemProcessada = new JPanel();
		imagemProcessada.setBounds(280, 415, 256, 256);
		imagemProcessada.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProcessamento.add(imagemProcessada);
		
	}// -- fim do construtor
	
	
	 private void selecionarImagem(java.awt.event.ActionEvent evt) {
		 
		 try {
	            JFileChooser arquivo = new JFileChooser();
	            arquivo.setDialogTitle("Selecione a imagem");
	            arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            
	            int opcao = arquivo.showOpenDialog(this);
	            if(opcao == JFileChooser.APPROVE_OPTION) {
	            	System.out.println("imagem tudo certo");
	            	int [][] matrizImagemAux = gerarMatrizDaImagem(arquivo.getSelectedFile());
	            	gerarImagemDaMatriz(matrizImagemAux, imagemInicial);
	            	
	            }
	            
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "A imagem não foi carrregada");
	        }
	    }
	 
	public int[][] gerarMatrizDaImagem(File file) throws IOException{
		  FileInputStream fileInputStream = null;
	      Scanner scan = null;
	          
	      fileInputStream = new FileInputStream(file);
	      scan = new Scanner(fileInputStream);
	      scan.nextLine();
	      
	      imgLargura = scan.nextInt();
	      imgAltura = scan.nextInt();
	      int valorPixel= scan.nextInt();

	       //ler os valores do arquivo pgm e adiciona na matriz
	       matrizImagem = new int[imgAltura][imgLargura];
	       for (int i = 0; i < imgAltura; i++) {
	           for (int j = 0; j < imgLargura; j++) {
	               matrizImagem[i][j] = scan.nextInt();
	           }
	       }

	       fileInputStream.close();
	       return matrizImagem;
		
	 }
	 
	 public void gerarImagemDaMatriz(int[][] imagemMatriz, JPanel panel) {
		 
	        BufferedImage imagemBuffered = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
	        
	        //transforma os valores da imagem em cores com o setRGB
	        for (int i = 0; i < imagemMatriz.length; i++) {
	            for (int j = 0; j < imagemMatriz[0].length; j++) {
	            	int corAtual =imagemMatriz[i][j];
	                imagemBuffered.setRGB(j, i, new Color(corAtual, corAtual, corAtual).getRGB());
	            }
	        }

	        panel.getGraphics().drawImage(imagemBuffered, 0, 0, null);
	 }
	 

	 
	//OPERACOES
	 public void aplicarProcessamentos(java.awt.event.ActionEvent evt, int indiceComboBox, double gamma, int a_log,int sigma, int w, double w_target, int a_linear,int b_linear) {//gamma é o C
		 //pega o valor do selecionar lá e faz um switch
		 System.out.println(indiceComboBox);
		 switch(indiceComboBox) {
			 case 0:
				aplicarNegativo();
				 break;
			 case 1:
				 aplicarGamma(gamma);
				 break;
			 case 2:
				 aplicarlogaritma(a_log);
				 break;
			 case 3:
				 aplicarIntensidadeGeral(sigma, w);
				 break;
			 case 4:
				 aplicarFaixaDinamica(w_target);
				 break;
			 case 5:
				 aplicarLinear(a_linear, b_linear);
				 break;
			default:
				System.out.println("problema no combobox Processos");
		 }
	 }
	 
	 //OPERACOES
	 
	 public void aplicarNegativo() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	matrizImgAux[i][j] = 255 - matrizImagem[i][j];

	            }
	        }
	        
	        gerarImagemDaMatriz(matrizImgAux,imagemProcessada);
	 }
	 
	 public void aplicarGamma(double c) {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	matrizImgAux[i][j] = normalizaPixel((int) (2 * (Math.pow(matrizImagem[i][j], c))));
	            }
	        }
	        
	        gerarImagemDaMatriz(matrizImgAux,imagemProcessada);
	 }
	 
	 public void aplicarlogaritma(int a) {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	matrizImgAux[i][j] = normalizaPixel( a * (int)Math.log(matrizImagem[i][j]) + 1);
	            
	            }
	        }
	        
	        gerarImagemDaMatriz(matrizImgAux,imagemProcessada);
	 }
	 
	 public void aplicarIntensidadeGeral(int sigma, int w) {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	 matrizImgAux[i][j] = normalizaPixel((int) (255 * (1 / (1 + Math.pow(Math.E, - ((matrizImagem[i][j] - w) / sigma))))));
	            }
	        }
	        
	        gerarImagemDaMatriz(matrizImgAux,imagemProcessada);
	 }
	 
	 public void aplicarFaixaDinamica(double w_target) {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

		 double fMin = 0;
	     double fMax = imgAltura;
	     for (int i = 0; i < imgLargura; i++) {
	        for (int j = 0; j < imgAltura; j++) {
	        	int resultado =  (int) (((matrizImagem[i][j] - fMin)/(fMax-fMin)) * w_target);
	            matrizImgAux[i][j] =normalizaPixel(resultado);
	         }
	      }
	        
	        gerarImagemDaMatriz(matrizImgAux,imagemProcessada);
	 }
	 
	 public void aplicarLinear(int a, int b) {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	matrizImgAux[i][j] = normalizaPixel((int) (a * matrizImagem[i][j] + b));
	 
	            }
	        }
	        
	        gerarImagemDaMatriz(matrizImgAux,imagemProcessada);
	 }
	 

	 //ADICIONAIS
	 public static int normalizaPixel(int pixel) {
		 int v = pixel;
	     return v > 255 ? 255 : (v < 0 ? 0 : v);

     }
}
