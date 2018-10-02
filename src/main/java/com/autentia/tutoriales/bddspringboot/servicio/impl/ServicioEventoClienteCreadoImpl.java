package com.autentia.tutoriales.bddspringboot.servicio.impl;

import com.autentia.tutoriales.bddspringboot.conversor.ConversorEventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.evento.EventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.repositorio.RepositorioPerfilCliente;
import com.autentia.tutoriales.bddspringboot.servicio.ServicioEventoClienteCreado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEventoClienteCreadoImpl implements ServicioEventoClienteCreado {

    private final RepositorioPerfilCliente repositorio;
    private final ConversorEventoClienteCreado conversor;

    @Autowired
    public ServicioEventoClienteCreadoImpl(RepositorioPerfilCliente repositorio, ConversorEventoClienteCreado conversor) {
        this.repositorio = repositorio;
        this.conversor = conversor;
    }

    @Override
    public void registrar(EventoClienteCreado evento) {
        PerfilCliente perfil = conversor.convert(evento);
        repositorio.save(perfil);
    }
}
