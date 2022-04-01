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





public class JanelaFiltros extends JPanel {
	
	JPanel panelPrincipal = new JPanel();
	public JButton btnSelecionarImg;
	JPanel imagemInicial;
	JPanel imagemFiltrada;
	
	public int [][] matrizImagem;
	private static int imgAltura;
	private static int imgLargura;
	public JanelaFiltros() {
		
		setLayout(null);
		setSize(800,800);
		
		JPanel panelFiltro = new JPanel();
		panelFiltro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltro.setBounds(0, 0, 800, 800);
		add(panelFiltro);
		panelFiltro.setLayout(null);
		
		//Local da Imagem para ser filtrada
		imagemInicial = new JPanel();
		imagemInicial.setBounds(280, 60, 256, 256);
		imagemInicial.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imagem a ser filtrada", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltro.add(imagemInicial);
		
		//botao para selecionar a imagem
	    btnSelecionarImg = new JButton("SelecionarImagem");
	    btnSelecionarImg .setFont(new Font("Arial", Font.BOLD, 11));
	    btnSelecionarImg .setBounds(300, 345, 200, 20);
	    btnSelecionarImg.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		selecionarImagem(evt);
	    	}	
	     });
		panelFiltro.add(btnSelecionarImg);
		
		JLabel labelFiltrada = new JLabel("Imagem Filtrada:");
		labelFiltrada.setFont(new Font("Arial", Font.BOLD, 12));
		labelFiltrada.setBounds(360, 390, 100, 13);
		panelFiltro.add(labelFiltrada);
		
		//Local da imagem filtrada
		imagemFiltrada = new JPanel();
		imagemFiltrada.setBounds(280, 415, 256, 256);
		imagemFiltrada.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltro.add(imagemFiltrada);
		
	}// -- fim do construtor
	
	//FUNCOES PEGAR IMAGEM E GERAR AS MATRIZES
	
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
	 
	 
	 
	 //FUNCOES DOS FILTROS
	 
	 public void aplicarFiltros(java.awt.event.ActionEvent evt, int indiceComboBox, double coefA) {
		 System.out.println("funcionou");
		 //pega o valor do selecionar lá e faz um switch
		 System.out.println(indiceComboBox);
		 switch(indiceComboBox) {
			 case 0:
				 filtroMedia(matrizImagem);
				 break;
			 case 1:
				 filtroMediana(matrizImagem);
				 break;
			 case 2:
				 filtroPassaAlta(matrizImagem);
				 break;
			 case 3:
				 filtroRobertsX(matrizImagem);
				 break;
			 case 4:
				filtroRobertsY(matrizImagem);
				 break;
			 case 5:
				 filtroRoberts(matrizImagem);
				 break;
			 case 6:
				filtroPrewittX(matrizImagem);
				 break;
			 case 7:
				filtroPrewittY(matrizImagem);
				break;
			 case 8:
				filtroPrewitt(matrizImagem);
				break;
			 case 9:
				 filtroAltoReforco(matrizImagem, coefA);
				 break;
			 case 10:
				 filtroSobel(matrizImagem);
				 break;
			default:
				System.out.println("problema no combobox");
		 }
		 
		 
	 }
	 
	 
	 

	 //FILTROS
	 public void filtroMedia(int [][]matrizImagem) {
	        int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        // valor da mascara de convolucao
	        double valor = 0.1111;// 1/9
			double[][]media = {{valor,valor,valor},{valor,valor,valor},{valor,valor,valor}};
		        
		    matrizImgAux = convolucao(matrizImagem, media);
		    matrizImgAux = normalizacao(matrizImgAux);
	        
	        gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	    }
	 
	 
	 public void filtroMediana(int [][]matrizImagem) {
	      int[][] matrizImgAux= new int[imgAltura][imgLargura];

	      matrizImgAux = convolucaoMediana(matrizImagem);

	       gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	    }
	 
	 
	 public void filtroPassaAlta(int [][]matrizImagem) {
	        int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        //[-1, -1, -.1]
	        //[-1, 9 , -1]
	        //[-1, -1, -1]
	        int[][]passaAlta = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
	        
	        matrizImgAux = convolucaoMatrizes(matrizImagem, passaAlta);
	        matrizImgAux = normalizacao(matrizImgAux);

	        gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	    }

	 public void filtroRobertsX(int [][]matrizImagem) {
	        int[][] matrizImgAux= new int[imgAltura][imgLargura];
	        int[][]robertsX = {{0,0,0},{0,1,0},{0,-1,0}};
	        //[0, 0, 0]
	        //[0, 1 , 0]
	        //[0, -1, 0]

	        matrizImgAux = convolucaoMatrizes(matrizImagem, robertsX);
	        matrizImgAux = normalizacao(matrizImgAux);

	        gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	    }
	 
	 public void filtroRobertsY(int [][]matrizImagem) {
	        int[][] matrizImgAux= new int[imgAltura][imgLargura];
	        //[0, 0, 0]
	        //[0, 1 , -1]
	        //[0, 0, 0]
	        int[][]robertsY = {{0,0,0},{0,1,-1},{0,0,0}};
	        
	        matrizImgAux = convolucaoMatrizes(matrizImagem, robertsY);
	        matrizImgAux = normalizacao(matrizImgAux);

	        gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	    }
	 
	 public void filtroRoberts(int [][]matrizImagem) {

	        int[][] matrizImgAuxX= new int[imgAltura][imgLargura];
	        int[][] matrizImgAuxY= new int[imgAltura][imgLargura];
	        int[][] matrizImgAuxFinal= new int[imgAltura][imgLargura];

	        int[][]robertsX = {{0,0,0},{0,1,0},{0,-1,0}};
	        int[][]robertsY = {{0,0,0},{0,1,-1},{0,0,0}};
	        
	        matrizImgAuxX = convolucaoMatrizes(matrizImagem, robertsX);//prewitt horizontal
	        matrizImgAuxY = convolucaoMatrizes(matrizImagem, robertsY);//prewitt vertical
	        matrizImgAuxFinal = somadeImagens(matrizImgAuxX, matrizImgAuxY);
	       
	        gerarImagemDaMatriz(matrizImgAuxFinal, imagemFiltrada);
	   }
	 
	 
	 public void filtroPrewitt(int [][]matrizImagem) {

	        int[][] matrizImgAuxX= new int[imgAltura][imgLargura];
	        int[][] matrizImgAuxY= new int[imgAltura][imgLargura];
	        int[][] matrizImgAuxFinal= new int[imgAltura][imgLargura];

	        int[][] prewittX = {{-1,-1,-1},{0,0,0},{1,1,1}};
	        int[][] prewittY = {{-1,0,1},{-1,0,1},{-1,0,1}};
	        
	        matrizImgAuxX = convolucaoMatrizes(matrizImagem, prewittX);//prewitt horizontal
	        matrizImgAuxY = convolucaoMatrizes(matrizImagem, prewittY);//prewitt vertical
	        matrizImgAuxFinal = somadeImagens(matrizImgAuxX, matrizImgAuxY);
	       
	  
	        gerarImagemDaMatriz(matrizImgAuxFinal, imagemFiltrada);
	   }
	 public void filtroPrewittX(int [][]matrizImagem) {

	        int[][] matrizImgAux= new int[imgAltura][imgLargura];
	        int[][] prewittX = {{-1,-1,-1},{0,0,0},{1,1,1}};

	        matrizImgAux = convolucaoMatrizes(matrizImagem, prewittX);//prewitt horizontal
	       
	        matrizImgAux = normalizacao(matrizImgAux);
	        gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	   }
	 public void filtroPrewittY(int [][]matrizImagem) {

	        int[][] matrizImgAux= new int[imgAltura][imgLargura];
	        int[][] prewittY = {{-1,0,1},{-1,0,1},{-1,0,1}};
	        
	        matrizImgAux = normalizacao(matrizImgAux);
	        matrizImgAux = convolucaoMatrizes(matrizImagem, prewittY);//prewitt vertical
	       
	        gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	   }
	 
	 
	 public void filtroAltoReforco(int [][]matrizImagem, double coefA) {
	        int[][] matrizImgAux= new int[imgAltura][imgLargura];

	        double w = (double) ((9 * coefA) - 1);
			double[][] altoReforco = {{-1,-1,-1},{-1,w,-1},{-1,-1,-1}};

			matrizImgAux = convolucao(matrizImagem, altoReforco);
			
	        gerarImagemDaMatriz(matrizImgAux, imagemFiltrada);
	  }
	 
	 public void filtroSobel(int [][]matrizImagem) {
	        int[][] matrizImgAuxX= new int[imgAltura][imgLargura];
	        int[][] matrizImgAuxY= new int[imgAltura][imgLargura];
	        int[][] matrizImgAuxFinal= new int[imgAltura][imgLargura];

	        int[][] sobelX = {{-1,-2,-1},{0,0,0},{1,2,1}};
	        int[][] sobelY = {{-1,0,1},{-2,0,2},{-1,0,1}};
	        
	        matrizImgAuxX = convolucaoMatrizes(matrizImagem, sobelX);
	        matrizImgAuxY = convolucaoMatrizes(matrizImagem, sobelY);
	        matrizImgAuxFinal = somadeImagens(matrizImgAuxX, matrizImgAuxY);

	        gerarImagemDaMatriz(matrizImgAuxFinal, imagemFiltrada);
	  }
	 
	 
	 
	 //FUNCOES DE CONVOLUCAO

	 //Convolucao das matriz de passa alta, prewitt robet e sobrel, possui somente valores com int
	 public static int[][] convolucaoMatrizes(int[][] matriz, int[][] filtro) {
		 
		 //adiciona a borda da matriz
			int[][] matrizLimite = new int[matriz.length + 2][matriz[0].length + 2];
			for (int i = 0; i < matrizLimite.length; i++) {
				for (int j = 0; j < matrizLimite[0].length; j++) {
					if (i == 0) {
						matrizLimite[i][j] = 0;
					} else if (i == (matrizLimite.length - 1)) {
						matrizLimite[i][j] = 0;
					} else if (j == 0) {
						matrizLimite[i][j] = 0;
					} else if (j == (matrizLimite[0].length - 1)) {
						matrizLimite[i][j] = 0;
					} else {
						matrizLimite[i][j] = matriz[i - 1][j - 1];
					}

				}
			}

			//adicionar o filtro pela imagem
			int[][] matrizImagem = new int[matriz.length][matriz[0].length];

			int soma = 0;
			for (int i = 0; i < (matrizLimite.length - 2); i++) {

				for (int j = 0; j < (matrizLimite[0].length - 2); j++) {

					soma += matrizLimite[i][j] * filtro[0][0];
					soma += matrizLimite[i][j + 1] * filtro[0][1];
					soma += matrizLimite[i][j + 2] * filtro[0][2];
					soma += matrizLimite[i + 1][j] * filtro[1][0];
					soma += matrizLimite[i + 1][j + 1] * filtro[1][1];
					soma += matrizLimite[i + 1][j + 2] * filtro[1][2];
					soma += matrizLimite[i + 2][j] * filtro[2][0];
					soma += matrizLimite[i + 2][j + 1] * filtro[2][1];
					soma += matrizLimite[i + 2][j + 2] * filtro[2][2];

					matrizImagem[i][j] = Math.abs(soma);
					soma = 0;
				}
			}
			return matrizImagem;
		}
	 
	 //mascara de convolucao das matrizes alto reforco e media devido aos parametros com double
		public static int[][] convolucao(int[][] matriz, double[][] filtro) {
			int[][] matrizLimite = new int[matriz.length + 2][matriz[0].length + 2];
			for (int i = 0; i < matrizLimite.length; i++) {
				for (int j = 0; j < matrizLimite[0].length; j++) {
					if (i == 0) {
						matrizLimite[i][j] = 0;
					} else if (i == (matrizLimite.length - 1)) {
						matrizLimite[i][j] = 0;
					} else if (j == 0) {
						matrizLimite[i][j] = 0;

					} else if (j == (matrizLimite[0].length - 1)) {
						matrizLimite[i][j] = 0;
					} else {
						matrizLimite[i][j] = matriz[i - 1][j - 1];
					}

				}

			}
			
			//aplicar a mascara
			int[][] matrizImagem = new int[matriz.length][matriz[0].length];
			double soma = 0;
			for (int i = 0; i < (matrizLimite.length - 2); i++) {

				for (int j = 0; j < (matrizLimite[0].length - 2); j++) {
					soma += matrizLimite[i][j] * filtro[0][0];
					soma += matrizLimite[i][j + 1] * filtro[0][1];
					soma += matrizLimite[i][j + 2] * filtro[0][2];
					soma += matrizLimite[i + 1][j] * filtro[1][0];
					soma += matrizLimite[i + 1][j + 1] * filtro[1][1];
					soma += matrizLimite[i + 1][j + 2] * filtro[1][2];
					soma += matrizLimite[i + 2][j] * filtro[2][0];
					soma += matrizLimite[i + 2][j + 1] * filtro[2][1];
					soma += matrizLimite[i + 2][j + 2] * filtro[2][2];

					//normaliação
					if (soma > 255) {
						soma = 255;
					}
					if (soma < 0) {
						soma = 0;
					}

					matrizImagem[i][j] = (int) Math.round(soma);
					soma = 0;
				}
			}
			return matrizImagem;

		}
		
		//aplicacao da mascara convucao no filtro da mediana
		public static int[][] convolucaoMediana(int[][] matriz) {
			int[][] matrizImgAux = new int[imgAltura][imgLargura];
			int[] valores = new int[9];

			    for (int i = 0; i < imgAltura; i++) {

			        for (int j = 0; j < imgLargura; j++) {
			            valores[0] = i == 0 || j == 0 ? 0 : matriz[i - 1][j - 1];
			            valores[1] = i == 0 ? 0 : matriz[i - 1][j];
			            valores[2] = i == 0 || j == imgLargura - 1 ? 0 : matriz[i - 1][j + 1];

			            valores[3] = j == 0 ? 0 : matriz[i][j - 1];
			            valores[4] = matriz[i][j];
			            valores[5] = j == imgLargura - 1 ? 0 : matriz[i][j + 1];

			            valores[6] = i == imgAltura - 1 || j == 0 ? 0 : matriz[i + 1][j - 1];
			            valores[7] = i == imgAltura - 1 ? 0 : matriz[i + 1][j];
			            valores[8] = i == imgAltura - 1 || j == imgLargura - 1 ? 0 : matriz[i + 1][j + 1];


			            Arrays.sort(valores);
			            matrizImgAux[i][j] = valores[4];
			        }
			    }

			return matrizImgAux;
		}
	 
		
		
		
	 //AUXILIARES


	        
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
	  
	   public static int[][] somadeImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		   int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
	    	for (int i = 0; i < matrizImagemFinal.length; i++) {
	    		for (int j = 0; j < matrizImagemFinal.length; j++) {
	    			matrizImagemFinal[i][j] = Math.abs(matrizImagem1[i][j]) + Math.abs(matrizImagem2[i][j]);

	    		}
	    	}
	    	matrizImagemFinal = normalizacao(matrizImagemFinal);
	    	return matrizImagemFinal;

	   	}
}
