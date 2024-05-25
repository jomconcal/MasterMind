package graficos.casilleros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import graficos.casillas.CasillaJugada;

/**
 * Casillero donde colocar las casillas que el jugador puede manipular. Se
 * estructura en un array de dos dimensiones.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class Casillero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Array de dos dimensiones para colocar las casillas.
	 */
	private CasillaJugada[][] casillaJugadas;

	/**
	 * Filas que contiene el array
	 */
	private int filas;

	/**
	 * Columnas que contiene el array
	 */
	private int columnas;

//	/**
//	 * Variable para determinar si el jugador ha ganado la partida o no.
//	 */
//	private boolean victoria;

	/**
	 * Fila en la que se encuentra la casilla con el foco.
	 */
	private int filaActual;

	/**
	 * Columna en la que se encuentra la casilla con el foco.
	 */
	private int columnaActual;

	/**
	 * Indica si se puede seguir jugando o no.
	 */
	private boolean finJuego;

	/**
	 * Inicia el casillero con un determinado de filas y columnas. Inicia la
	 * variable finJuego en false. Marca el foco en la casilla 0,0.
	 * 
	 * @param filas
	 * @param columnas
	 */
	public Casillero(int filas, int columnas) {
//		this.victoria = false;
		this.finJuego = false;
		this.filas = filas;
		this.columnas = columnas;
		setLayout(new GridLayout(filas, columnas));
		casillaJugadas = new CasillaJugada[filas][columnas];
		anyadirCasillas();
		setPreferredSize(new Dimension(columnas * 60, filas * 60));
		this.focus(0, 0);
	}

	/**
	 * Coloca todas las casillas en el casillero.
	 */
	private void anyadirCasillas() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				// Inicia la casilla como jugable o no dependiendo de la fila que ocupe.
				CasillaJugada c = new CasillaJugada(i < 1);
				this.add(c);
				casillaJugadas[i][j] = c;
			}
		}
	}

	/**
	 * Cambia el color de la casilla para que el jugador sepa cuál se va a
	 * modificar. Actualiza la posición de la fila y columna actual. Si la columna
	 * excede su rango se coloca en el lado opuesto.
	 * 
	 * @param fila    identifica la fila de la casilla
	 * @param columna identifica la columna de la casilla
	 */
	public void focus(int fila, int columna) {
		this.filaActual = fila;
		this.columnaActual = columna;
		if (columna == this.columnas) {
			this.columnaActual = 0;
		} else if (columna == -1) {
			this.columnaActual = this.columnas - 1;
		}
		this.casillaJugadas[filaActual][columnaActual].setBackground(new Color(147, 99, 65));
	}

	/**
	 * Cambia el color de la casilla para que el jugador sepa que ya no se va a
	 * modificar.
	 * 
	 * @param fila    identifica la fila de la casilla
	 * @param columna identifica la columna de la casilla
	 */
	public void unFocus(int fila, int columna) {
		this.casillaJugadas[fila][columna].setBackground(new Color(111, 65, 20));
	}

	/**
	 * Devuelve el casillero completo
	 * 
	 * @return
	 */
	public CasillaJugada[][] getCasillas() {
		return casillaJugadas;
	}

	/**
	 * Devuelve la casilla que se encentra en la posición requerida.
	 * 
	 * @param fila    de la casilla
	 * @param columna de la casilla
	 * @return casillaJugada
	 */
	public CasillaJugada getCasillas(int fila, int columna) {
		return casillaJugadas[fila][columna];
	}

	/**
	 * Filas totales del casillero
	 * 
	 * @return filas
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * Columnas totales del casillero
	 * 
	 * @return columnas
	 */
	public int getColumnas() {
		return columnas;
	}

//	/**
//	 * Informa de si el jugador ha ganado o no la partida.
//	 * 
//	 * @return victoria
//	 */
//	public boolean isVictoria() {
//		return victoria;
//	}

//	/**
//	 * Modifica la situación de la variable victoria.
//	 * 
//	 * @param victoria
//	 */
//	public void setVictoria(boolean victoria) {
//		this.victoria = victoria;
//	}

	public int getFilaActual() {
		return filaActual;
	}

	public int getColumnaActual() {
		return columnaActual;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	/**
	 * Termina el juego y quita el foco de cualquier casilla
	 * 
	 * @param finJuego
	 */
	public void setFinJuego(boolean finJuego) {
		this.finJuego = finJuego;
		if (finJuego)
			unFocus(filaActual, columnaActual);
	}

	/**
	 * Quita el foco de la fila actual y la pasa al siguiente. Si llega al final se
	 * acaba la partida. Modifica la variable finJuego.
	 * 
	 */
	public void avanzarFila() {
		finJuego = filaActual == filas - 1;

		unFocus(filaActual, columnaActual);

		if (!finJuego) {
			int colores[] = new int[columnas];
			// Recoge los colores que actualmente se han jugado y los guarda en un array.
			for (int i = 0; i < colores.length; i++) {
				colores[i] = casillaJugadas[filaActual][i].getNumColor();
			}
			focus(filaActual + 1, 0);

			// Coloca los colores en las nueva casillas.
			for (int i = 0; i < colores.length; i++) {
				casillaJugadas[filaActual][i].setColor(colores[i]);
			}
		}
	}

}
