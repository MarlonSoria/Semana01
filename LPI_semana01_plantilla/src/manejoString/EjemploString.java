package manejoString;

public class EjemploString {

	public static void main(String[] args) {
		
		
		String texto = "a001;  Juancito ;  Pando  ;12;05;LP1";
		
		// Separar los textos en código, nombre, apellido, nota1, nota2 y curso
		//Asignar valores a unas variables
		String separador[]=texto.split(";");
		String codigo =separador[0];
		String nombre =separador[1].trim().toLowerCase();
		String apellido =separador[2];
		int nota1 = Integer.parseInt(separador[3]);
		int nota2 = Integer.parseInt(separador[4]);
		String curso =separador[5].trim();
		//bucle para el recorrido
		for (String s : separador) {
			System.out.println(s.trim());
		}
		
		
		// Convertir el apellido a mayúscula y el nombre el minúscula
		System.out.println("Apellidos :"+ apellido.toUpperCase());
		System.out.println("Nombre :"+ nombre.toLowerCase());
		
		
		// Validar que el curso sea LP1
		if(curso.equalsIgnoreCase("LP1")){
			System.out.println("Curso correcto :"+curso);
		}else{
			System.out.println("Error en el curso");
		}
		
		// Validar que el código empiece con la letras “a” o “p”
		if(codigo.startsWith("A")|| codigo.startsWith("P")){
			System.out.println("Codigo Correcto");
		}else{
			System.out.println("Codigo no valido");
		}
		
		// validar que el tamaño del código sea 4
		if(codigo.length()==4){
			System.out.println("Codigo valido");
		}else{
			System.out.println("Error en el formato de codigo");
		}
		// Generar un correo con el siguiente formato: 1° letra del nombre + parte numérica del código + @cibertec.pe. Ej.  j001@cibertec.pe
		char primerComponente =nombre.charAt(0);
		String segundoComponente = codigo.substring(1);
		System.out.println(primerComponente + segundoComponente +"@cibertec.edu.pe");
		// Mostrar los datos

		
	}

	



	

}
