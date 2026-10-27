/**
 * 
 */
package ejemplos;

import java.io.IOException;

/**
 * 
 */
public class Ejemplo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String RUTA = "notepad.exe";
				//ProcessBuilder pb = new ProcessBuilder();
				//pb.command("ping", "google.com");
		ProcessBuilder pb = new ProcessBuilder(RUTA);
		try {
			Process ps = pb.start(); // Iniciamos el proceso
			System.out.println("ID del proceso " + ps.pid());
			
			ps.destroy(); // Destruimos el proceso
				System.out.println("Proceso finalizado");

		} catch (IOException e) {
				e.printStackTrace();
		}
	}
}
