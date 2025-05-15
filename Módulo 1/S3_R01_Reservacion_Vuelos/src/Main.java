//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Pasajero pasajero = new Pasajero("Marco Antonio", "P123456");
        Vuelo vuelo = new Vuelo("UX123", "Berlín", "10:30");

        // Reservar asiento
        boolean reservado = vuelo.reservarAsiento(pasajero);
        if (reservado) {
            System.out.println("✅ Reserva realizada con éxito.\n");
        } else {
            System.out.println("❌ No se pudo realizar la reserva.\n");
        }

        // Mostrar itinerario
        System.out.println(vuelo.obtenerItinerario());

        // Cancelar reserva
        System.out.println("❌ Cancelando reserva...\n");
        vuelo.cancelarReserva();

        // Mostrar itinerario actualizado
        System.out.println(vuelo.obtenerItinerario());

        // Realizamos una nueva reservacion
        vuelo.reservarAsiento("Susana Miranda", "P987654");
        System.out.println(vuelo.obtenerItinerario());
    }
}