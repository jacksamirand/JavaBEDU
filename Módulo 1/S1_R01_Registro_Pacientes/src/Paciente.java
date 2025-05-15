public class Paciente {
    String nombre;
    int edad;
    String numExpediente;

    void mostrarInformacion(){
        System.out.println("\n📋 Información del paciente:");
        System.out.println("Paciente: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Expediente: " + numExpediente);
    }
}
