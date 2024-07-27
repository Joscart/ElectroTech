package modelo;

import libreria.Generica;

public class Proveedor implements Validable{
	
	private Generica<Integer,String> la = new Generica<>();
	private Generica<String,String> lb = new Generica<>();

	public Proveedor() {
		// TODO Auto-generated constructor stub
		super();
		setCodigo();
	}
	
	public Proveedor(int id, String nombresCompletos, String cedula, String razonSocial, String correo, String telefono, String codigo) {
        // TODO Auto-generated constructor stub
        super();
        setID(id);
        setNombresCompletos(nombresCompletos);
        setCedula(cedula);
        setRazonSocial(razonSocial);
        setCorreo(correo);
        setTelefono(telefono);
        setCodigo(codigo);
	}
	
	public void setID(int id) {
		la.setAtributo1(id);
	}
	
	public int getID() {
		return la.getAtributo1();
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
	
	public boolean setCedula(String cedula) {
        if (!validarCedula(cedula))
            return false;
        lb.setAtributo2(cedula);
        return true;
	}
	
	public String getCedula() {
		return lb.getAtributo2();
	}
	
	public boolean setCodigo(String codigo) {
		if (!validarCodigo(codigo))
			return false;
		la.setAtributo3(codigo);
		return true;
	}
	
	public void setCodigo() {
		la.setAtributo3(Validable.generarCodigo());
	}
	
	public String getCodigo() {
		return la.getAtributo3();
	}
	
	public boolean setRazonSocial(String razonSocial) {
		if (!validarRazonSocial(razonSocial))
			return false;
		la.setAtributo4(razonSocial);
		return true;
	}
	
	public String getRazonSocial() {
		return la.getAtributo4();
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
	
	public boolean validarNombresCompletos(String nombresCompletos) {
		return nombresCompletos.matches(ER_NOMBRES_COMPLETOS);
	}
	
	public boolean validarCedula(String cedula) {
		return cedula.matches(ER_CEDULA);
	}
	
	public boolean validarCodigo(String codigo) {
		return codigo.matches(ER_CODIGO);
	}
	
	public boolean validarRazonSocial(String razonSocial) {
		return razonSocial.matches(ER_RAZON_SOCIAL);
	}
	
	public boolean validarCorreo(String correo) {
		return correo.matches(ER_CORREO);
	}
	
	public boolean validarTelefono(String telefono) {
		return telefono.matches(ER_TELEFONO);
	}

}
