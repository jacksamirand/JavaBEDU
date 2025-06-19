import java.util.*;
public static void main(String[] args) {
    List<MaterialCurso> materiales = new ArrayList<>();

    // Agregar materiales
    materiales.add(new Video("Estructuras de datos", "Laura", 25));
    materiales.add(new Video("Algoritmos de búsqueda", "Pedro", 30));
    materiales.add(new Articulo("Complejidad algorítmica", "Laura", 1500));
    materiales.add(new Articulo("Buenas prácticas en programación", "Marta", 1000));
    materiales.add(new Ejercicio("Listas enlazadas", "Pedro"));
    materiales.add(new Ejercicio("Recursividad", "Laura"));

    // Mostrar materiales
    System.out.println("📚 Materiales del curso:");
    PlataformaEducativa.mostrarMateriales(materiales);

    // Contar duración de videos
    List<Video> videos = new ArrayList<>();
    for (MaterialCurso m : materiales) {
        if (m instanceof Video v) videos.add(v);
    }
    PlataformaEducativa.contarDuracionVideos(videos);

    // Marcar ejercicios como revisados
    PlataformaEducativa.marcarEjerciciosRevisados(materiales);

    // Filtrar por autor (Mario)
    PlataformaEducativa.filtrarPorAutor(materiales, m -> m.getAutor().equals("Laura"));
}
