import java.util.concurrent.CompletableFuture;

public class MovilidadApp {

    public static void main(String[] args) {
        CompletableFuture<String> rutaFuture = RutaService.calcularRuta();
        CompletableFuture<Double> tarifaFuture = TarifaService.estimarTarifa();

        rutaFuture
                .thenCombine(tarifaFuture, (ruta, tarifa) ->
                        String.format("✅ 🚗 Ruta calculada: %s | Tarifa estimada: $%.2f", ruta, tarifa))
                .exceptionally(error -> "❌ Ocurrió un error durante el proceso: " + error.getMessage())
                .thenAccept(System.out::println);

        // Mantener la app activa mientras se completan las tareas
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
