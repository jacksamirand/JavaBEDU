import java.util.*;
import java.util.function.Predicate;

public class PlataformaEducativa {

    // Muestra todos los materiales
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
        System.out.println();
    }

    // Cuenta duración total de videos
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("🎥 Duración total de videos: " + total + " minutos\n");
    }

    // Marca ejercicios como revisados
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio ejercicio) {
                ejercicio.marcarRevisado();
                System.out.println("✅ Ejercicio '" + ejercicio.getTitulo() + "' marcado como revisado.");
            }
        }
        System.out.println();
    }

    // Filtración de materiales por autor
    public static <T extends MaterialCurso> void filtrarPorAutor(List<T> lista, Predicate<T> filtro) {
        System.out.println("🔍 Filtrando materiales por autor:");
        for (T material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }
        System.out.println();
    }
}