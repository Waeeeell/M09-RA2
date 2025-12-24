public class Futbolista extends Thread {

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    public void setNgols(int ngols) {
        this.ngols = ngols;
    }

    public void setNtirades(int ntirades) {
        this.ntirades = ntirades;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            // acumula els xuts
            ntirades++;
            // marca si random per tirada és menor que PROBABILITAT
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String[] jugadors = { "Piqué", "Vinicius", "Torres", "Ramos",
                "Ronaldo", "Lewan", "Belli", "Arnau",
                "Aspas", "Messi", "MBapé" };

        Futbolista[] futbolistes = new Futbolista[NUM_JUGADORS];

        // creem tots els fils/jugadors
        for (int i = 0; i < NUM_JUGADORS; i++) {
            futbolistes[i] = new Futbolista(jugadors[i]);
        }

        System.out.println("Inici dels xuts --------------------");

        for (Futbolista futbolista : futbolistes) {
            futbolista.start();
        }

        for (Futbolista futbolista : futbolistes) {
            try {
                futbolista.join();
            } catch (InterruptedException e) {
                System.err.println("Error, espera interrumpuda: " + e.getMessage());
            }
        }

        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        for (Futbolista futbolista : futbolistes) {
            System.out.println(futbolista.getName() + " -> " + futbolista.getNgols() + " gols");
        }
    }
}