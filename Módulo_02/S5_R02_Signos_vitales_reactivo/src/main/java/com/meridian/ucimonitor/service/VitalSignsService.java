package com.meridian.ucimonitor.service;

import com.meridian.ucimonitor.model.VitalSigns;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class VitalSignsService {

    public Flux<VitalSigns> generatePatientData(int patientId) {
        return Flux.interval(Duration.ofMillis(300))
                .map(tick -> new VitalSigns(
                        patientId,
                        random(40, 140),     // FC
                        random(80, 160),     // PA sistólica
                        random(50, 100),     // PA diastólica
                        random(85, 100)      // SpO2
                ));
    }

    private int random(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
