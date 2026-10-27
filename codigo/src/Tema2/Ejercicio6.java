package Tema2;


class Tarea implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class Ejercicio6 extends Thread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Tarea t = new Tarea();
		Thread hilo = new Thread(t);
		System.out.println("Estado inicial: " + hilo.getState());
		hilo.start();
		System.out.println("Tras hilo.start: " + hilo.getState());
		Thread.sleep(1000);
		System.out.println("Tras Thread.sleep: " + hilo.getState());
		hilo.join();
		System.out.println("Tras hilo.join: " + hilo.getState());

	}

}