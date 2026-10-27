//Crea una clase denominada  Ejercicio2 que herede de Thread.
//
//Cuando se ejecute deberá mostrar por pantalla el siguiente mensaje:
//
//Hola desde mi primer hilo
//
//Requisitos
//•	Heredar de la clase Thread.
//•	Definir la tarea que ejecutará el hilo. Crear la función run.
//•	Arrancar el hilo desde el método main().
//
//Cuestiones
//1.	¿Qué método contiene el código que ejecuta el hilo?
//¿Qué método debe utilizarse para ponerlo en marcha?
//
//Pista
//Un hilo necesita definir qué trabajo realizará y después ser iniciado desde el programa principal.

package Tema2;

public class Ejercicio2 extends Thread {
	@Override
	public void run() {
		System.out.println("Hola desde mi primer hilo");
	}
	public static void main(String[] args) {
		Ejercicio2 hilo = new Ejercicio2();
		hilo.start();
	}
	


}
