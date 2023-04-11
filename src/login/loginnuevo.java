package login;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseMotionAdapter;

public class loginnuevo extends JFrame {

	private JPanel contentPane;
	static loginnuevo login;
	private JTextField usuariotxt;
	private JPasswordField passwordField;
	private Usuario user = new Usuario();
	
	private int xMouse,yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login  = new loginnuevo();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the frame.
	 */
	public loginnuevo() {
		setUndecorated(true);
		setResizable(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				login.setLocation(x- xMouse,y- yMouse);
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(loginnuevo.class.getResource("/login/polar-bear-2043.png")));
		setTitle("INICIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 906, 547);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		
		header.setBackground(Color.BLACK);
		header.setBounds(0, 0, 906, 43);
		panel.add(header);
		header.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(Color.red);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(Color.black);
			}
		});
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 43, 43);
		header.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 0, 43, 43);
		panel_2.add(lblNewLabel_3);
		
		JLabel fondo = new JLabel("");
		fondo.setForeground(Color.WHITE);
		fondo.setBounds(545, 0, 361, 548);
		fondo.setIcon(new ImageIcon(registro.class.getResource("/login/giphy.gif")));
		panel.add(fondo);
		
		JLabel lblNewLabel = new JLabel("iniciar sesión");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Star Jedi Logo DoubleLine1", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(99, 54, 212, 75);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("usuario");
		lblNewLabel_1.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(99, 140, 189, 14);
		panel.add(lblNewLabel_1);
		
		usuariotxt = new JTextField();
		usuariotxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(usuariotxt.getText().equals("Ingrese su usuario")) {
					usuariotxt.setText("");
					usuariotxt.setForeground(Color.white);
				}
				
				if(passwordField.getText().isEmpty()  ) {
					passwordField.setText("********");
					passwordField.setForeground(Color.gray);
				}
				
			}
		});
		usuariotxt.setFont(new Font("Arial", Font.PLAIN, 15));
		usuariotxt.setText("Ingrese su usuario");
		usuariotxt.setForeground(Color.GRAY);
		usuariotxt.setBackground(Color.BLACK);
		usuariotxt.setBorder(null);
		usuariotxt.setToolTipText("");
		usuariotxt.setBounds(99, 193, 395, 20);
		panel.add(usuariotxt);
		usuariotxt.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 224, 395, 7);
		panel.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(99, 270, 189, 14);
		panel.add(lblNewLabel_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(99, 344, 395, 7);
		panel.add(separator_1);
		
		JPanel botonlogin = new JPanel();
		botonlogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String r_icono = "/login/icono.gif";
				ImageIcon icono = new ImageIcon(getClass().getResource(r_icono));
				
				/*
				if (user.comparardatos(usuariotxt.getText(), passwordField.getText())==1) {
					JOptionPane.showMessageDialog(login, "Logueado correctamente", "LOGIN",
							JOptionPane.INFORMATION_MESSAGE,icono);
					JFrame welcome = new welcomenuevo();
					welcome.setVisible(true);
					login.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(login, "Problemas en usuario ,contraseña y/o tipo", "ERROR",
							JOptionPane.ERROR_MESSAGE);		
				}	
				
				*/
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				botonlogin.setBackground(Color.gray);
				botonlogin.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonlogin.setBackground(Color.white);
				botonlogin.setForeground(Color.black);
			}
		});
		botonlogin.setBounds(375, 434, 119, 38);
		panel.add(botonlogin);
		botonlogin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(44, 11, 129, 14);
		botonlogin.add(lblNewLabel_2);
		
		JRadioButton botonContraseña = new JRadioButton("Mostrar contraseña");
		botonContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if(botonContraseña.isSelected()== true) {
					 passwordField.setEchoChar((char) 0);
					 passwordField.setEchoChar((char)0);

	                }else {
	                	passwordField.setEchoChar('*');        
	                }
			}
		});
		botonContraseña.setForeground(Color.WHITE);
		botonContraseña.setOpaque(false);
		botonContraseña.setBorder(null);
		botonContraseña.setBounds(96, 358, 152, 23);
		panel.add(botonContraseña);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(passwordField.getText().equals("********")) {
					passwordField.setText("");
					passwordField.setForeground(Color.white);
					
				}
				
				if(usuariotxt.getText().isEmpty()) {
					usuariotxt.setText("Ingrese su usuario");
					usuariotxt.setForeground(Color.gray);
				}
				
			}
		});
		passwordField.setBorder(null);
		passwordField.setEchoChar('*');
		passwordField.setText("********");
		passwordField.setForeground(Color.GRAY);
		passwordField.setOpaque(false);
		passwordField.setBounds(99, 313, 395, 20);
		panel.add(passwordField);
		
		
	
		
		
	}
}
