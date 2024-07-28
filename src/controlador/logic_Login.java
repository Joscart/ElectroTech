package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.Login;
<<<<<<< HEAD
import vista.UsuarioGS;
=======
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f
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
    private UsuarioGS usuarioGSView;
    private UsuarioDAO usuarioDAO;

    public logic_Login(Login loginView) {
        this.loginView = loginView;
        this.usuarioDAO = new UsuarioDAO();
        this.loginView.btn_test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });
    }

    public logic_Login(UsuarioGS usuarioGSView) {
        this.usuarioGSView = usuarioGSView;
        this.usuarioDAO = new UsuarioDAO();
        this.usuarioGSView.btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });
    }

    private void authenticate() {
        String username = loginView.textFieldUsername.getText();
        String password = new String(loginView.passwordField.getPassword());

<<<<<<< HEAD
        if (verificarUsuario(username, password)) {
=======
<<<<<<< HEAD
        if (verificarUsuario(username, password)) {
=======
        if (username.equals("admin") && password.equals("12345")) {
>>>>>>> 7aa060d71a6620cf8401934f43f81d7cc5219ce2
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f
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
<<<<<<< HEAD
        Usuario user = new Usuario();
        user.setNombre(usuario);
        user.setClave(contrasena);  // Se asegurará de codificar la clave dentro de la clase Usuario
        Usuario autenticado = usuarioDAO.iniciarSesion(user);
        return autenticado != null;
    }

    private void agregarUsuario() {
        // Recoger datos del nuevo usuario (esto podría ser mejorado con un formulario dedicado)
        String nombre = JOptionPane.showInputDialog(usuarioGSView, "Ingrese el nombre:");
        String nombresCompletos = JOptionPane.showInputDialog(usuarioGSView, "Ingrese los nombres completos:");
        String correo = JOptionPane.showInputDialog(usuarioGSView, "Ingrese el correo:");
        String cedula = JOptionPane.showInputDialog(usuarioGSView, "Ingrese la cédula:");
        String clave = JOptionPane.showInputDialog(usuarioGSView, "Ingrese la clave:");
        int rol = Integer.parseInt(JOptionPane.showInputDialog(usuarioGSView, "Ingrese el rol (número):"));

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setNombresCompletos(nombresCompletos);
        usuario.setCorreo(correo);
        usuario.setCedula(cedula);
        usuario.setClave(clave);
        usuario.setRol(rol);

        if (usuarioDAO.agregarUsuario(usuario)) {
            JOptionPane.showMessageDialog(usuarioGSView, "Usuario agregado exitosamente!");
        } else {
            JOptionPane.showMessageDialog(usuarioGSView, "Error al agregar el usuario.");
        }
=======
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
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f
    }
}


