public class Vuelo {
    final String codigoVuelo;
    String destino;
    String horaSalida; //Hora de salida en formato 24hrs
    Pasajero asientoReservado; //Puede ser un NULL

    //Constructor
    Vuelo(String codigoVuelo, String destino, String horaSalida){
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.asientoReservado = null;
    }

    //Asigna al pasajero si no hay reserva previa
    boolean reservarAsiento(Pasajero p){
        if (asientoReservado == null) {
            asientoReservado = p;
            return true;
        } else {
            return false;
        }
    }

    //Metodo sobrecargado
    boolean reservarAsiento(String nombre, String pasaporte){
        Pasajero nuevoPasajero = new Pasajero(nombre, pasaporte);
        return reservarAsiento(nuevoPasajero);
    }

    //Eliminación de pasajero asignado
    void cancelarReserva() {
        asientoReservado = null;
    }

     //Muestra la información del vuelo y el pasajero
    String obtenerItinerario(){
        String info = "✈️ Itinerario del vuelo:\n";
        info += "Código: " + codigoVuelo + "\n";
        info += "Destino: " + destino + "\n";
        info += "Salida: " + horaSalida + "\n";
        if (asientoReservado != null) {
            info += "Pasajero: " + asientoReservado.nombre + "\n";
        } else {
            info += "Pasajero: [Sin reserva]\n";
        }
        return info;
    }
}
