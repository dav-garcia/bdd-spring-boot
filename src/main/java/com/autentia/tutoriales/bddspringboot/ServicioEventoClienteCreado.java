package com.autentia.tutoriales.bddspringboot;

import com.autentia.tutoriales.bddspringboot.adaptador.bus.dto.EventoClienteCreado;

public interface ServicioEventoClienteCreado {

    void registrar(EventoClienteCreado evento);
}
