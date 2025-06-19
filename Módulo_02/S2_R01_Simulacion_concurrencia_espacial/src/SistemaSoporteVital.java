import java.util.concurrent.Callable;

class SistemaSoporteVital implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1200);
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}