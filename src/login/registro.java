package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registro extends JFrame {

	private JPanel contentPane;
	private JTextField Usuario;
	private JTextField Correoelectronico;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_5;
	static ArrayList<String> contraseña = new ArrayList<String>();
	static ArrayList<String> usuario = new ArrayList<String>();
	static ArrayList<String> correo = new ArrayList<String>();
	static registro register;
	private Usuario user = new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register = new registro();
					register.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registro() {

		setTitle("Formulario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.setBounds(95, 550, 150, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame login = new login();
				login.setVisible(true);
				register.setVisible(false);

			}
		});
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (passwordField_1.getText().equals(passwordField.getText()) && !Usuario.getText().isEmpty()
						&& !Correoelectronico.getText().isEmpty() && !passwordField.getText().isEmpty()
						&& !passwordField_1.getText().isEmpty() && Correoelectronico.getText().contains("@")
						&& Correoelectronico.getText().contains(".")) {
					usuario.add(Usuario.getText());
					contraseña.add(passwordField.getText());
					correo.add(Correoelectronico.getText());

					JOptionPane.showMessageDialog(contentPane, "Te has registrado correctamente", "REGISTRO",
							JOptionPane.INFORMATION_MESSAGE);

					JFrame welcome = new welcome();
					welcome.setVisible(true);
					register.setVisible(false);

					user.AgregarUsuario(Usuario.getText(), passwordField.getText(), Correoelectronico.getText());
				} else {
					if (!passwordField_1.getText().equals(passwordField.getText())) {
						JOptionPane.showMessageDialog(contentPane, "Las contraseñas no coinciden", "TONTISIMO",
								JOptionPane.ERROR_MESSAGE);
						passwordField_1.setBackground(Color.red);
						passwordField.setBackground(Color.red);
					} else if (passwordField.getText().isEmpty() && Usuario.getText().isEmpty()
							&& Correoelectronico.getText().isEmpty() && passwordField_1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Campos vacios", "TONTISIMO",
								JOptionPane.ERROR_MESSAGE);
					} else if (Usuario.getText().isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Usuario vacio", "TONTISIMO",
								JOptionPane.ERROR_MESSAGE);
						Usuario.setBackground(Color.red);
					} else if (Correoelectronico.getText().isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Email vacio", "TONTISIMO",
								JOptionPane.ERROR_MESSAGE);
						Correoelectronico.setBackground(Color.red);
					} else if (!Correoelectronico.getText().contains("@")
							&& !Correoelectronico.getText().contains(".")) {
						JOptionPane.showMessageDialog(contentPane, "Email incorrecto", "TONTISIMO",
								JOptionPane.ERROR_MESSAGE);
						Correoelectronico.setBackground(Color.blue);
					} else {
						JOptionPane.showMessageDialog(contentPane, "Contraseña vacias", "TONTISIMO",
								JOptionPane.ERROR_MESSAGE);
						passwordField_1.setBackground(Color.red);
						passwordField.setBackground(Color.red);
					}

				}
			}
		});

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Mostra Contraseña");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (rdbtnNewRadioButton.isSelected() == true) {
					passwordField.setEchoChar((char) 0);
					passwordField_1.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
					passwordField_1.setEchoChar('*');
				}
			}
		});

		JButton btnNewButton_1_1 = new JButton("Iniciar Sesion");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame login = new login();
				login.setVisible(true);
				register.setVisible(false);
			}
		});
		btnNewButton_1_1.setBounds(108, 550, 150, 23);
		contentPane.add(btnNewButton_1_1);
		rdbtnNewRadioButton.setBounds(367, 446, 150, 23);
		rdbtnNewRadioButton.setOpaque(false);
		contentPane.add(rdbtnNewRadioButton);

		btnNewButton_1.setBounds(367, 550, 150, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(70, 100, 134, 14);
		contentPane.add(lblNewLabel);

		Usuario = new JTextField();
		Usuario.setBounds(367, 100, 150, 20);
		contentPane.add(Usuario);
		Usuario.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Correo electronico");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(70, 200, 150, 14);
		contentPane.add(lblNewLabel_1);

		Correoelectronico = new JTextField();
		Correoelectronico.setBounds(367, 200, 150, 20);
		contentPane.add(Correoelectronico);
		Correoelectronico.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(70, 301, 134, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Repetir Contraseña");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(70, 400, 188, 14);
		contentPane.add(lblNewLabel_2_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(367, 300, 150, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(367, 400, 150, 20);
		contentPane.add(passwordField_1);

		JLabel lblNewLabel_3 = new JLabel("Pulsa arriba si ya estas registrado");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(70, 595, 200, 27);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("FORMULARIO DE REGISTRO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(187, 36, 473, 14);
		contentPane.add(lblNewLabel_4);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar nombre?");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(367, 127, 150, 23);
		contentPane.add(chckbxNewCheckBox);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(registro.class.getResource("/login/gato.jpg")));
		lblNewLabel_5.setBounds(-92, 0, 770, 757);
		contentPane.add(lblNewLabel_5);

	}
}
