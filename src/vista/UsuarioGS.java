package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Usuario;
import modelo.UsuarioDAO;
import controlador.logic_Login;

public class UsuarioGS extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldBuscar;
    private JList<String> listUsuarios;
    private DefaultListModel<String> listModel;
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldContrasena;
    private UsuarioDAO usuarioDAO;
    public JButton btnAgregarUsuario; // Renombrado para mantener consistencia

    // Nuevo campo para la instancia de logic_Login
    private logic_Login loginLogic;

    /**
     * Create the frame.
     */
    public UsuarioGS() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Gestión de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 250, 240)); // Color pastel beige
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelBuscar = new JPanel();
        panelBuscar.setBounds(10, 10, 420, 50);
        panelBuscar.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelBuscar);
        panelBuscar.setLayout(null);

        JButton btnAtras = new JButton("Atrás");
        btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAtras.setBounds(0, 10, 100, 30);
        btnAtras.setBackground(new Color(240, 128, 128)); // Color coral
        btnAtras.setForeground(Color.BLACK); // Texto negro
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        panelBuscar.add(btnAtras);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBuscar.setBounds(110, 10, 60, 30);
        lblBuscar.setForeground(new Color(70, 130, 180)); // Color acero azul
        panelBuscar.add(lblBuscar);

        textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(173, 15, 200, 25);
        textFieldBuscar.setBackground(Color.WHITE); // Fondo blanco para el campo de búsqueda
        textFieldBuscar.setForeground(Color.BLACK); // Texto negro
        panelBuscar.add(textFieldBuscar);
        textFieldBuscar.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBuscar.setBounds(390, 15, 100, 25);
        btnBuscar.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnBuscar.setForeground(Color.BLACK); // Texto negro
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });
        panelBuscar.add(btnBuscar);

        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(10, 70, 420, 120);
        panelBotones.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelBotones);
        panelBotones.setLayout(null);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEditar.setBounds(10, 10, 180, 40);
        btnEditar.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnEditar.setForeground(Color.BLACK); // Texto negro
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarUsuario();
            }
        });
        panelBotones.add(btnEditar);

        btnAgregarUsuario = new JButton("Agregar Usuario"); // Renombrado
        btnAgregarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAgregarUsuario.setBounds(210, 10, 180, 40);
        btnAgregarUsuario.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnAgregarUsuario.setForeground(Color.BLACK); // Texto negro
        panelBotones.add(btnAgregarUsuario);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEliminar.setBounds(210, 70, 180, 40);
        btnEliminar.setBackground(new Color(255, 99, 71)); // Color tomate
        btnEliminar.setForeground(Color.BLACK); // Texto negro
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
        panelBotones.add(btnEliminar);

        // JPanel para mostrar la lista de usuarios
        JPanel panelLista = new JPanel();
        panelLista.setBounds(10, 200, 420, 150);
        panelLista.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelLista);
        panelLista.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        listUsuarios = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listUsuarios);
        panelLista.add(scrollPane, BorderLayout.CENTER);

        // JTextField y JPasswordField para editar usuario seleccionado
        JPanel panelEdit = new JPanel();
        panelEdit.setBounds(10, 360, 420, 50);
        panelEdit.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelEdit);
        panelEdit.setLayout(new GridLayout(1, 4, 5, 5));

        JLabel lblUsuario = new JLabel("Usuario:");
        panelEdit.add(lblUsuario);

        textFieldUsuario = new JTextField();
        panelEdit.add(textFieldUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        panelEdit.add(lblContrasena);

        passwordFieldContrasena = new JPasswordField();
        panelEdit.add(passwordFieldContrasena);

        // Agregar listener para actualizar campos de edición cuando se seleccione un usuario
        listUsuarios.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String usuarioSeleccionado = listUsuarios.getSelectedValue();
                    if (usuarioSeleccionado != null) {
                        cargarUsuario(usuarioSeleccionado);
                    }
                }
            }
        });

        cargarUsuarios(); // Cargar usuarios al iniciar

        // Crear una instancia de logic_Login con la referencia a UsuarioGS
        loginLogic = new logic_Login(this);

        // Asociar el ActionListener para el botón de agregar usuario
        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginLogic.agregarUsuario();
            }
        });
    }

    private void cargarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        listModel.clear();
        for (Usuario usuario : usuarios) {
            listModel.addElement(usuario.getNombre());
        }
    }

    private void buscarUsuario() {
        String buscar = textFieldBuscar.getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un usuario para buscar.");
            return;
        }

        listModel.clear();
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().contains(buscar)) {
                listModel.addElement(usuario.getNombre());
            }
        }
    }

    private void cargarUsuario(String usuarioNombre) {
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(usuarioNombre)) {
                textFieldUsuario.setText(usuario.getNombre());
                passwordFieldContrasena.setText(usuario.getClave());
                return;
            }
        }
        // Si el usuario no se encuentra, limpia los campos
        textFieldUsuario.setText("");
        passwordFieldContrasena.setText("");
    }

    private void editarUsuario() {
        String usuarioSeleccionado = listUsuarios.getSelectedValue();
        if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para editar.");
            return;
        }

        String nuevoUsuario = textFieldUsuario.getText().trim();
        String nuevaContrasena = new String(passwordFieldContrasena.getPassword()).trim();

        if (nuevoUsuario.isEmpty() || nuevaContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un nuevo usuario y contraseña.");
            return;
        }

        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(usuarioSeleccionado)) {
                usuario.setNombre(nuevoUsuario);
                usuario.setClave(nuevaContrasena);
                usuarioDAO.actualizarUsuario(usuario);
                cargarUsuarios();
                JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.");
                return;
            }
        }
    }

    private void eliminarUsuario() {
        String usuarioSeleccionado = listUsuarios.getSelectedValue();
        if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            List<Usuario> usuarios = usuarioDAO.getUsuarios();
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(usuarioSeleccionado)) {
                    usuarioDAO.eliminarUsuario(usuario.getID());
                    cargarUsuarios();
                    JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UsuarioGS frame = new UsuarioGS();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
