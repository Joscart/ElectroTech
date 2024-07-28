package vista;

import javax.swing.JPanel;

import controlador.logic_ProductoVS;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BoxLayout;

public class ProductoVS extends JPanel {

	private static final long serialVersionUID = 1L;
	public logic_ProductoVS logic;
	public JTextField txt_buscar;
	public JTable tbl_productos;

	/**
	 * Create the panel.
	 */
	public ProductoVS() {
		
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		logic = new logic_ProductoVS(this);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		
		txt_buscar = new JTextField();
		panel.add(txt_buscar);
		txt_buscar.setColumns(30);
		
		tbl_productos = new JTable();
		add(tbl_productos);
	}

}
