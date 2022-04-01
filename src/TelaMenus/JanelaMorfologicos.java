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





public class JanelaMorfologicos extends JPanel {
	
	JPanel panelPrincipal = new JPanel();
	public JButton btnSelecionarImg;
	JPanel imagemInicial;
	JPanel imagemOperada;
	public int [][] matrizImagem;
	public int[][] matrizAtual;
	private static int imgAltura;
	private static int imgLargura;
	
	public JanelaMorfologicos() {
		
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
	            	//matrizImagemBinaria = transformarMatrizBinaria(matrizImagemAux);
	            	gerarImagemDaMatriz(matrizImagemAux, imagemInicial);
	            	//gerarImagemDaMatriz(matrizImagemBinaria, imagemInicial);
	            	
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
	
	 
	 
	 public void aplicarMorfologia(java.awt.event.ActionEvent evt, int indiceComboBox) {
		 int[][] matrizFinal;
		 System.out.println(indiceComboBox);
		 switch(indiceComboBox) {
			 case 0:
				 //erosao
				 matrizAtual =aplicarErosao(matrizImagem);
				 gerarImagemDaMatriz(matrizAtual, imagemOperada);
				 break;
			 case 1:
				 //dilatacao
				 matrizAtual =aplicarDilatacao(matrizImagem);
				 gerarImagemDaMatriz(matrizAtual, imagemOperada);
				 break;
			 case 2:
				 //abertura(erosao seguido de dilatacao)
				 int[][]matrizErosao =aplicarErosao(matrizImagem);
				 int[][] matrizAbertura =aplicarDilatacao(matrizErosao);
				 gerarImagemDaMatriz(matrizAbertura, imagemOperada);
				 break;
			 case 3:
				 //fechamento(dilatacao seguido de uma erosao)
				 int[][] matrizDilatada =aplicarDilatacao(matrizImagem);
				 int[][]matrizFechamento =aplicarErosao(matrizDilatada);
				
				 gerarImagemDaMatriz(matrizFechamento, imagemOperada);

				 break;
			 case 4:
				//gradiente(dilatacao - erosao)
				 matrizDilatada =aplicarDilatacao(matrizImagem);
				 matrizErosao =aplicarErosao(matrizImagem);
				 matrizFinal =subtrairMatrizes(matrizDilatada, matrizErosao);

				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				
				 break;
			 
			 case 5:
				//operacao top hat( abertura menos imagem)
				 matrizErosao =aplicarErosao(matrizImagem);
				 matrizAbertura =aplicarDilatacao(matrizErosao);
				
				 matrizFinal =subtrairMatrizes(matrizImagem, matrizAbertura);
				 
				 
				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				 
				 break;
			 case 6://botton hat (fechamento - imagem)
				 matrizDilatada =aplicarDilatacao(matrizImagem);
				 matrizFechamento =aplicarErosao(matrizDilatada);
				
				 matrizFinal =subtrairMatrizes(matrizFechamento, matrizImagem);
				matrizFinal = normaliza(matrizFinal);
				 gerarImagemDaMatriz(matrizFinal, imagemOperada);
				 
				 
				 break;
			default:
				System.out.println("problema no combobox");
		 }
		 
		 
	 }
	 
	 public int[][] aplicarErosao(int [][] matrizImgAtual) {
		 
		 int []elemB = {0,1,0,1,1,1,0,1,0};
		 int[][] matrizImgAux= new int[imgAltura][imgLargura];
	     int[] valores = new int[9];
		 for (int i = 0; i < imgAltura; i++) {
		     for (int j = 0; j < imgLargura; j++) {
		         int total = 0;

		         if (elemB[0] != 0) valores[total++] = i == 0 || j == 0 ? 0 : matrizImgAtual[i - 1][j - 1];
		         
		         if (elemB[1] != 0) valores[total++] = i == 0 ? 0 : matrizImgAtual[i - 1][j];
		         if (elemB[2] != 0) valores[total++] = i == 0 || j == imgLargura - 1 ? 0 : matrizImgAtual[i - 1][j + 1];

		         if (elemB[3] != 0) valores[total++] = j == 0 ? 0 : matrizImgAtual[i][j - 1];
		         if (elemB[4] != 0) valores[total++] = matrizImgAtual[i][j];
		         if (elemB[5] != 0) valores[total++] = j == imgLargura - 1 ? 0 : matrizImgAtual[i][j + 1];

		         if (elemB[6] != 0) valores[total++] = i == imgAltura - 1 || j == 0 ? 0 : matrizImgAtual[i + 1][j - 1];
		         if (elemB[7] != 0) valores[total++] = i == imgAltura - 1 ? 0 : matrizImgAtual[i + 1][j];
		         if (elemB[8] != 0) valores[total++] = i == imgAltura - 1 || j == imgLargura - 1 ? 0 : matrizImgAtual[i + 1][j + 1];

		          if (total == 0) {
		              matrizImgAux[i][j] = valores[0];
		          } else if (total > 0) {
		              inserirValorOrdenado(valores, total);
		              matrizImgAux[i][j] = valores[0];
		          } else {
		              matrizImgAux[i][j] = matrizImgAux[i][j];
		           }
		      }
		 }
	        return matrizImgAux;  
	 }
	 
public int[][] aplicarDilatacao(int [][]matrizImgAtual) {
		 
	int []elemB = {0,1,0,1,1,1,0,1,0};
	 int[][] matrizImgAux= new int[imgAltura][imgLargura];
    int[] valores = new int[9];
	 for (int i = 0; i < imgAltura; i++) {
	     for (int j = 0; j < imgLargura; j++) {
	         int total = 0;

	         if (elemB[0] != 0) valores[total++] = i == 0 || j == 0 ? 0 : matrizImgAtual[i - 1][j - 1];
	         
	         if (elemB[1] != 0) valores[total++] = i == 0 ? 0 : matrizImgAtual[i - 1][j];
	         if (elemB[2] != 0) valores[total++] = i == 0 || j == imgLargura - 1 ? 0 : matrizImgAtual[i - 1][j + 1];

	         if (elemB[3] != 0) valores[total++] = j == 0 ? 0 : matrizImgAtual[i][j - 1];
	         if (elemB[4] != 0) valores[total++] = matrizImgAtual[i][j];
	         if (elemB[5] != 0) valores[total++] = j == imgLargura - 1 ? 0 : matrizImgAtual[i][j + 1];

	         if (elemB[6] != 0) valores[total++] = i == imgAltura - 1 || j == 0 ? 0 : matrizImgAtual[i + 1][j - 1];
	         if (elemB[7] != 0) valores[total++] = i == imgAltura - 1 ? 0 : matrizImgAtual[i + 1][j];
	         if (elemB[8] != 0) valores[total++] = i == imgAltura - 1 || j == imgLargura - 1 ? 0 : matrizImgAtual[i + 1][j + 1];

	          if (total == 0) {
	              matrizImgAux[i][j] = valores[0];
	          } else if (total > 0) {
	              inserirValorOrdenado(valores, total);
	              matrizImgAux[i][j] = valores[total-1];
	          } else {
	              matrizImgAux[i][j] = matrizImgAux[i][j];
	           }
	      }
	 }
	        return matrizImgAux;  
	 }


	public static int[][] subtrairMatrizes(int[][] matriz1, int[][] matriz2){
	    int[][] matrizFinal = new int[imgLargura][imgAltura];
	    for(int i = 0; i < imgLargura; i++){
	        for(int j = 0; j < imgAltura; j++){
	            matrizFinal[i][j] =  matriz1[i][j] - matriz2[i][j];
	        }
	    }
	    matrizFinal = normalizacao(matrizFinal);
	    return matrizFinal;
	}
	
	public static int[][] normaliza(int[][] matriz){
	    int[][] matrizFinal = new int[imgLargura][imgAltura];
	    for(int i = 0; i < imgLargura; i++){
	        for(int j = 0; j < imgAltura; j++){
	            if(matriz[i][j]<180) {
	            	matrizFinal[i][j]=0;
	            }else {
	            	matrizFinal[i][j] = matriz[i][j];
	            }
	        }
	    }
	    return matrizFinal;
	}
	 
	 //AUXILIARES
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
	
	public void inserirValorOrdenado(int []arr,int n) {
	    for (int i = 1; i < n; i++) {
	        int key = arr[i];
	        int j = i - 1;

	        while (j >= 0 && arr[j] > key) {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	}
}
