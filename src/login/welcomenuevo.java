package login;

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

public class welcomenuevo extends JFrame {

	private JPanel contentPane;
	static welcomenuevo welcome;
	private Usuario user = new Usuario();

	private int xMouse, yMouse;
	private JTable tabla;
	private JTable table;
	private JTable table_1;

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

		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(0, 0, 906, 548);
		panel.add(panel_3);
		panel_3.setLayout(null);

		table_1 = new JTable();
		table_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table_1.setBounds(51, 169, 495, 336);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"id", "Nombre", "Planeta", "Raza", "Edad"},
				{new Integer(1), "Darth Vader", "Desconocido", "Humano", "46"},
				{new Integer(2), "Emperador Palpatine", "Naboo", "Humano", null},
				{new Integer(3), "Kylo Ren", "Desconocido", "Humano", "29"},
				{new Integer(4), "Darth Maul", "Dathomir", "Zabrak", null},
				{new Integer(5), "Asajj Ventress", "Dathomir", "Dathomirian", null},
				{new Integer(6), "Count Dooku", "Serenno", "Humano", null},
				{new Integer(7), "General Grievous", "Kalee", "Kaleesh", null},
				{new Integer(8), "Boba Fett", "Kamino", "Humano", "33"},
				{new Integer(9), "Jango Fett", "Concord Dawn", "Humano", null},
				{new Integer(10), "Director Krennic", "Fresia", "Humano", null},
				{new Integer(11), "Galen Erso", "Coruscant", "Humano", null},
				{new Integer(12), "Snoke", "Desconocido", "Desconocido", null},
				{new Integer(13), "Grand Moff Tarkin", "Eriadu", "Humano", null},
				{new Integer(14), "Admiral Piett", "Desconocido", "Humano", null},
				{new Integer(15), "Supreme Leader Snoke", "Desconocido", "Desconocido", null},
				{new Integer(16), "Darth Sidious", "Naboo", "Humano", null},
				{new Integer(17), "General Hux", "Arkanis", "Humano", null},
				{new Integer(18), "Darth Bane", "Apatros", "Humano", null},
				{new Integer(19), "General Hux", "Arkanis", "Humano", null},
				{new Integer(20), "Savage Opress", "Dathomir", "Dathomirian", null},
			},
			new String[] {
				"id", "Nombre", "Planeta", "Raza", "Edad"
			}
		));
		panel_3.add(table_1);

		JLabel lblPersonajesOscuros = new JLabel("personajes oscuros");
		lblPersonajesOscuros.setForeground(Color.WHITE);
		lblPersonajesOscuros.setFont(new Font("Star Jedi", Font.PLAIN, 22));
		lblPersonajesOscuros.setBounds(143, 79, 322, 69);
		panel_3.add(lblPersonajesOscuros);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new CompoundBorder());
		panel_4.setVisible(false);
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(0, 0, 906, 548);
		panel.add(panel_4);
		panel_4.setLayout(null);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setBounds(34, 182, 495, 336);
		table.setModel(user.rellenarTablapersonajesl());
		panel_4.add(table);

		JLabel lblNewLabel = new JLabel("personajes luminosos");
		lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(139, 102, 322, 69);
		panel_4.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
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
				panel_4.setVisible(true);
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

		// Agregar JTable al JFrame
		tabla = new JTable();
		tabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabla.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "NAME" }));
		tabla.setBounds(254, 336, 388, 116);
		tabla.setModel(user.rellenarTablapersonajesl());
		panel_1.add(tabla);

	}
}
