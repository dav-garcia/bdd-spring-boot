package com.autentia.tutoriales.bddspringboot.adaptador.rest;

import com.autentia.tutoriales.bddspringboot.ServicioConsultaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.adaptador.rest.dto.RespuestaPerfilCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PerfilClienteController {

    private final ServicioConsultaPerfilCliente servicio;

    @Autowired
    public PerfilClienteController(ServicioConsultaPerfilCliente servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/cliente/perfil/{id}")
    public RespuestaPerfilCliente get(@PathVariable String id) {
        return servicio.consultar(UUID.fromString(id));
    }
}
