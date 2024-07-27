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
        setBounds(100, 100, 450, 300);

<<<<<<< HEAD
=======
        // Configuración del contentPane con un color pastel de fondo
>>>>>>> 7aa060d71a6620cf8401934f43f81d7cc5219ce2
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblLogin.setForeground(Color.decode("#8000FF"));

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUsername.setForeground(Color.decode("#0000FF"));

        textFieldUsername = new JTextField();
        textFieldUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPassword.setForeground(Color.decode("#0000FF"));

        passwordField = new JPasswordField();
        passwordField.setColumns(10);

        btn_test = new JButton("Login");
        btn_test.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_test.setBackground(Color.decode("#03C03C"));
        btn_test.setForeground(Color.WHITE);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(173)
                    .addComponent(lblLogin)
                    .addContainerGap(183, Short.MAX_VALUE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(75)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblUsername)
                        .addComponent(lblPassword))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(passwordField)
                        .addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addContainerGap(97, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap(185, Short.MAX_VALUE)
                    .addComponent(btn_test)
                    .addGap(170))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblLogin)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblUsername)
                        .addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(btn_test)
                    .addContainerGap(120, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);

        // Inicializar logic_Login
        logic = new logic_Login(this);
    }
}

