package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel("Menú Principal");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(50, 20, 350, 30);
        contentPane.add(lblTitle);

        JButton btnVentana = new JButton("VENTA");
        btnVentana.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVentana.setBounds(50, 70, 350, 40);
        btnVentana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ventana clicked");
                // Lógica para la acción de Ventana
            }
        });
        contentPane.add(btnVentana);

        JButton btnGestionProducto = new JButton("GESTIÓN PRODUCTO");
        btnGestionProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGestionProducto.setBounds(50, 120, 350, 40);
        btnGestionProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Producto clicked");
                // Lógica para la acción de Gestión Producto
            }
        });
        contentPane.add(btnGestionProducto);

        JButton btnGestionUsuario = new JButton("GESTIÓN USUARIO");
        btnGestionUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGestionUsuario.setBounds(50, 170, 350, 40);
        btnGestionUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Usuario clicked");
                // Lógica para la acción de Gestión Usuario
            }
        });
        contentPane.add(btnGestionUsuario);

        JButton btnGestionProveedores = new JButton("GESTIÓN PROVEEDORES");
        btnGestionProveedores.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGestionProveedores.setBounds(50, 220, 350, 40);
        btnGestionProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Proveedores clicked");
                // Lógica para la acción de Gestión Proveedores
            }
        });
        contentPane.add(btnGestionProveedores);
    }
}

