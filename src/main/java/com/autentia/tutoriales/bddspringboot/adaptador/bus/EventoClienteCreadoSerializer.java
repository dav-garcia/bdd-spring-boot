package com.autentia.tutoriales.bddspringboot.adaptador.bus;

import com.autentia.tutoriales.bddspringboot.adaptador.bus.dto.EventoClienteCreado;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

public class EventoClienteCreadoSerializer extends JsonSerializer<EventoClienteCreado> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        objectMapper.registerModule(new JavaTimeModule());
        super.configure(configs, isKey);
    }
}
