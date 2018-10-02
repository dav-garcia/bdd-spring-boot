package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.evento.EventoClienteCreado;

public interface ServicioEventoClienteCreado {

    void registrar(EventoClienteCreado evento);
}
