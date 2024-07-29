package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libreria.Conexion;

public class ProductoDAO {
	
	private Conexion con;
	
	public ProductoDAO() {
        // TODO Auto-generated constructor stub
        this.con = new Conexion("electrotech");
        con.openConn();
	}

	public ProductoDAO(Conexion con) {
		// TODO Auto-generated constructor stub
		this.con = con;
	}
	
	public synchronized List<Producto> getProductos() {
		List<Producto> productos = new ArrayList<>();
		ResultSet rs = con.getQuery("SELECT * FROM producto");
		try {
			while (rs.next()) {
				productos.add(new Producto(rs.getInt("id_producto"), rs.getInt("id_proveedor"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getInt("cantidad"), rs.getDouble("precio")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}
	
	public synchronized Producto getProducto(int id) {
		ResultSet rs = con.getQuery(String.format("SELECT * FROM producto WHERE id_producto = %d;", id));
		try {
			if (rs.next()) {
				return new Producto(rs.getInt("id_producto"), rs.getInt("id_proveedor"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getInt("cantidad"), rs.getDouble("precio"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public synchronized boolean agregarProducto(Producto producto) {
		return con.setQuery(String.format(
				"INSERT INTO producto (id_proveedor, nombre, descripcion, cantidad, precio) VALUES (%d, '%s', '%s', %d, %s);",
				producto.getIDProveedor(), producto.getNombre(), producto.getDescripcion(), producto.getCantidad(),
				producto.getPrecio()));
	}
	
	public synchronized boolean actualizarProducto(Producto producto) {
		return con.setQuery(String.format(
				"UPDATE producto SET id_proveedor = %d, nombre = '%s', descripcion = '%s', cantidad = %d, precio = %s WHERE id_producto = %d;",
				producto.getIDProveedor(), producto.getNombre(), producto.getDescripcion(), producto.getCantidad(),
				producto.getPrecio(), producto.getID()));
	}
	
	public synchronized boolean eliminarProducto(int id) {
		return con.setQuery(String.format("DELETE FROM producto WHERE id_producto = %d;", id));
	}

}
