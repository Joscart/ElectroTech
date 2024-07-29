package controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import modelo.Usuario;
import vista.*;

public class logic_Ventana implements WindowListener{
	
	private Ventana lb;
	private Usuario usuario;

	public logic_Ventana(Ventana lb) {
		// TODO Auto-generated constructor stub
		this.lb = lb;
		lb.frame = new Login();
		listeners();
	}
	
	private void listeners() {
		lb.frame.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (lb.frame instanceof Login) {
			if (((Login) lb.frame).isLogin) {
            lb.frame = new Menu();
            listeners();
            lb.frame.setVisible(true);
			}
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
