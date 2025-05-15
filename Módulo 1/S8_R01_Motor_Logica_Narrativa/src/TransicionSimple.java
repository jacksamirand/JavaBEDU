public class TransicionSimple implements TransicionHistoria {
    @Override
    public void avanzarEscena(String decision) {
        // Simple transición basada en la decisión
        if ("A".equalsIgnoreCase(decision)) {
            System.out.println("Avanzas hacia el bosque encantado.");
        } else if ("B".equalsIgnoreCase(decision)) {
            System.out.println("Te diriges a la ciudadela abandonada.");
        } else {
            System.out.println("Decisión no reconocida, permaneces en el campamento.");
        }
    }
}