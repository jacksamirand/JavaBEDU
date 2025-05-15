public class PagoEfectivo extends MetodoPago{
    public PagoEfectivo(double monto){
        super(monto);
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago en efectivo \uD83D\uDCB5 $" + monto);
    }

    @Override
    public boolean autenticar() {
        return true;
    }
}
