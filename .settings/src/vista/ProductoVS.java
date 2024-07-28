package vista;

import javax.swing.JPanel;

import controlador.logic_ProductoVS;

public class ProductoVS extends JPanel {

	private static final long serialVersionUID = 1L;
	public logic_ProductoVS logic;

	/**
	 * Create the panel.
	 */
	public ProductoVS() {
		logic = new logic_ProductoVS(this);
	}

}
