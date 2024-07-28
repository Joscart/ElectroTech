package modelo;

import libreria.Conexion;

public class Estadistica {
	
	private Conexion con;
	private UsuarioDAO usuario_dao;
	private ProductoDAO producto_dao;
	private ProveedorDAO proveedor_dao;

	public Estadistica() {
		// TODO Auto-generated constructor stub
		this.con = new Conexion("electrotech");
		this.usuario_dao = new UsuarioDAO(this.con);
		this.producto_dao = new ProductoDAO(this.con);
		this.proveedor_dao = new ProveedorDAO(this.con);
		con.openConn();
	}

}
