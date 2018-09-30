package com.autentia.tutoriales.bddspringboot.servicio.impl;

import com.autentia.tutoriales.bddspringboot.servicio.ServicioConsultaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;

import java.time.LocalDate;
import java.util.UUID;

public class ServicioConsultaPerfilClienteImpl implements ServicioConsultaPerfilCliente {

    @Override
    public RespuestaPerfilCliente consultar(UUID idCliente) {
        return new RespuestaPerfilCliente.Builder()
        .withId(idCliente)
        .withNombre("David")
        .withFechaNacimiento(LocalDate.of(1976,2,28))
        .withEmail("dgarciagil@autentia.com")
        .withTelefono("+34 123456789")
        .build();
    }
}
