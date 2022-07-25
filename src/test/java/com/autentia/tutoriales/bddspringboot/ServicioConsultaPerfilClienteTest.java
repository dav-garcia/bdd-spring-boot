package com.autentia.tutoriales.bddspringboot;

import com.autentia.tutoriales.bddspringboot.conversor.ConversorRespuestaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.adaptador.rest.dto.RespuestaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.impl.ServicioConsultaPerfilClienteImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ServicioConsultaPerfilClienteTest {

    private final RepositorioPerfilCliente repositorio = mock(RepositorioPerfilCliente.class);
    private final ConversorRespuestaPerfilCliente conversor = new ConversorRespuestaPerfilCliente();

    private final ServicioConsultaPerfilCliente sut = new ServicioConsultaPerfilClienteImpl(repositorio, conversor);

    @Test
    void dadoIdClienteExistenteEntoncesDevuelvePerfilCliente() {
        // Given
        UUID id = UUID.randomUUID();
        Optional<PerfilCliente> perfilOpcional = Optional.of(new PerfilCliente.Builder()
                .withId(id)
                .withNombre("David")
                .withFechaNacimiento(LocalDate.of(1976, 2, 28))
                .withEmail("dgarciagil@autentia.com")
                .withTelefono("+34 123456789")
                .build());
        doReturn(perfilOpcional).when(repositorio).findById(id);

        // When
        RespuestaPerfilCliente result = sut.consultar(id);

        // Then
        assertThat(result, is(not(nullValue())));
        assertThat(result.getId(), is(id));
        assertThat(result.getNombre(), is("David"));
        assertThat(result.getFechaNacimiento(), is(LocalDate.of(1976, 2, 28)));
        assertThat(result.getEmail(), is("dgarciagil@autentia.com"));
        assertThat(result.getTelefono(), is("+34 123456789"));

        ArgumentCaptor<UUID> idCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(repositorio).findById(idCaptor.capture());
        assertThat(idCaptor.getValue(), is(id));
    }
}
