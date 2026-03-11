public class Taula {

    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        String[] noms = {"Plato", "Aristotil", "Socrates", "Descartes", "Kant"};
        forquilles = new Forquilla[numFilosofs];
        filosofs = new Filosof[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof(noms[i], esquerra, dreta);
        }
    }

    public void showTaula() {
        System.out.println("=== La Taula dels Filosofs ===");
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println(filosofs[i].getName() + " -> Forquilla esquerra: "
                    + forquilles[i].getNum() + ", Forquilla dreta: "
                    + forquilles[(i + 1) % forquilles.length].getNum());
        }
        System.out.println("==============================");
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(5);
        taula.showTaula();
        taula.cridarATaula();
    }
}
