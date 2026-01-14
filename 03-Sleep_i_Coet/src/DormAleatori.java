import java.util.Random;

public class DormAleatori extends Thread {
    private final long inici;
    private Random random = new Random();

    public DormAleatori(String nom) {
        super(nom); // Llama al constructor de Thread para asignar el nombre al hilo
        this.inici = System.currentTimeMillis(); // Guarda el tiempo exacto de creación
    }

    // Retorna el tiempo inicial registrado al crear la instancia
    public long getInici() {
        return inici;
    }

    // Calcula la diferencia de tiempo entre el inicio y el momento actual
    public static long calculaTempsTotal(long tInicial, long tActual) {
        return tActual - tInicial;
    }

    @Override
    // Método principal que se ejecuta cuando el hilo comienza (start)
    public void run() {
        int interval_aleatori;
        // Se ejecutan 10 iteraciones por cada hilo
        for (int i = 0; i < 10; i++) {
            // Genera un número aleatorio entre 0 y 999 milisegundos
            interval_aleatori = random.nextInt(1000);

            // Imprime el nombre del hilo, número de iteración, tiempo de sueño y tiempo
            // total transcurrido
            System.out.printf("%-4s (%d) a dormir %5dms total %6d\n", this.getName(), i, interval_aleatori,
                    calculaTempsTotal(getInici(), System.currentTimeMillis()));

            try {
                // Duerme el hilo en cada iteración por el tiempo aleatorio generado
                Thread.sleep(interval_aleatori);
            } catch (InterruptedException e) {
                // Captura errores en caso de que el hilo sea interrumpido bruscamente
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Creación de las instancias de los hilos
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        // Inicia la ejecución de los hilos (esto llama internamente al método run)
        joan.start();
        pep.start();

        // Este mensaje se imprimirá probablemente antes de que terminen los hilos
        System.out.println("-- Fin de main -----------");
    }
}