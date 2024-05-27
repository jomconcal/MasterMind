package graficos.acciones;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import graficos.casilleros.Casillero;
import graficos.casilleros.Pistas;
import graficos.casilleros.Solucionario;
import graficos.casilleros.Tablero;
import logica.Logica;

/**
 * Acción que permite con las flechas cambiar la casilla que tiene el foco o
 * cambiar el color de la casilla que recibe el foco.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class AccionFlechas extends KeyAdapter {
	
	/**
	 * Tablero sobre el que recae la acción
	 */
	private Tablero tablero;

	/**
	 * Casillero sobre el que realizar las acciones.
	 */
	private Casillero casillero;

	/**
	 * Pistas que se muestran al usuario tras la accion
	 */
	private Pistas pistas;

	/**
	 * Soluciones al acertijo.
	 */
	private Solucionario solucionario;

	/**
	 * Fila de la casilla que recibe la acción.
	 */
	private int fila;

	/**
	 * Fila de la columna que recibe la acción.
	 */
	private int columna;

	/**
	 * Inicia el la clase de la acción recogiendo el casillero y la fila y columna
	 * que tienen actualmente el foco.
	 * 
	 * @param casillero
	 */
	public AccionFlechas(Tablero tablero) {
		this.tablero=tablero;
		this.pistas = tablero.getPistas();
		this.casillero = tablero.getCasillero();
		this.solucionario = tablero.getSolucionario();
		this.fila = casillero.getFilaActual();
		this.columna = casillero.getColumnaActual();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.fila = casillero.getFilaActual();
		this.columna = casillero.getColumnaActual();
		int colorActual = casillero.getCasillas(fila, columna).getNumColor();
		// Si se presiona la tecla derecha se desplaza el foco a la derecha. Si excede
		// del límite vuelve a la casilla inicial.
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			casillero.focus(fila, columna + 1);
			casillero.unFocus(fila, columna);
		}

		// Si se presiona la tecla izquierda se desplaza el foco a la izquierda. Si
		// excede
		// del límite vuelve a la casilla final.
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			casillero.focus(fila, columna - 1);
			casillero.unFocus(fila, columna);
		}

		// Si se presiona la tecla abajo se modifica el color de la casilla de forma
		// ascendente. Si excede del límite vuelve al color inicial.
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			casillero.getCasillas(fila, columna).setColor(colorActual + 1);
		}

		// Si se presiona la tecla arriba se modifica el color de la casilla de forma
		// descendente. Si excede del límite vuelve al color final.
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			casillero.getCasillas(fila, columna).setColor(colorActual - 1);
		}

		// Si se presiona la tecla enter se pasa el foco a la siguiente fila y se
		// muestra la pista. Si se llega al final se acaba el juego.
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int aciertos[] = Logica.valorAciertos(casillero.getCasillas()[fila], solucionario.getSoluciones());
			pistas.getPista(fila).colocarPistas(aciertos);

			if (aciertos[0] == 4) {
				casillero.setFinJuego(true);
				solucionario.mostrarResultado(true);
				tablero.removeKeyListener(this);
			} else {
				casillero.avanzarFila();
				if (casillero.isFinJuego()) {
					tablero.removeKeyListener(this);
					solucionario.mostrarResultado(false);
				}
			}
		}
	}

}
