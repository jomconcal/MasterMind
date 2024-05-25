package logica;

import javax.swing.ImageIcon;

import graficos.CasillaJugada;
import graficos.CasillaSolucion;

public class Logica {


	/**
	 * Calcula cúantos colores están dentro de su sitio y cúantos están fuera. El
	 * primer valor será el de dentro y el segundo el de fuera.
	 * 
	 * @param jugadas las casillas que han sido respondidas
	 * @param soluciones las SOluciones preestablecidas
	 * @return int[] aciertos
	 */
	public static int[] valorAciertos(CasillaJugada[] jugadas, CasillaSolucion[] soluciones) {
		int[] aciertos = new int[2];
		int sitio = 0;
		int fuera = 0;
		ImageIcon jugada;
		ImageIcon solucion;
		for (int i = 0; i < jugadas.length; i++) {
			jugada = jugadas[i].getColor();
			solucion = soluciones[i].getColor();

			if (jugada.equals(solucion)) {
				sitio += 1;
				soluciones[i].setComprobada(true);
				jugadas[i].setAcertada(true);
			}

		}

		for (int i = 0; i < jugadas.length; i++) {
			jugada = jugadas[i].getColor();
			boolean comprobada = false;
			if (!jugadas[i].isAcertada()) {
				for (int j = 0; j < soluciones.length && !comprobada; j++) {
					solucion = soluciones[j].getColor();
					if (jugada.equals(solucion) && !soluciones[j].isComprobada()) {
						fuera += 1;
						soluciones[j].setComprobada(true);
						comprobada = true;
						jugadas[i].setAcertada(true);
					}
				}
			}
		}
		reiniciarValores(soluciones);
		aciertos[0] = sitio;
		aciertos[1] = fuera;
		return aciertos;
	}

	/**
	 * Reiniciar el atributo de comprobación de las casillas a falsr
	 * 
	 * @param soluciones CasillaSolucion[]
	 */
	private static void reiniciarValores(CasillaSolucion[] soluciones) {
		for (int i = 0; i < soluciones.length; i++) {
			soluciones[i].setComprobada(false);
		}
	}
}
