package com.meridian.prime.controller;

import com.meridian.prime.service.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sistema")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @GetMapping(value = "/eventos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> eventos() {
        return sistemaService.eventosCriticos();
    }

    @GetMapping(value = "/alertas", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> alertas() {
        return sistemaService.alertaGlobal();
    }
}