public class PagoTarjeta extends MetodoPago{
    private double saldoDisponible;

    public PagoTarjeta(double monto, double saldoDisponible) {
        super(monto);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago con tarjeta \uD83D\uDCB3 $" + monto);
    }

    @Override
    public boolean autenticar() {
        return saldoDisponible >= monto;
    }
}
