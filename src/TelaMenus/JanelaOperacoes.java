package TelaMenus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

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
	JLabel labelImagem1;
	JLabel labelImagem2;
	JLabel labelImagemResultado;
	
	public JanelaOperacoes() {
		
		setLayout(null);
		setSize(800,800);
		
		JPanel panelOperacao = new JPanel();
		panelOperacao.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.setBounds(0, 0, 800, 800);
		add(panelOperacao);
		panelOperacao.setLayout(null);
		
		
		labelImagem1 = new JLabel();
		labelImagem1.setBounds(20, 20, 320, 320);
		labelImagem1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "1º Imagem", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(labelImagem1);
		
	    btnSelecionarImg1 = new JButton("SelecionarImagem");
	    btnSelecionarImg1 .setFont(new Font("Arial", Font.BOLD, 11));
	    btnSelecionarImg1 .setBounds(70, 345, 200, 20);
	    btnSelecionarImg1.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		selecionarImagem(evt, labelImagem1);
	    	}	
	     });
		panelOperacao.add(btnSelecionarImg1);
		
		//imagem 2
		
		labelImagem2 = new JLabel();
		labelImagem2.setBounds(400, 20, 320, 320);
		labelImagem2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "2º Imagem", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(labelImagem2);
		
		 btnSelecionarImg2 = new JButton("SelecionarImagem");
		    btnSelecionarImg2 .setFont(new Font("Arial", Font.BOLD, 11));
		    btnSelecionarImg2 .setBounds(470, 345, 200, 20);
		    btnSelecionarImg2.addActionListener(new java.awt.event.ActionListener() {
		    	public void actionPerformed(java.awt.event.ActionEvent evt) {
		    		selecionarImagem(evt, labelImagem2);
		    	}	
		     });
			panelOperacao.add(btnSelecionarImg2);
		
		
		labelImagemResultado = new JLabel();
		labelImagemResultado.setBounds(200, 380, 320, 320);
		labelImagemResultado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOperacao.add(labelImagemResultado);
		
	}
	
	
	 private void selecionarImagem(java.awt.event.ActionEvent evt, JLabel labelImagem) {//GEN-FIRST:event_selectImage
	        try {
	            JFileChooser arquivo = new JFileChooser();
	            arquivo.setDialogTitle("Selecione a imagem");
	            arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            
	            
	            int opcao = arquivo.showOpenDialog(this);
	            if(opcao == JFileChooser.APPROVE_OPTION) {
	            	System.out.println(arquivo.getSelectedFile().getPath());
	            	ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
	            	
	            	labelImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(labelImagem1.getWidth()-20, labelImagem1.getHeight()-20, Image.SCALE_DEFAULT)));
	            	System.out.println("imagem tudo certo");
	            }
	            
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "OPS! Não foi possivel carregar a imagem.");
	        }
	    }

}
