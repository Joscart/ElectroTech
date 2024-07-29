package controlador;

import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.*;

public class logic_ProveedorGS implements ActionListener, ListSelectionListener{

	private ProveedorGS lb;
	private ProveedorDAO pdao = new ProveedorDAO();
	private Proveedor proveedorSeleccionado;
	private List<Proveedor> proveedores;

	public logic_ProveedorGS(ProveedorGS lb) {
		// TODO Auto-generated constructor stub
		this.lb = lb;
		cargarProveedores();
		listeners();
	}

	private void listeners() {
		lb.lst_proveedores.addListSelectionListener(this);
		lb.btn_atras.addActionListener(this);
		lb.btn_eliminar.addActionListener(this);
		lb.btn_editar.addActionListener(this);
		lb.btn_nuevo.addActionListener(this);
		lb.btn_guardar.addActionListener(this);
	}

	private void cargarProveedores() {
		proveedores = pdao.getProveedores();
		lb.lst_proveedores.setListData(proveedores.toArray(new Proveedor[0]));
	}

	private void cargarProveedor() {
		if (proveedorSeleccionado == null) {
			lb.txt_nombre.setText("");
			lb.txt_cedula.setText("");
			lb.txt_razonSocial.setText("");
			lb.txt_correo.setText("");
			lb.txt_telefono.setText("");
			lb.txt_codigo.setText("");
			return;
		}
		lb.txt_nombre.setText(proveedorSeleccionado.getNombresCompletos());
		lb.txt_cedula.setText(proveedorSeleccionado.getCedula());
		lb.txt_razonSocial.setText(proveedorSeleccionado.getRazonSocial());
		lb.txt_correo.setText(proveedorSeleccionado.getCorreo());
		lb.txt_telefono.setText(proveedorSeleccionado.getTelefono());
		lb.txt_codigo.setText(proveedorSeleccionado.getCodigo());
	}

	private boolean agregarProveedor() {
		String nombresCompletos = lb.txt_nombre.getText();
		String cedula = lb.txt_cedula.getText();
		String razonSocial = lb.txt_razonSocial.getText();
		String correo = lb.txt_correo.getText();
		String telefono = lb.txt_telefono.getText();
		String codigo = lb.txt_codigo.getText();
		Proveedor proveedor = new Proveedor();
		if (!proveedor.setNombresCompletos(nombresCompletos))
			return false;
		if (!proveedor.setCedula(cedula))
			return false;
		if (!proveedor.setRazonSocial(razonSocial))
			return false;
		if (!proveedor.setCorreo(correo))
			return false;
		if (!proveedor.setTelefono(telefono))
			return false;
		if (codigo.isEmpty())
			proveedor.setCodigo();
		else if (!proveedor.setCodigo(codigo))
			return false;
		return pdao.agregarProveedor(proveedor);
	}
	
	private boolean editarProveedor() {
		String nombresCompletos = lb.txt_nombre.getText();
		String cedula = lb.txt_cedula.getText();
		String razonSocial = lb.txt_razonSocial.getText();
		String correo = lb.txt_correo.getText();
		String telefono = lb.txt_telefono.getText();
		String codigo = lb.txt_codigo.getText();
		Proveedor proveedor = proveedorSeleccionado;
		if (proveedor == null)
			return false;
		if (!proveedor.setNombresCompletos(nombresCompletos))
			return false;
		if (!proveedor.setCedula(cedula))
			return false;
		if (!proveedor.setRazonSocial(razonSocial))
			return false;
		if (!proveedor.setCorreo(correo))
			return false;
		if (!proveedor.setTelefono(telefono))
			return false;
		if (!proveedor.setCodigo(codigo))
			return false;
		return pdao.actualizarProveedor(proveedor);
	}
	
	private boolean eliminarProveedor() {
		if(proveedorSeleccionado == null) return false;
		return pdao.eliminarProveedor(proveedorSeleccionado.getID());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		proveedorSeleccionado = lb.lst_proveedores.getSelectedValue();
		cargarProveedor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_atras) {
			lb.dispose();
		} else if (e.getSource() == lb.btn_eliminar) {
			if (eliminarProveedor()) {
				cargarProveedores();
				cargarProveedor();
				JOptionPane.showMessageDialog(null, "Proveedor eliminado");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar el proveedor");
			}
		} else if (e.getSource() == lb.btn_editar) {
			if (editarProveedor()) {
				cargarProveedores();
				cargarProveedor();
				JOptionPane.showMessageDialog(null, "Proveedor actualizado");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo actualizar el proveedor");
			}
		} else if (e.getSource() == lb.btn_nuevo) {
			proveedorSeleccionado = null;
			cargarProveedor();
		} else if (e.getSource() == lb.btn_guardar) {
			if (agregarProveedor()) {
				cargarProveedores();
				cargarProveedor();
				JOptionPane.showMessageDialog(null, "Proveedor agregado");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo agregar el proveedor");
			}
		}
		cargarProveedores();

	}

}
