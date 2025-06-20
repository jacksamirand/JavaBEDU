package com.meridian.ucimonitor.simulator;

import com.meridian.ucimonitor.model.VitalSigns;
import com.meridian.ucimonitor.service.VitalSignsService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class PatientSimulator {

    private final VitalSignsService service = new VitalSignsService();

    public Flux<String> getCriticalEventsFlux() {
        Flux<VitalSigns> patient1 = service.generatePatientData(1);
        Flux<VitalSigns> patient2 = service.generatePatientData(2);
        Flux<VitalSigns> patient3 = service.generatePatientData(3);

        return Flux.merge(patient1, patient2, patient3)
                .filter(this::isCritical)
                .delayElements(Duration.ofSeconds(1)) // backpressure
                .map(this::buildAlertMessage);
    }

    private boolean isCritical(VitalSigns v) {
        return v.getHeartRate() < 50 || v.getHeartRate() > 120
                || v.getSystolicBP() < 90 || v.getSystolicBP() > 140
                || v.getDiastolicBP() < 60 || v.getDiastolicBP() > 90
                || v.getOxygen() < 90;
    }

    private String buildAlertMessage(VitalSigns v) {
        StringBuilder alert = new StringBuilder();
        if (v.getHeartRate() < 50 || v.getHeartRate() > 120) {
            alert.append(String.format("⚠️ Paciente %d - FC crítica: %d bpm%n", v.getPatientId(), v.getHeartRate()));
        }
        if (v.getSystolicBP() < 90 || v.getSystolicBP() > 140 ||
                v.getDiastolicBP() < 60 || v.getDiastolicBP() > 90) {
            alert.append(String.format("⚠️ Paciente %d - PA crítica: %d/%d mmHg%n", v.getPatientId(), v.getSystolicBP(), v.getDiastolicBP()));
        }
        if (v.getOxygen() < 90) {
            alert.append(String.format("⚠️ Paciente %d - SpO2 baja: %d%%%n", v.getPatientId(), v.getOxygen()));
        }
        return alert.toString();
    }
}
