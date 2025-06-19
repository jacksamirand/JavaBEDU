import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimulacionMisionEspacial {
    public static void main(String[] args) throws Exception {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        // Crear thread pool de 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Enviar tareas al executor
        Future<String> navFuture = executor.submit(new SistemaNavegacion());
        Future<String> soporteFuture = executor.submit(new SistemaSoporteVital());
        Future<String> termicoFuture = executor.submit(new SistemaControlTermico());
        Future<String> comFuture = executor.submit(new SistemaComunicaciones());

        // Imprimir resultados (se bloquea hasta que cada tarea termina)
        System.out.println(comFuture.get());
        System.out.println(soporteFuture.get());
        System.out.println(termicoFuture.get());
        System.out.println(navFuture.get());

        // Apagar executor
        executor.shutdown();

        System.out.println("✅ Todos los sistemas reportan estado operativo.");
    }
}