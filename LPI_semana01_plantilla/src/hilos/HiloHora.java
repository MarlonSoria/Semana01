package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import vista.FrmPrincipal;

public class HiloHora extends Thread {
	@Override
	public void run() {
		while (true) {
			Date hora = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			FrmPrincipal.lblHora.setText(sdf.format(hora));
			// mostrar en consola
			//System.out.println(sdf.format(hora));
		}
	}

}
