
import java.util.Random;

public class Soci extends Thread {

    private final int ESPERA_MAX;
    private final Random RND;
    private final int MAX_ANYS;
    private final Compte COMPTE;
    private final float APORTACIO;

    public Soci(String nom) {
        super(nom);
        this.COMPTE = Compte.getInstance();
        this.MAX_ANYS = 10;
        this.APORTACIO = 10f;
        this.ESPERA_MAX = 100;
        this.RND = new Random();
    }

    public Compte getCompte() {
        return this.COMPTE;
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
                    sleep(RND.nextInt(ESPERA_MAX));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}