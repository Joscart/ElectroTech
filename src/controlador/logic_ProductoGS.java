package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.*;
import modelo.*;

public class logic_ProductoGS implements ActionListener, ListSelectionListener{
	
	private ProductoGS lb;
	private ProductoDAO pdao = new ProductoDAO();
	private Producto productoSeleccionado;
	private ProveedorDAO proveedorDAO = new ProveedorDAO();

	public logic_ProductoGS(ProductoGS lb) {
		// TODO Auto-generated constructor stub
		this.lb = lb;
		listeners();
		cargarProveedores();
	}
	
	private void listeners() {
		lb.pn_productovs.lst_productos.addListSelectionListener(this);
		lb.btn_atras.addActionListener(this);
		lb.btn_eliminar.addActionListener(this);
		lb.btn_editar.addActionListener(this);
		lb.btn_nuevo.addActionListener(this);
		lb.btn_guardar.addActionListener(this);
	}
	
	private void cargarProveedores() {
		lb.cbx_proveedor.removeAllItems();
		proveedorDAO.getProveedores().forEach(p -> lb.cbx_proveedor.addItem(p));
	}
	
	private void cargarProducto() {
		if (productoSeleccionado == null) {
			lb.txt_nombre.setText("");
			lb.txt_precio.setText("");
			lb.spn_cantidad.setValue(0);
			lb.txt_descripcion.setText("");
			return;
		}
		lb.txt_nombre.setText(productoSeleccionado.getNombre());
		lb.txt_precio.setText(String.valueOf(productoSeleccionado.getPrecio()));
		lb.spn_cantidad.setValue(productoSeleccionado.getCantidad());
		lb.txt_descripcion.setText(productoSeleccionado.getDescripcion());
		lb.cbx_proveedor.setSelectedItem(proveedorDAO.getProveedor(productoSeleccionado.getIDProveedor()));
	}
	
	private boolean agregarProducto() {
		String nombre = lb.txt_nombre.getText();
		String descripcion = lb.txt_descripcion.getText();
		double precio = Double.parseDouble(lb.txt_precio.getText());
		int cantidad = (int) lb.spn_cantidad.getValue();
		Proveedor proveedor = (Proveedor) lb.cbx_proveedor.getSelectedItem();
		Producto producto = new Producto();
		if (!producto.setNombre(nombre))
			return false;
		if (!producto.setDescripcion(descripcion))
			return false;
		if (!producto.setPrecio(precio))
			return false;
		if (!producto.setCantidad(cantidad))
			return false;
		producto.setIDProveedor(proveedor.getID());
		return pdao.agregarProducto(producto);
	}
	
	private boolean editarProducto() {
		String nombre = lb.txt_nombre.getText();
		String descripcion = lb.txt_descripcion.getText();
		double precio = Double.parseDouble(lb.txt_precio.getText());
		int cantidad = (int) lb.spn_cantidad.getValue();
		Proveedor proveedor = (Proveedor) lb.cbx_proveedor.getSelectedItem();
		Producto producto = productoSeleccionado;
		if (producto == null)
			return false;
		if (!producto.setNombre(nombre))
			return false;
		if (!producto.setDescripcion(descripcion))
			return false;
		if (!producto.setPrecio(precio))
			return false;
		if (!producto.setCantidad(cantidad))
			return false;
		producto.setIDProveedor(proveedor.getID());
		return pdao.actualizarProducto(producto);
	}
	
	private boolean eliminarProducto() {
		if (productoSeleccionado == null)
			return false;
		return pdao.eliminarProducto(productoSeleccionado.getID());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		cargarProveedores();
		productoSeleccionado = lb.pn_productovs.lst_productos.getSelectedValue();
		cargarProducto();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_atras) {
			lb.dispose();
		} else if(e.getSource() == lb.btn_eliminar) {
            if (productoSeleccionado == null)
                return;
            if (eliminarProducto()) {
                cargarProveedores();
                cargarProducto();
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
			}
        } else if (e.getSource() == lb.btn_editar) {
            if (productoSeleccionado == null)
                return;
            if (editarProducto()) {
                cargarProveedores();
                cargarProducto();
                JOptionPane.showMessageDialog(null, "Producto editado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Error al editar el producto");
			}
        } else if (e.getSource() == lb.btn_nuevo) {
            productoSeleccionado = null;
            cargarProducto();
        } else if (e.getSource() == lb.btn_guardar) {
            if (agregarProducto()) {
                cargarProveedores();
                cargarProducto();
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Error al agregar el producto");
			}
		}
		lb.pn_productovs.logic.cargarProductos();
		
	}

}
