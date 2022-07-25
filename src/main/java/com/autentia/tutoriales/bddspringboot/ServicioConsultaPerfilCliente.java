package com.autentia.tutoriales.bddspringboot;

import com.autentia.tutoriales.bddspringboot.adaptador.rest.dto.RespuestaPerfilCliente;

import java.util.UUID;

public interface ServicioConsultaPerfilCliente {

    RespuestaPerfilCliente consultar(UUID idCliente);
}
