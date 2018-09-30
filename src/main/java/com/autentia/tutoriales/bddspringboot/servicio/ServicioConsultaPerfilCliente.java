package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;

import java.util.UUID;

public interface ServicioConsultaPerfilCliente {

    RespuestaPerfilCliente consultar(UUID idCliente);
}
