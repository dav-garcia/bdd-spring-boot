package com.autentia.tutoriales.bddspringboot;

import com.autentia.tutoriales.bddspringboot.conversor.ConversorEventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.adaptador.bus.dto.EventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.impl.ServicioEventoClienteCreadoImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ServicioEventoClienteCreadoTest {

    private final RepositorioPerfilCliente repositorio = mock(RepositorioPerfilCliente.class);
    private final ConversorEventoClienteCreado conversor = new ConversorEventoClienteCreado();

    private final ServicioEventoClienteCreado sut = new ServicioEventoClienteCreadoImpl(repositorio, conversor);

    @Test
    void dadoEventoClienteCreadoEntoncesRegistraPerfilCliente() {
        // Given
        UUID id = UUID.randomUUID();
        EventoClienteCreado evento = new EventoClienteCreado.Builder()
                .withId(id)
                .withNombre("David")
                .withFechaNacimiento(LocalDate.of(1976, 2, 28))
                .withEmail("dgarciagil@autentia.com")
                .withTelefono("+34 123456789")
                .build();

        // When
        sut.registrar(evento);

        // Then
        ArgumentCaptor<PerfilCliente> perfilCaptor = ArgumentCaptor.forClass(PerfilCliente.class);
        verify(repositorio).save(perfilCaptor.capture());
        PerfilCliente perfil = perfilCaptor.getValue();
        assertThat(perfil, is(not(nullValue())));
        assertThat(perfil.getId(), is(id));
        assertThat(perfil.getNombre(), is("David"));
        assertThat(perfil.getFechaNacimiento(), is(LocalDate.of(1976, 2, 28)));
        assertThat(perfil.getEmail(), is("dgarciagil@autentia.com"));
        assertThat(perfil.getTelefono(), is("+34 123456789"));
    }
}
