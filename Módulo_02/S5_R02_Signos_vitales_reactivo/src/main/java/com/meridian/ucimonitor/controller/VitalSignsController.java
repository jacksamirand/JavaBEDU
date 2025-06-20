package com.meridian.ucimonitor.controller;

import com.meridian.ucimonitor.simulator.PatientSimulator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class VitalSignsController {

    private final PatientSimulator simulator;

    public VitalSignsController(PatientSimulator simulator) {
        this.simulator = simulator;
    }

    @GetMapping(value = "/critical-events", produces = "application/stream+json")
    public Flux<String> streamCriticalEvents() {
        return simulator.getCriticalEventsFlux();
    }
}
