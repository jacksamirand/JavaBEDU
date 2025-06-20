package com.meridian.prime.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SistemaService {

    public Flux<String> trafico() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> ThreadLocalRandom.current().nextInt(50, 101)) // más probabilidad de alerta
                .filter(nivel -> nivel > 70)
                .map(nivel -> "🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar")
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel());
    }

    public Flux<String> contaminacion() {
        return Flux.interval(Duration.ofMillis(600))
                .map(i -> ThreadLocalRandom.current().nextInt(30, 80))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)")
                .subscribeOn(Schedulers.parallel());
    }

    public Flux<String> accidentes() {
        List<String> prioridades = List.of("Baja", "Media", "Alta");
        return Flux.interval(Duration.ofMillis(800))
                .map(i -> prioridades.get(ThreadLocalRandom.current().nextInt(3)))
                .filter(p -> p.equals("Alta"))
                .map(p -> "🚑 Emergencia vial: Accidente con prioridad " + p)
                .subscribeOn(Schedulers.parallel());
    }

    public Flux<String> trenes() {
        return Flux.interval(Duration.ofMillis(700))
                .map(i -> ThreadLocalRandom.current().nextInt(0, 11))
                .filter(min -> min > 5)
                .map(min -> "🚝 Tren maglev con retraso crítico: " + min + " minutos")
                .delayElements(Duration.ofMillis(300)) // simulate backpressure
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel());
    }

    public Flux<String> semaforos() {
        return Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    int idx = ThreadLocalRandom.current().nextInt(3);
                    return List.of("Verde", "Amarillo", "Rojo").get(idx);
                })
                .scan(0, (acc, estado) -> estado.equals("Rojo") ? acc + 1 : 0)
                .filter(rojos -> rojos >= 3)
                .map(rojos -> "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte")
                .distinctUntilChanged()
                .subscribeOn(Schedulers.parallel());
    }

    public Flux<String> eventosCriticos() {
        return Flux.merge(trafico(), contaminacion(), accidentes(), trenes(), semaforos())
                .publish()
                .autoConnect();
    }

    public Flux<String> alertaGlobal() {
        return eventosCriticos()
                .buffer(Duration.ofSeconds(2)) // agrupamos cada 2 segundos
                .filter(lista -> lista.size() >= 3)
                .map(lista -> "\n🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime\n")
                .subscribeOn(Schedulers.parallel());
    }
}