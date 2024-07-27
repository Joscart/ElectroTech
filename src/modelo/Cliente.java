package modelo;

import libreria.Generica;

public class Cliente implements Validable{
	
	private int id;
	private Generica<String,String> lb = new Generica<>();

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(int id, String nombresCompletos, String correo, String telefono, String direccion) {
		super();
		setID(id);
		setNombresCompletos(nombresCompletos);
		setCorreo(correo);
		setTelefono(telefono);
		setDireccion(direccion);
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public boolean setNombresCompletos(String nombresCompletos) {
		if (!validarNombresCompletos(nombresCompletos))
			return false;
		lb.setAtributo1(nombresCompletos);
		return true;
	}
	
	public String getNombresCompletos() {
		return lb.getAtributo1();
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
	
	public boolean setTelefono(String telefono) {
		if (!validarTelefono(telefono))
			return false;
		lb.setAtributo4(telefono);
		return true;
	}
	
	public String getTelefono() {
		return lb.getAtributo4();
	}
	
	public boolean setDireccion(String direccion) {
		if (!validarDireccion(direccion))
			return false;
		lb.setAtributo2(direccion);
		return true;
	}
	
	public String getDireccion() {
		return lb.getAtributo2();
	}
	
	public boolean validarNombresCompletos(String nombresCompletos) {
		return nombresCompletos.matches(ER_NOMBRES_COMPLETOS);
	}
	
	public boolean validarCorreo(String correo) {
		return correo.matches(ER_CORREO);
	}
	
	public boolean validarTelefono(String telefono) {
		return telefono.matches(ER_TELEFONO);
	}
	
	public boolean validarDireccion(String direccion) {
		return direccion.matches(ER_DIRECCION);
	}

}
