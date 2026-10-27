//Repite el ejercicio anterior utilizando la interfaz Runnable en lugar de heredar de Thread.
//Requisitos
//•	Crear una clase que implemente Runnable.
//•	Asociarla a un objeto de tipo Thread.
//•	Ejecutar la tarea.
//Cuestiones
//1.	¿Qué diferencias observas respecto al ejercicio anterior?
//¿Qué solución te parece más flexible?
//Pista
//Implementar Runnable no crea un hilo por sí mismo.


package Tema2;

class HiloNumeros implements Runnable {	// Define una tarea que puede ejecutar un hilo.
	@Override
    public void run() {					// Aquí se escribe el trabajo que realizará la tarea.
		for (int i = 1; i <= 10; i++) {
			System.out.println("Número: " + i);
		}
	}
}

class HiloLetras implements Runnable {	// Define otra tarea para ejecutar en un hilo.	
	@Override
    public void run() {
		for (char z = 'A'; z <= 'J'; z++) {
			System.out.println("Letra: " + z);
		}
	}
}
public class Ejercicio4 {
	public static void main(String[] args) {
		HiloNumeros tareaNumeros = new HiloNumeros(); 	// Crea la tarea que imprimirá los números.
		HiloLetras tareaLetras = new HiloLetras();		// Crea la tarea que imprimirá las letras.

	        // Asociamos las tareas a los hilos (Requisito: Asociarla a un objeto Thread)
	    Thread hilo1 = new Thread(tareaNumeros);		// Crea un hilo y le asigna la tarea a.
	    Thread hilo2 = new Thread(tareaLetras);			// Crea otro hilo y le asigna la tarea b.

	        // Ejecutamos la tarea
	    hilo1.start();
	    hilo2.start();
	}
}
