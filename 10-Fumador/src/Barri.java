public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];
        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Fumador(estanc, i + 1);
        }
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.estanc.start();
        for (int i = 0; i < 3; i++) {
            barri.fumadors[i].start();
        }
        for (int i = 0; i < 3; i++) {
            try {
                barri.fumadors[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        barri.estanc.tancarEstanc();
    }
}
