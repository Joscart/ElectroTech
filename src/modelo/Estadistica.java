package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import libreria.Conexion;

public class Estadistica extends Thread{
	
	private Conexion con;
	private UsuarioDAO usuario_dao;
	private ProductoDAO producto_dao;
	private ProveedorDAO proveedor_dao;
	private List<Usuario> usuarios;
	private List<Producto> productos;
	private List<Proveedor> proveedores;
	private List<Registro> registros;
	private List<Factura> facturas;
	private Instant inicio;

	public Estadistica() {
		// TODO Auto-generated constructor stub
		this.con = new Conexion("electrotech");
		this.usuario_dao = new UsuarioDAO(this.con);
		this.producto_dao = new ProductoDAO(this.con);
		this.proveedor_dao = new ProveedorDAO(this.con);
		con.openConn();
		inicio = Instant.now();
	}
	
	private synchronized void cargarListas() {
		this.usuarios = this.usuario_dao.getUsuarios();
		this.productos = this.producto_dao.getProductos();
		this.proveedores = this.proveedor_dao.getProveedores();
	}
	
	private Duration tiempoSesion() {
		return Duration.between(inicio, Instant.now());
	}
	
	private void actualizar() {
		this.cargarListas();
	}
	
	private synchronized List<Registro> getRegistros() {
		List<Registro> registros = new ArrayList<>();
		ResultSet rs = con.getQuery("SELECT * FROM registro");
		try {
			while (rs.next()) {
				registros.add(new Registro(rs.getInt("id_registro"), rs.getInt("id_producto"), rs.getInt("id_factura"),
						rs.getInt("cantidad"), rs.getDouble("monto"), rs.getDate("fecha")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registros;
	}
	
	private int usuariosRegistrados() {
		actualizar();
		return this.usuarios.size();
	}
	
	private int productosRegistrados() {
		actualizar();
		return this.productos.size();
	}
	
	private int proveedoresRegistrados() {
		actualizar();
		return this.proveedores.size();
	}
	
	

}
