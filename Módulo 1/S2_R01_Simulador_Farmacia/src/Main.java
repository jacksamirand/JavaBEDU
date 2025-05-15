import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del medicamento: ");
        String medicamento = scanner.nextLine();

        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        System.out.print("Cantidad de piezas: ");
        int cantidad = scanner.nextInt();

        SimuladorFarmacia simulador = new SimuladorFarmacia(medicamento, precioUnitario, cantidad);
        simulador.mostrarResumenCompra();

        scanner.close();
    }
}
