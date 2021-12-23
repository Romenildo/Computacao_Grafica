/** 
 * Classe panel Coordenadas
 * 
 * @version: 2.0.0
 * @authors Antonio Leomar Ferreira Soares,
 * 		    Dennis Eduardo Santos da Silva,
 * 		    Romenildo do Vale ferreira.
 */
package TelaMenus;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class panelCoordenadas extends JPanel {
	
	public JLabel mousePosition;
	public JLabel coordenadaMundo;
	public JLabel coordenadaCentralizadaNormalizada;
	public JLabel coordenadaCartesiana;
	
	public panelCoordenadas() {
		setLayout(null);
		setSize(400,800);
		
		JPanel panelCoordenadas = new JPanel();
		panelCoordenadas.setBorder(new TitledBorder(null, "Coordenadas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelCoordenadas.setBounds(10, 10, 366, 743);
		panelCoordenadas.setLayout(new FlowLayout());
		add(panelCoordenadas);
		

		mousePosition = new JLabel();
		panelCoordenadas.add(mousePosition);

		coordenadaCentralizadaNormalizada = new JLabel();
		panelCoordenadas.add(coordenadaCentralizadaNormalizada);
		
		coordenadaMundo = new JLabel();
		panelCoordenadas.add(coordenadaMundo);
		
		coordenadaCartesiana = new JLabel();
		panelCoordenadas.add(coordenadaCartesiana);
	}
	

}
