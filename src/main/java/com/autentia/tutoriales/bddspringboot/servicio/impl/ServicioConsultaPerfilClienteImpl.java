package com.autentia.tutoriales.bddspringboot.servicio.impl;

import com.autentia.tutoriales.bddspringboot.conversor.ConversorPerfilCliente;
import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.repositorio.RepositorioPerfilCliente;
import com.autentia.tutoriales.bddspringboot.servicio.ServicioConsultaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ServicioConsultaPerfilClienteImpl implements ServicioConsultaPerfilCliente {

    private final RepositorioPerfilCliente repositorio;
    private final ConversorPerfilCliente conversor;

    @Autowired
    public ServicioConsultaPerfilClienteImpl(RepositorioPerfilCliente repositorio, ConversorPerfilCliente conversor) {
        this.repositorio = repositorio;
        this.conversor = conversor;
    }

    @Override
    public RespuestaPerfilCliente consultar(UUID idCliente) {
        Optional<PerfilCliente> perfilOpcional = repositorio.findById(idCliente);
        return conversor.convert(perfilOpcional.orElse(null));
    }
}
