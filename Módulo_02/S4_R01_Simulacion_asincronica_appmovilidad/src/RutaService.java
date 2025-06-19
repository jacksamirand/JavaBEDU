import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class RutaService {

    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Calculando ruta...");
            try {
                Thread.sleep(2000 + new Random().nextInt(1000)); // 2–3 segundos
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
            return "Centro -> Norte";
        });
    }
}
