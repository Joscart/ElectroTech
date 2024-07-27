package controlador;

import vista.Login;
import vista.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

<<<<<<< HEAD
        if (verificarUsuario(username, password)) {
=======
        if (username.equals("admin") && password.equals("12345")) {
>>>>>>> 7aa060d71a6620cf8401934f43f81d7cc5219ce2
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

    private boolean verificarUsuario(String usuario, String contrasena) {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equals(usuario) && partes[1].equals(contrasena)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
