package com.autentia.tutoriales.bddspringboot.impl;

import com.autentia.tutoriales.bddspringboot.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.RepositorioPerfilCliente;
import com.autentia.tutoriales.bddspringboot.ServicioConsultaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.conversor.ConversorRespuestaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.adaptador.rest.dto.RespuestaPerfilCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ServicioConsultaPerfilClienteImpl implements ServicioConsultaPerfilCliente {

    private final RepositorioPerfilCliente repositorio;
    private final ConversorRespuestaPerfilCliente conversor;

    @Autowired
    public ServicioConsultaPerfilClienteImpl(RepositorioPerfilCliente repositorio, ConversorRespuestaPerfilCliente conversor) {
        this.repositorio = repositorio;
        this.conversor = conversor;
    }

    @Override
    public RespuestaPerfilCliente consultar(UUID idCliente) {
        Optional<PerfilCliente> perfilOpcional = repositorio.findById(idCliente);
        return conversor.convert(perfilOpcional.orElse(null));
    }
}
