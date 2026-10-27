

package Tema2;


class Contador2 {
	int valor = 0;
	public void incrementar() {
		valor++;
	}
	
}


class Incrementador implements Runnable{
	
	private Contador2 contador;
	
	public Incrementador(Contador2 contador) {
		this.contador = contador;
		
	}
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			contador.incrementar();
	}
}

}


public class Ejercicio7 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Contador2 contador = new Contador2();
		
		Incrementador tareaA = new Incrementador(contador);
		Incrementador tareaB = new Incrementador(contador);

		Thread hiloA = new Thread(tareaA);
		Thread hiloB = new Thread(tareaB);
		
		
		
		

		hiloA.start();
		hiloB.start();


		try {
			hiloA.join();
			hiloB.join();
		}catch (InterruptedException e) {
			
		}
		System.out.println(contador.valor);
	}

}
