import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...\n");

        // Recurso compartido
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Executor con 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Lista de profesionales que intentarán usar el recurso
        String[] profesionales = {
                "Dr. Méndez",
                "Dra. Villalobos",
                "Dr. Ortega",
                "Dra. Esquivel",
                "Robot Da Vinci (asist. quirúrgico)",
                "Monitor de signos vitales",
                "Mesa de instrumental",
                "Anestesióloga Morales",
                "Dr. Ríos",
                "Lámpara quirúrgica móvil"
        };

        // Crear y ejecutar tareas
        for (String nombre : profesionales) {
            executor.execute(() -> salaCirugia.usar(nombre));
        }

        // Cerrar executor
        executor.shutdown();
    }
}