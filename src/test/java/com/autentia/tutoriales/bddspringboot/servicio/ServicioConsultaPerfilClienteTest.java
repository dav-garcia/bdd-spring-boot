package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.servicio.impl.ServicioConsultaPerfilClienteImpl;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ServicioConsultaPerfilClienteTest {

    private final ServicioConsultaPerfilCliente sut = new ServicioConsultaPerfilClienteImpl();

    @Test
    public void dadoIdClienteExistenteEntoncesDevuelvePerfilCliente() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        RespuestaPerfilCliente result = sut.consultar(id);

        // Then
        assertThat(result, is(not(nullValue())));
        assertThat(result.getId(), is(id));
        assertThat(result.getNombre(), is("David"));
        assertThat(result.getFechaNacimiento(), is(LocalDate.of(1976, 2, 28)));
        assertThat(result.getEmail(), is("dgarciagil@autentia.com"));
        assertThat(result.getTelefono(), is("+34 123456789"));
    }
}
