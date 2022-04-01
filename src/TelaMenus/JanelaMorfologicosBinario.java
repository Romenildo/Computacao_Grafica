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





public class JanelaMorfologicosBinario extends JPanel {
	
	JPanel panelPrincipal = new JPanel();
	public JButton btnSelecionarImg;
	JPanel imagemInicial;
	JPanel imagemOperada;
	public int [][] matrizImagemBinaria;
	public int[][] matrizAtual;
	private static int imgAltura;
	private static int imgLargura;
	
	public JanelaMorfologicosBinario() {
		
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
		imagemOperada = new JPanel();
		imagemOperada.setBounds(280, 415, 256, 256);
		imagemOperada.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltro.add(imagemOperada);
		
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
	            	matrizImagemBinaria = transformarMatrizBinaria(matrizImagemAux, 255);
	            	gerarImagemDaMatriz(matrizImagemBinaria, imagemInicial);
	            	
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
	       matrizImagemBinaria = new int[imgAltura][imgLargura];
	       for (int i = 0; i < imgAltura; i++) {
	           for (int j = 0; j < imgLargura; j++) {
	               matrizImagemBinaria[i][j] = scan.nextInt();
	           }
	       }

	       fileInputStream.close();
	       return matrizImagemBinaria;
		
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
	 
	 public static int[][] transformarMatrizBinaria(int [][] imagemMatriz,int pixel_desejado) {
		 int [][] matrizImgBinaria = new int [imgAltura][imgLargura];
		 int somaTotal=0, quantidade=0;
		 int media;
		 //tirar media dos valores dos pixeis da imagem
		 for (int i = 0; i < imagemMatriz.length; i++) {
	            for (int j = 0; j < imagemMatriz[0].length; j++) {
	            	somaTotal+= imagemMatriz[i][j];
	            	quantidade++;
	            }
	        }
		 media =(int) somaTotal/quantidade;
		 
		 
		 for (int i = 0; i < imagemMatriz.length; i++) {
	            for (int j = 0; j < imagemMatriz[0].length; j++) {
	            	int corAtual =imagemMatriz[i][j];
	                if(imagemMatriz[i][j]>media) {
	                	matrizImgBinaria[i][j] = pixel_desejado;
	                }else {
	                	matrizImgBinaria[i][j] = 255 - pixel_desejado;
	                }
	            }
	        }
		 
		 return matrizImgBinaria;
	 }
	 
	 
	 
	 public void aplicarMorfologia(java.awt.event.ActionEvent evt, int indiceComboBox, int pixel_desejado) {
		 int[][] matrizFinal;

		 switch(indiceComboBox) {
			 case 0:
				 //erosao
				 matrizAtual =aplicarErosao(matrizImagemBinaria,pixel_desejado);
				 gerarImagemDaMatriz(matrizAtual, imagemOperada);
				 break;
			 case 1:
				 //dilatacao
				 matrizAtual =aplicarDilatacao(matrizImagemBinaria,pixel_desejado);
				 gerarImagemDaMatriz(matrizAtual, imagemOperada);
				 break;
			 case 2:
				 //abertura
				 int[][]matrizErosao =aplicarErosao(matrizImagemBinaria,pixel_desejado);
				 int[][] matrizAbertura =aplicarDilatacao(matrizErosao,pixel_desejado);
				 gerarImagemDaMatriz(matrizAbertura, imagemOperada);
				 break;
			 case 3:
				 //fechamento
				 int[][] matrizDilatada =aplicarDilatacao(matrizImagemBinaria,pixel_desejado);
				 int[][]matrizFechamento =aplicarErosao(matrizDilatada,pixel_desejado);
				
				 gerarImagemDaMatriz(matrizFechamento, imagemOperada);

				 break;
			 case 4:
				//gradiente
				 matrizDilatada =aplicarDilatacao(matrizImagemBinaria,pixel_desejado);
				 matrizErosao =aplicarErosao(matrizImagemBinaria,pixel_desejado);
				 matrizFinal =subtrairMatrizes(matrizDilatada, matrizErosao,pixel_desejado);

				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				
				 break;
			 case 5:
				//contorno interno
				 //a imagem menos uma erosao
				 matrizErosao =aplicarErosao(matrizImagemBinaria,pixel_desejado);
				 
				 matrizFinal =subtrairMatrizes(matrizImagemBinaria, matrizErosao, pixel_desejado);
				 
				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				 break;
			 case 6:
				 //contorno externo
				 //dilatação menos a imagem
				 matrizDilatada =aplicarDilatacao(matrizImagemBinaria,pixel_desejado);
				 
				 matrizFinal =subtrairMatrizes(matrizDilatada,matrizImagemBinaria, pixel_desejado);
				 
				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				 break;
			 case 7:
				//operacao top hat
				 matrizErosao =aplicarErosao(matrizImagemBinaria,pixel_desejado);
				 matrizAbertura =aplicarDilatacao(matrizErosao,pixel_desejado);
				
				 matrizFinal =subtrairMatrizes(matrizImagemBinaria, matrizAbertura, pixel_desejado);
				 
				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				 
				 break;
			 case 8:
				 matrizDilatada =aplicarDilatacao(matrizImagemBinaria,pixel_desejado);
				 matrizFechamento =aplicarErosao(matrizDilatada,pixel_desejado);
				 matrizFinal =subtrairMatrizes( matrizFechamento, matrizImagemBinaria, pixel_desejado);

				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				 //operacao botton
				 break;
			 case 9:
				 matrizFinal = transformarMatrizBinaria(matrizImagemBinaria, pixel_desejado);
				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				 //operacao botton
				 break;
			default:
				System.out.println("problema no combobox");
		 }
		 
		 
	 }
	 
	 public int[][] aplicarErosao(int [][] matrizImagemAtual, int pixel_desejado) {
		 
		 int [][]matrizB = {{0,1,0},{1,1,1},{0,1,0}};
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];
	     
		 	int pixel = 0;
		 	//pixel desejado 255 branco  0 preto
			int pixel_fundo = 255 - pixel_desejado;
			
			//percorrer a matriz da imagem principal
			for(int i = 1; i < imgLargura-1; i++){	
				for(int j = 1; j < imgAltura-1; j++){
					int pintar = 1;
					
					//percorrer matrizB
					for(int x = -1; x <= 1; x++){
						for(int y = -1; y <= 1; y++){
							if(pintar == 1) {
								pixel = matrizImagemAtual[i+x][j+y];
								
								if(matrizB[x + 1][y + 1] == 1) {
									if((pixel != pixel_desejado)) {
										pintar = 0;
									}
										
								}
							} else break;
						}
						
						if(pintar == 0) {
							matrizImgAux[i][j]=pixel_fundo;
							break;
						} 
					}
					
					if(pintar == 1){
						matrizImgAux[i][j]= pixel_desejado;
					}
				}
			}
			
	        return matrizImgAux;  
	 }
	 
public int[][] aplicarDilatacao(int [][]matrizImagemAtual, int pixel_desejado) {
		 
		 int [][]matrizB = {{0,1,0},{1,1,1},{0,1,0}};
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];

