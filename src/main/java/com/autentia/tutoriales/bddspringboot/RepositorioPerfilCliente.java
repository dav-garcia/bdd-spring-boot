package com.autentia.tutoriales.bddspringboot;

import java.util.Optional;
import java.util.UUID;

public interface RepositorioPerfilCliente {

    Optional<PerfilCliente> findById(final UUID idCliente);
    PerfilCliente save(final PerfilCliente perfil);
    void deleteById(final UUID idCliente);
}
