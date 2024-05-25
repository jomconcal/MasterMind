package graficos.casillas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import graficos.Colores;

/**
 * Casilla para informar al jugador de cúantos colores ha acertado. Por cada
 * acierto fuera de lugar recibirá una pista de color blanco. Por cada acierto
 * bien colocado recibirá una pista de color negro.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class CasillaPista extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Array para colocar las pistas.
	 */
	private JLabel[] pistas;

	/**
	 * Inicia el casillero con las pistas sin color.
	 */
	public CasillaPista() {
		setLayout(new GridLayout(2, 2));
		setBackground(new Color(50, 50, 50));
		setBorder(new BevelBorder(1));
		this.pistas = new JLabel[4];
		colocarPistas();
	}

	/**
	 * Coloca por primera vez las pistas sin ningún color. Se usa en el constructor.
	 */
	private void colocarPistas() {
		for (int i = 0; i < pistas.length; i++) {
			pistas[i] = new JLabel("", JLabel.CENTER);
			add(pistas[i]);
		}
	}

	/**
	 * Modifica las pistas tras el turno del jugador.
	 * 
	 * @param aciertos array de longitud dos. En la posición 0 recoge el número de
	 *                 aciertos que están en su lugar. En la posición 1 recoge el
	 *                 número de aciertos que están fuera de lugar.
	 */
	public void colocarPistas(int[] aciertos) {
		ImageIcon blanco = Colores.BLANCO.getColor();
		ImageIcon negro = Colores.NEGRO.getColor();

		int posicion = 0;
		//Por cada acierto en su lugar coloca una pista negra
		for (int i = 0; i < aciertos[0]; i++) {
			pistas[posicion++].setIcon(negro);
		}
		//Por cada acierto fuera de lugar coloca una pista blanca
		for (int i = 0; i < aciertos[1]; i++) {
			pistas[posicion++].setIcon(blanco);
		}
		updateUI();
	}
}
