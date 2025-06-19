
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class AnalisisCalidad {
    public static void main(String[] args) {
        // Nuevos datos para las sucursales y encuestas
        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal("Sur", Arrays.asList(
                        new Encuesta("Laura", "Esperé más de 40 minutos para ser atendida", 2),
                        new Encuesta("Andrés", null, 4),
                        new Encuesta("Silvia", "El personal fue amable, pero hubo confusión con mi receta", 3)
                )),
                new Sucursal("Este", Arrays.asList(
                        new Encuesta("Miguel", "La sala de espera estaba sucia", 1),
                        new Encuesta("Valeria", null, 2),
                        new Encuesta("Tomás", "Faltaba aire acondicionado y hacía mucho calor", 3)
                )),
                new Sucursal("Oeste", Arrays.asList(
                        new Encuesta("Daniela", null, 5),
                        new Encuesta("Julio", "Tardaron mucho en procesar mi pago", 3)
                ))
        );

        // Procesamiento de encuestas con calificación ≤ 3 y comentario presente
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(encuesta -> encuesta.getCalificacion() <= 3)
                                .flatMap(encuesta -> encuesta.getComentario()
                                        .map(comentario -> Stream.of(
                                                "Sucursal " + sucursal.getNombre() +
                                                        ": Seguimiento a paciente con comentario: \"" + comentario + "\""))
                                        .orElseGet(Stream::empty))
                )
                .forEach(System.out::println);
    }
}
