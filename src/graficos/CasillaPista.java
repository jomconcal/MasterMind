package graficos;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class CasillaPista extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel[] pistas;

	public CasillaPista() {
		setLayout(new GridLayout(2, 2));
		setBackground(new Color(50, 50, 50));
		setBorder(new BevelBorder(1));
		this.pistas = new JLabel[4];
		colocarPistas();
	}

	private void colocarPistas() {
		for (int i = 0; i < pistas.length; i++) {
			pistas[i] = new JLabel(new ImageIcon(),JLabel.CENTER);
			add(pistas[i]);
		}
	}
	
	public void colocarPistas(int[]aciertos) {
		ImageIcon blanco= Colores.BLANCO;
		ImageIcon negro=Colores.NEGRO;
		
		int posicion=0;
		for(int i=0;i<aciertos[0];i++) {
			pistas[posicion++].setIcon(negro);
		}
		for(int i=0;i<aciertos[1];i++) {
			pistas[posicion++].setIcon(blanco);
		}
		updateUI();
	}
}
