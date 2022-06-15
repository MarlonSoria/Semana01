package manejoString;

public class Demo2 {

	public static void main(String[] args) {
		String texto ="Programar es lo maximo";
		//           0123
		//metoos principales de la clase de String
		
		//requirimientos
		
		//cantidad de caracteres 
		System.out.println("Cantidad de caracteres: "+texto.length());
		System.out.println("Caracter de la posicion 5: "+texto.charAt(5));
		System.out.println("El texto inicia con la letra A: "+texto.startsWith("A"));
		System.out.println("El texto inicia con la letra o: "+texto.endsWith("o"));
		System.out.println("El texto en mayuscula: "+texto.toUpperCase());
		System.out.println("El texto en mayuscula: "+texto.toLowerCase());
		System.out.println("la vocal a --> e " +texto.replace("a","e"));
		System.out.println("Texto sin espacio: " +texto.trim());
		
		//
		

	}

}
