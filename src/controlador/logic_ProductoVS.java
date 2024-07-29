package controlador;

import vista.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.*;

public class logic_ProductoVS implements KeyListener, ListSelectionListener{
	
	private ProductoVS lb;
	private List<Producto> productos;
	private ProductoDAO pdao = new ProductoDAO();
	public Producto productoSeleccionado;

	public logic_ProductoVS(ProductoVS lb) {
		// TODO Auto-generated constructor stub
		this.lb = lb;
		cargarProductos();
		listeners();
	}
	
	private void listeners() {
		lb.txt_buscar.addKeyListener(this);
		lb.lst_productos.addListSelectionListener(this);
	}
	
	public void cargarProductos() {
		productos = pdao.getProductos();
		lb.lst_productos.setListData(productos.toArray(new Producto[0]));
	}
	
	private void buscarProducto() {
		String nombre = lb.txt_buscar.getText();
		lb.lst_productos.setListData(productos.stream().filter(p -> p.getNombre().contains(nombre)).toArray(Producto[]::new));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		buscarProducto();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		productoSeleccionado = lb.lst_productos.getSelectedValue();
	}

}
