package modelo;

import java.sql.Date;

import libreria.Generica;

public class Usuario implements Validable, Codificador{
	
	private Generica<Integer,Date> la = new Generica<>();
	private Generica<String,String> lb = new Generica<>();
	private String clave;

	public Usuario() {
		// TODO Auto-generated constructor stub
		super();
		setFechaCreacion(new Date(System.currentTimeMillis()));
	}
	
	public Usuario(int id, String nombre, String nombresCompletos, String correo, String cedula, String clave, int rol, Date fechaCreacion) {
        // TODO Auto-generated constructor stub
		super();
        setID(id);
        setNombre(nombre);
        setNombresCompletos(nombresCompletos);
        setCorreo(correo);
        setCedula(cedula);
        setClaveCodificada(clave);
        setRol(rol);
        setFechaCreacion(fechaCreacion);
	}
	
	public void setID(int id) {
		la.setAtributo1(id);
	}
	
	public int getID() {
		return la.getAtributo1();
	}
	
	public boolean setNombre(String nombre) {
        if (!validarNombre(nombre))
        	return false;
        lb.setAtributo1(nombre);
        return true;
    }
	
	public String getNombre() {
		return lb.getAtributo1();
	}
	
	public boolean setNombresCompletos(String nombresCompletos) {
		if (!validarNombresCompletos(nombresCompletos))
			return false;
		lb.setAtributo2(nombresCompletos);
		return true;
	}
	
	public String getNombresCompletos() {
		return lb.getAtributo2();
	}
	
	public boolean setCorreo(String correo) {
        if (!validarCorreo(correo))
            return false;
        lb.setAtributo3(correo);
        return true;
	}
	
	public String getCorreo() {
		return lb.getAtributo3();
	}
	
	public boolean setCedula(String cedula) {
        if (!validarCedula(cedula))
            return false;
        lb.setAtributo4(cedula);
        return true;
	}
	
	public String getCedula() {
		return lb.getAtributo4();
	}
	
	public boolean setClave(String clave) {
		if (!validarClave(clave))
			return false;
		this.clave = Codificador.codificar(clave);
		return true;
	}
	
	public boolean setClave(char[] clave) {
		return setClave(new String(clave));
	}
	
	public String getClave() {
		return Codificador.decodificar(clave);
	}
	
	public void setClaveCodificada(String clave) {
		this.clave = clave;
	}
	
	public String getClaveCodificada() {
		return clave;
	}
	
	public void setRol(int rol) {
		la.setAtributo2(rol);
	}
	
	public int getRol() {
		return la.getAtributo2();
	}
	
	public Date getFechaCreacion() {
		return la.getAtributo3();
	}
	
	private void setFechaCreacion(Date fechaCreacion) {
		la.setAtributo3(fechaCreacion);
	}
	
	public boolean validarNombre(String nombre) {
		return nombre.matches(ER_NOMBRE);
	}
	
	public boolean validarNombresCompletos(String nombresCompletos) {
		return nombresCompletos.matches(ER_NOMBRES_COMPLETOS);
	}
	
	public boolean validarCorreo(String correo) {
		return correo.matches(ER_CORREO);
	}
	
	public boolean validarCedula(String cedula) {
		return cedula.matches(ER_CEDULA);
	}
	
	public boolean validarClave(String clave) {
		return clave.matches(ER_CLAVE);
	}

}
