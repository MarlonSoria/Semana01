package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloTiempo;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


public class Logueo extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JLabel lblTexto;
	public static JLabel lblTiempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
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
	public Logueo() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/avatar.png")));
		setTitle("CIBERFARMA - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(114, 36, 96, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(114, 83, 96, 20);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 36, 103, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(205, 80, 103, 20);
		contentPane.add(txtClave);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(114, 116, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setEnabled(false);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(226, 116, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/avatar.png")));
		lblFondo.setBounds(0, 11, 127, 184);
		contentPane.add(lblFondo);
		
		lblTexto = new JLabel("Esta ventana se cerrara en\r\n");
		lblTexto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		lblTexto.setBounds(73, 11, 127, 14);
		contentPane.add(lblTexto);
		
		lblTiempo = new JLabel("10 segundos");
		lblTiempo.setBounds(205, 11, 74, 14);
		contentPane.add(lblTiempo);
		//constructor
		//iniciarConteo();
		
	}
	private void iniciarConteo(){
		//llamar al proceso
		HiloTiempo h= new HiloTiempo();
		//inicia el proceso
		h.start();
		
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowOpenedThis(arg0);
		}
	}
	protected void windowOpenedThis(WindowEvent arg0) {
		iniciarConteo();
		
	}
}
