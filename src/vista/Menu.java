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
    public RoundedButton btnVentana;
    public RoundedButton btnGestionProducto;
    public RoundedButton btnGestionUsuario;
    public RoundedButton btnGestionProveedores;

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
        setBounds(500, 150, 450, 340);
        
        contentPane= new BackgroundPanel("src/recursos/imagenes/menu.jpg");

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Menú Principal");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Unispace", Font.BOLD, 20));
        lblTitle.setBounds(50, 20, 350, 30);
        lblTitle.setForeground(Color.decode("#3a7eb5"));
        contentPane.add(lblTitle);

        btnVentana = new RoundedButton("VENTA");
        btnVentana.setFont(new Font("Unispace", Font.BOLD, 18));
        btnVentana.setBounds(50, 70, 350, 40);
        btnVentana.setBackground(Color.decode("#8b4d86"));
        btnVentana.setForeground(new Color(0, 0, 0)); // Color de texto ajustado para mejor visibilidad
        btnVentana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ventana clicked");
                Venta venta = new Venta();
                venta.setVisible(true);
                btnVentana.setBackground(Color.GREEN);
                btnVentana.setForeground(Color.BLACK); // Mantener el texto visible
            }
        });
        contentPane.add(btnVentana);

        btnGestionProducto = new RoundedButton("GESTIÓN PRODUCTO");
        btnGestionProducto.setFont(new Font("Unispace", Font.BOLD, 18));
        btnGestionProducto.setBounds(50, 120, 350, 40);
        btnGestionProducto.setBackground(Color.decode("#3a84b4"));
        btnGestionProducto.setForeground(Color.BLACK); // Color de texto ajustado para mejor visibilidad
        btnGestionProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Producto clicked");
                ProductoGS productoGS = new ProductoGS();
                productoGS.setVisible(true);
                btnGestionProducto.setBackground(Color.GREEN);
                btnGestionProducto.setForeground(Color.BLACK); // Mantener el texto visible
            }
        });
        contentPane.add(btnGestionProducto);

        btnGestionUsuario = new RoundedButton("GESTIÓN USUARIO");
        btnGestionUsuario.setFont(new Font("Unispace", Font.BOLD, 18));
        btnGestionUsuario.setBounds(50, 170, 350, 40);
        btnGestionUsuario.setBackground(Color.decode("#7cb461"));
        btnGestionUsuario.setForeground(Color.BLACK); // Color de texto ajustado para mejor visibilidad
        btnGestionUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Usuario clicked");
                btnGestionUsuario.setBackground(Color.GREEN);
                btnGestionUsuario.setForeground(Color.BLACK); // Mantener el texto visible
                
                // Crear y mostrar la ventana UsuarioGS
                UsuarioGS usuarioGS = new UsuarioGS();
                usuarioGS.setVisible(true);
            }
        });
        contentPane.add(btnGestionUsuario);

        btnGestionProveedores = new RoundedButton("GESTIÓN PROVEEDORES");
        btnGestionProveedores.setFont(new Font("Unispace", Font.BOLD, 18));
        btnGestionProveedores.setBounds(50, 220, 350, 40);
        btnGestionProveedores.setBackground(Color.decode("#b8d69e"));
        btnGestionProveedores.setForeground(Color.BLACK); // Color de texto ajustado para mejor visibilidad
        btnGestionProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gestión Proveedores clicked");
                ProveedorGS proveedorGS = new ProveedorGS();
                proveedorGS.setVisible(true);
                btnGestionProveedores.setBackground(Color.GREEN);
                btnGestionProveedores.setForeground(Color.BLACK); // Mantener el texto visible
            }
        });
        contentPane.add(btnGestionProveedores);
    }
}

