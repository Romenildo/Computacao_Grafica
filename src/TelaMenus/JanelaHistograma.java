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

public class JanelaHistograma extends JPanel {
	
	JPanel panelPrincipal = new JPanel();
	JButton btnSelecionarImg1;

	JPanel imagemInicial;
	JPanel imagemInicialHistograma;
	JPanel imagemEqualizada;
	JPanel imagemEqualizadaHistograma;
	
	public int [][] matrizImagemInicial;
	public int [][] matrizImagemEqualizada;
	private static int imgAltura;
	private static int imgLargura;
	
	public JanelaHistograma() {
		
		setLayout(null);
		setSize(800,800);
		
		JPanel panelOperacao = new JPanel();
		panelOperacao.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.setBounds(0, 0, 800, 800);
		add(panelOperacao);
		panelOperacao.setLayout(null);
		
		
		imagemInicial = new JPanel();
		imagemInicial.setBounds(50, 50, 256, 256);
		imagemInicial.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "1º Imagem", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(imagemInicial);
		
	    btnSelecionarImg1 = new JButton("SelecionarImagem");
	    btnSelecionarImg1 .setFont(new Font("Arial", Font.BOLD, 11));
	    btnSelecionarImg1 .setBounds(80, 310, 200, 35);
	    btnSelecionarImg1.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		selecionarImagem(evt);
	    	}	
	     });
		panelOperacao.add(btnSelecionarImg1);
		
		//imagem 2
		
		imagemInicialHistograma = new JPanel();
		imagemInicialHistograma.setBounds(400, 50, 256, 256);
		imagemInicialHistograma.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Histograma", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(imagemInicialHistograma);
		
		JLabel nvlCinzaOriginal = new JLabel("0  <--- nivel de Cinza ---> 255");
		nvlCinzaOriginal .setFont(new Font("Arial", Font.BOLD, 11));
		nvlCinzaOriginal .setBounds(450, 310, 200, 13);
		panelOperacao.add(nvlCinzaOriginal );
		
		
		//imagem 1 equalizada
		imagemEqualizada = new JPanel();
		imagemEqualizada.setBounds(50, 380, 256, 256);
		imagemEqualizada.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Equalizada", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(imagemEqualizada);
		
		//imagem 2 equalizada
		imagemEqualizadaHistograma = new JPanel();
		imagemEqualizadaHistograma.setBounds(400, 380, 256, 256);
		imagemEqualizadaHistograma.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Histograma Equalizada", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(imagemEqualizadaHistograma);
		
		JLabel nvlCinzaEq = new JLabel("0  <--- nivel de Cinza ---> 255");
		nvlCinzaEq .setFont(new Font("Arial", Font.BOLD, 11));
		nvlCinzaEq .setBounds(450, 640, 200, 13);
		panelOperacao.add(nvlCinzaEq );
		
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
	       matrizImagemInicial = new int[imgAltura][imgLargura];
	       for (int i = 0; i < imgAltura; i++) {
	           for (int j = 0; j < imgLargura; j++) {
	               matrizImagemInicial[i][j] = scan.nextInt();
	           }
	       }

	       fileInputStream.close();
	       return matrizImagemInicial;
		
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
	 
	 public void iniciarEqualizacao(java.awt.event.ActionEvent evt) {
		 
		 int heigth = imgAltura;
         if (heigth != 256) {
             heigth = 256 - heigth;
         } else {
             heigth = 0;
         }
         //imagem do grafico 
		 imagemInicialHistograma.getGraphics().drawImage(gerarMatrizHistograma(matrizImagemInicial), 0, heigth, null);
		 
		 //imagem equalizada
		 matrizImagemEqualizada = equalizaImagem(matrizImagemInicial);
		 gerarImagemDaMatriz(matrizImagemEqualizada, imagemEqualizada);
		 
		 //imagem do grafico
		 imagemEqualizadaHistograma.getGraphics().drawImage(gerarMatrizHistograma(matrizImagemEqualizada), 0, heigth, null);
		
		 
	 }
	 
	 public BufferedImage gerarMatrizHistograma(int [][]imagem) {
	        BufferedImage imagemResult = new BufferedImage(imgLargura, imgAltura, BufferedImage.TYPE_INT_RGB);
		 
	        int[] freq = new int[256];
	        
	        //iniciar com zeros
	        for (int i = 0; i < freq.length; i++) {
	            freq[i] = 0;
	        }
	        
	        //ativa as frquencia de quantas vezes o pixel preceu
	        for (int i = 0; i < imgAltura; i++) {
	            for (int j = 0; j < imgLargura; j++) {
	                freq[imagem[i][j]] += 1;
	            }
	        }

	        // Coloca todos os pixels do buffered image na cor preta
	        for (int i = 0; i < imgAltura; i++) {
	            for (int j = 0; j < imgLargura; j++) {
	                imagemResult.setRGB(i, j, new Color(0, 0, 0).getRGB());
	            }
	        }

	        // Procura o valor RGB com maior frequencia entre 0 e 255
	        int maior = 0;
	        for (int i = 0; i < freq.length; i++) {
	            if (freq[i] > maior) {
	                maior = freq[i];
	            }
	        }

	        // Plota as frequencias dos valores RGB na vertical
	        for (int i = 0; i < imgAltura - 1; i++) {
	            int funcao = (100 * freq[i]) / maior;
	            for (int j = 0; j < funcao; j++) {
	            	if(i%2==0) {
	            		imagemResult.setRGB(i, imgAltura - 1 - j, new Color(255, 219, 88).getRGB());
	            	}else {
	            		imagemResult.setRGB(i, imgAltura - 1 - j, new Color(238, 173, 60).getRGB());
	            	}
	                
	            }
	        }

	        return imagemResult;
	 }
	 
	 public static int[][] equalizaImagem(int[][] imagem) {

			int[][] imagemAuxFinal = new int[imgAltura][imgLargura];
			double frequencia = 0;
			double[] frequenciaValor = new double[256];
			double[] probabilidadeK = new double[256];
			int[] nvlCinza = new int[256];

			//gera a fequencia
			for (int i = 0; i < frequenciaValor.length; i++) {
				for (int j = 0; j < imgAltura; j++) {
					for (int l = 0; l < imgLargura; l++) {
						if (i == imagem[j][l]) {
							frequencia += 1;
						}

					}
				}
				frequenciaValor[i] = frequencia;
			}

			//valor de K
			for (int i = 0; i < probabilidadeK.length; i++) {
				probabilidadeK[i] = frequenciaValor[i] / (imgLargura * imgAltura);

			}

			//nivel de cinza
			for (int i = 0; i < nvlCinza.length; i++) {
				nvlCinza[i] = (int) Math.round(probabilidadeK[i] * 255);

			}

			//faz o mapeamento na imagem
			for (int a = 0; a < nvlCinza.length; a++) {
				for (int i = 0; i < imagem.length; i++) {
					for (int j = 0; j < imagem[0].length; j++) {
						if (a == imagem[i][j]) {
							imagemAuxFinal[i][j] = nvlCinza[a];

						}

					}

				}
			}

			return imagemAuxFinal;

		}

}
