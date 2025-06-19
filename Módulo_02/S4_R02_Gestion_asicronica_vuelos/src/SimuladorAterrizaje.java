import java.util.concurrent.*;

public class SimuladorAterrizaje {
    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        // Ejecutar todas las verificaciones en paralelo
        CompletableFuture<Boolean> pista = AeropuertoControl.verificarPista();
        CompletableFuture<Boolean> clima = AeropuertoControl.verificarClima();
        CompletableFuture<Boolean> trafico = AeropuertoControl.verificarTraficoAereo();
        CompletableFuture<Boolean> personal = AeropuertoControl.verificarPersonalTierra();

        // Combinar resultados
        CompletableFuture<Void> allChecks = CompletableFuture.allOf(pista, clima, trafico, personal);

        allChecks.thenRun(() -> {
            try {
                boolean resultadoFinal = pista.get() && clima.get() && trafico.get() && personal.get();
                if (resultadoFinal) {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.out.println("\n❌ Error al evaluar condiciones: " + e.getMessage());
            }
        }).exceptionally(error -> {
            System.out.println("\n❌ Fallo en alguna verificación: " + error.getMessage());
            return null;
        });

        // Mantener el programa activo hasta que todas las tareas finalicen
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
