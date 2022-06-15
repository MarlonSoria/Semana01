package manejoString;

public class Demo1 {

	public static void main(String[] args) {
		String user = "Nando Jose";
		String user1= "Nando";
		
		//Comparando direccion de memoria 
		if(user == user1)
			System.out.println("iguale Direccion de Memoria");
		else 
			System.out.println("Diferente Direccion de memoria");
		
		//Comparar texto 
		if(user.equals(user1))
			System.out.println("igual contenido");
		else
			System.out.println("Diferente contenido");

	}

}
