package vista;

import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.logic_Venta;
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

public class Venta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public logic_Venta logic;

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
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(230, 230, 250)); // Light blue background

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 230, 250)); // Lavender background
        contentPane.add(panel, BorderLayout.EAST);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{129, 0};
        gbl_panel.rowHeights = new int[]{27, 32, 0, 27, 0};
        gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(255, 255, 255)); // White background
        btnAgregar.setForeground(new Color(0, 0, 0)); // Black text
        GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
        gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
        gbc_btnAgregar.gridx = 0;
        gbc_btnAgregar.gridy = 0;
        panel.add(btnAgregar, gbc_btnAgregar);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        GridBagConstraints gbc_horizontalBox_1 = new GridBagConstraints();
        gbc_horizontalBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalBox_1.gridx = 0;
        gbc_horizontalBox_1.gridy = 1;
        panel.add(horizontalBox_1, gbc_horizontalBox_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        horizontalBox_1.add(lblNewLabel);
        
        JSpinner spinner = new JSpinner();
        horizontalBox_1.add(spinner);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 255, 255)); // White background
        btnEliminar.setForeground(new Color(0, 0, 0)); // Black text
        GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
        gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
        gbc_btnEliminar.gridx = 0;
        gbc_btnEliminar.gridy = 2;
        panel.add(btnEliminar, gbc_btnEliminar);
        
        ProductoVS panel_1 = new ProductoVS();
        contentPane.add(panel_1, BorderLayout.WEST);
        
        JList list = new JList();
        contentPane.add(list, BorderLayout.CENTER);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(240, 248, 255)); // Light blue background
        contentPane.add(panel_3, BorderLayout.SOUTH);
        
        JLabel lblNumProductos = new JLabel("Num Productos:");
        panel_3.add(lblNumProductos);
        
        JLabel lblTotal = new JLabel("Total:");
        panel_3.add(lblTotal);
        
        Box horizontalBox = Box.createHorizontalBox();
        contentPane.add(horizontalBox, BorderLayout.NORTH);
        
        JButton btnAtras = new JButton("Atras");
        btnAtras.setBackground(new Color(255, 255, 255)); // White background
        btnAtras.setForeground(new Color(0, 0, 0)); // Black text
        horizontalBox.add(btnAtras);
        
        Component verticalStrut = Box.createVerticalStrut(40);
        horizontalBox.add(verticalStrut);
        logic = new logic_Venta(this);
    }
}
