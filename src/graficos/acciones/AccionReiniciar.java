package graficos.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graficos.casilleros.Tablero;

/**
 * CLase para reiniciar los valores del tablero y comenzar la partida.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class AccionReiniciar implements ActionListener {

	
	/**
	 * Tablero con todos los componentes
	 */
	private Tablero tablero;

	/**
	 * Inicializa los atributos de la clase.
	 * @param tablero
	 */
	public AccionReiniciar(Tablero tablero) {
		this.tablero = tablero;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tablero.reiniciar();
	}

}
