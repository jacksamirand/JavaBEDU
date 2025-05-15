public class Main {
    public static void main(String[] args) {
        // Creamos dos facturas con el mismo folio
        Factura f1 = new Factura("ABC123", "Juan Pérez", 1450.00);
        Factura f2 = new Factura("ABC123", "Comercial XYZ", 1450.00);
        Factura f3 = new Factura("XYZ789", "Comercial XYZ", 1450.00);

        // Mostramos facturas con toString()
        System.out.println("01" + f1);
        System.out.println("02" + f2);
        System.out.println("03" + f3);

        // Comparamos si son iguales usando equals()
        System.out.println("¿Las facturas 1 y 2 son iguales?: " + (f1.equals(f2) ? "Sí" : "No"));
        System.out.println("¿Las facturas 1 y 3 son iguales?: " + (f1.equals(f3) ? "Sí" : "No"));
    }
}
