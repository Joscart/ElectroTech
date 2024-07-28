package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.Login;
import vista.UsuarioGS;
import vista.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        if (verificarUsuario(username, password)) {
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
    }
}


