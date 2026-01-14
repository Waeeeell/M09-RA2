import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coet {
    // Atributo que almacena un array de objetos tipo Motor
    private Motor[] motors;

    public Coet() {
        this.motors = new Motor[4];
        for (int i = 0; i < this.motors.length; i++) {
            this.motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        // Comprueba que la potencia esté en el rango permitido (0 a 10)
        if (p >= 0 && p <= 10) {
            System.out.printf("Pasando a potencia %d\n", p);

            // Recorre el array y actualiza cada motor con la nueva potencia
            for (Motor mot : motors) {
                mot.setPotencia(p);
            }
        } else {
            // Lanza error si el valor no es válido
            throw new IllegalArgumentException("Valor de potencia inválido, solo entre 0 y 10.");
        }
    }

    public void arranca() {
        for (Motor mot : motors) {
            mot.start();
        }
    }
}