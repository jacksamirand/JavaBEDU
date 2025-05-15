//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Entrada entrada1 = new Entrada("Concierto Lindsey Stirling", 1200.00);
        EntradaRecord entrada2 = new EntradaRecord("Concierto Orquesta Escuela Carlos Chávez", 100.00);

        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();
    }
}