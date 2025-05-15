public class PagoTransferencia extends MetodoPago{
    private boolean validacionExt;

    public PagoTransferencia(double monto, boolean validacionExt) {
        super(monto);
        this.validacionExt = validacionExt;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago en efectivo \uD83D\uDCE4 $" + monto);
    }

    @Override
    public boolean autenticar() {
        return false;
    }
}
