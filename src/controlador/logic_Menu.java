package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.*;

public class logic_Menu implements ActionListener{

	private Menu lb;
	
	public logic_Menu(Menu lb) {
		// TODO Auto-generated constructor stub
		this.lb = lb;
		listeners();
	}
	
	private void listeners() {
		lb.btnGestionProducto.addActionListener(this);
		lb.btnGestionProveedores.addActionListener(this);
		lb.btnGestionUsuario.addActionListener(this);
		lb.btnVentana.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btnGestionProducto) {
			new logic_ProductoVS(new ProductoVS());
		} else if (e.getSource() == lb.btnGestionProveedores) {
			new logic_ProveedorGS(new ProveedorGS());
		} else if (e.getSource() == lb.btnGestionUsuario) {
			new logic_UsuarioGS(new UsuarioGS());
		} else if (e.getSource() == lb.btnVentana) {
			new logic_Venta(new Venta());
		}
	}

}
