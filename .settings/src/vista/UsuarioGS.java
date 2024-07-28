package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UsuarioGS extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldBuscar;
    private JTextArea textAreaInfo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Establecer look and feel del sistema
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    UsuarioGS frame = new UsuarioGS();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UsuarioGS() {
        setTitle("Gestión de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(173, 216, 230)); // Color azul claro
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelBuscar = new JPanel();
        panelBuscar.setBounds(10, 10, 420, 50);
        panelBuscar.setBackground(new Color(135, 206, 250)); // Color azul más oscuro
        contentPane.add(panelBuscar);
        panelBuscar.setLayout(null);

        JButton btnAtras = new JButton("Atrás");
        btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAtras.setBounds(0, 10, 100, 30);
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Atrás clicked");
                // Lógica para volver al menú principal
            }
        });
        panelBuscar.add(btnAtras);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBuscar.setBounds(110, 10, 60, 30);
        panelBuscar.add(lblBuscar);

        textFieldBuscar = new JTextField();
        textFieldBuscar.setBounds(180, 15, 200, 25);
        panelBuscar.add(textFieldBuscar);
        textFieldBuscar.setColumns(10);

        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(10, 70, 420, 120);
        panelBotones.setBackground(new Color(135, 206, 250)); // Color azul más oscuro
        contentPane.add(panelBotones);
        panelBotones.setLayout(null);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEditar.setBounds(10, 10, 180, 40);
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Editar clicked");
                // Lógica para editar usuario
            }
        });
        panelBotones.add(btnEditar);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAgregar.setBounds(210, 10, 180, 40);
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Agregar clicked");
                // Lógica para agregar usuario
            }
        });
        panelBotones.add(btnAgregar);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNuevo.setBounds(10, 70, 180, 40);
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
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Eliminar clicked");
                // Lógica para eliminar usuario
            }
        });
        panelBotones.add(btnEliminar);

        // JPanel para mostrar información
        JPanel panelInfo = new JPanel();
        panelInfo.setBounds(10, 200, 420, 150);
        panelInfo.setBackground(new Color(135, 206, 250)); // Color azul más oscuro
        contentPane.add(panelInfo);
        panelInfo.setLayout(null);

        textAreaInfo = new JTextArea();
        textAreaInfo.setBounds(10, 10, 400, 130);
        panelInfo.add(textAreaInfo);
        textAreaInfo.setLineWrap(true);
        textAreaInfo.setWrapStyleWord(true);
    }
}
