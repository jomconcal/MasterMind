package graficos;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Casillero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CasillaJugada[][] casillaJugadas;
	private int filas;
	private int columnas;
	private boolean victoria;

	public Casillero(int filas, int columnas) {
		this.victoria=false;
		this.filas = filas;
		this.columnas = columnas;
		setLayout(new GridLayout(filas, columnas));
		casillaJugadas = new CasillaJugada[filas][columnas];
		anyadirCasillas();
		setPreferredSize(new Dimension(columnas * 60, filas * 60));
	}

	private void anyadirCasillas() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				CasillaJugada c = new CasillaJugada(i<1);
				this.add(c);
				casillaJugadas[i][j] = c;
			}
		}
	}

	public CasillaJugada[][] getCasillas() {
		return casillaJugadas;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public boolean isVictoria() {
		return victoria;
	}

	public void setVictoria(boolean victoria) {
		this.victoria = victoria;
	}
	
	

}
