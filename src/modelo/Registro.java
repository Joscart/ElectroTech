package modelo;

import java.sql.Date;

import libreria.Generica;

public class Registro implements Validable{
	
	private Generica<Integer,Integer> la = new Generica<>();
	private Generica<Double,Date> lb = new Generica<>();

	public Registro() {
		// TODO Auto-generated constructor stub
		setFecha(new Date(System.currentTimeMillis()));
	}
	
	public Registro(int id, int id_producto, int id_factura, int cantidad, double precio, Date fecha) {
		// TODO Auto-generated constructor stub
		super();
		setID(id);
		setIDProducto(id_producto);
		setIDFactura(id_factura);
		setCantidad(cantidad);
		setPrecio(precio);
		setFecha(fecha);
	}
	
	public void setID(int id) {
		la.setAtributo1(id);
	}
	
	public int getID() {
		return la.getAtributo1();
	}
	
	public void setIDProducto(int id_producto) {
		la.setAtributo2(id_producto);
	}
	
	public int getIDProducto() {
		return la.getAtributo2();
	}
	
	public void setIDFactura(int id_factura) {
		la.setAtributo3(id_factura);
	}
	
	public int getIDFactura() {
		return la.getAtributo3();
	}
	
	public boolean setCantidad(int cantidad) {
		if (!validarCantidad(cantidad))
			return false;
		la.setAtributo4(cantidad);
		return true;
	}
	
	public int getCantidad() {
		return la.getAtributo4();
	}
	
	public boolean setPrecio(double precio) {
		if (!validarPrecio(precio))
			return false;
		lb.setAtributo1(precio);
		return true;
	}
	
	public double getPrecio() {
		return lb.getAtributo1();
	}
	
	public void setFecha(Date fecha) {
		lb.setAtributo3(fecha);
	}
	
	public Date getFecha() {
		return lb.getAtributo3();
	}
	
	public boolean validarCantidad(int cantidad) {
		return cantidad > 0;
	}
	
	public boolean validarPrecio(double precio) {
		return precio > 0;
	}

}
