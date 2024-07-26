package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libreria.Conexion;

public class UsuarioDAO {
	
	private Conexion con;

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
		this.con = new Conexion("electrotech");
		con.openConn();
	}
	
	public UsuarioDAO(Conexion con) {
		// TODO Auto-generated constructor stub
		this.con = con;
	}
	
	public synchronized List<Usuario> getUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		ResultSet rs = con.getQuery("SELECT * FROM registro");
		try {
			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("nombres_completos"),
						rs.getString("correo"), rs.getString("cedula"), rs.getString("clave"), rs.getInt("rol"), rs.getDate("fecha_ingreso")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public synchronized Usuario getUsuario(int id) {
		ResultSet rs = con.getQuery(String.format("SELECT * FROM usuario WHERE id_usuario = %d;", id));
		try {
			if (rs.next()) {
				return new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("nombres_completos"),
						rs.getString("correo"), rs.getString("cedula"), rs.getString("clave"), rs.getInt("rol"),
						rs.getDate("fecha_ingreso"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public synchronized Usuario iniciarSesion(Usuario usuario) {
		ResultSet rs = con.getQuery(String.format("SELECT * FROM usuario WHERE (correo = '%s' OR nombre = '%s') AND clave = '%s';",
				usuario.getCorreo(), usuario.getNombre(), usuario.getClaveCodificada()));
		try {
			if (rs.next()) {
				return new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("nombres_completos"),
						rs.getString("correo"), rs.getString("cedula"), rs.getString("clave"), rs.getInt("rol"),
						rs.getDate("fecha_ingreso"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public synchronized boolean agregarUsuario(Usuario usuario) {
		return con.setQuery(String.format(
				"INSERT INTO usuario (nombre, nombres_completos, correo, cedula, clave, rol, fecha_ingreso) VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s');",
				usuario.getNombre(), usuario.getNombresCompletos(), usuario.getCorreo(), usuario.getCedula(),
				usuario.getClave(), usuario.getRol(), usuario.getFechaCreacion().toString()));
	}
	
	public synchronized boolean actualizarUsuario(Usuario usuario) {
		return con.setQuery(String.format(
				"UPDATE usuario SET nombre = '%s', nombres_completos = '%s', correo = '%s', cedula = '%s', clave = '%s', rol = %d, fecha_ingreso = '%s' WHERE id_usuario = %d;",
				usuario.getNombre(), usuario.getNombresCompletos(), usuario.getCorreo(), usuario.getCedula(),
				usuario.getClave(), usuario.getRol(), usuario.getFechaCreacion().toString(), usuario.getID()));
	}
	
	public synchronized boolean eliminarUsuario(int id) {
		return con.setQuery(String.format("DELETE FROM usuario WHERE id_usuario = %d;", id));
	}

}
