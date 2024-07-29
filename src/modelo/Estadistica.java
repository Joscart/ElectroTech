package modelo;

import java.sql.Date;
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
	private Object lock = new Object();
	private Usuario usuario;

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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private synchronized List<Factura> getFacturas() {
		List<Factura> facturas = new ArrayList<>();
		ResultSet rs = con.getQuery("SELECT * FROM factura");
		try {
			while (rs.next()) {
				facturas.add(new Factura(rs.getInt("id_factura"), rs.getInt("id_usuario"), rs.getInt("id_cliente"),
						rs.getDouble("monto")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facturas;
	}

	private synchronized boolean agregarFactura(Factura factura) {
		return con.setQuery(String.format("INSERT INTO factura (id_usuario, id_cliente, monto) VALUES (%d, %d, %.2f);",
				factura.getIDUsuario(), factura.getIDCliente(), factura.getTotal()));
	}

	private synchronized boolean agregarRegistro(Registro registro) {
		return con.setQuery(String.format(
				"INSERT INTO registro (id_producto, id_factura, cantidad, monto, fecha) VALUES (%d, %d, %d, %.2f, '%s');",
				registro.getIDProducto(), registro.getIDFactura(), registro.getCantidad(), registro.getPrecio(),
				registro.getFecha()));
	}

	public int usuariosRegistrados() {
		actualizar();
		return this.usuarios.size();
	}

	public int productosRegistrados() {
		actualizar();
		return this.productos.size();
	}

	public int proveedoresRegistrados() {
		actualizar();
		return this.proveedores.size();
	}

	public boolean venderProducto(Producto producto, double total) throws SQLException {
		actualizar();
		if (producto.getCantidad() < 0) return false;

		if (producto_dao.getProducto(producto.getID()).getCantidad() < producto.getCantidad()) return false;

		if (!producto_dao.actualizarProducto(producto)) return false;

		if (!agregarFactura(new Factura(1, usuario.getID(), usuario.getID(), producto.getPrecio() * producto.getCantidad()))) return false;

		ResultSet rs = con.getQuery("SELECT MAX(id_factura) FROM factura");

		if (rs.next()) {
			int id_factura = rs.getInt("id_factura");
			if (!agregarRegistro(new Registro(1, producto.getID(), id_factura, producto.getCantidad(),
					producto.getPrecio(), new Date(System.currentTimeMillis()))))
				return false;
		}

		return true;
	}

	public boolean venderProducto(Producto producto, double total, int id_factura) throws SQLException {
		actualizar();
		if (producto.getCantidad() < 0) return false;

		if (producto_dao.getProducto(producto.getID()).getCantidad() < producto.getCantidad()) return false;

		if (!producto_dao.actualizarProducto(producto)) return false;

		if (!agregarFactura(new Factura(1, usuario.getID(), usuario.getID(), producto.getPrecio() * producto.getCantidad()))) return false;

		if (!agregarRegistro(new Registro(1, producto.getID(), id_factura, producto.getCantidad(),
				producto.getPrecio(), new Date(System.currentTimeMillis()))))
			return false;


		return true;
	}

	public boolean venderProductos(List<Producto> productos, double total) throws SQLException {
		if (!agregarFactura(new Factura(1, usuario.getID(), usuario.getID(), total))) return false;

		ResultSet rs = con.getQuery("SELECT MAX(id_factura) FROM factura");
		int id_factura = rs.getInt("id_factura");
		if (rs.next()) {
			id_factura = rs.getInt("id_factura");
		}
		for (Producto producto : productos) {
			if (!venderProducto(producto,total,id_factura))
				return false;
		}
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (lock) {
				try {
					lock.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			actualizar();
		}
	}

}
