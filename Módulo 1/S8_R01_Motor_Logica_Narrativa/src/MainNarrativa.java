import java.util.Scanner;

public class MainNarrativa {

    private final TransicionHistoria transicion;
    private final GestorDialogo dialogo;
    private final LogicaDesicion logicaDecision;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo dialogo, LogicaDesicion logicaDesicion) {
        this.transicion = transicion;
        this.dialogo = dialogo;
        this.logicaDecision = logicaDesicion;
    }

    public void iniciarEscena() {
        dialogo.mostrarDialogo("Te despiertas en un campamento misterioso al amanecer.");
        String decision = logicaDecision.tomarDesicion();
        transicion.avanzarEscena(decision);
        dialogo.mostrarDialogo("La historia continúa...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDesicion decision = new DesicionBinaria(scanner);

        MainNarrativa narrativa = new MainNarrativa(transicion, dialogo, decision);
        narrativa.iniciarEscena();

        scanner.close();
    }
}