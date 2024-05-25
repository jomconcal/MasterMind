package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Solucionario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CasillaSolucion[] casillas;

	private JPanel resultado;

	private JLabel solucion;
	public Solucionario(int columnas) {
		setLayout(new BorderLayout());
		solucion= new JLabel("Averigua el enigma",JLabel.CENTER);
		add(solucion,BorderLayout.CENTER);
		setPreferredSize(new Dimension(columnas * 60, 60));

		this.casillas = new CasillaSolucion[4];
		rellenarCasillas();
	}
	
	public void mostrarResultado() {
		setLayout(new GridLayout(1, 5));
		remove(solucion);
		for (int i = 0; i < casillas.length; i++) {
			add(casillas[i]);
		}
		resultado = new JPanel();
		resultado.setLayout(new BorderLayout());
		resultado.setBackground(Color.BLACK);
		add(resultado);
	}

	private void rellenarCasillas() {
		for (int i = 0; i < casillas.length; i++) {
			casillas[i] = new CasillaSolucion();
		}
		
	}

	public CasillaSolucion[] getSoluciones() {
		return this.casillas;
	}
	
	public void setResultado(JLabel resultado) {
		this.resultado.add(resultado,BorderLayout.CENTER);
		updateUI();
	}

}
