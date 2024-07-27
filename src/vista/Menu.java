package vista;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Establecer look and feel del sistema
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Menu frame = new Menu();
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
    public Menu() {
        setTitle("Sistema de Gestión de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(240, 248, 255)); // Color pastel de fondo
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Menú Principal");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(50, 20, 350, 30);
        lblTitle.setForeground(Color.decode("#8000FF"));
        contentPane.add(lblTitle);

        JButton btnVentana = new JButton("VENTA");
        btnVentana.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVentana.setBounds(50, 70, 350, 40);
        btnVentana.setBackground(Color.decode("#03C03C"));
        btnVentana.setForeground(Color.BLACK); // Color de texto ajustado para mejor visibilidad
        btnVentana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ventana clicked");
                btnVentana.setBackground(Color.GREEN);
                btnVentana.setForeground(Color.BLACK); // Mantener el texto visible
            }
        });
        contentPane.add(btnVentana);

        JButton btnGestionProducto = new JButton("GESTIÓN PRODUCTO");
        btnGestionProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGestionProducto.setBounds(50, 120, 350, 40);
        btnGestionProducto.setBackground(Color.decode("#03C03C"));
        btnGestionProducto.setForeground(Color.BLACK); // Color de texto ajustado para mejor visibilidad
        btnGestionProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Producto clicked");
                btnGestionProducto.setBackground(Color.GREEN);
                btnGestionProducto.setForeground(Color.BLACK); // Mantener el texto visible
            }
        });
        contentPane.add(btnGestionProducto);

        JButton btnGestionUsuario = new JButton("GESTIÓN USUARIO");
        btnGestionUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGestionUsuario.setBounds(50, 170, 350, 40);
        btnGestionUsuario.setBackground(Color.decode("#03C03C"));
        btnGestionUsuario.setForeground(Color.BLACK); // Color de texto ajustado para mejor visibilidad
        btnGestionUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Usuario clicked");
                btnGestionUsuario.setBackground(Color.GREEN);
                btnGestionUsuario.setForeground(Color.BLACK); // Mantener el texto visible
<<<<<<< HEAD
                
                // Crear y mostrar la ventana UsuarioGS
                UsuarioGS usuarioGS = new UsuarioGS();
                usuarioGS.setVisible(true);
=======
>>>>>>> 7aa060d71a6620cf8401934f43f81d7cc5219ce2
            }
        });
        contentPane.add(btnGestionUsuario);

        JButton btnGestionProveedores = new JButton("GESTIÓN PROVEEDORES");
        btnGestionProveedores.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGestionProveedores.setBounds(50, 220, 350, 40);
        btnGestionProveedores.setBackground(Color.decode("#03C03C"));
        btnGestionProveedores.setForeground(Color.BLACK); // Color de texto ajustado para mejor visibilidad
        btnGestionProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Proveedores clicked");
                btnGestionProveedores.setBackground(Color.GREEN);
                btnGestionProveedores.setForeground(Color.BLACK); // Mantener el texto visible
            }
        });
        contentPane.add(btnGestionProveedores);
    }
}
