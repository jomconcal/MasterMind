package graficos.casillas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import graficos.Colores;

/**
 * Casilla que recogerá la solución que debe encontrar el jugador.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class CasillaSolucion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Etiqueta para colocar el color de la solución.
	 */
	private JLabel solucion;

	/**
	 * Color de la solución.
	 */
	private ImageIcon color;

	/**
	 * Número que identifica la posición del elemento del numerador que representa
	 * el color.
	 */
	private int numColor;

	/**
	 * Variable para determinar si la casilla ya ha sido comprobada para dar una
	 * pista y no volverla a comprobar.
	 */
	private boolean comprobada;

	/**
	 * Inicia la casilla con la comprobación en false.
	 */
	public CasillaSolucion() {

		comprobada = false;

		setLayout(new BorderLayout());
		// Coloca el color elegido aleatoriamente.
		color = elegirColor();
		solucion = new JLabel(color, JLabel.CENTER);
		setBackground(new Color(67, 40, 16));
		setBorder(new BevelBorder(1));
		add(solucion, BorderLayout.CENTER);
	}

	/**
	 * Elige un color del numerador identificado entre 0 y 5 de forma aleatoria. Se
	 * utiliza en el constructor.
	 * 
	 * @return
	 */
	private ImageIcon elegirColor() {
		this.numColor = (int) (Math.random() * 6);
		return Colores.values()[numColor].getColor();
	}

	/**
	 * Número que identifica la posición del elemento del numerador que representa
	 * el color.
	 * 
	 * @return
	 */
	public int getNumColor() {
		return numColor;
	}

	/**
	 * Estado de comprobación de la casilla
	 * @return
	 */
	public boolean isComprobada() {
		return comprobada;
	}

	/**
	 * Modificar la situación de la casilla una vez comprobada.
	 * @param comprobada
	 */
	public void setComprobada(boolean comprobada) {
		this.comprobada = comprobada;
	}

}
