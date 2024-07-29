package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controlador.logic_ProveedorGS;
import modelo.Proveedor;

import javax.swing.JList;

public class ProveedorGS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public logic_ProveedorGS logic;
	public JTextField txt_nombre;
	public JTextField txt_cedula;
	public JTextField txt_codigo;
	public JTextField txt_correo;
	public JTextField txt_telefono;
	public JTextField txt_razonSocial;
    public JList<Proveedor> lst_proveedores;
    public RoundedButton btn_atras;
    public RoundedButton btn_nuevo;
    public RoundedButton btn_editar;
    public RoundedButton btn_guardar;
    public RoundedButton btn_eliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProveedorGS frame = new ProveedorGS();
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
	public ProveedorGS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 754, 401);
        contentPane= new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(55, 81, 126)); // Light blue background

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new BackgroundPanel("src/recursos/imagenes/ProductosGS.jpg");
        panel_1.setBackground(new Color(230, 230, 250)); // Lavender background
        contentPane.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        RoundedLabel lblNombre = new RoundedLabel("Nombre:",(new Color(58, 96, 142)));
        lblNombre.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNombre.setForeground(new Color(255, 255, 255)); // Teal text
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
        
        RoundedLabel lblNewLabel_1 = new RoundedLabel("Cedula:",(new Color(52, 162, 117)));
        lblNewLabel_1.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255)); // Teal text
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 4;
        panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JLabel lblNewLabel = new RoundedLabel("Codigo",(new Color(29, 123, 161)));
        lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNewLabel.setForeground(new Color(255, 255, 255)); // Teal text
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 2;
        gbc_lblNewLabel.gridy = 4;
        panel_1.add(lblNewLabel, gbc_lblNewLabel);
        
        txt_cedula = new JTextField();
        GridBagConstraints gbc_txt_cedula = new GridBagConstraints();
        gbc_txt_cedula.insets = new Insets(0, 0, 5, 5);
        gbc_txt_cedula.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_cedula.gridx = 1;
        gbc_txt_cedula.gridy = 5;
        panel_1.add(txt_cedula, gbc_txt_cedula);
        txt_cedula.setColumns(10);
        
        txt_codigo = new JTextField();
        GridBagConstraints gbc_txt_codigo = new GridBagConstraints();
        gbc_txt_codigo.insets = new Insets(0, 0, 5, 5);
        gbc_txt_codigo.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_codigo.gridx = 2;
        gbc_txt_codigo.gridy = 5;
        panel_1.add(txt_codigo, gbc_txt_codigo);
        txt_codigo.setColumns(10);
        
        JLabel lblNewLabel_2 = new RoundedLabel("Correo",(new Color(52, 162, 117)));
        lblNewLabel_2.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNewLabel_2.setForeground(new Color(255, 255, 255)); // Teal text
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 7;
        panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        txt_correo = new JTextField();
        GridBagConstraints gbc_txt_correo = new GridBagConstraints();
        gbc_txt_correo.gridwidth = 2;
        gbc_txt_correo.insets = new Insets(0, 0, 5, 5);
        gbc_txt_correo.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_correo.gridx = 1;
        gbc_txt_correo.gridy = 8;
        panel_1.add(txt_correo, gbc_txt_correo);
        txt_correo.setColumns(10);
        
        JLabel lblNewLabel_3 = new RoundedLabel("Telefono",(new Color(91, 92, 158)));
        lblNewLabel_3.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNewLabel_3.setForeground(new Color(255, 255, 255)); // Teal text
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTH;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 10;
        panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        txt_telefono = new JTextField();
        GridBagConstraints gbc_txt_telefono = new GridBagConstraints();
        gbc_txt_telefono.anchor = GridBagConstraints.NORTH;
        gbc_txt_telefono.insets = new Insets(0, 0, 5, 5);
        gbc_txt_telefono.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_telefono.gridx = 1;
        gbc_txt_telefono.gridy = 11;
        panel_1.add(txt_telefono, gbc_txt_telefono);
        txt_telefono.setColumns(10);
        
        JLabel lblNewLabel_4 = new RoundedLabel("Razon Social",(new Color(136, 82, 142)));
        lblNewLabel_4.setFont(new Font("Unispace", Font.PLAIN, 15));
        lblNewLabel_4.setForeground(new Color(255, 255, 255)); // Teal text
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 12;
        panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        txt_razonSocial = new JTextField();
        GridBagConstraints gbc_txt_razonSocial = new GridBagConstraints();
        gbc_txt_razonSocial.gridwidth = 2;
        gbc_txt_razonSocial.insets = new Insets(0, 0, 5, 5);
        gbc_txt_razonSocial.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_razonSocial.gridx = 1;
        gbc_txt_razonSocial.gridy = 13;
        panel_1.add(txt_razonSocial, gbc_txt_razonSocial);
        txt_razonSocial.setColumns(10);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
        gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
        gbc_horizontalStrut.gridx = 0;
        gbc_horizontalStrut.gridy = 14;
        panel_1.add(horizontalStrut, gbc_horizontalStrut);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
        gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalStrut_1.gridx = 4;
        gbc_horizontalStrut_1.gridy = 14;
        panel_1.add(horizontalStrut_1, gbc_horizontalStrut_1);
        
        Box verticalBox = Box.createVerticalBox();
        contentPane.add(verticalBox, BorderLayout.EAST);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut);
        
        btn_nuevo = new RoundedButton("New button");
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setFont(new Font("Unispace", Font.PLAIN, 11));
        btn_nuevo.setBackground(new Color(0, 172, 200)); // Blue button background
        btn_nuevo.setForeground(new Color(255, 255, 255)); // White text
        verticalBox.add(btn_nuevo);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_1);
        
        btn_editar = new RoundedButton("New button");
        btn_editar.setText("Editar");
        btn_editar.setFont(new Font("Unispace", Font.PLAIN, 11));
        btn_editar.setBackground(new Color(101, 189, 123)); // Blue button background
        btn_editar.setForeground(new Color(255, 255, 255)); // White text
        verticalBox.add(btn_editar);
        
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_2);
        
        btn_guardar = new RoundedButton("New button");
        btn_guardar.setText("Guardar");
        btn_guardar.setFont(new Font("Unispace", Font.PLAIN, 11));
        btn_guardar.setBackground(new Color(26, 99, 124));
        btn_guardar.setForeground(Color.decode("#FFFFFF"));
        verticalBox.add(btn_guardar);
        
        Component verticalStrut_3 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_3);
        
        btn_eliminar = new RoundedButton("New button");
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setFont(new Font("Unispace", Font.PLAIN, 11));
        btn_eliminar.setBackground(new Color(135, 79, 140));
        btn_eliminar.setForeground(Color.decode("#FFFFFF"));
        verticalBox.add(btn_eliminar);
        
        Box horizontalBox = Box.createHorizontalBox();
        contentPane.add(horizontalBox, BorderLayout.NORTH);
        
        btn_atras = new RoundedButton("New button");
        btn_atras.setText("Atras");
        btn_atras.setFont(new Font("Unispace", Font.PLAIN, 11));
        btn_atras.setBackground(new Color(135, 79, 140));
        btn_atras.setForeground(Color.decode("#FFFFFF"));
        horizontalBox.add(btn_atras);
        
        Component verticalStrut_4 = Box.createVerticalStrut(40);
        horizontalBox.add(verticalStrut_4);
        
        lst_proveedores = new JList<>();
        contentPane.add(lst_proveedores, BorderLayout.WEST);
		logic = new logic_ProveedorGS(this);
	}

}
