package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.*;
import modelo.*;

public class logic_Venta implements ActionListener, ListSelectionListener, ChangeListener{
	
	private Venta lb;
	private Estadistica estadisticas = new Estadistica();
	private Producto productoSeleccionado;
	private Producto productoSeleccionado2;
	private List<Producto> productos = new ArrayList<>();

	public logic_Venta(Venta lb) {
		// TODO Auto-generated constructor stub
		this.lb = lb;
		listeners();
	}
	
	private void listeners() {
		lb.btn_atras.addActionListener(this);
		lb.btn_eliminar.addActionListener(this);
		lb.btn_agregar.addActionListener(this);
		lb.spn_cantidad.addChangeListener(this);
		lb.pn_productovs.lst_productos.addListSelectionListener(this);
		lb.lst_productos.addListSelectionListener(this);
		lb.btn_venta.addActionListener(this);
	}
	
	private void agregarProducto() {
		if (productoSeleccionado == null) {
			return;
		}
		productoSeleccionado.setCantidad(1);
		productos.add(productoSeleccionado);
		lb.lst_productos.setListData(productos.toArray(new Producto[0]));
		lb.lst_productos.setSelectedValue(productoSeleccionado, false);
		lb.spn_cantidad.setValue(1);
	}
	
	private void eliminarProducto() {
		if (productoSeleccionado2 == null) {
			return;
		}
		productos.remove(productoSeleccionado2);
		lb.lst_productos.setListData(productos.toArray(new Producto[0]));
	}
	
	private double calcularTotal() {
		double total = productos.stream().mapToDouble(p -> (p.getPrecio() * p.getCantidad())).sum();
		lb.lbl_total.setText("Total: " + total);
		return total;
	}
	
	private void cargarNumProductos() {
		int numProductos = productos.stream().mapToInt(p -> p.getCantidad()).sum();
		lb.lbl_numProductos.setText("Productos: " + numProductos);
	}
	
	private void actualizarCantidad() {
		if (productoSeleccionado2 == null) {
			return;
		}
		lb.spn_cantidad.setValue(productoSeleccionado2.getCantidad());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.pn_productovs.lst_productos) {
			productoSeleccionado = lb.pn_productovs.lst_productos.getSelectedValue();
			//lb.pn_productovs.lst_productos.setSelectedValue(productoSeleccionado, false);
		} else if (e.getSource() == lb.lst_productos) {
			productoSeleccionado2 = lb.lst_productos.getSelectedValue();
			//lb.lst_productos.setSelectedValue(productoSeleccionado2, false);
			actualizarCantidad();
			System.out.println(productoSeleccionado2);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_atras) {
            lb.dispose();
        } else if (e.getSource() == lb.btn_eliminar) {
            eliminarProducto();
            calcularTotal();
            cargarNumProductos();
		} else if (e.getSource() == lb.btn_agregar) {
			agregarProducto();
			calcularTotal();
			cargarNumProductos();
		} else if (e.getSource() == lb.btn_venta) {
			if (productos.isEmpty()) {
				return;
			}
			try {
				if (!estadisticas.venderProductos(productos, calcularTotal())) {
					return;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			productos.clear();
			lb.lst_productos.setListData(productos.toArray(new Producto[0]));
			calcularTotal();
			cargarNumProductos();
			JOptionPane.showMessageDialog(null, "Venta realizada con exito");
		}
		actualizarCantidad();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.spn_cantidad) {
            if (productoSeleccionado2 == null) {
                return;
            }
            productoSeleccionado2.setCantidad((int) lb.spn_cantidad.getValue());
            calcularTotal();
            cargarNumProductos();
		}
	}

}
