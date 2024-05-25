package graficos;

import javax.swing.ImageIcon;

import aplicacion.Main;

public enum Colores {

	ROJO(new ImageIcon(Main.class.getResource("/colores/rojo.png"))),
	ROSA(new ImageIcon(Main.class.getResource("/colores/rosa.png"))),
	BLANCO (new ImageIcon(Main.class.getResource("/colores/blanco.png"))),
	AMARILLO (new ImageIcon(Main.class.getResource("/colores/amarillo.png"))),
	VERDE (new ImageIcon(Main.class.getResource("/colores/verde.png"))),
	AZUL (new ImageIcon(Main.class.getResource("/colores/azul.png"))),
	
	NEGRO (new ImageIcon(Main.class.getResource("/colores/negro.png")));

	private ImageIcon color;
	private Colores(ImageIcon color) {
		this.color=color;
	}
	
	public ImageIcon getColor() {
		return this.color;
	}
	
	

}
