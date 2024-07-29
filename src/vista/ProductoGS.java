package vista;

import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.logic_ProductoGS;
import java.awt.BorderLayout;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;

public class ProductoGS extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public logic_ProductoGS logic;
    public ProductoVS pn_productovs;
    public JTextField txt_nombre;
    public JTextField txt_precio;
    public JSpinner spn_cantidad;
    public JTextPane txt_descripcion;
    public JComboBox cbx_proveedor;
    public RoundedButton btn_nuevo;
    public RoundedButton btn_editar;
    public RoundedButton btn_guardar;
    public RoundedButton btn_eliminar;
    public RoundedButton btn_atras;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductoGS frame = new ProductoGS();
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
    public ProductoGS() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 754, 401);
        contentPane= new BackgroundPanel("src/recursos/imagenes/ProductosGS.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(230, 230, 250)); // Light blue background

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        pn_productovs = new ProductoVS();
        contentPane.add(pn_productovs, BorderLayout.WEST);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(230, 230, 250)); // Lavender background
        contentPane.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNombre.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 1;
        panel_1.add(lblNombre, gbc_lblNombre);
        
        txt_nombre = new JTextField();
        GridBagConstraints gbc_txt_nombre = new GridBagConstraints();
        gbc_txt_nombre.gridwidth = 3;
        gbc_txt_nombre.insets = new Insets(0, 0, 5, 5);
        gbc_txt_nombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_nombre.gridx = 1;
        gbc_txt_nombre.gridy = 2;
        panel_1.add(txt_nombre, gbc_txt_nombre);
        txt_nombre.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Descripcion:");
        lblNewLabel_1.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 3;
        panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
        gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
        gbc_horizontalStrut.gridx = 0;
        gbc_horizontalStrut.gridy = 4;
        panel_1.add(horizontalStrut, gbc_horizontalStrut);
        
        txt_descripcion = new JTextPane();
        txt_descripcion.setFont(new Font("Unispace", Font.PLAIN, 15));
        GridBagConstraints gbc_txt_descripcion = new GridBagConstraints();
        gbc_txt_descripcion.gridwidth = 3;
        gbc_txt_descripcion.insets = new Insets(0, 0, 5, 5);
        gbc_txt_descripcion.fill = GridBagConstraints.BOTH;
        gbc_txt_descripcion.gridx = 1;
        gbc_txt_descripcion.gridy = 4;
        panel_1.add(txt_descripcion, gbc_txt_descripcion);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
        gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalStrut_1.gridx = 4;
        gbc_horizontalStrut_1.gridy = 4;
        panel_1.add(horizontalStrut_1, gbc_horizontalStrut_1);
        
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblCantidad.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
        gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidad.gridx = 1;
        gbc_lblCantidad.gridy = 5;
        panel_1.add(lblCantidad, gbc_lblCantidad);
        
        spn_cantidad = new JSpinner();
        GridBagConstraints gbc_spn_cantidad = new GridBagConstraints();
        gbc_spn_cantidad.insets = new Insets(0, 0, 5, 5);
        gbc_spn_cantidad.gridx = 2;
        gbc_spn_cantidad.gridy = 5;
        panel_1.add(spn_cantidad, gbc_spn_cantidad);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblPrecio.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
        gbc_lblPrecio.anchor = GridBagConstraints.EAST;
        gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrecio.gridx = 1;
        gbc_lblPrecio.gridy = 6;
        panel_1.add(lblPrecio, gbc_lblPrecio);
        
        txt_precio = new JTextField();
        GridBagConstraints gbc_txt_precio = new GridBagConstraints();
        gbc_txt_precio.insets = new Insets(0, 0, 5, 5);
        gbc_txt_precio.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_precio.gridx = 2;
        gbc_txt_precio.gridy = 6;
        panel_1.add(txt_precio, gbc_txt_precio);
        txt_precio.setColumns(10);
        
        JLabel lblProveedor = new JLabel("Proveedor:");
        lblProveedor.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblProveedor.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
        gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_lblProveedor.gridx = 1;
        gbc_lblProveedor.gridy = 7;
        panel_1.add(lblProveedor, gbc_lblProveedor);
        
        cbx_proveedor = new JComboBox();
        GridBagConstraints gbc_cbx_proveedor = new GridBagConstraints();
        gbc_cbx_proveedor.gridwidth = 3;
        gbc_cbx_proveedor.insets = new Insets(0, 0, 0, 5);
        gbc_cbx_proveedor.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbx_proveedor.gridx = 1;
        gbc_cbx_proveedor.gridy = 8;
        panel_1.add(cbx_proveedor, gbc_cbx_proveedor);
        
        Box verticalBox = Box.createVerticalBox();
        contentPane.add(verticalBox, BorderLayout.EAST);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut);
        
        btn_nuevo = new RoundedButton("New button");
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setFont(new Font("Unispace", Font.PLAIN, 13));
        btn_nuevo.setBackground(new Color(47, 131, 115)); // Blue button background
        btn_nuevo.setForeground(new Color(255, 255, 255)); // White text
        verticalBox.add(btn_nuevo);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_1);
        
        btn_editar = new RoundedButton("New button");
        btn_editar.setText("Editar");
        btn_editar.setFont(new Font("Unispace", Font.PLAIN, 13));
        btn_editar.setBackground(new Color(137, 81, 142)); // Blue button background
        btn_editar.setForeground(new Color(255, 255, 255)); // White text
        verticalBox.add(btn_editar);
        
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_2);
        
        btn_guardar = new RoundedButton("New button");
        btn_guardar.setText("Guardar");
        btn_guardar.setFont(new Font("Unispace", Font.PLAIN, 13));
        btn_guardar.setBackground(new Color(0, 176, 200));
        btn_guardar.setForeground(Color.decode("#FFFFFF"));
        verticalBox.add(btn_guardar);
        
        Component verticalStrut_3 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_3);
        
        btn_eliminar = new RoundedButton("New button");
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setFont(new Font("Unispace", Font.PLAIN, 13));
        btn_eliminar.setBackground(new Color(92, 53, 120));
        btn_eliminar.setForeground(Color.decode("#FFFFFF"));
        verticalBox.add(btn_eliminar);
        
        Box horizontalBox = Box.createHorizontalBox();
        contentPane.add(horizontalBox, BorderLayout.NORTH);
        
        btn_atras = new RoundedButton("New button");
        btn_atras.setText("Atras");
        btn_atras.setFont(new Font("Unispace", Font.PLAIN, 15));
        btn_atras.setBackground(new Color(136, 80, 141));
        btn_atras.setForeground(Color.decode("#FFFFFF"));
        horizontalBox.add(btn_atras);
        
        Component verticalStrut_4 = Box.createVerticalStrut(40);
        horizontalBox.add(verticalStrut_4);
        logic = new logic_ProductoGS(this);
    }

}