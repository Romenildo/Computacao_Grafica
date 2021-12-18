package TelaMenus;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelRetaDDA extends JPanel {
	
	public panelRetaDDA() {
		JPanel panel4 = new JPanel();
		panel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmos de Rasterização da Reta"));
		
		JLabel label1 = new JLabel("Informe as coordenadas do mundo - eixo Xmin: ");
		JLabel label2 = new JLabel("Informe as coordenadas do mundo - eixo Xmin: ");
		JLabel label3 = new JLabel("Informe as coordenadas do mundo - eixo Xmin: ");
		
		setSize(200,300);
		
		panel4.add(label1);
		panel4.add(label2);
		panel4.add(label3);
	}
}
