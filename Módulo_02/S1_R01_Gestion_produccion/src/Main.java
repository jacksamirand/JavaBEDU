import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = Arrays.asList(
                new OrdenMasa("A123", 500),
                new OrdenMasa("A124", 750)
        );

        List<OrdenPersonalizada> ordenesPersonalizadas = Arrays.asList(
                new OrdenPersonalizada("P456", 100, "Interceramic"),
                new OrdenPersonalizada("P789", 150, "Lumidec")
        );

        List<OrdenPrototipo> ordenesPrototipo = Arrays.asList(
                new OrdenPrototipo("T789", 10, "Diseño"),
                new OrdenPrototipo("T790", 5, "Pruebas")
        );

        // Mostrar órdenes
        System.out.println("📋 Órdenes registradas:");
        PlantaIndustrial.mostrarOrdenes(ordenesMasa);

        System.out.println("📋 Órdenes registradas:");
        PlantaIndustrial.mostrarOrdenes(ordenesPersonalizadas);

        System.out.println("📋 Órdenes registradas:");
        PlantaIndustrial.mostrarOrdenes(ordenesPrototipo);

        // Procesar personalizadas
        List<OrdenProduccion> todasOrdenes = new ArrayList<>();
        todasOrdenes.addAll(ordenesMasa);
        todasOrdenes.addAll(ordenesPersonalizadas);
        todasOrdenes.addAll(ordenesPrototipo);

        PlantaIndustrial.procesarPersonalizadas(todasOrdenes, 200);

        // Contar órdenes
        PlantaIndustrial.contarOrdenes(todasOrdenes);
    }
}