

package Tema2;


class Contador8 {
	int valor = 0;
	public synchronized void incrementar() {	//implementamos synchronized aquí 
		valor++;
	}
	
}


class Incrementador8 implements Runnable{
	
	private Contador8 contador8;
	
	public Incrementador8(Contador8 contador8) {
		this.contador8 = contador8;
		
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			contador8.incrementar();
	}
}

}


public class Ejercicio8 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Contador8 contador8 = new Contador8();
		
		Incrementador8 tareaA = new Incrementador8(contador8);
		Incrementador8 tareaB = new Incrementador8(contador8);

		Thread hiloA = new Thread(tareaA);
		Thread hiloB = new Thread(tareaB);
		
		
		
		

		hiloA.start();
		hiloB.start();


		try {
			hiloA.join();
			hiloB.join();
		}catch (InterruptedException e) {
			
		}
		System.out.println(contador8.valor);
	}

}
