package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.evento.EventoPerfilClienteCreado;
import com.autentia.tutoriales.bddspringboot.servicio.impl.ServicioEventoPerfilClienteCreadoImpl;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

public class ServicioEventoPerfilClienteCreadoTest {

    private final ServicioEventoPerfilClienteCreado sut = new ServicioEventoPerfilClienteCreadoImpl();

    @Test
    public void dadoEventoPerfilClienteCreadoEntoncesRegistraPerfilCliente() {
        // Given
        UUID id = UUID.randomUUID();
        EventoPerfilClienteCreado evento = new EventoPerfilClienteCreado.Builder()
                .withId(id)
                .withNombre("David")
                .withFechaNacimiento(LocalDate.of(1976, 2, 28))
                .withEmail("dgarciagil@autentia.com")
                .withTelefono("+34 123456789")
                .build();

        // When
        sut.registrar(evento);

        // Then
    }
}
