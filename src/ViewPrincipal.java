import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Canvas;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

public class ViewPrincipal {

	private JFrame frmCoordenadas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal window = new ViewPrincipal();
					window.frmCoordenadas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoordenadas = new JFrame();
		frmCoordenadas.setTitle("Coordenadas");
		frmCoordenadas.setBounds(100, 100, 905, 596);
		frmCoordenadas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(frmCoordenadas.getContentPane(), popupMenu);
		frmCoordenadas.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		frmCoordenadas.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(10, 170, 111, 24);
		frmCoordenadas.getContentPane().add(mnNewMenu);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
