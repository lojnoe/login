package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class welcomenuevo extends JFrame {

	private JPanel contentPane;
	static welcomenuevo welcome;
	private loginnuevo login = new loginnuevo();
	private Usuario user = new Usuario();

	private int xMouse, yMouse;
	private JTable table;
	private JTable table_1;
	private JTextField id;
	private JTextField nombre;
	private JTextField idluminoso;
	private JTextField nombreluminoso;
	JPanel panel_3 = new JPanel();
	JPanel panel_4_1_1 = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_4 = new JPanel();
	private JTable table_2;
	private JTextField nombreusuario;
	private JTextField contraseñausuario;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome = new welcomenuevo();
					welcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public welcomenuevo() {
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
				welcome.setLocation(x - xMouse, y - yMouse);
			}
		});

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(welcomenuevo.class.getResource("/login/polar-bear-2043.png")));
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

		panel_4_1_1.setBorder(new CompoundBorder());
		panel_4_1_1.setVisible(false);

		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 42, 906, 506);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblBienvenido_1 = new JLabel("bienvenido");
		lblBienvenido_1.setForeground(Color.WHITE);
		lblBienvenido_1.setFont(new Font("Star Jedi", Font.PLAIN, 26));
		lblBienvenido_1.setBounds(340, 11, 208, 77);
		panel_1.add(lblBienvenido_1);

		JLabel lblEligeBando = new JLabel("- elige bando -");
		lblEligeBando.setForeground(Color.WHITE);
		lblEligeBando.setFont(new Font("Star Jedi", Font.PLAIN, 26));
		lblEligeBando.setBounds(322, 212, 277, 77);
		panel_1.add(lblEligeBando);

		JLabel lblNewLabel_1_2 = new JLabel("$");
		lblNewLabel_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel_4_1_1.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1_2.setForeground(Color.gray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1_2.setForeground(Color.white);
			}
		});
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Star Jedi", Font.PLAIN, 99));
		lblNewLabel_1_2.setBounds(607, 0, 299, 506);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("#");
		lblNewLabel_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panel_1.setVisible(false);
				panel_3.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1_1_1.setForeground(Color.gray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1_1_1.setForeground(Color.white);
			}
		});
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Star Jedi", Font.PLAIN, 99));
		lblNewLabel_1_1_1.setBounds(0, 0, 300, 506);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("quieres iniciar sesion con otra cuenta?");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				welcome.setVisible(false);
				login.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.gray);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.white);

			}
		});
		lblNewLabel_2.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(322, 413, 277, 14);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("ver usuarios registrados");
		lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(true);
				panel_1.setVisible(false);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2_1.setForeground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2_1.setForeground(Color.white);
			}
		});
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Star Jedi", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(322, 438, 277, 14);
		panel_1.add(lblNewLabel_2_1);
		panel_4_1_1.setBackground(Color.BLACK);
		panel_4_1_1.setBounds(0, 0, 906, 548);
		panel.add(panel_4_1_1);
		panel_4_1_1.setLayout(null);

		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setBounds(34, 182, 495, 336);
		table.setModel(user.rellenarTablapersonajesl());
		panel_4_1_1.add(table);

		idluminoso = new JTextField();
		idluminoso.setColumns(10);
		idluminoso.setBounds(701, 166, 109, 20);
		panel_4_1_1.add(idluminoso);

		JLabel lblNewLabel_1_3_1 = new JLabel("id");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Star Jedi", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(701, 136, 86, 14);
		panel_4_1_1.add(lblNewLabel_1_3_1);

		JButton boton_1 = new JButton("Comprobar");
		boton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (user.comparardatospersonajes(id.getText(), nombre.getText()) == 1) {
					JOptionPane.showMessageDialog(welcome, "Se encuentra en la tabla", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(welcome, "No se encuentra en la tabla", "Informacion",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		boton_1.setBounds(701, 364, 109, 23);
		panel_4_1_1.add(boton_1);

		JLabel lblNewLabel = new JLabel("personajes luminosos");
		lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(35, 123, 322, 69);
		panel_4_1_1.add(lblNewLabel);

		JButton btnBorrar_1 = new JButton("Borrar");
		btnBorrar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (user.comparardatospersonajes(id.getText(), nombre.getText()) == 1) {
					user.borrarDatosPersonajes(id.getText(), nombre.getText());
					JOptionPane.showMessageDialog(welcome, "Eliminado correctamente", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
					table.setModel(user.rellenarTablapersonajes());
				} else {
					JOptionPane.showMessageDialog(welcome, "No se ha podido realizar la operacion", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBorrar_1.setBounds(701, 429, 109, 23);
		panel_4_1_1.add(btnBorrar_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("nombre");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Star Jedi", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(701, 230, 109, 14);
		panel_4_1_1.add(lblNewLabel_1_1_2);

		nombreluminoso = new JTextField();
		nombreluminoso.setColumns(10);
		nombreluminoso.setBounds(701, 255, 109, 20);
		panel_4_1_1.add(nombreluminoso);

		JLabel lblNewLabel_3_1 = new JLabel("X");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(0, 0, 43, 43);
		panel_4_1_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel(" ←");
		lblNewLabel_3_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(true);
				panel_4_1_1.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3_2.setForeground(Color.gray);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3_2.setForeground(Color.white);

			}
		});
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(0, 42, 43, 43);
		panel_4_1_1.add(lblNewLabel_3_2);

		panel_3.setVisible(false);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(0, 0, 906, 548);
		panel.add(panel_3);
		panel_3.setLayout(null);

		table_1 = new JTable();
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(Color.BLACK);
		table_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table_1.setBounds(51, 169, 495, 336);
		table_1.setModel(user.rellenarTablapersonajes());
		panel_3.add(table_1);

		JLabel lblNewLabel_3_2_1 = new JLabel(" ←");
		lblNewLabel_3_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(true);
				panel_3.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3_2_1.setForeground(Color.gray);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3_2_1.setForeground(Color.white);

			}
		});
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_2_1.setBounds(0, 42, 43, 43);
		panel_3.add(lblNewLabel_3_2_1);

		JLabel lblPersonajesOscuros = new JLabel("personajes oscuros");
		lblPersonajesOscuros.setForeground(Color.WHITE);
		lblPersonajesOscuros.setFont(new Font("Star Jedi", Font.PLAIN, 22));
		lblPersonajesOscuros.setBounds(51, 105, 322, 69);
		panel_3.add(lblPersonajesOscuros);
		setLocationRelativeTo(table_1);

		id = new JTextField();
		id.setBounds(701, 166, 109, 20);
		panel_3.add(id);
		id.setColumns(10);

		nombre = new JTextField();
		nombre.setBounds(701, 255, 109, 20);
		panel_3.add(nombre);
		nombre.setColumns(10);

		JButton boton = new JButton("Comprobar");
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (user.comparardatospersonajes(id.getText(), nombre.getText()) == 1) {
					JOptionPane.showMessageDialog(welcome, "Se encuentra en la tabla", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(welcome, "No se encuentra en la tabla", "Informacion",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		boton.setBounds(701, 364, 109, 23);
		panel_3.add(boton);

		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setFont(new Font("Star Jedi", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(701, 136, 86, 14);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("nombre");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Star Jedi", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(701, 230, 109, 14);
		panel_3.add(lblNewLabel_1_1);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (user.comparardatospersonajes(id.getText(), nombre.getText()) == 1) {
					user.borrarDatosPersonajes(id.getText(), nombre.getText());
					JOptionPane.showMessageDialog(welcome, "Eliminado correctamente", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
					table_1.setModel(user.rellenarTablapersonajes());
				} else {
					JOptionPane.showMessageDialog(welcome, "No se ha podido realizar la operacion", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnBorrar.setBounds(701, 429, 109, 23);
		panel_3.add(btnBorrar);
		panel_4.setVisible(false);
		panel_4.setBackground(Color.BLACK);
		panel_4.setForeground(Color.WHITE);

		panel_4.setBounds(0, 0, 906, 548);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblUsuarios = new JLabel("usuarios");
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Star Jedi", Font.PLAIN, 22));
		lblUsuarios.setBounds(50, 105, 322, 69);
		panel_4.add(lblUsuarios);

		table_2 = new JTable();
		table_2.setForeground(Color.WHITE);
		table_2.setBackground(Color.BLACK);
		table_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table_2.setBounds(33, 185, 495, 336);
		table_2.setModel(user.rellenarTabla());
		panel_4.add(table_2);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("nombre");
		lblNewLabel_1_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1_1.setFont(new Font("Star Jedi", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1.setBounds(700, 138, 86, 14);
		panel_4.add(lblNewLabel_1_3_1_1);

		nombreusuario = new JTextField();
		nombreusuario.setColumns(10);
		nombreusuario.setBounds(700, 163, 109, 20);
		panel_4.add(nombreusuario);

		JButton boton_1_1 = new JButton("Comprobar");
		boton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (user.comparardatos(nombreusuario.getText(), contraseñausuario.getText()) == 1) {
					JOptionPane.showMessageDialog(welcome, "Se encuentra en la tabla", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(welcome, "No se encuentra en la tabla", "Informacion",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		boton_1_1.setBounds(700, 365, 109, 23);
		panel_4.add(boton_1_1);

		JButton btnBorrar_1_1 = new JButton("Borrar");
		btnBorrar_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (user.comparardatos(nombreusuario.getText(), contraseñausuario.getText()) == 1) {
					user.borrarDatos(nombreusuario.getText(), contraseñausuario.getText());
					JOptionPane.showMessageDialog(welcome, "Eliminado correctamente", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
					table_2.setModel(user.rellenarTabla());
				} else {
					JOptionPane.showMessageDialog(welcome, "No se ha podido realizar la operacion", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnBorrar_1_1.setBounds(700, 429, 109, 23);
		panel_4.add(btnBorrar_1_1);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("contraseña");
		lblNewLabel_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_2_1.setFont(new Font("Star Jedi", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1.setBounds(700, 229, 109, 14);
		panel_4.add(lblNewLabel_1_1_2_1);

		contraseñausuario = new JTextField();
		contraseñausuario.setColumns(10);
		contraseñausuario.setBounds(700, 259, 109, 20);
		panel_4.add(contraseñausuario);

		JLabel lblNewLabel_3_2_1_1 = new JLabel(" ←");
		lblNewLabel_3_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(false);
				panel_1.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3_2_1_1.setForeground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3_2_1_1.setForeground(Color.white);
			}
		});
		lblNewLabel_3_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_2_1_1.setBounds(0, 44, 43, 43);
		panel_4.add(lblNewLabel_3_2_1_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}
