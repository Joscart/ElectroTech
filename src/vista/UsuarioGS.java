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
    private JTextField txt_buscar;
    private JList<String> lst_Usuarios;
    private DefaultListModel<String> listModel;
    private JTextField txt_Usuario;
    private JPasswordField passwordF_Contrasena;
    private UsuarioDAO usuarioDAO;
    public JButton btnAgregarUsuario; // Renombrado para mantener consistencia

    // Nuevo campo para la instancia de logic_Login
    private logic_Login loginLogic;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnAtras;
    private JButton btnBuscar;

    /**
     * Create the frame.
     */
    public UsuarioGS() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Gestión de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 519, 500);
        contentPane =  new BackgroundPanel("src/recursos/imagenes/a.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 250, 240)); // Color pastel beige
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelBuscar = new BackgroundPanel("src/recursos/imagenes/usuariosa.jpg");
        panelBuscar.setBounds(10, 10, 490, 50);
        panelBuscar.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelBuscar);
        panelBuscar.setLayout(null);

        btnAtras = new RoundedButton("Atrás");
        btnAtras.setFont(new Font("Unispace", Font.BOLD, 15));
        btnAtras.setBounds(0, 10, 100, 30);
        btnAtras.setBackground(new Color(0, 116, 109)); // Color coral
        btnAtras.setForeground(new Color(255, 255, 255)); // Texto negro
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        panelBuscar.add(btnAtras);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Unispace", Font.BOLD, 15));
        lblBuscar.setBounds(110, 10, 71, 30);
        lblBuscar.setForeground(new Color(70, 130, 180)); // Color acero azul
        panelBuscar.add(lblBuscar);

        txt_buscar = new JTextField();
		txt_buscar.setBounds(191, 15, 182, 25);
        txt_buscar.setBackground(Color.WHITE); // Fondo blanco para el campo de búsqueda
        txt_buscar.setForeground(Color.BLACK); // Texto negro
        panelBuscar.add(txt_buscar);
        txt_buscar.setColumns(10);

        btnBuscar = new RoundedButton("Buscar");
        btnBuscar.setFont(new Font("Unispace", Font.BOLD, 15));
        btnBuscar.setBounds(383, 13, 100, 25);
        btnBuscar.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnBuscar.setForeground(new Color(255, 255, 255)); // Texto negro
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });
        panelBuscar.add(btnBuscar);

        JPanel panelBotones =  new BackgroundPanel("src/recursos/imagenes/usuariosm.jpg");
        panelBotones.setBounds(10, 70, 490, 120);
        panelBotones.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelBotones);
        panelBotones.setLayout(null);

        btnEditar = new RoundedButton("Editar");
        btnEditar.setFont(new Font("Unispace", Font.BOLD, 15));
        btnEditar.setBounds(23, 11, 180, 40);
        btnEditar.setBackground(new Color(47, 36, 129)); // Color azul pálido
        btnEditar.setForeground(new Color(255, 255, 255)); // Texto negro
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarUsuario();
            }
        });
        panelBotones.add(btnEditar);

        btnAgregarUsuario = new RoundedButton("Agregar Usuario"); // Renombrado
        btnAgregarUsuario.setFont(new Font("Unispace", Font.BOLD, 15));
        btnAgregarUsuario.setBounds(275, 11, 180, 40);
        btnAgregarUsuario.setBackground(new Color(6, 101, 165)); // Color azul pálido
        btnAgregarUsuario.setForeground(new Color(255, 255, 255)); // Texto negro
        panelBotones.add(btnAgregarUsuario);

        btnEliminar = new RoundedButton("Eliminar");
        btnEliminar.setFont(new Font("Unispace", Font.BOLD, 15));
        btnEliminar.setBounds(154, 69, 180, 40);
        btnEliminar.setBackground(new Color(228, 36, 209)); // Color tomate
        btnEliminar.setForeground(new Color(255, 255, 255)); // Texto negro
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
        panelBotones.add(btnEliminar);

        // JPanel para mostrar la lista de usuarios
        JPanel panelLista = new BackgroundPanel("src/recursos/imagenes/usuariosb.jpg");
        panelLista.setBounds(10, 200, 483, 150);
        panelLista.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelLista);
        panelLista.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        lst_Usuarios = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(lst_Usuarios);
        panelLista.add(scrollPane, BorderLayout.CENTER);

        // JTextField y JPasswordField para editar usuario seleccionado
        JPanel panelEdit = new BackgroundPanel("src/recursos/imagenes/usuariosm.jpg");
        panelEdit.setBounds(10, 360, 483, 50);
        panelEdit.setBackground(new Color(173, 216, 230)); // Color azul claro
        contentPane.add(panelEdit);
        panelEdit.setLayout(new GridLayout(1, 4, 5, 5));

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(new Color(255, 255, 255));
        lblUsuario.setFont(new Font("Unispace", Font.BOLD, 15));
        panelEdit.add(lblUsuario);

        txt_Usuario = new JTextField();
        panelEdit.add(txt_Usuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(new Color(255, 255, 255));
        lblContrasena.setFont(new Font("Unispace", Font.BOLD, 15));
        panelEdit.add(lblContrasena);

        passwordF_Contrasena = new JPasswordField();
        panelEdit.add(passwordF_Contrasena);

        // Agregar listener para actualizar campos de edición cuando se seleccione un usuario
        lst_Usuarios.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String usuarioSeleccionado = lst_Usuarios.getSelectedValue();
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
        String buscar = txt_buscar.getText().trim();
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
                txt_Usuario.setText(usuario.getNombre());
                passwordF_Contrasena.setText(usuario.getClave());
                return;
            }
        }
        // Si el usuario no se encuentra, limpia los campos
        txt_Usuario.setText("");
        passwordF_Contrasena.setText("");
    }

    private void editarUsuario() {
        String usuarioSeleccionado = lst_Usuarios.getSelectedValue();
        if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para editar.");
            return;
        }

        String nuevoUsuario = txt_Usuario.getText().trim();
        String nuevaContrasena = new String(passwordF_Contrasena.getPassword()).trim();

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
        String usuarioSeleccionado = lst_Usuarios.getSelectedValue();
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
