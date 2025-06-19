import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AeropuertoControl {
    private static final Random random = new Random();

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2000, 3000);
            boolean disponible = probabilidad(0.8);
            System.out.println("🛣️ Pista disponible: " + (disponible ? "✅" : "❌"));
            return disponible;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2000, 3000);
            boolean favorable = probabilidad(0.85);
            System.out.println("🌦️ Clima favorable: " + (favorable ? "✅" : "❌"));
            return favorable;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2000, 3000);
            boolean despejado = probabilidad(0.9);
            System.out.println("🚦 Tráfico aéreo despejado: " + (despejado ? "✅" : "❌"));
            return despejado;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2000, 3000);
            boolean disponible = probabilidad(0.95);
            System.out.println("👷‍♂️ Personal disponible: " + (disponible ? "✅" : "❌"));
            return disponible;
        });
    }

    private static void esperar(int minMs, int maxMs) {
        try {
            Thread.sleep(minMs + random.nextInt(maxMs - minMs));
        } catch (InterruptedException e) {
            throw new RuntimeException("Error en simulación");
        }
    }

    private static boolean probabilidad(double probabilidad) {
        return random.nextDouble() < probabilidad;
    }
}
