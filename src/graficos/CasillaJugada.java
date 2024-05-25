package graficos;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class CasillaJugada extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<ImageIcon> colores;
	private DefaultComboBoxModel<ImageIcon> modeloColores;
	private boolean acertada;

	public CasillaJugada(boolean jugable) {
		this.acertada = false;
		setBackground(new Color(111, 65, 20));
		setBorder(new BevelBorder(1));

		colores = new JComboBox<>();
		modeloColores = new DefaultComboBoxModel<ImageIcon>();
		rellenarComboColores(jugable);

	}

	private void rellenarComboColores(boolean jugable) {

		modeloColores.addElement(Colores.ROJO);
		modeloColores.addElement(Colores.ROSA);
		modeloColores.addElement(Colores.BLANCO);
		modeloColores.addElement(Colores.AMARILLO);
		modeloColores.addElement(Colores.VERDE);
		modeloColores.addElement(Colores.AZUL);

		colores.setModel(modeloColores);

		if (jugable)
			this.add(colores);

	}

	public void setJugable(boolean jugable) {
		if (jugable)
			this.add(colores);
		else {
			this.remove(colores);
			setFondo();
		}
		updateUI();
	}

	private void setFondo() {
		JLabel fondo = new JLabel((ImageIcon) colores.getSelectedItem(), JLabel.CENTER);
		this.setLayout(new BorderLayout());
		add(fondo, BorderLayout.CENTER);
	}

	public ImageIcon getColor() {
		return (ImageIcon) this.colores.getSelectedItem();
	}

	public void setColor(ImageIcon icon) {
		this.colores.setSelectedItem(icon);
		updateUI();
	}
	public boolean isAcertada() {
		return acertada;
	}

	public void setAcertada(boolean acertada) {
		this.acertada = acertada;
	}

	
	

}
