package com.bedu.tienda;

import com.bedu.tienda.model.Marca;
import com.bedu.tienda.model.Producto;
import com.bedu.tienda.repository.MarcaRepository;
import com.bedu.tienda.repository.ProductoRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(MarcaRepository marcaRepo, ProductoRepository productoRepo, Validator validator) {
		return args -> {

			// Crear marcas
			Marca apple = new Marca("Apple");
			Marca samsung = new Marca("Samsung");
			Marca sony = new Marca("Sony");
			Marca lg = new Marca("LG");

			List<Marca> marcas = List.of(apple, samsung, sony, lg);
			for (Marca m : marcas) {
				Set<ConstraintViolation<Marca>> violations = validator.validate(m);
				if (violations.isEmpty()) {
					marcaRepo.save(m);
				} else {
					violations.forEach(v -> System.out.println("Error Marca: " + v.getPropertyPath() + " " + v.getMessage()));
				}
			}

			// Crear productos asociados a marcas
			List<Producto> productos = List.of(
					new Producto("iPhone 15", "Smartphone Apple última generación", 25000, apple),
					new Producto("iPad Pro", "Tablet profesional Apple", 32000, apple),
					new Producto("MacBook Air", "Laptop ultraligera Apple", 35000, apple),

					new Producto("Galaxy S23", "Smartphone Samsung última generación", 21000, samsung),
					new Producto("Smart TV 55\"", "Televisión inteligente Samsung", 15000, samsung),
					new Producto("Galaxy Buds", "Audífonos inalámbricos Samsung", 3500, samsung),

					new Producto("PlayStation 5", "Consola de videojuegos Sony", 12000, sony),
					new Producto("Cámara Alpha", "Cámara profesional Sony", 25000, sony),
					new Producto("Barra de sonido", "Sistema de audio Sony 2.1", 4800, sony),

					new Producto("Smart TV OLED", "Televisión LG OLED 65 pulgadas", 28000, lg),
					new Producto("Refrigerador Smart", "Refrigerador LG con WiFi", 22000, lg),
					new Producto("Lavadora automática", "Lavadora LG 10 kg", 9000, lg)
			);

			for (Producto p : productos) {
				Set<ConstraintViolation<Producto>> violations = validator.validate(p);
				if (violations.isEmpty()) {
					productoRepo.save(p);
				} else {
					violations.forEach(v -> System.out.println("Error Producto: " + v.getPropertyPath() + " " + v.getMessage()));
				}
			}

			// Mostrar productos agrupados por marca
			System.out.println("📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre() + " ($" + p.getPrecio() + ")"));
			});
		};
	}
}
