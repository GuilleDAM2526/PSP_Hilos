
//Todos los programas Java se ejecutan inicialmente mediante un hilo principal creado automáticamente por la JVM.
//Desarrolla una aplicación que muestre por pantalla el nombre del hilo que está ejecutando el método main().
//
//Requisitos
//Mostrar únicamente el nombre del hilo actual.
//Ejecutar el programa y comprobar el resultado.
//
//Cuestiones
//¿Cómo se llama el hilo que ejecuta el programa al iniciarse? 
//¿Has tenido que crearlo manualmente?
//
//Pista
//La clase Thread dispone de métodos para obtener información sobre el hilo que se está ejecutando en este momento.
package Tema2;
public class Ejercicio1 extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hilo actual: " + Thread.currentThread());
		
		//Thread hiloActual = Thread.currentThread();
		//System.out.println("nombre" + hiloActual.getName();
		

	}

}
