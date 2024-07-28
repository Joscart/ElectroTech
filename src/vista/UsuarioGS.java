package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
<<<<<<< HEAD

import controlador.logic_Login;
=======
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f

public class UsuarioGS extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldBuscar;
    private JList<String> listUsuarios;
    private DefaultListModel<String> listModel;
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldContrasena;

    private static final String FILE_PATH = "usuarios.txt";
<<<<<<< HEAD
    public JButton btnAgregarUsuario; // Renombrado para mantener consistencia
=======
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f

    /**
     * Create the frame.
     */
    public UsuarioGS() {
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
<<<<<<< HEAD
        btnAtras.addActionListener(new ActionListener() {
=======
        btnAtras.addActionListener((ActionListener) new ActionListener() {
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }

			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        panelBuscar.add(btnAtras);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBuscar.setBounds(110, 10, 60, 30);
        lblBuscar.setForeground(new Color(70, 130, 180)); // Color acero azul
        panelBuscar.add(lblBuscar);

        textFieldBuscar = new JTextField();
        textFieldBuscar.setBounds(180, 15, 200, 25);
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

<<<<<<< HEAD
        btnAgregarUsuario = new JButton("Agregar Usuario"); // Renombrado
        btnAgregarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAgregarUsuario.setBounds(210, 10, 180, 40);
        btnAgregarUsuario.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnAgregarUsuario.setForeground(Color.BLACK); // Texto negro
        panelBotones.add(btnAgregarUsuario);
=======
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAgregar.setBounds(210, 10, 180, 40);
        btnAgregar.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnAgregar.setForeground(Color.BLACK); // Texto negro
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Agregar clicked");
                AgregarUsuario agregarUsuario = new AgregarUsuario();
                agregarUsuario.setVisible(true);
            }
        });
        panelBotones.add(btnAgregar);
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNuevo.setBounds(10, 70, 180, 40);
        btnNuevo.setBackground(new Color(100, 149, 237)); // Color azul pálido
        btnNuevo.setForeground(Color.BLACK); // Texto negro
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nuevo clicked");
                // Lógica para nuevo usuario
            }
        });
        panelBotones.add(btnNuevo);

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
        listUsuarios.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String usuarioSeleccionado = listUsuarios.getSelectedValue();
                if (usuarioSeleccionado != null) {
                    cargarUsuario(usuarioSeleccionado);
                }
            }
        });
    }

    private void buscarUsuario() {
        String buscar = textFieldBuscar.getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un usuario para buscar.");
            return;
        }

        listModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].contains(buscar)) {
                    listModel.addElement(partes[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarUsuario(String usuario) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equals(usuario)) {
                    textFieldUsuario.setText(partes[0]);
                    passwordFieldContrasena.setText(partes[1]);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equals(usuarioSeleccionado)) {
                    lineas.add(nuevoUsuario + "," + nuevaContrasena);
                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Usuario editado con éxito.");
        buscarUsuario(); // Actualiza la lista de usuarios
    }

    private void eliminarUsuario() {
        String usuarioSeleccionado = listUsuarios.getSelectedValue();
        if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para eliminar.");
            return;
        }

        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (!partes[0].equals(usuarioSeleccionado)) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito.");
        buscarUsuario(); // Actualiza la lista de usuarios
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsuarioGS frame = new UsuarioGS();
            frame.setVisible(true);
<<<<<<< HEAD
            logic_Login logic = new logic_Login(frame); // Inicializa la lógica de login para UsuarioGS
=======
>>>>>>> 38ddf8f8adea5cfe9cfb5a909ae188b1fb48237f
        });
    }
}

