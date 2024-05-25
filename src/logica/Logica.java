package logica;


import graficos.casillas.CasillaJugada;
import graficos.casillas.CasillaSolucion;

public class Logica {


	/**
	 * Calcula cúantos colores están dentro de su sitio y cúantos están fuera. El
	 * primer valor será el de dentro y el segundo el de fuera.
	 * 
	 * @param jugadas las casillas que han sido respondidas
	 * @param soluciones las Soluciones preestablecidas
	 * @return int[] aciertos Posición 0 en su sitio, posición 1 fuera de sitio. 
	 */
	public static int[] valorAciertos(CasillaJugada[] jugadas, CasillaSolucion[] soluciones) {
		int[] aciertos = new int[2];
		int sitio = 0;
		int fuera = 0;
		int jugada;
		int solucion;
		for (int i = 0; i < jugadas.length; i++) {
			jugada = jugadas[i].getNumColor();
			solucion = soluciones[i].getNumColor();

			if (jugada==solucion){
				sitio += 1;
				soluciones[i].setComprobada(true);
				jugadas[i].setAcertada(true);
			}

		}

		for (int i = 0; i < jugadas.length; i++) {
			jugada = jugadas[i].getNumColor();
			boolean comprobada = false;
			if (!jugadas[i].isAcertada()) {
				for (int j = 0; j < soluciones.length && !comprobada; j++) {
					solucion = soluciones[j].getNumColor();
					if (jugada==solucion && !soluciones[j].isComprobada()) {
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
	 * Reiniciar el atributo de comprobación de las casillas a false
	 * 
	 * @param soluciones CasillaSolucion[]
	 */
	private static void reiniciarValores(CasillaSolucion[] soluciones) {
		for (int i = 0; i < soluciones.length; i++) {
			soluciones[i].setComprobada(false);
		}
	}
}
