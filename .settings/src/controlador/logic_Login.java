package controlador;

import vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class logic_Login {

    private Login loginView;

    public logic_Login(Login loginView) {
        this.loginView = loginView;
        this.loginView.btn_test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });
    }

    private void authenticate() {
        String username = loginView.textFieldUsername.getText();
        String password = new String(loginView.passwordField.getPassword());

        if (username.equals("admin") && password.equals("12345")) {
            JOptionPane.showMessageDialog(loginView, "Login exitoso!");
        } else {
            JOptionPane.showMessageDialog(loginView, "Usuario o contraseña incorrectos.");
        }
    }
}
