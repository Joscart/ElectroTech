package vista;

import javax.swing.JPanel;

import controlador.logic_ProductoVS;
import modelo.Producto;

import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JList;

public class ProductoVS extends JPanel {

	private static final long serialVersionUID = 1L;
	public logic_ProductoVS logic;
	public JTextField txt_buscar;
	public JList<Producto> lst_productos;

	/**
	 * Create the panel.
	 */
	public ProductoVS() {
		
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		
		txt_buscar = new JTextField();
		panel.add(txt_buscar);
		txt_buscar.setColumns(30);
		
		lst_productos = new JList<>();
		add(lst_productos);
		logic = new logic_ProductoVS(this);
	}

}
