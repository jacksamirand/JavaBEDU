import java.util.*;
import java.util.stream.*;

public class Pizzeria {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Ana", "domicilio", "444-1234"),
                new Pedido("Luis", "local", null),
                new Pedido("Carlos", "domicilio", null),
                new Pedido("Marta", "domicilio", "555-5862"),
                new Pedido("Elena", "local", "789-1975")
        );

        pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(Pedido::getTelefono)                      // Optional<String>
                .flatMap(Optional::stream)                     // Elimina los vacíos
                .map(tel -> "📞 Confirmación enviada al número: " + tel)
                .forEach(System.out::println);
    }
}
