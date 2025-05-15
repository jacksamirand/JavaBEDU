public class Pasajero {
    String nombre;
    String pasaporte;

    Pasajero(String nombre, String pasaporte){
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

    String getNombre(){
        return this.nombre;
    }

    String getPasaporte(){
        return  this.pasaporte;
    }
}
