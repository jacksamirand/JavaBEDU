import java.util.Objects;

public class CuentaFiscal {
    private String rfc;
    private double saldoDisponible;

    public CuentaFiscal(String rfc, double saldoDisponible){
        this.rfc = rfc;
        if (saldoDisponible >= 0) {
            this.saldoDisponible = saldoDisponible;
        } else {
            System.out.println("❌ El saldo no puede ser negativo. Se asigna 0.");
            this.saldoDisponible = 0;
        }
    }

    public String getRfc() {
        return rfc;
    }
    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Validación de RFC declarado
    public boolean validarRFC(DeclaracionImpuestos d) {
        return Objects.equals(this.rfc, d.rfcContibuyente());
    }

    public void mostrarCuenta() {
        System.out.println("🏦 Cuenta fiscal registrada con RFC: " + rfc + ", saldo disponible: $" + saldoDisponible);
    }

}
