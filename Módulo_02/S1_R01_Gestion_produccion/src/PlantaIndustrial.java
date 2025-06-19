import java.util.List;

public class PlantaIndustrial {

    // Método genérico para mostrar cualquier orden
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
        System.out.println(); // Línea en blanco para separar bloques
    }

    // Método para procesar órdenes personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada personalizada) {
                personalizada.ajustarCosto(costoAdicional);
            }
        }
        System.out.println();
    }

    // Conteo de tipos de órdenes
    public static void contarOrdenes(List<OrdenProduccion> todas) {
        int masa = 0, personalizadas = 0, prototipos = 0;
        for (OrdenProduccion orden : todas) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) personalizadas++;
            else if (orden instanceof OrdenPrototipo) prototipos++;
        }

        System.out.println("📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + personalizadas);
        System.out.println("🧪 Prototipos: " + prototipos);
    }
}