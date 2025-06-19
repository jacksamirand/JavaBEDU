import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class TarifaService {

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            try {
                Thread.sleep(1000 + new Random().nextInt(1000)); // 1–2 segundos
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
            return 50.0 + new Random().nextDouble() * 50; // Tarifa entre 50 y 100
        });
    }
}
