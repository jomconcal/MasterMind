package aplicacion;

import java.awt.EventQueue;
import graficos.Tablero;

public class Main {

	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Tablero t = new Tablero(10,4);
				t.setVisible(true);
				
				
			}
		});
	}

}
