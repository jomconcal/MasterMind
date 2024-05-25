package graficos.casilleros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.Main;
import graficos.casillas.CasillaSolucion;

/**
 * Casillero que recibe las casillas con la solución.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class Solucionario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Array con las casillas con la solución
	 */
	private CasillaSolucion[] casillasSolucion;

	/**
	 * Etiqueta que muestra un mensaje para mantener la solución oculta hasta el
	 * final del juego.
	 */
	private JLabel solucionOculta;

	/**
	 * Inicia el solucionario con un número determinado de columnas.
	 * 
	 * @param columnas
	 */
	public Solucionario(int columnas) {
		setLayout(new BorderLayout());
		solucionOculta = new JLabel("Averigua el enigma", JLabel.CENTER);
		add(solucionOculta, BorderLayout.CENTER);
		setPreferredSize(new Dimension(columnas * 60, 60));

		this.casillasSolucion = new CasillaSolucion[4];
		rellenarCasillas();
	}

	/**
	 * Muestra la solucion una vez que el jugador haya terminado el juego. Si ha
	 * acabado vistorioso, mostrará además una cara sonriente, si no una triste.
	 */
	public void mostrarResultado(boolean victoria) {
		setLayout(new GridLayout(1, 5));
		remove(solucionOculta);
		for (int i = 0; i < casillasSolucion.length; i++) {
			add(casillasSolucion[i]);
		}
		JPanel resultado = new JPanel();
		resultado.setLayout(new BorderLayout());
		resultado.setBackground(Color.BLACK);

		if (victoria) {
			resultado.add(new JLabel(new ImageIcon(Main.class.getResource("/emoticonos/sonrisa3.jpg"))));
		}else {
			resultado.add(new JLabel(new ImageIcon(Main.class.getResource("/emoticonos/perdedor3.jpg"))));
		}

		add(resultado);
		updateUI();
	}

	/**
	 * Inicia las casillas con la solución
	 */
	private void rellenarCasillas() {
		for (int i = 0; i < casillasSolucion.length; i++) {
			casillasSolucion[i] = new CasillaSolucion();
		}

	}

	/**
	 * Devuelve las casillas con la solución.
	 * 
	 * @return CasillaSolucion[]
	 */
	public CasillaSolucion[] getSoluciones() {
		return this.casillasSolucion;
	}

	/**
	 * Devuelve una única casilla identificada por su posición.
	 * 
	 * @param columna
	 * @return CasillaSolucion
	 */
	public CasillaSolucion getCasillaSolucione(int columna) {
		return this.casillasSolucion[columna];
	}
}
