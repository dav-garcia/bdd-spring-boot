package com.autentia.tutoriales.bddspringboot.impl;

import com.autentia.tutoriales.bddspringboot.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.RepositorioPerfilCliente;
import com.autentia.tutoriales.bddspringboot.ServicioEventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.conversor.ConversorEventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.adaptador.bus.dto.EventoClienteCreado;
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
