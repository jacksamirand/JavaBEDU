import java.util.concurrent.Callable;

class SistemaComunicaciones implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(800);
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}