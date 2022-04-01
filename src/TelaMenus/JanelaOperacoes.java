package TelaMenus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JanelaOperacoes extends JPanel {
	
	JPanel panelPrincipal = new JPanel();
	JButton btnSelecionarImg1;
	JButton btnSelecionarImg2;
	JPanel labelImagem1;
	JPanel labelImagem2;
	JPanel labelImagemResultado;
	public int [][] matrizImagem1;
	public int [][] matrizImagem2;
	private static int imgAltura;
	private static int imgLargura;
	
	public JanelaOperacoes() {
		
		setLayout(null);
		setSize(800,800);
		
		JPanel panelOperacao = new JPanel();
		panelOperacao.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.setBounds(0, 0, 800, 800);
		add(panelOperacao);
		panelOperacao.setLayout(null);
		
		
		labelImagem1 = new JPanel();
		labelImagem1.setBounds(40, 60, 256, 256);
		labelImagem1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "1º Imagem", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(labelImagem1);
		
	    btnSelecionarImg1 = new JButton("SelecionarImagem");
	    btnSelecionarImg1 .setFont(new Font("Arial", Font.BOLD, 11));
	    btnSelecionarImg1 .setBounds(70, 345, 200, 20);
	    btnSelecionarImg1.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		selecionarImagem(evt, 1);
	    	}	
	     });
		panelOperacao.add(btnSelecionarImg1);
		
		//imagem 2
		
		labelImagem2 = new JPanel();
		labelImagem2.setBounds(438, 60, 256, 256);
		labelImagem2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "2º Imagem", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(labelImagem2);
		
		 btnSelecionarImg2 = new JButton("SelecionarImagem");
		    btnSelecionarImg2 .setFont(new Font("Arial", Font.BOLD, 11));
		    btnSelecionarImg2 .setBounds(470, 345, 200, 20);
		    btnSelecionarImg2.addActionListener(new java.awt.event.ActionListener() {
		    	public void actionPerformed(java.awt.event.ActionEvent evt) {
		    		selecionarImagem(evt, 2);
		    	}	
		     });
			panelOperacao.add(btnSelecionarImg2);
		
		JLabel labelResultado = new JLabel("Resultado");
		labelResultado.setFont(new Font("Arial", Font.BOLD, 22));
		labelResultado.setBounds(322, 382, 150, 27);
		panelOperacao.add(labelResultado);
			
			
		labelImagemResultado = new JPanel();
		labelImagemResultado.setBounds(245, 420, 256, 256);
		labelImagemResultado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imagem Final", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(labelImagemResultado);
		
	}
	
	
	private void selecionarImagem(java.awt.event.ActionEvent evt, int tipo) {
		 
		 try {
	            JFileChooser arquivo = new JFileChooser();
	            arquivo.setDialogTitle("Selecione a imagem");
	            arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            
	            int opcao = arquivo.showOpenDialog(this);
	            if(opcao == JFileChooser.APPROVE_OPTION) {
	            	System.out.println("imagem tudo certo");
	            	if(tipo == 1) {
	            		matrizImagem1 = gerarMatrizDaImagem(arquivo.getSelectedFile(),1);
		            	gerarImagemDaMatriz(matrizImagem1, labelImagem1);
	            	}else if(tipo == 2) {
	            		matrizImagem2 = gerarMatrizDaImagem(arquivo.getSelectedFile(),2);
		            	gerarImagemDaMatriz(matrizImagem2, labelImagem2);
	            	}
	            	
	            	
	            }
	            
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "A imagem não foi carrregada");
	        }
	    }
	 
	 public int[][] gerarMatrizDaImagem(File file,int tipo) throws IOException{
		  FileInputStream fileInputStream = null;
	      Scanner scan = null;
	          
	      fileInputStream = new FileInputStream(file);
	      scan = new Scanner(fileInputStream);
	      scan.nextLine();
	      
	      imgLargura = scan.nextInt();
	      imgAltura = scan.nextInt();
	      int valorPixel= scan.nextInt();
	      
	      if(tipo == 1) {
	    	  matrizImagem1 = new int[imgAltura][imgLargura];
		       for (int i = 0; i < imgAltura; i++) {
		           for (int j = 0; j < imgLargura; j++) {
		               matrizImagem1[i][j] = scan.nextInt();
		           }
		       }
		       fileInputStream.close();
		       return matrizImagem1;
		       
	      }else if(tipo ==2) {
	    	  matrizImagem2 = new int[imgAltura][imgLargura];
		       for (int i = 0; i < imgAltura; i++) {
		           for (int j = 0; j < imgLargura; j++) {
		               matrizImagem2[i][j] = scan.nextInt();
		           }
		       }
		       fileInputStream.close();
		       return matrizImagem2;
	      }
	       //ler os valores do arquivo pgm e adiciona na matriz
		return matrizImagem1;
	       

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
	 
	 public void aplicarOperacoes(java.awt.event.ActionEvent evt, int indiceComboBox) {

		 switch(indiceComboBox) {
			 case 0:
				aplicarSoma();
				 break;
			 case 1:
				 aplicarSubtracao();
				 break;
			 case 2:
				 aplicarMultiplicacao();
				 break;
			 case 3:
				 aplicarDivisao();
				 break;
			 case 4:
				aplicarOR();
				 break;
			 case 5:
				aplicarAND();
				 break;
			 case 6:
				 aplicarXOR();
				 break;
			default:
				System.out.println("problema no combobox operacoes");
		 }
	 }
	 
	 //OPERACOES
	 
	 public void aplicarSoma() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	 matrizImgAux[i][j] =matrizImagem1[i][j] + matrizImagem2[i][j]; 
	            }
	        }
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, labelImagemResultado);
	 }
	 
	 public void aplicarSubtracao() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	 matrizImgAux[i][j] =matrizImagem1[i][j] - matrizImagem2[i][j];
	            	 
	            }
	        }
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, labelImagemResultado);
	 }
	 
	 public void aplicarMultiplicacao() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	 matrizImgAux[i][j] =matrizImagem1[i][j] * matrizImagem2[i][j];
	            }
	        }
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, labelImagemResultado);
	 }
	 
	 public void aplicarDivisao() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	//caso dividido por zero
	            	if (matrizImagem2[i][j] != 0) {
	            		matrizImgAux[i][j] = (int) Math.round(matrizImagem1[i][j] / matrizImagem2[i][j]);
	                } else {
	                	matrizImgAux[i][j] = 0;
	                }

	            }
	        }
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, labelImagemResultado);
	 }
	 
	 public void aplicarOR() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	 matrizImgAux[i][j] =matrizImagem1[i][j] | matrizImagem2[i][j];
	            	 
	            }
	        }
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, labelImagemResultado);
	 }
	 
	 public void aplicarAND() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	 matrizImgAux[i][j] =matrizImagem1[i][j] & matrizImagem2[i][j];
	            	 
	            }
	        }
	        
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, labelImagemResultado);
	 }
	 public void aplicarXOR() {
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        for (int i = 0; i < imgLargura; i++) {
	            for (int j = 0; j < imgAltura; j++) {
	            	 matrizImgAux[i][j] = matrizImagem1[i][j] ^ matrizImagem2[i][j];
	            	 
	            }
	        }
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, labelImagemResultado);
	 }
	 
	 
	 //colcoar em um local diferente
	  public static int[][] normalizacao(int[][] matriz) {
	    	int min = matriz[0][0];
	    	int max = matriz[0][0];
	    	for (int i = 0; i < matriz.length; i++) {
	    		for (int j = 0; j < matriz[0].length; j++) {
	    			if (min > matriz[i][j]) {
	    				min = matriz[i][j];
	    			}

	    			if (max < matriz[i][j]) {
	    				max = matriz[i][j];
	    			}
	    		}
	    	}

	    	int[][] matrizFinal = new int[matriz.length][matriz[0].length];
	    	for (int i = 0; i < matrizFinal.length; i++) {
	    		for (int j = 0; j < matrizFinal[0].length; j++) {
	    			if (max == min) {
	    				matrizFinal[i][j] = max;
	    			} else {
	    				matrizFinal[i][j] = (int) Math.round((255 * (matriz[i][j] - min)) / (max - min));

	    			}
	    		}
	    	}

	    	return matrizFinal;
	    }

}
