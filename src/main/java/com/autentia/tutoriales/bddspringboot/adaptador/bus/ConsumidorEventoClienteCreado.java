package com.autentia.tutoriales.bddspringboot.adaptador.bus;

import com.autentia.tutoriales.bddspringboot.adaptador.bus.dto.EventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.ServicioEventoClienteCreado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorEventoClienteCreado {

    private final ServicioEventoClienteCreado servicio;

    @Autowired
    public ConsumidorEventoClienteCreado(ServicioEventoClienteCreado servicio) {
        this.servicio = servicio;
    }

    @KafkaListener(topics = EventoClienteCreado.TOPIC, groupId = "bdd-spring-boot")
    public void procesarEvento(Acknowledgment ack, @Payload EventoClienteCreado evento) {
        servicio.registrar(evento);
        ack.acknowledge();
    }
}
