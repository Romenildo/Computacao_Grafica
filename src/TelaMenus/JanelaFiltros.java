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

public class JanelaFiltros extends JPanel {
	
	JPanel panelPrincipal = new JPanel();
	JButton btnSelecionarImg;
	JLabel labelImagem1;
	JLabel labelImagem2;
	
	public JanelaFiltros() {
		
		setLayout(null);
		setSize(800,800);
		
		JPanel panelFiltro = new JPanel();
		panelFiltro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltro.setBounds(0, 0, 800, 800);
		add(panelFiltro);
		panelFiltro.setLayout(null);
		
		
		labelImagem1 = new JLabel();
		labelImagem1.setBounds(250, 20, 320, 320);
		labelImagem1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imagem a ser filtrada", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltro.add(labelImagem1);
		
	    btnSelecionarImg = new JButton("SelecionarImagem");
	    btnSelecionarImg .setFont(new Font("Arial", Font.BOLD, 11));
	    btnSelecionarImg .setBounds(300, 345, 200, 20);
	    btnSelecionarImg.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		selecionarImagem(evt);
	    	}	
	     });
		panelFiltro.add(btnSelecionarImg);
		
		labelImagem2 = new JLabel();
		labelImagem2.setBounds(250, 370, 320, 320);
		labelImagem2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imagem filtrada", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFiltro.add(labelImagem2);
	}
	
	
	 private void selecionarImagem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImage
	        try {
	            JFileChooser arquivo = new JFileChooser();
	            arquivo.setDialogTitle("Selecione a imagem");
	            arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            
	            
	            int opcao = arquivo.showOpenDialog(this);
	            if(opcao == JFileChooser.APPROVE_OPTION) {
	            	System.out.println(arquivo.getSelectedFile().getPath());
	            	ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
	            	
	            	labelImagem1.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(labelImagem1.getWidth()-20, labelImagem1.getHeight()-20, Image.SCALE_DEFAULT)));
	            	System.out.println("imagem tudo certo");
	            }
	            
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "OPS! Não foi possivel carregar a imagem.");
	        }
	    }

}
