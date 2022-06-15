package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Producto;
import validaciones.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmRegProd extends JInternalFrame implements KeyListener{
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox cboTipo;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	//Intanciar un objeto para establecer la estructura de la tabla
	DefaultTableModel model =new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProd frame = new FrmRegProd();
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
	public FrmRegProd() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 506, 350);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(21, 45, 84, 14);
		getContentPane().add(label);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(102, 42, 86, 20);
		getContentPane().add(txtCodigo);

		JLabel label_1 = new JLabel("Producto:");
		label_1.setBounds(21, 70, 75, 14);
		getContentPane().add(label_1);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(102, 67, 86, 20);
		getContentPane().add(txtProducto);

		JLabel label_2 = new JLabel("Tipo:");
		label_2.setBounds(21, 95, 53, 14);
		getContentPane().add(label_2);

		cboTipo = new JComboBox();
		cboTipo.setBounds(85, 92, 123, 20);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione tipo", "Pastillas", "Jarabe", "Otros" }));
		getContentPane().add(cboTipo);

		JLabel label_3 = new JLabel("Cantidad:");
		label_3.setBounds(21, 120, 49, 14);
		getContentPane().add(label_3);

		txtCantidad = new JTextField();
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(95, 117, 53, 20);
		getContentPane().add(txtCantidad);

		JLabel label_4 = new JLabel("Precio:");
		label_4.setBounds(162, 120, 46, 14);
		getContentPane().add(label_4);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(218, 117, 60, 20);
		getContentPane().add(txtPrecio);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FrmRegProd.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(328, 13, 116, 34);
		getContentPane().add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(FrmRegProd.class.getResource("/img/abrir.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnGuardar.setBounds(328, 63, 116, 34);
		getContentPane().add(btnGuardar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmRegProd.class.getResource("/img/cerrar.png")));
		btnCerrar.setBounds(328, 112, 116, 34);
		getContentPane().add(btnCerrar);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(21, 13, 224, 20);
		getContentPane().add(lblMantenimientoDeProductos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 470, 154);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);
		tblProductos.setFillsViewportHeight(true);
		//determinar las columnas de las tablas
		model.addColumn("Codigo");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		//Asignar modelo a la tabla
		tblProductos.setModel(model);

	}

	void ingresar() {
		String cod, prod;
		int cant;
		double pre;
		int tipo;

		cod  = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre  = leerPrecio();
		tipo = leerTipo();
		
		if(pre == -1 || cant== -1 || tipo== 0 || prod==null || cod==null){
			//mostrar ventana Error
			return;
		}else{
		
         //mostar datos en la tabla
		Object fila[]={cod,prod,cant,pre};
		model.addRow(fila);
		}
	}

	private String leerCodigo() {
		//Formato de codigo P0001/p001
		String cod=null;
		if(txtCodigo.getText().trim().length()==0){
			mensajeError("Ingresar el codigo");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			cod=null;
		}else if (txtCodigo.getText().trim().matches(Validaciones.CODIGO_PRODUCTO)){
			cod = txtCodigo.getText().trim();
		}else{
			mensajeError("Formato de codigo no valido. Ej.P0001 o p0001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			cod=null;
		}
		return cod;
	}

	String leerProducto() {
		//validar ingresar carecteres 3-15
		String prod = null;
		if(txtProducto.getText().trim().length()==0){
			mensajeError("Ingresar el Producto");
			txtProducto.setText("");
			txtProducto.requestFocus();
			prod = null;
		}else if(txtProducto.getText().trim().matches(Validaciones.TEXTO)){
			prod = txtProducto.getText();	
		}else{
			mensajeError("Producto no valido");
			txtProducto.setText("");
			txtProducto.requestFocus();
			prod=null;
		}
		return prod;
	}
	
	int leerTipo() {
		int tipo;
		tipo =cboTipo.getSelectedIndex();
		if(tipo == 0){
			mensajeError("Seleccionar el tipo de Producto");
		}
		return tipo;
	}

	int leerCantidad() {
		int cant = -1;
		if(txtCantidad.getText().trim().length()==0){ //caja de texto vacia
			mensajeError("Ingresar la cantidad del producto");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
		}else{
			try{
				cant =Integer.parseInt(txtCantidad.getText());
				if(cant <= 0){
					mensajeError("Ingresar valor mayor a 0");
					txtCantidad.setText("");
					txtCantidad.requestFocus();
					cant = -1;
				}
			}catch(NumberFormatException e){
				mensajeError("Ingresar valores Numericos");
				txtCantidad.setText("");
				txtCantidad.requestFocus();
				txtCantidad.setBackground(Color.RED);
			}
		}
		return cant;
	}

	double leerPrecio() {
		double pre = -1;
		if(txtPrecio.getText().length()==0){
			mensajeError("Ingresar el Precio del Producto");
			txtPrecio.requestFocus();
		}else{
			try {
				pre = Double.parseDouble(txtPrecio.getText());
				if(pre <= 0){
					mensajeError("Ingresar un precio mayor a 0");
					txtPrecio.setText("");
					txtPrecio.requestFocus();
					pre = -1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingresar valores numericos");
				txtPrecio.setText("");
				txtPrecio.requestFocus();
				txtPrecio.setBackground(Color.RED);
			}
		}
		return pre;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error!!!",0);
		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtPrecio) {
			keyReleasedTxtPrecio(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtPrecio(KeyEvent arg0) {
		txtPrecio.setBackground(Color.WHITE);		
	}
}
