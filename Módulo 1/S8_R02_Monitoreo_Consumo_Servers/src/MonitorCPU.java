import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MonitorCPU {

    public static void main(String[] args) {
        Set<Double> consumosRegistrados = new HashSet<>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            System.out.println("Ingrese consumos de CPU para servidores (ingrese 'fin' para terminar):");

            while (true) {
                System.out.print("Consumo CPU (%): ");
                String entrada = scanner.nextLine().trim();

                if ("fin".equalsIgnoreCase(entrada)) {
                    break;
                }

                double consumo;

                // Validar que sea número
                try {
                    consumo = Double.parseDouble(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Entrada no es un número válido.");
                    continue;
                }

                // Validar rango 0-100
                if (consumo < 0 || consumo > 100) {
                    System.out.println("Error: El consumo debe estar entre 0 y 100.");
                    continue;
                }

                // Validar duplicados
                if (consumosRegistrados.contains(consumo)) {
                    System.out.println("Error: Registro duplicado, ese consumo ya fue ingresado.");
                    continue;
                }

                // Lanzar excepción si consumo crítico > 95
                if (consumo > 95) {
                    throw new ConsumoCriticoException("Alerta: Consumo crítico detectado (" + consumo + "%).");
                }

                // Si todo ok agregar al conjunto
                consumosRegistrados.add(consumo);
                System.out.println("Consumo registrado correctamente.");
            }

            System.out.println("\nRegistro finalizado. Valores ingresados:");
            consumosRegistrados.forEach(c -> System.out.println(c + "%"));

        } catch (ConsumoCriticoException e) {
            System.err.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("MonitorCPU finalizado.");
        }
    }
}