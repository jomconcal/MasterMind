package aplicacion;

import java.awt.EventQueue;

import graficos.casilleros.Tablero;

public class Main {

	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Tablero t = new Tablero(10,4);
				t.iniciarPanelAcciones();
				t.setVisible(true);
				
			}
		});
	}

}
