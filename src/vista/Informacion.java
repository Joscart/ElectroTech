package vista;

import javax.swing.JPanel;

import controlador.logic_Informacion;

public class Informacion extends JPanel {

	private static final long serialVersionUID = 1L;
	public logic_Informacion logic;

	/**
	 * Create the panel.
	 */
	public Informacion() {
		logic = new logic_Informacion(this);
	}

}
