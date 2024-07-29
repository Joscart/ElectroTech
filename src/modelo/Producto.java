package modelo;

import libreria.Generica;

public class Producto implements Validable{
	
	private Generica<Integer,String> la = new Generica<>();
	private Generica<Integer,Double> lb = new Generica<>();

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int id, int id_proveedor, String nombre, String descripcion, int cantidad, double precio) {
		// TODO Auto-generated constructor stub
		super();
		setID(id);
		setIDProveedor(id_proveedor);
		setNombre(nombre);
		setDescripcion(descripcion);
		setCantidad(cantidad);
		setPrecio(precio);
	}
	
	public void setID(int id) {
		la.setAtributo1(id);
	}
	
	public int getID() {
		return la.getAtributo1();
	}
	
	public void setIDProveedor(int id_proveedor) {
		la.setAtributo2(id_proveedor);
	}
	
	public int getIDProveedor() {
		return la.getAtributo2();
	}
	
	public boolean setNombre(String nombre) {
		if (!validarNombre(nombre))
			return false;
		la.setAtributo3(nombre);
		return true;
	}
	
	public String getNombre() {
		return la.getAtributo3();
	}
	
	public boolean setDescripcion(String descripcion) {
		if (!validarDescripcion(descripcion))
			return false;
		la.setAtributo4(descripcion);
		return true;
	}
	
	public String getDescripcion() {
		return la.getAtributo4();
	}
	
	public boolean setCantidad(int cantidad) {
		if (!validarCantidad(cantidad))
			return false;
		lb.setAtributo1(cantidad);
		return true;
	}
	
	public int getCantidad() {
		return lb.getAtributo1();
	}
	
	public boolean setPrecio(double precio) {
		if (!validarPrecio(precio))
			return false;
		lb.setAtributo3(precio);
		return true;
	}
	
	public double getPrecio() {
		return lb.getAtributo3();
	}
	
	public boolean validarNombre(String nombre) {
		return nombre.matches(ER_NOMBRE);
	}
	
	public boolean validarDescripcion(String descripcion) {
		return descripcion.matches(ER_DESCRIPCION);
	}
	
	public boolean validarCantidad(int cantidad) {
		return cantidad > 0;
	}
	
	public boolean validarPrecio(double precio) {
		return precio > 0;
	}

	@Override
	public String toString() {
		return String.format("%s", getNombre());
	}
	
	

}
