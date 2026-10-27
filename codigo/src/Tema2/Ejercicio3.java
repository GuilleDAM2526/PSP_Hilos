//Crea dos hilos diferentes.
//
//Hilo A
//Mostrará los números del 1 al 10.
//
//Hilo B
//Mostrará las letras desde la A hasta la J.
//
//Ejecuta ambos hilos desde el método principal.
//
//Requisitos
//•	Crear dos hilos independientes.
//•	Lanzar ambos mediante start().
//•	Observar la salida obtenida en consola.
//
//Cuestiones
//1.	¿Aparecen siempre primero los números y después las letras?
//¿Ocurren siempre las mismas salidas?
//
//Ejecuta el programa varias veces y compara el resultado.
package Tema2;
public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloNumeros1 a = new HiloNumeros1();
		HiloLetras1 b = new HiloLetras1();
		a.start();
		b.start();
	}
}

class HiloNumeros1 extends Thread {
	@Override
    public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Número: " + i);
		}
	}
}

class HiloLetras1 extends Thread {
	@Override
    public void run() {
		for (char z = 'A'; z <= 'J'; z++) {
			System.out.println("Letra: " + z);
		}
	}
}