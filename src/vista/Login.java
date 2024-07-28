package vista;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.logic_Login;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public logic_Login logic;
    public JButton btn_test;
    public JTextField textFieldUsername;
    public JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 150, 550, 350);

        contentPane= new BackgroundPanel("src/recursos/imagenes/login.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Unispace", Font.BOLD, 30));
        lblLogin.setForeground(Color.decode("#7f00ff"));

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setFont(new Font("Unispace", Font.BOLD, 18));
        lblUsername.setForeground(new Color(192, 192, 192));

        textFieldUsername = new JTextField();
        textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldUsername.setColumns(10);
        textFieldUsername.setBackground(Color.decode("#fbebd2"));

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Unispace", Font.BOLD, 18));
        lblPassword.setForeground(new Color(192, 192, 192));

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setColumns(10);
        passwordField.setBackground(Color.decode("#fbebd2"));

        btn_test = new RoundedButton("Validar");
        btn_test.setFont(new Font("Unispace", Font.PLAIN, 18));
        btn_test.setBackground(Color.decode("#02c03c"));
        btn_test.setForeground(new Color(0, 0, 0));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(85)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblUsername)
        						.addComponent(lblPassword))
        					.addGap(43)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(199)
        					.addComponent(lblLogin))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(177)
        					.addComponent(btn_test, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(61, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(35)
        			.addComponent(lblLogin)
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblUsername)
        				.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(41)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPassword)
        				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(41)
        			.addComponent(btn_test)
        			.addContainerGap(53, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);

        // Inicializar logic_Login
        logic = new logic_Login(this);
    }
}

