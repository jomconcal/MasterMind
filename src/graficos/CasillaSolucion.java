package graficos;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class CasillaSolucion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel solucion;
	private ImageIcon color;
	private boolean comprobada;

	public CasillaSolucion() {

		comprobada = false;
		setLayout(new BorderLayout());
		color = elegirColor();
		solucion = new JLabel(color, JLabel.CENTER);
		setBackground(new Color(67, 40, 16));
		setBorder(new BevelBorder(1));
		add(solucion, BorderLayout.CENTER);
	}

	private ImageIcon elegirColor() {
		int aleatorio = (int) (Math.random() * 6);
		ImageIcon color;
		switch (aleatorio) {
		case 0:
			color = Colores.ROJO;
			break;
		case 1:
			color = Colores.ROSA;
			break;
		case 2:
			color = Colores.BLANCO;
			break;
		case 3:
			color = Colores.AMARILLO;
			break;
		case 4:
			color = Colores.VERDE;
			break;
		case 5:
			color = Colores.AZUL;
			break;
		default:
			color = Colores.NEGRO;
			break;
		}
		return color;
	}

	public ImageIcon getColor() {
		return color;
	}

	public boolean isComprobada() {
		return comprobada;
	}

	public void setComprobada(boolean comprobada) {
		this.comprobada = comprobada;
	}

}
