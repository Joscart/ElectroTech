package vista;

import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.logic_Venta;
import modelo.Producto;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import java.awt.Font;

public class Venta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public logic_Venta logic;
    public JButton btn_eliminar;
    private JLabel lblNewLabel;
    public JButton btn_agregar;
    public JButton btn_atras;
    public JSpinner spn_cantidad;
    public JList<Producto> lst_productos;
    public ProductoVS pn_productovs;
    public JLabel lbl_total;
    public JLabel lbl_numProductos;
    public RoundedButton btn_venta;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Venta frame = new Venta();
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
    public Venta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 570, 386);
        contentPane= new BackgroundPanel("src/recursos/imagenes/venta.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(230, 230, 250)); // Light blue background

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new BackgroundPanel("src/recursos/imagenes/venta.jpg");
        panel.setBackground(new Color(230, 230, 250)); // Lavender background
        contentPane.add(panel, BorderLayout.EAST);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{129, 0};
        gbl_panel.rowHeights = new int[]{27, 32, 0, 0, 0, 0, 0, 0, 27, 0};
        gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        btn_agregar = new RoundedButton("Agregar");
        btn_agregar.setFont(new Font("Unispace", Font.PLAIN, 15));
        btn_agregar.setBackground(new Color(98, 180, 146)); // White background
        btn_agregar.setForeground(new Color(0, 0, 0)); // Black text
        GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
        gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
        gbc_btnAgregar.gridx = 0;
        gbc_btnAgregar.gridy = 0;
        panel.add(btn_agregar, gbc_btnAgregar);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        GridBagConstraints gbc_horizontalBox_1 = new GridBagConstraints();
        gbc_horizontalBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalBox_1.gridx = 0;
        gbc_horizontalBox_1.gridy = 1;
        panel.add(horizontalBox_1, gbc_horizontalBox_1);
        
        lblNewLabel = new JLabel("Cantidad");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 2;
        panel.add(lblNewLabel, gbc_lblNewLabel);
        lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 15));
        
        spn_cantidad = new JSpinner();
        GridBagConstraints gbc_spn_cantidad = new GridBagConstraints();
        gbc_spn_cantidad.insets = new Insets(0, 0, 5, 0);
        gbc_spn_cantidad.gridx = 0;
        gbc_spn_cantidad.gridy = 3;
        panel.add(spn_cantidad, gbc_spn_cantidad);
        spn_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        btn_eliminar = new RoundedButton("Eliminar");
        btn_eliminar.setFont(new Font("Unispace", Font.PLAIN, 15));
        btn_eliminar.setBackground(new Color(116, 47, 106)); // White background
        btn_eliminar.setForeground(new Color(0, 0, 0)); // Black text
        GridBagConstraints gbc_btn_Eliminar = new GridBagConstraints();
        gbc_btn_Eliminar.insets = new Insets(0, 0, 5, 0);
        gbc_btn_Eliminar.gridx = 0;
        gbc_btn_Eliminar.gridy = 5;
        panel.add(btn_eliminar, gbc_btn_Eliminar);
        
        btn_venta = new RoundedButton("Terminar venta");
        btn_venta.setForeground(Color.WHITE);
        btn_venta.setFont(new Font("Unispace", Font.PLAIN, 15));
        btn_venta.setBackground(new Color(116, 47, 106));
        GridBagConstraints gbc_btn_eliminar_1 = new GridBagConstraints();
        gbc_btn_eliminar_1.insets = new Insets(0, 0, 5, 0);
        gbc_btn_eliminar_1.gridx = 0;
        gbc_btn_eliminar_1.gridy = 7;
        panel.add(btn_venta, gbc_btn_eliminar_1);
        
        pn_productovs = new ProductoVS();
        contentPane.add(pn_productovs, BorderLayout.WEST);
        
        lst_productos = new JList<>();
        contentPane.add(lst_productos, BorderLayout.CENTER);
        
        JPanel panel_3 = new BackgroundPanel("src/recursos/imagenes/vantaabajo.jpg");
        panel_3.setBackground(new Color(240, 248, 255)); // Light blue background
        contentPane.add(panel_3, BorderLayout.SOUTH);
        
        lbl_numProductos = new RoundedLabel("Num Productos:", new Color(98, 180, 146));
        lbl_numProductos.setFont(new Font("Unispace", Font.BOLD, 13));
        panel_3.add(lbl_numProductos);
        
        lbl_total = new RoundedLabel("Total:",new Color(98, 180, 146));
        lbl_total.setFont(new Font("Unispace", Font.BOLD, 13));
        panel_3.add(lbl_total);
        
        Box horizontalBox = Box.createHorizontalBox();
        contentPane.add(horizontalBox, BorderLayout.NORTH);
        
        btn_atras = new RoundedButton("Atras");
        btn_atras.setFont(new Font("Unispace", Font.PLAIN, 15));
        btn_atras.setBackground(new Color(163, 109, 115)); // White background
        btn_atras.setForeground(new Color(0, 0, 0)); // Black text
        horizontalBox.add(btn_atras);
        
        Component verticalStrut = Box.createVerticalStrut(40);
        horizontalBox.add(verticalStrut);
        logic = new logic_Venta(this);
    }
}
