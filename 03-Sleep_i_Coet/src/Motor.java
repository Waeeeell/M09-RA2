import java.util.Random;

public class Motor extends Thread {
    private int potAct;
    private int potObj;
    private int numMotor;
    private String estat;
    private Random random = new Random();

    public Motor(int numMotor) {
        this.potAct = 0;
        this.potObj = 0;
        this.numMotor = numMotor;
        this.estat = "Incre.";
    }

    // Establece la potencia objetivo que el motor debe alcanzar
    public void setPotencia(int p) {
        this.potObj = p;
    }

    @Override
    public void run() {

        // Bucle principal del hilo
        while (true) {
            // Mientras no hayamos alcanzado la potencia deseada
            while (potAct != potObj) {
                // Determina si el estado es de incremento o decremento
                estat = potAct < potObj ? "Incre." : "Decre.";

                // Suma o resta 1 a la potencia actual según corresponda
                potAct += potAct < potObj ? +1 : -1;

                // Si tras el cambio ya hemos llegado al objetivo, cambiamos el estado
                if (potAct == potObj)
                    estat = "FerRes"; // Estado: "HacerNada"

                System.out.printf("Motor %2d: %-7sObjetivo: %d Actual: %d\n", numMotor, estat, potObj, potAct);

                try {
                    // Entre cada cambio de potencia, hay un retraso aleatorio de entre 0 y 2
                    // segundos
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                // Pequeña espera de cortesía para no sobrecargar el procesador cuando está en
                // reposo
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Condición de salida: cuando la potencia llega a 0, se rompe el bucle y el
            // hilo termina
            if (potAct == 0)
                break;
        }
    }
}