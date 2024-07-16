package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import vista.*;

public class logic_Login implements ActionListener{
	
	private Login lb;

	public logic_Login(Login lb) {
		// TODO Auto-generated constructor stub
		this.lb = lb;
		listeners();
	}
	
	private void listeners() {
		lb.btn_test.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_test) {
			System.out.println("Boton Test");
			lb.dispatchEvent(new WindowEvent(lb, WindowEvent.WINDOW_CLOSING));
		}
	}

}
