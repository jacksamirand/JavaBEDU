import java.util.Optional;

public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc; //Con esto hacemos manejo seguro del valor nulo

    public Factura(double monto, String descripcion, String rfc){
        this.monto = monto;
        this.descripcion = descripcion;
        //En caso de que tenga valor null debe almacenarse usando Optional.empty()
        this.rfc = (rfc != null) ? Optional.of(rfc) : Optional.empty();
        //this.rfc = Optional.ofNullable(rfc);
    }

    public String getResumen(){
        String resumen = "📄 Factura generada:\n " +
                "Descripción: " + descripcion +
                "Monto: $" + monto + "\n";

        // Si el RFC está presente, se muestra. Si no, se muestra mensaje alternativo.
        resumen += "RFC: " + rfc.orElse("[No proporcionado]") + "\n";

        return resumen;
    }

}
