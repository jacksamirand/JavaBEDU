public class SimuladorFarmacia {
    private String medicamento;
    private double precioUnitario;
    private int cantidad;

    public SimuladorFarmacia(String medicamento, double precioUnitario, int cantidad) {
        this.medicamento = medicamento;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public void mostrarResumenCompra() {
        double totalSinDescuento = precioUnitario * cantidad;
        var aplicaDescuento = totalSinDescuento > 500; // Uso de 'var' para inferir tipo
        double descuento = aplicaDescuento ? totalSinDescuento * 0.15 : 0;
        double totalConDescuento = totalSinDescuento - descuento;

        System.out.println("\n \uD83D\uDED2 Resumen de compra:" +
                           "\n\tMedicamento: " + medicamento +
                           "\n\tCantidad: " + cantidad +
                           "\n\tPrecio unitario: $" + precioUnitario +
                           "\n\tTotal sin descuento: $" + totalSinDescuento +
                           "\n\t¿Aplica descuento?: " + aplicaDescuento +
                           "\n\tDescuento: $" + descuento +
                           "\n\tTotal a pagar: $" + totalConDescuento);
    }
}