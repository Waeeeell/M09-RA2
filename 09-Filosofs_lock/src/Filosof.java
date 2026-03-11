public class Filosof extends Thread {

    private String nom;
    private long iniciGana;
    private long fiGana;
    private long gana;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;

    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    public void agafarForquillaEsquerra() {
        System.out.println(nom + " intenta agafar la forquilla esquerra " + forquillaEsquerra.getNum());
        forquillaEsquerra.agafar();
        System.out.println(nom + " ha agafat la forquilla esquerra " + forquillaEsquerra.getNum());
    }

    public void agafarForquillaDreta() {
        System.out.println(nom + " intenta agafar la forquilla dreta " + forquillaDreta.getNum());
        forquillaDreta.agafar();
        System.out.println(nom + " ha agafat la forquilla dreta " + forquillaDreta.getNum());
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void deixarForquilles() {
        forquillaEsquerra.deixar();
        System.out.println(nom + " ha deixat la forquilla esquerra " + forquillaEsquerra.getNum());
        forquillaDreta.deixar();
        System.out.println(nom + " ha deixat la forquilla dreta " + forquillaDreta.getNum());
    }

    public void menjar() {
        gana = fiGana - iniciGana;
        System.out.println(nom + " esta menjant. Ha esperat " + gana + " ms per menjar.");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nom + " ha acabat de menjar.");
    }

    @Override
    public void run() {
        iniciGana = System.currentTimeMillis();
        System.out.println(nom + " te gana.");
        agafarForquilles();
        fiGana = System.currentTimeMillis();
        menjar();
        deixarForquilles();
    }
}
