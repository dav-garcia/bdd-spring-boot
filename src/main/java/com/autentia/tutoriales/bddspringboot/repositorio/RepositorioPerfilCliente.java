package com.autentia.tutoriales.bddspringboot.repositorio;

import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorioPerfilCliente extends JpaRepository<PerfilCliente, UUID> {
}
