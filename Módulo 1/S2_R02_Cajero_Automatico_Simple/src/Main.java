import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CajeroAutomatico cajero = new CajeroAutomatico(1000.0);
        int opcion;

        do {
            System.out.println("\n💳 Bienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> cajero.consultarSaldo();
                case 2 -> {
                    System.out.print("💰 Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    cajero.depositar(deposito);
                }
                case 3 -> {
                    System.out.print("💸 Ingresa el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    cajero.retirar(retiro);
                }
                case 4 -> System.out.println("👋 Gracias por usar el cajero. ¡Hasta pronto!");
                default -> System.out.println("🚫 Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
