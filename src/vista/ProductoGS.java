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

public class ProductoGS extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public logic_ProductoGS logic;
    private ProductoVS pn_productovs;
    private JTextField textField;
    private JTextField textField_1;

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
        contentPane = new JPanel();
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
        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 0;
        panel_1.add(lblNombre, gbc_lblNombre);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 3;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        panel_1.add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Descripcion:");
        lblNewLabel_1.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
        gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
        gbc_horizontalStrut.gridx = 0;
        gbc_horizontalStrut.gridy = 3;
        panel_1.add(horizontalStrut, gbc_horizontalStrut);
        
        JTextPane textPane = new JTextPane();
        GridBagConstraints gbc_textPane = new GridBagConstraints();
        gbc_textPane.gridwidth = 3;
        gbc_textPane.insets = new Insets(0, 0, 5, 5);
        gbc_textPane.fill = GridBagConstraints.BOTH;
        gbc_textPane.gridx = 1;
        gbc_textPane.gridy = 3;
        panel_1.add(textPane, gbc_textPane);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
        gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalStrut_1.gridx = 4;
        gbc_horizontalStrut_1.gridy = 3;
        panel_1.add(horizontalStrut_1, gbc_horizontalStrut_1);
        
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
        gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidad.gridx = 1;
        gbc_lblCantidad.gridy = 4;
        panel_1.add(lblCantidad, gbc_lblCantidad);
        
        JSpinner spinner = new JSpinner();
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.insets = new Insets(0, 0, 5, 5);
        gbc_spinner.gridx = 2;
        gbc_spinner.gridy = 4;
        panel_1.add(spinner, gbc_spinner);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
        gbc_lblPrecio.anchor = GridBagConstraints.EAST;
        gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrecio.gridx = 1;
        gbc_lblPrecio.gridy = 5;
        panel_1.add(lblPrecio, gbc_lblPrecio);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 5;
        panel_1.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        JLabel lblProveedor = new JLabel("Proveedor:");
        lblProveedor.setForeground(new Color(0, 128, 128)); // Teal text
        GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
        gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_lblProveedor.gridx = 1;
        gbc_lblProveedor.gridy = 6;
        panel_1.add(lblProveedor, gbc_lblProveedor);
        
        JComboBox comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridwidth = 3;
        gbc_comboBox.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 7;
        panel_1.add(comboBox, gbc_comboBox);
        
        Box verticalBox = Box.createVerticalBox();
        contentPane.add(verticalBox, BorderLayout.EAST);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBackground(new Color(0, 0, 255)); // Blue button background
        btnNewButton.setForeground(new Color(255, 255, 255)); // White text
        verticalBox.add(btnNewButton);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_1);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBackground(new Color(0, 0, 255)); // Blue button background
        btnNewButton_1.setForeground(new Color(255, 255, 255)); // White text
        verticalBox.add(btnNewButton_1);
        
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_2);
        
        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.setBackground(Color.decode("#0000FF"));
        btnNewButton_2.setForeground(Color.decode("#FFFFFF"));
        verticalBox.add(btnNewButton_2);
        
        Component verticalStrut_3 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_3);
        
        JButton btnNewButton_3 = new JButton("New button");
        btnNewButton_3.setBackground(Color.decode("#0000FF"));
        btnNewButton_3.setForeground(Color.decode("#FFFFFF"));
        verticalBox.add(btnNewButton_3);
        
        Box horizontalBox = Box.createHorizontalBox();
        contentPane.add(horizontalBox, BorderLayout.NORTH);
        
        JButton btnNewButton_4 = new JButton("New button");
        btnNewButton_4.setBackground(Color.decode("#0000FF"));
        btnNewButton_4.setForeground(Color.decode("#FFFFFF"));
        horizontalBox.add(btnNewButton_4);
        
        Component verticalStrut_4 = Box.createVerticalStrut(40);
        horizontalBox.add(verticalStrut_4);
        logic = new logic_ProductoGS(this);
    }

}

