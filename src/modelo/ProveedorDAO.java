package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libreria.Conexion;

public class ProveedorDAO {
	
	private Conexion con;
	
	public ProveedorDAO() {
		// TODO Auto-generated constructor stub
		this.con = new Conexion("electrotech");
		con.openConn();
	}

	public ProveedorDAO(Conexion con) {
		// TODO Auto-generated constructor stub
		this.con = con;
	}
	
	public synchronized List<Proveedor> getProveedores() {
		List<Proveedor> proveedores = new ArrayList<>();
		ResultSet rs = con.getQuery("SELECT * FROM proveedor");
		try {
			while (rs.next()) {
				proveedores.add(new Proveedor(rs.getInt("id_proveedor"), rs.getString("nombres_completos"),
						rs.getString("cedula"), rs.getString("razon_social"), rs.getString("correo"), rs.getString("telefono"), rs.getString("codigo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proveedores;
	}
	
	public synchronized Proveedor getProveedor(int id) {
		ResultSet rs = con.getQuery(String.format("SELECT * FROM proveedor WHERE id_proveedor = %d;", id));
		try {
			if (rs.next()) {
				return new Proveedor(rs.getInt("id_proveedor"), rs.getString("nombres_completos"),
						rs.getString("cedula"), rs.getString("razon_social"), rs.getString("correo"),
						rs.getString("telefono"), rs.getString("codigo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public synchronized boolean agregarProveedor(Proveedor proveedor) {
		return con.setQuery(String.format(
				"INSERT INTO proveedor (nombres_completos, cedula, razon_social, correo, telefono, codigo) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
				proveedor.getNombresCompletos(), proveedor.getCedula(), proveedor.getRazonSocial(),
				proveedor.getCorreo(), proveedor.getTelefono(), proveedor.getCodigo()));
	}
	
	public synchronized boolean actualizarProveedor(Proveedor proveedor) {
		return con.setQuery(String.format(
				"UPDATE proveedor SET nombres_completos = '%s', cedula = '%s', razon_social = '%s', correo = '%s', telefono = '%s', codigo = '%s' WHERE id_proveedor = %d;",
				proveedor.getNombresCompletos(), proveedor.getCedula(), proveedor.getRazonSocial(),
				proveedor.getCorreo(), proveedor.getTelefono(), proveedor.getCodigo(), proveedor.getID()));
	}
	
	public synchronized boolean eliminarProveedor(int id) {
		boolean eliminado = true;
		if(!con.setQuery(String.format("DELETE FROM proveedor WHERE id_proveedor = %d;", id))) eliminado = false;
		if(!con.setQuery(String.format("DELETE FROM producto WHERE id_proveedor = %d;", id))) eliminado = false;
		return eliminado;
	}

}
