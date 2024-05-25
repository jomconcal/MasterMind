package graficos;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Casillero casillero;
	private Botonero botonero;
	private Solucionario solucionario;
	private Pistas pistas;
	private JPanel panelSuperior;

	public Tablero(int filas, int columnas) {
		setTitle("Master Mind");
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 0);
		
		panelSuperior= new JPanel();
		panelSuperior.setLayout(new BorderLayout());
		JMenuBar menuBar=new JMenuBar();
		JMenu menu = new JMenu("Menú");
		JMenuItem reiniciar = new JMenuItem("Reiniciar");
		reiniciar.addActionListener((e)->{
			this.remove(casillero);
			this.remove(botonero);
			this.remove(pistas);
			panelSuperior.remove(solucionario);
			iniciarTablero(filas, columnas);
		});
		menu.add(reiniciar);
		menuBar.add(menu);
		panelSuperior.add(menuBar,BorderLayout.NORTH);
		
		add(panelSuperior,BorderLayout.NORTH);
		iniciarTablero(filas, columnas);


	}

	private void iniciarTablero(int filas, int columnas) {
		casillero = new Casillero(filas, columnas);
		solucionario = new Solucionario(columnas);
		pistas = new Pistas(filas);
		botonero = new Botonero(casillero, solucionario, pistas);

		this.add(casillero, BorderLayout.CENTER);
		this.add(botonero, BorderLayout.SOUTH);
		panelSuperior.add(solucionario, BorderLayout.SOUTH);
		this.add(pistas, BorderLayout.EAST);
		
		this.pack();

	}

}
