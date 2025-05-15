public class Entrada {
    String nombreEvento;
    double precio;

    public Entrada(String nombreEvento, double precio){
        this.nombreEvento = nombreEvento;
        this.precio = precio;
    }

    void mostrarInformacion(){
        System.out.println("Evento: " + nombreEvento + "| Precio: $" + precio);
    }
}
