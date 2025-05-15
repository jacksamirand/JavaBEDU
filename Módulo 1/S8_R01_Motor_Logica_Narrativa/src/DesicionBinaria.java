import java.util.Scanner;

public class DesicionBinaria implements LogicaDesicion {
    private final Scanner scanner;

    public DesicionBinaria(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String tomarDesicion() {
        System.out.println("¿Qué camino eliges? (A) Bosque encantado - (B) Ciudadela abandonada");
        System.out.print("Ingresa tu decisión: ");
        return scanner.nextLine().trim().toUpperCase();
    }
}