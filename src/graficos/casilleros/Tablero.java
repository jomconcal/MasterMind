package graficos.casilleros;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import graficos.acciones.AccionFlechas;
import graficos.acciones.AccionReiniciar;

/**
 * Tablero que recoge todos los casilleros y los muestra al jugador para que
 * interaccione.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Casillero con las casillas jugables
	 */
	private Casillero casillero;

	/**
	 * Solucionario con las soluciones ocultas.
	 */
	private Solucionario solucionario;

	/**
	 * Pistas con las casillas que irán ayudando al jugador.
	 */
	private Pistas pistas;

	/**
	 * Panel encargado de recibir las acciones que realizará el jugador.
	 */
	private PanelAcciones panelAcciones;

	/**
	 * Filas que tiene el tablero
	 */
	private int filas;

	/**
	 * Columnas que tiene el tablero
	 */
	private int columnas;

	/**
	 * Inicia el tablero con un número de filas y columnas.
	 * 
	 * @param filas
	 * @param columnas
	 */
	public Tablero(int filas, int columnas) {
		setTitle("Master Mind");
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 0);

		iniciarTablero(filas, columnas);

	}

	/**
	 * Función que inicia los elementos del tablero con el mismo número de filas y
	 * columnas.
	 * 
	 * @param filas
	 * @param columnas
	 */
	private void iniciarTablero(int filas, int columnas) {
		casillero = new Casillero(filas, columnas);
		solucionario = new Solucionario(columnas);
		pistas = new Pistas(filas);
		this.filas = filas;
		this.columnas = columnas;

		this.add(casillero, BorderLayout.CENTER);
		this.add(solucionario, BorderLayout.NORTH);
		this.add(pistas, BorderLayout.EAST);

	}

	/**
	 * Inicialización del panel de acciones fuera del constructor para no resultar
	 * nulo. Ya que necesita Tablero como parámetro.
	 */
	public void iniciarPanelAcciones() {
		panelAcciones = new PanelAcciones();
		panelAcciones.addKeyListener(new AccionFlechas(this));
		panelAcciones.getBoton().addActionListener(new AccionReiniciar(this));
		this.add(panelAcciones, BorderLayout.SOUTH);
		this.pack();

	}

	public Casillero getCasillero() {
		return casillero;
	}

	public Solucionario getSolucionario() {
		return solucionario;
	}

	public Pistas getPistas() {
		return pistas;
	}

	public PanelAcciones getPanelAcciones() {
		return panelAcciones;
	}

	public void reiniciar() {
		

		this.remove(casillero);
		this.remove(solucionario);
		this.remove(pistas);
		this.remove(panelAcciones);
		
		iniciarTablero(filas, columnas);
		iniciarPanelAcciones();
		
		//Si no no se actualizan los listeners.
		this.setVisible(false);
		this.setVisible(true);
		
	}

}
