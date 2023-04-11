package login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private JPanel interfazlogin;
	private JPasswordField passwordField;
	private JTextField textField;
	static ArrayList<String> contraseña = new ArrayList<String>();
	static ArrayList<String> usuario = new ArrayList<String>();
	static login ventana;
	private Usuario user = new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana = new login();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 718);
		interfazlogin = new JPanel();
		interfazlogin.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(interfazlogin);
		interfazlogin.setLayout(null);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Mostrar contraseña");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if(rdbtnNewRadioButton.isSelected()== true) {
					 passwordField.setEchoChar((char) 0);
	                    
	                }else {
	                	passwordField.setEchoChar('*');
	                   
	                }
			}
		});
		rdbtnNewRadioButton.setBounds(367, 347, 150, 23);
		rdbtnNewRadioButton.setOpaque(false);
		interfazlogin.add(rdbtnNewRadioButton);
		
		textField = new JTextField();
		textField.setBounds(367, 100, 150, 20);
		interfazlogin.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(367, 300, 150, 20);
		interfazlogin.add(passwordField);
		
		JLabel Titulo = new JLabel("INICIO DE SESION");
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Titulo.setBounds(213, 11, 237, 82);
		interfazlogin.add(Titulo);
		
		JButton botonlogin = new JButton("LOGIN");
		botonlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (user.comparardatos(textField.getText(), passwordField.getText())==1) {
					JOptionPane.showMessageDialog(ventana, "Logueado correctamente", "LOGIN",
							JOptionPane.INFORMATION_MESSAGE);
					JFrame welcome = new welcome();
					welcome.setVisible(true);
					ventana.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(ventana, "Problemas en usuario ,contraseña y/o tipo", "LOGIN",
							JOptionPane.ERROR_MESSAGE);
				
				
				
				}		
			}
		});
		botonlogin.setBounds(273, 499, 89, 23);
		interfazlogin.add(botonlogin);
		
		JLabel Usuario = new JLabel("USUARIO");
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Usuario.setBounds(70, 100, 134, 14);
		interfazlogin.add(Usuario);
		
		JLabel Contrasena = new JLabel("CONTRASEÑA");
		Contrasena.setForeground(new Color(0, 0, 0));
		Contrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Contrasena.setBounds(70, 301, 134, 14);
		interfazlogin.add(Contrasena);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(registro.class.getResource("/login/gato.jpg")));
		fondo.setBounds(-92, 0, 770, 757);
		interfazlogin.add(fondo);
		
		
		
	}
}
