import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creación objeto Paciente
        Paciente paciente1 = new Paciente();

        // Solicitud de datos
        System.out.print("📝 Ingresa el nombre del paciente: ");
        paciente1.nombre = scanner.nextLine();

        System.out.print("🧮 Ingresa la edad: ");
        paciente1.edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("📁 Ingresa el número de expediente: ");
        paciente1.numExpediente = scanner.nextLine();

        // Mostrar los datos ingresados
        paciente1.mostrarInformacion();

        scanner.close();

    }
}