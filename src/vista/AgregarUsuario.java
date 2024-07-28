package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;

    public AgregarUsuario() {
        setTitle("Agregar Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 250, 240)); // Color pastel beige
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuario.setBounds(10, 20, 80, 30);
        contentPane.add(lblUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(100, 20, 150, 30);
        contentPane.add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(10, 60, 80, 30);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 150, 30);
        contentPane.add(passwordField);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAgregar.setBounds(80, 100, 120, 30);
        btnAgregar.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnAgregar.setForeground(Color.BLACK); // Texto negro
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String contrasena = new String(passwordField.getPassword());
                guardarUsuario(usuario, contrasena);
                System.out.println("Usuario agregado: " + usuario);
                dispose(); // Cerrar la ventana después de agregar
            }
        });
        contentPane.add(btnAgregar);
    }

    private void guardarUsuario(String usuario, String contrasena) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            writer.write(usuario + "," + contrasena);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

