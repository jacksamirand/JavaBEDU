import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestionTemasConcurrente {
    public static void main(String[] args) {
        // CopyOnWriteArrayList para gestionar temas activos de forma segura en concurrencia
        CopyOnWriteArrayList<Tema> temasActivos = new CopyOnWriteArrayList<>();

        // Agregar temas
        temasActivos.add(new Tema("Lectura comprensiva", 2));
        temasActivos.add(new Tema("Matemáticas básicas", 1));
        temasActivos.add(new Tema("Cuidado del medio ambiente", 3));

        // Mostrar lista ordenada por título (orden natural)
        System.out.println("Temas ordenados alfabéticamente:");
        Collections.sort(temasActivos); // usa Comparable<Tema> por título
        for (Tema t : temasActivos) {
            System.out.println(t);
        }
        System.out.println();

        // Ordenar por prioridad (1 urgente, 2 importante, 3 opcional) usando Comparator
        System.out.println("Temas ordenados por prioridad ascendente:");
        temasActivos.sort(Comparator.comparingInt(Tema::getPrioridad));
        for (Tema t : temasActivos) {
            System.out.println(t);
        }
        System.out.println();

        // ConcurrentHashMap para repositorio concurrente de recursos
        ConcurrentHashMap<String, String> repositorioRecursos = new ConcurrentHashMap<>();

        // Agregar recursos
        repositorioRecursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        repositorioRecursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        repositorioRecursos.put("Cuidado del medio ambiente", "https://recursos.edu/medioambiente");

        // Mostrar recursos asociados a cada tema
        System.out.println("Repositorio de recursos compartidos:");
        for (String titulo : repositorioRecursos.keySet()) {
            System.out.println(titulo + " → " + repositorioRecursos.get(titulo));
        }
    }
}