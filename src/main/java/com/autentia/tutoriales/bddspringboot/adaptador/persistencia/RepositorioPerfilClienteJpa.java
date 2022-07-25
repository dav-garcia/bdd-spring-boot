package com.autentia.tutoriales.bddspringboot.adaptador.persistencia;

import com.autentia.tutoriales.bddspringboot.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.RepositorioPerfilCliente;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface RepositorioPerfilClienteJpa extends RepositorioPerfilCliente, Repository<PerfilCliente, UUID> {
}
