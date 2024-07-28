package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUsuarioDialog extends JDialog {

    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldContrasena;
    private boolean isConfirmed = false;
    private String nuevoUsuario;
    private String nuevaContrasena;

    public EditUsuarioDialog(Frame parent, String usuarioActual) {
        super(parent, "Editar Usuario", true);
        setBounds(100, 100, 400, 200);
        getContentPane().setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblUsuario = new JLabel("Nuevo Usuario:");
        getContentPane().add(lblUsuario);

        textFieldUsuario = new JTextField(usuarioActual);
        getContentPane().add(textFieldUsuario);

        JLabel lblContrasena = new JLabel("Nueva Contraseña:");
        getContentPane().add(lblContrasena);

        passwordFieldContrasena = new JPasswordField();
        getContentPane().add(passwordFieldContrasena);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevoUsuario = textFieldUsuario.getText().trim();
                nuevaContrasena = new String(passwordFieldContrasena.getPassword()).trim();
                if (nuevoUsuario.isEmpty() || nuevaContrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(EditUsuarioDialog.this, "Por favor, llena todos los campos.");
                } else {
                    isConfirmed = true;
                    dispose();
                }
            }
        });
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().add(btnCancelar);

        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public String getNuevoUsuario() {
        return nuevoUsuario;
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }
}
