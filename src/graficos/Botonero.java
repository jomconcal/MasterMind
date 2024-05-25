package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.Main;
import logica.Logica;

public class Botonero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton botonJugar;

	public Botonero(Casillero casillero, Solucionario solucionario, Pistas pistas) {
		botonJugar = new JButton("Jugar");
		botonJugar.addActionListener(new Jugar(casillero, solucionario, pistas));
		this.add(botonJugar);
	}

	private class Jugar implements ActionListener {

		private CasillaJugada[][] filasJugadas;
		private CasillaSolucion[] soluciones;
		private CasillaPista[] pistas;
		private Casillero casillero;
		private Solucionario solucionario;
		private int fila;

		public Jugar(Casillero casillero, Solucionario solucionario, Pistas pistas) {
			this.solucionario=solucionario;
			this.casillero = casillero;
			this.filasJugadas = casillero.getCasillas();
			this.soluciones = solucionario.getSoluciones();
			this.pistas = pistas.getPistas();
			this.fila = 0;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			CasillaJugada[] jugadas = casillasJugadas(fila);
			int[] aciertos = Logica.valorAciertos(jugadas, soluciones);
			activarPistas(aciertos, fila);
			if (aciertos[0] == 4) {
				casillero.setVictoria(true);
				JLabel victoria=new JLabel(new ImageIcon(Main.class.getResource("/emoticonos/sonrisa3.jpg")));
				solucionario.mostrarResultado();
				solucionario.setResultado(victoria);
			} else
				avanzarFila(fila,jugadas);

			fila++;
			if (casillero.isVictoria())
				botonJugar.setEnabled(false);

		}

		/**
		 * Recoge las casillas que han sido jugadas y actualiza las siguientes para ser
		 * jugadas en el próximo turno.
		 * 
		 * @param fila fila que se va a analizar
		 * @return Casillas[] jugadas
		 */
		private CasillaJugada[] casillasJugadas(int fila) {
			CasillaJugada[] jugadas = new CasillaJugada[4];

			for (int j = 0; j < filasJugadas[fila].length; j++) {
				filasJugadas[fila][j].setJugable(false);
				jugadas[j] = filasJugadas[fila][j];
			}

			return jugadas;
		}

		private void avanzarFila(int fila, CasillaJugada[]jugadas) {
			fila++;
			if (fila < filasJugadas.length) {
				for (int j = 0; j < filasJugadas[fila].length; j++) {

					filasJugadas[fila][j].setColor(jugadas[j].getColor());
					filasJugadas[fila][j].setJugable(true);
				}
			} else {
				// terminar juego
				JLabel derrota=new JLabel(new ImageIcon(Main.class.getResource("/emoticonos/perdedor3.jpg")));
				solucionario.mostrarResultado();
				solucionario.setResultado(derrota);
				botonJugar.setEnabled(false);
			}
		}

		/**
		 * Da la pista oportuna en base a los aciertos en la fila indicada.
		 * 
		 * @param aciertos
		 * @param fila
		 */
		private void activarPistas(int[] aciertos, int fila) {
			pistas[fila].colocarPistas(aciertos);
		}

	}

}
