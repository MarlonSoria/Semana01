package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hilos.HiloHora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JMenu mnReportes;
	private JMenuItem mntmVentas;
	private JMenuItem mntmUsuarios;
	private JDesktopPane escritorio;
	public static JLabel lblHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		try {
			//Seleccionar el diseño a trabajar
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 374);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/3069182_device_business_computer_technology_office_icon (1).png")));
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/1312510_circle_off_on_style_turn_icon (1).png")));
		mnSistema.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/7239029_basic_maintenance_settings_control_options_icon (1).png")));
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/1564535_customer_user_userphoto_account_person_icon.png")));
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/4172394_goods_merchandise_stock_supply_vendibles_icon.png")));
		mnMantenimiento.add(mntmProductos);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2530827_general_inkjet printer_office_paper printer_print_icon.png")));
		menuBar.add(mnReportes);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/49615_reports_report_documents_icon.png")));
		mnReportes.add(mntmVentas);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/5340287_man_people_person_user_users_icon.png")));
		mnReportes.add(mntmUsuarios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(SystemColor.textHighlight);
		contentPane.add(escritorio, BorderLayout.CENTER);
		
		lblHora = new JLabel("00:00:00");
		lblHora.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblHora.setForeground(Color.WHITE);
		lblHora.setBounds(452, 38, 96, 33);
		escritorio.add(lblHora);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmProductos) {
			actionPerformedMntmProductos(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		//salir de la aplicacion 
		//dispose(); //cierra una ventana
		System.exit(0);//cierra la palicacion
	}
	protected void actionPerformedMntmProductos(ActionEvent arg0) {
		//Instancia
		FrmRegProd prod=new FrmRegProd();
		prod.setVisible(true);
		escritorio.add(prod);
		
	}
	private void mostrarHora(){
		//llamar al proceso 
		HiloHora hora = new HiloHora();
		//ejecutar proceso
		hora.start();
		
		}
	}


