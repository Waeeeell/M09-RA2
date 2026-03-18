public class Fumador extends Thread {
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int numFumades;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        this.numFumades = 0;
    }

    public void fuma() {
        if (tabac != null && paper != null && llumi != null) {
            tabac = null;
            paper = null;
            llumi = null;
            try {
                Thread.sleep((long) (Math.random() * 500 + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numFumades++;
            System.out.println("Fumador " + id + " fumant");
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
        }
    }

    public void compraTabac() {
        System.out.println("Fumador " + id + " comprant Tabac");
        tabac = estanc.venTabac();
    }

    public void compraPaper() {
        System.out.println("Fumador " + id + " comprant Paper");
        paper = estanc.venPaper();
    }

    public void compraLlumi() {
        System.out.println("Fumador " + id + " comprant Llumi");
        llumi = estanc.venLlumi();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            compraTabac();
            compraPaper();
            compraLlumi();
            fuma();
        }
    }
}
