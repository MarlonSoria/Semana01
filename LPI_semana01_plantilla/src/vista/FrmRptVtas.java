package vista;

import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmRptVtas extends JFrame implements ActionListener {
	private JLabel lblFechaActual;
	private JLabel lblDel;
	private JTextField txtFechaActual;
	private JDateChooser dcFecha;
	private JScrollPane scrollPane;
	private JButton btnReporte;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRptVtas frame = new FrmRptVtas();
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
	public FrmRptVtas() {
		setBounds(100, 100, 450, 412);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte de Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 215, 37);
		getContentPane().add(lblNewLabel);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(302, 60, 89, 23);
		getContentPane().add(btnReporte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 161, 389, 201);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblFechaActual = new JLabel("Fecha Actual:");
		lblFechaActual.setBounds(10, 64, 81, 14);
		getContentPane().add(lblFechaActual);
		
		lblDel = new JLabel("Fecha Fin:\r\n");
		lblDel.setBounds(10, 101, 52, 14);
		getContentPane().add(lblDel);
		
		txtFechaActual = new JTextField();
		txtFechaActual.setEnabled(false);
		txtFechaActual.setBounds(101, 61, 86, 20);
		getContentPane().add(txtFechaActual);
		txtFechaActual.setColumns(10);
		//asignar fecha actual
		txtFechaActual.setText(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(101, 101, 86, 20);
		getContentPane().add(dcFecha);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporte) {
			actionPerformedBtnReporte(arg0);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent arg0) {
		String fechAct,fechFin;
		fechAct = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		fechFin=getFechaFin();
		//mostrar
		txtS.setText("Fecha Actual : "+fechAct + "\n");
		txtS.append("Fecha Fin: "+fechFin);
		
	}

	private String getFechaFin() {
		return new SimpleDateFormat("yyyy/MM/dd").format(dcFecha.getDate()) ;
	}
}
