package graficos.casilleros;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel para recibir todas las acciones
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class PanelReiniciar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Botón para reiniciar el juego.
	 */
	private JButton reiniciar;

	/**
	 * Inicia el panel recibiendo como parámetros los casilleros que debe manipular.
	 * 
	 * @param casillero
	 * @param solucionario
	 * @param pistas
	 */
	public PanelReiniciar() {
		reiniciar = new JButton("Reiniciar");
		this.add(reiniciar);
	}

	public JButton getBoton() {
		return this.reiniciar;
	}
}