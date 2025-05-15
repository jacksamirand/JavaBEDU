import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegistroSimulacion {

    // Ruta del archivo de configuración
    private static final Path RUTA_ARCHIVO = Paths.get("config", "parametros.txt");

    public static void main(String[] args) {
        try {
            guardarParametros();
            if (Files.exists(RUTA_ARCHIVO)) {
                System.out.println("Archivo creado correctamente.");
                String contenido = leerParametros();
                System.out.println("Contenido del archivo:\n" + contenido);
            } else {
                System.out.println("No se pudo crear el archivo.");
            }
        } catch (IOException e) {
            System.err.println("Error durante la operación con el archivo: " + e.getMessage());
        }
    }

    // Metodo para guardar los parámetros en el archivo
    private static void guardarParametros() throws IOException {
        // Si la carpeta config no existe, crearla
        Path carpetaConfig = RUTA_ARCHIVO.getParent();
        if (!Files.exists(carpetaConfig)) {
            Files.createDirectories(carpetaConfig);
        }

        String parametros =
                "Tiempo de ciclo: 55.8 segundos\n" +
                        "Velocidad de línea: 1.2 m/s\n" +
                        "Número de estaciones: 8\n";

        Files.write(RUTA_ARCHIVO, parametros.getBytes());
    }

    // Método para leer el contenido del archivo
    private static String leerParametros() throws IOException {
        return Files.readString(RUTA_ARCHIVO);
    }
}
