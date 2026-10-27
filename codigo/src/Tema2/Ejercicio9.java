package Tema2;

// Objeto compartido por los dos hilos.
// Guarda si la descarga del archivo ya ha terminado.
class ArchivoDescargado {
    // Empieza en false porque el archivo aún no está disponible.
    private boolean disponible = false;

    // El procesador llama a este método para esperar a que termine
    // la descarga. Es synchronized para que wait() use el monitor
    // de este mismo objeto.
    public synchronized void esperarArchivo() throws InterruptedException {

        // Se usa while, y no if, para volver a comprobar la condición
        // cuando el hilo despierte.
        while (!disponible) {
            // Libera el monitor y deja este hilo esperando.
            // Podrá continuar cuando otro hilo lo despierte.
            wait();
        }
    }

    // El descargador llama a este método cuando termina la descarga.
    public synchronized void terminarDescarga() {

        // Indica que el archivo ya está disponible.
        disponible = true;

        // Despierta a los hilos que estén esperando en este objeto.
        notifyAll();
    }
}

// Tarea que simula la descarga del archivo.
class Descargador implements Runnable {
    // Referencia al objeto compartido con el procesador.
    private final ArchivoDescargado archivo;

    // Recibe el objeto compartido al crear la tarea.
    public Descargador(ArchivoDescargado archivo) {
        this.archivo = archivo;
    }

    // Código que ejecutará el hilo del descargador.
    @Override
    public void run() {
        System.out.println("Descargador: empezando descarga...");

        try {
            // Simula que la descarga tarda 3 segundos.
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // Conserva el estado de interrupción del hilo y termina la tarea.
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("Descargador: descarga completada.");

        // Marca el archivo como disponible y avisa al procesador.
        archivo.terminarDescarga();
    }
}

// Tarea que espera el archivo y luego lo procesa.
class Procesador implements Runnable {
    // Referencia al mismo objeto compartido que usa el descargador.
    private final ArchivoDescargado archivo;

    // Recibe el objeto compartido al crear la tarea.
    public Procesador(ArchivoDescargado archivo) {
        this.archivo = archivo;
    }

    // Código que ejecutará el hilo del procesador.
    @Override
    public void run() {
        System.out.println("Procesador: esperando archivo...");

        try {
            // El hilo queda esperando hasta que el archivo esté disponible.
            archivo.esperarArchivo();
        } catch (InterruptedException e) {
            // Conserva el estado de interrupción del hilo y termina la tarea.
            Thread.currentThread().interrupt();
            return;
        }

        // Estas instrucciones solo se ejecutan después de que la descarga termine.
        System.out.println("Procesador: archivo disponible.");
        System.out.println("Procesador: procesando archivo...");
    }
}

// Clase principal del programa.
public class Ejercicio9 {
    public static void main(String[] args) throws InterruptedException {

        // Crea un único objeto compartido entre ambos hilos.
        ArchivoDescargado archivo = new ArchivoDescargado();

        // Crea las tareas y sus respectivos hilos.
        Thread descargador = new Thread(new Descargador(archivo));
        Thread procesador = new Thread(new Procesador(archivo));

        // Inicia primero el procesador para que pueda quedar esperando.
        procesador.start();

        // Inicia la descarga.
        descargador.start();

        // El hilo principal espera a que ambos hilos terminen.
        procesador.join();
        descargador.join();
    }
}