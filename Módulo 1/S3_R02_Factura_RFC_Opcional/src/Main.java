public class Main {
    public static void main(String[] args) {
        Factura facturaConRFC = new Factura(8000.0, "Servicio técnico", "ABCC010101XYZ");
        Factura facturaSinRFC = new Factura(1056.2, "Mantenimiento de equipo", null);

        // Mostrar ambas facturas
        System.out.println(facturaConRFC.getResumen());
        System.out.println(facturaSinRFC.getResumen());
    }
}
