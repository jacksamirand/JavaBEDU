public class Main {
    public static void main(String[] args){
        Ambulancia ambulancia = new Ambulancia("AMB1234", "Ernesto");
        Patrulla patrulla = new Patrulla("POLI456", "Miguel");
        UnidadBomberos bomberos = new UnidadBomberos("BOM7894", "Juliana");

        ambulancia.iniciarOperacion();
        System.out.println();
        patrulla.iniciarOperacion();
        System.out.println();
        bomberos.iniciarOperacion();
    }
}
