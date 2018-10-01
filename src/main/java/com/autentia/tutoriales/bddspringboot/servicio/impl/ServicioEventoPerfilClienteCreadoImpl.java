package com.autentia.tutoriales.bddspringboot.servicio.impl;

import com.autentia.tutoriales.bddspringboot.conversor.ConversorEventoPerfilClienteCreado;
import com.autentia.tutoriales.bddspringboot.evento.EventoPerfilClienteCreado;
import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.repositorio.RepositorioPerfilCliente;
import com.autentia.tutoriales.bddspringboot.servicio.ServicioEventoPerfilClienteCreado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEventoPerfilClienteCreadoImpl implements ServicioEventoPerfilClienteCreado {

    private final RepositorioPerfilCliente repositorio;
    private final ConversorEventoPerfilClienteCreado conversor;

    @Autowired
    public ServicioEventoPerfilClienteCreadoImpl(RepositorioPerfilCliente repositorio, ConversorEventoPerfilClienteCreado conversor) {
        this.repositorio = repositorio;
        this.conversor = conversor;
    }

    @Override
    public void registrar(EventoPerfilClienteCreado evento) {
        PerfilCliente perfil = conversor.convert(evento);
        repositorio.save(perfil);
    }
}