		 int pixel = 0;
		//255 ou 0 definir se meu pixel alvo é preto ou branco. Nesse caso, branco. 
			
			for(int i = 1; i < imgLargura-1; i++){	
				for(int j = 1; j < imgAltura-1; j++){
					
					pixel = matrizImagemAtual[i][j];
					
					if(pixel == pixel_desejado) {
						for(int x = - 1; x <= 1; x++) {
							for(int y = -1; y <= 1; y++){
								if(matrizB[x + 1][y + 1] == 1) {
									matrizImgAux[i+x][j+y] = pixel_desejado;
								}	
							}
						}
					}else {
						matrizImgAux[i][j] = 255-pixel_desejado;
					}			
				}	
			}
	        
	        return matrizImgAux;  
	 }


	public static int[][] subtrairMatrizes(int[][] imagem1, int[][] imagem2, int pixel_desejado){
	    int[][] matrizResult = new int[imgLargura][imgAltura];
	    for(int i = 0; i < imgLargura; i++){
	        for(int j = 0; j < imgAltura; j++){
	            matrizResult[i][j] =imagem1[i][j] - imagem2[i][j];
	        }
	    }
	    matrizResult = transformarMatrizBinaria(matrizResult, pixel_desejado);
	    return matrizResult;
	}
	 
}
