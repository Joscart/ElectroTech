package modelo;

import libreria.Generica;

public class Factura {
	
	private Generica<Integer,Integer> lb = new Generica<>();
	private double total;

	public Factura() {
		// TODO Auto-generated constructor stub
	}
	
	public Factura(int id, int id_usuario, int id_cliente, double total) {
		super();
		setID(id);
		setIDCliente(id_cliente);
		setIDUsuario(id_usuario);
		setTotal(total);
	}
	
	public void setID(int id) {
		lb.setAtributo1(id);
	}
	
	public int getID() {
		return lb.getAtributo1();
	}
	
	public void setIDUsuario(int id_usuario) {
		lb.setAtributo2(id_usuario);
	}
	
	public int getIDUsuario() {
		return lb.getAtributo2();
	}
	
	public void setIDCliente(int id_cliente) {
		lb.setAtributo3(id_cliente);
	}
	
	public int getIDCliente() {
		return lb.getAtributo3();
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getTotal() {
		return total;
	}

}
