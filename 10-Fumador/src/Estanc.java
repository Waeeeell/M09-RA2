import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {
    private List<Tabac> tabacs;
    private List<Paper> papers;
    private List<Llumi> llumis;
    private volatile boolean obert;

    public Estanc() {
        tabacs = new ArrayList<>();
        papers = new ArrayList<>();
        llumis = new ArrayList<>();
        obert = true;
    }

    public void nouSubministrament() {
        Random r = new Random();
        int opcio = r.nextInt(3);
        switch (opcio) {
            case 0:
                addTabac();
                break;
            case 1:
                addPaper();
                break;
            case 2:
                addLlumi();
                break;
        }
    }

    private synchronized void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }

    private synchronized void addPaper() {
        papers.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    private synchronized void addLlumi() {
        llumis.add(new Llumi());
        System.out.println("Afegint Llumi");
        notifyAll();
    }

    public synchronized Tabac venTabac() {
        while (tabacs.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tabacs.remove(0);
    }

    public synchronized Paper venPaper() {
        while (papers.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return papers.remove(0);
    }

    public synchronized Llumi venLlumi() {
        while (llumis.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return llumis.remove(0);
    }

    public synchronized void tancarEstanc() {
        obert = false;
        System.out.println("Estanc tancat");
        notifyAll();
    }

    @Override
    public void run() {
        System.out.println("Estanc obert");
        while (obert) {
            nouSubministrament();
            try {
                Thread.sleep((long) (Math.random() * 1000 + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
