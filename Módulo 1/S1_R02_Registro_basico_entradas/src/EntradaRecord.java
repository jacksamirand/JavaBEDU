public record EntradaRecord(String nombreEvento, double precio) {
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombreEvento + " | Precio: $" + precio);
    }
}
