package com.autentia.tutoriales.bddspringboot.repositorio;

import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;

import java.util.UUID;

public interface RepositorioPerfilCliente {

    PerfilCliente findById(UUID id);
}
