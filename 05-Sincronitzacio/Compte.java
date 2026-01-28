
import java.util.Random;

public class Compte {
    private float saldo;
    private static Compte instance = null;

    private Compte() {
        this.saldo = 0.0f;
    }

    public static synchronized Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }

    public synchronized float getSaldo() {
        return this.saldo;
    }

    public synchronized void setSaldo(float aportacio) {
        this.saldo += aportacio;
    }
}

class Soci extends Thread {
    private final int ESPERA_MAX = 100;
    private final Random RND = new Random();
    private final int MAX_ANYS = 10;
    private final float APORTACIO = 10f;
    private final Compte COMPTE;

    public Soci(String nom) {
        super(nom);
        this.COMPTE = Compte.getInstance();
    }

    @Override
    public void run() {
        for (int any = 0; any < MAX_ANYS; any++) {
            for (int mes = 0; mes < 12; mes++) {

                if (mes % 2 == 0) {
                    COMPTE.setSaldo(APORTACIO);
                } else {
                    COMPTE.setSaldo(-APORTACIO);
                }

                try {
                    Thread.sleep(RND.nextInt(ESPERA_MAX));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}