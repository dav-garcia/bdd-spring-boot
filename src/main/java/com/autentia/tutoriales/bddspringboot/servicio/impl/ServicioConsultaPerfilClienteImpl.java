package com.autentia.tutoriales.bddspringboot.servicio.impl;

import com.autentia.tutoriales.bddspringboot.servicio.ServicioConsultaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;

import java.util.UUID;

public class ServicioConsultaPerfilClienteImpl implements ServicioConsultaPerfilCliente {

    @Override
    public RespuestaPerfilCliente consultar(UUID idCliente) {
        return new RespuestaPerfilCliente();
    }
}
