package Tema2;
/*	lo que escribe por pantalla, lo he de pasar a otro archivo */

class Ej11 implements Runnable {
	
	private String nombre;
	
	public Ej11(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public void run() {
		for (int i=0; i<=20; i++) {
			System.out.println(nombre + " - Iteración " + i);
			try {
				Thread.sleep(10);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}

public class Ejercicio11 {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		Thread hiloA = new Thread(new Ej10("Hilo A"));
		Thread hiloB = new Thread(new Ej10("Hilo B"));
		
		//hiloA.setPriority(10);
		//hiloB.setPriority(1);
		hiloA.setPriority(Thread.MAX_PRIORITY);
		hiloB.setPriority(Thread.MIN_PRIORITY);
		
		hiloA.start();
		hiloB.start();
	}
}