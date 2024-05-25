package graficos;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Pistas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CasillaPista[] pistas;

	public Pistas(int filas) {
		this.setLayout(new GridLayout(filas,1));
		this.pistas = new CasillaPista[filas];
		rellenarPistas(filas);
		setPreferredSize(new Dimension(60,filas*60));
	}
	
	private void rellenarPistas(int filas){
		for(int i=0;i<filas;i++) {
			CasillaPista cp=new CasillaPista();
			pistas[i]=cp;
			this.add(cp);
		}
	}

	public CasillaPista[] getPistas() {
		return pistas;
	}

	
}
