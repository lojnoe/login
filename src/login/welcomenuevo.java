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

public class welcomenuevo extends JFrame {

	private JPanel contentPane;
	static welcomenuevo welcome;
	private Usuario user = new Usuario();
	
	private int xMouse,yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome  = new welcomenuevo();
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
				welcome.setLocation(x- xMouse,y- yMouse);
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(welcomenuevo.class.getResource("/login/polar-bear-2043.png")));
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setVisible(false);
		panel_4.setBounds(0, 0, 906, 548);
		panel.add(panel_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("$");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Star Jedi", Font.PLAIN, 99));
		lblNewLabel_1_2.setBounds(607, 0, 299, 506);
		panel_1.add(lblNewLabel_1_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setVisible(false);
		panel_3.setBounds(0, 0, 906, 548);
		panel.add(panel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("#");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panel_1.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Star Jedi", Font.PLAIN, 99));
		lblNewLabel_1_1_1.setBounds(0, 0, 300, 506);
		panel_1.add(lblNewLabel_1_1_1);
		
		
		
		
	
		
		
	}
}
