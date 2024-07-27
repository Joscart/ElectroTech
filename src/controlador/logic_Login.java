package controlador;

import vista.Login;
import vista.Menu;
import java.awt.Color;
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
            loginView.textFieldUsername.setBackground(Color.GREEN);
            loginView.passwordField.setBackground(Color.GREEN);
            JOptionPane.showMessageDialog(loginView, "Login exitoso!");
            // Abrir ventana Menu y cerrar ventana Login
            Menu menu = new Menu();
            menu.setVisible(true);
            loginView.dispose();
        } else {
            loginView.textFieldUsername.setBackground(Color.RED);
            loginView.passwordField.setBackground(Color.RED);
            JOptionPane.showMessageDialog(loginView, "Usuario o contraseña incorrectos.");
        }
    }
}
