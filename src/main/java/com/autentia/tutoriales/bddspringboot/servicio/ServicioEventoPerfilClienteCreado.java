package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.evento.EventoPerfilClienteCreado;

public interface ServicioEventoPerfilClienteCreado {

    void registrar(EventoPerfilClienteCreado evento);
}
