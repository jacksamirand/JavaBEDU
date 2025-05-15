public class Main {
    public static void main(String[] args){
        DeclaracionImpuestos declaracion = new DeclaracionImpuestos("AEJM990401J73", 12500.00);
        CuentaFiscal cuenta = new CuentaFiscal("AEJM990401J73",20500.0);

        System.out.println(declaracion);
        cuenta.mostrarCuenta();

        //Imprimimos si el RFC de la declaración es válida
        System.out.println("✅ ¿RFC válido para esta cuenta?: " + (cuenta.validarRFC(declaracion) ? "Sí" : "No"));
    }
}
