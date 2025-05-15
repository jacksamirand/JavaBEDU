public abstract class MetodoPago implements Autenticable{
    double monto;

    public MetodoPago(double monto){
        this.monto = monto;
    }

    public abstract void procesarPago();

    public void mostrarResumen(){
        //Obtenemos el nombre de la clase para identificar el tipo de pago
        System.out.println("Tipo: " + this.getClass().getSimpleName() + " - Monto: $" + monto);
    }
}
