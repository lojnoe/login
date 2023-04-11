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
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollBar;

public class registronuevo extends JFrame {

	private JPanel contentPane;
	static registronuevo registro;
	private JTextField usuariotxt;
	private JPasswordField contraseñatxt;
	private Usuario user = new Usuario();

	private int xMouse, yMouse;
	private JTextField correotxt;
	private JPasswordField contraseñarepetirtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro = new registronuevo();
					registro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registronuevo() {
		setBackground(Color.BLACK);
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
				registro.setLocation(x - xMouse, y - yMouse);
			}
		});

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(registronuevo.class.getResource("/login/polar-bear-2043.png")));
		setTitle("INICIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 583);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 993, 583);
		contentPane.add(panel);
		panel.setLayout(null);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(99, 394, 395, 7);
		panel.add(separator_1_1);

		contraseñarepetirtxt = new JPasswordField();
		contraseñarepetirtxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (contraseñarepetirtxt.getText().equals("********")) {
					contraseñarepetirtxt.setText("");
					contraseñarepetirtxt.setForeground(Color.white);

				}

				if (usuariotxt.getText().isEmpty() || contraseñatxt.getText().isEmpty()
						|| correotxt.getText().isEmpty()) {
					correotxt.setText("Ingrese su correo electronico");
					correotxt.setForeground(Color.gray);
					contraseñatxt.setText("********");
					contraseñatxt.setForeground(Color.gray);
					usuariotxt.setText("Ingrese su usuario");
					usuariotxt.setForeground(Color.gray);
				}
			}
		});
		contraseñarepetirtxt.setText("********");
		contraseñarepetirtxt.setOpaque(false);
		contraseñarepetirtxt.setForeground(Color.GRAY);
		contraseñarepetirtxt.setEchoChar('*');
		contraseñarepetirtxt.setBorder(null);
		contraseñarepetirtxt.setBounds(99, 365, 395, 20);
		panel.add(contraseñarepetirtxt);

		JPanel header = new JPanel();

		header.setBackground(Color.BLACK);
		header.setBounds(0, 0, 993, 43);
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

		JLabel lblNewLabel_1_1_1 = new JLabel("repetir Contraseña");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(99, 337, 189, 14);
		panel.add(lblNewLabel_1_1_1);

		JLabel fondo = new JLabel("");
		fondo.setForeground(Color.WHITE);
		fondo.setBounds(632, 0, 361, 583);
		fondo.setIcon(new ImageIcon(registro.class.getResource("/login/giphy.gif")));
		panel.add(fondo);

		JLabel lblNewLabel = new JLabel("registro");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Star Jedi Logo DoubleLine1", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(99, 54, 212, 75);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("usuario");
		lblNewLabel_1.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(99, 115, 189, 14);
		panel.add(lblNewLabel_1);

		usuariotxt = new JTextField();
		usuariotxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (usuariotxt.getText().equals("Ingrese su usuario")) {
					usuariotxt.setText("");
					usuariotxt.setForeground(Color.white);
				}

				if (contraseñatxt.getText().isEmpty() || contraseñarepetirtxt.getText().isEmpty()
						|| correotxt.getText().isEmpty()) {
					correotxt.setText("Ingrese su correo electronico");
					correotxt.setForeground(Color.gray);
					contraseñarepetirtxt.setText("********");
					contraseñarepetirtxt.setForeground(Color.gray);
					contraseñatxt.setText("********");
					contraseñatxt.setForeground(Color.gray);
				}

			}
		});
		usuariotxt.setFont(new Font("Arial", Font.PLAIN, 15));
		usuariotxt.setText("Ingrese su usuario");
		usuariotxt.setForeground(Color.GRAY);
		usuariotxt.setBackground(Color.BLACK);
		usuariotxt.setBorder(null);
		usuariotxt.setToolTipText("");
		usuariotxt.setBounds(99, 140, 395, 20);
		panel.add(usuariotxt);
		usuariotxt.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("correo");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(99, 189, 172, 14);
		panel.add(lblNewLabel_1_2);

		correotxt = new JTextField();
		correotxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (correotxt.getText().equals("Ingrese su correo electronico")) {
					correotxt.setText("");
					correotxt.setForeground(Color.white);

				}

				if (usuariotxt.getText().isEmpty() || contraseñarepetirtxt.getText().isEmpty()
						|| contraseñatxt.getText().isEmpty()) {
					usuariotxt.setText("Ingrese su usuario");
					usuariotxt.setForeground(Color.gray);
					contraseñarepetirtxt.setText("********");
					contraseñarepetirtxt.setForeground(Color.gray);
					contraseñatxt.setText("********");
					contraseñatxt.setForeground(Color.gray);
				}

			}
		});
		correotxt.setToolTipText("");
		correotxt.setText("Ingrese su correo electronico");
		correotxt.setForeground(Color.GRAY);
		correotxt.setFont(new Font("Arial", Font.PLAIN, 15));
		correotxt.setColumns(10);
		correotxt.setBorder(null);
		correotxt.setBackground(Color.BLACK);
		correotxt.setBounds(99, 214, 395, 20);
		panel.add(correotxt);

		JSeparator separator = new JSeparator();
		separator.setBounds(99, 171, 395, 7);
		panel.add(separator);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(99, 245, 395, 7);
		panel.add(separator_2);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(99, 263, 189, 14);
		panel.add(lblNewLabel_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(99, 319, 395, 7);
		panel.add(separator_1);

		JPanel botonlogin = new JPanel();
		botonlogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String r_icono = "/login/icono.gif";
				ImageIcon icono = new ImageIcon(getClass().getResource(r_icono));
				if (user.comparardatos(usuariotxt.getText(), contraseñatxt.getText()) == 1) {
					JOptionPane.showMessageDialog(registro, "Logueado correctamente", "LOGIN",
							JOptionPane.INFORMATION_MESSAGE,icono);
					JFrame welcome = new welcomenuevo();
					welcome.setVisible(true);
					registro.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(registro, "Problemas en usuario ,contraseña y/o tipo", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
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
		botonlogin.setBounds(380, 495, 119, 38);
		panel.add(botonlogin);
		botonlogin.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("REGISTRAR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(0, 11, 129, 14);
		botonlogin.add(lblNewLabel_2);

		JRadioButton botonContraseña = new JRadioButton("Mostrar contraseña");
		botonContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonContraseña.isSelected() == true) {
					contraseñatxt.setEchoChar((char) 0);
					contraseñarepetirtxt.setEchoChar((char) 0);

				} else {

					contraseñatxt.setEchoChar('*');
					contraseñarepetirtxt.setEchoChar('*');
				}
			}

		});
		botonContraseña.setForeground(Color.WHITE);
		botonContraseña.setOpaque(false);
		botonContraseña.setBorder(null);
		botonContraseña.setBounds(99, 422, 152, 23);
		panel.add(botonContraseña);

		contraseñatxt = new JPasswordField();
		contraseñatxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (contraseñatxt.getText().equals("********")) {
					contraseñatxt.setText("");
					contraseñatxt.setForeground(Color.white);

				}

				if (usuariotxt.getText().isEmpty() || contraseñarepetirtxt.getText().isEmpty()
						|| correotxt.getText().isEmpty()) {
					correotxt.setText("Ingrese su correo electronico");
					correotxt.setForeground(Color.gray);
					contraseñarepetirtxt.setText("********");
					contraseñarepetirtxt.setForeground(Color.gray);
					usuariotxt.setText("Ingrese su usuario");
					usuariotxt.setForeground(Color.gray);
				}

			}
		});
		contraseñatxt.setBorder(null);
		contraseñatxt.setEchoChar('*');
		contraseñatxt.setText("********");
		contraseñatxt.setForeground(Color.GRAY);
		contraseñatxt.setOpaque(false);
		contraseñatxt.setBounds(99, 288, 395, 20);
		panel.add(contraseñatxt);

	}
}
