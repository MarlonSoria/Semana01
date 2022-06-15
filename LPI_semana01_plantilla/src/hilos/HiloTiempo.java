package hilos;

import vista.Logueo;

public class HiloTiempo extends Thread {
	@Override
	public void run() {
		for(int i=10; i >= 0; i-- ){
			//mostar el valor en la etiqueta
			Logueo.lblTiempo.setText(i+"s");
			//System.out.println(i);
			//pausa
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error en el hilo"+ e.getMessage());
			}
		}
		//cerrar ventana
		System.exit(0);
	}

}
