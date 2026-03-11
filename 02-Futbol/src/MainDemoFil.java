
public class MainDemoFil {
    public static void main(String[] args) {
        // capturem el fil actual per mostrar les seves propietats
        Thread filActual = Thread.currentThread();
        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + filActual.getPriority() + ", Nom -> " + filActual.getName());
        System.out.println("toString() -> " + filActual.toString());

      
    }
}