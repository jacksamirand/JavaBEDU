import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class RegistroMuestrasBiotecnologia {

    public static void main(String[] args) {
        // Paso 1: ArrayList para registrar todas las especies en orden de llegada
        ArrayList<String> muestrasOrden = new ArrayList<>();
        muestrasOrden.add("Homo sapiens");
        muestrasOrden.add("Mus musculus");
        muestrasOrden.add("Arabidopsis thaliana");
        muestrasOrden.add("Homo sapiens");  // Repetida, porque puede haber replicación

        // Paso 2: HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(muestrasOrden);

        // Paso 3: HashMap para asociar ID de muestra con investigador responsable
        HashMap<String, String> muestraInvestigador = new HashMap<>();
        muestraInvestigador.put("M-001", "Dra. López");
        muestraInvestigador.put("M-002", "Dr. Hernández");
        muestraInvestigador.put("M-003", "Dra. Pérez");
        muestraInvestigador.put("M-004", "Dr. Hernández");

        // Mostrar resultados

        // Mostrar lista completa y ordenada de muestras (puede haber repetidas)
        System.out.println("Lista completa y ordenada de muestras:");
        for (String especie : muestrasOrden) {
            System.out.println("- " + especie);
        }
        System.out.println();

        // Mostrar especies únicas procesadas
        System.out.println("Especies únicas procesadas:");
        for (String especieUnica : especiesUnicas) {
            System.out.println("- " + especieUnica);
        }
        System.out.println();

        // Mostrar relación ID muestra → investigador responsable
        System.out.println("Relación ID de muestra → Investigador responsable:");
        for (String idMuestra : muestraInvestigador.keySet()) {
            System.out.println(idMuestra + " → " + muestraInvestigador.get(idMuestra));
        }
        System.out.println();

        // Búsqueda por ID de muestra
        String idBusqueda = "M-002";
        if (muestraInvestigador.containsKey(idBusqueda)) {
            System.out.println("Investigador responsable de la muestra " + idBusqueda + ": " + muestraInvestigador.get(idBusqueda));
        } else {
            System.out.println("No se encontró la muestra con ID " + idBusqueda);
        }
    }
}
