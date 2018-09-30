package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.servicio.impl.ServicioConsultaPerfilClienteImpl;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ServicioConsultaPerfilClienteTest {

    private final ServicioConsultaPerfilCliente sut = new ServicioConsultaPerfilClienteImpl();

    @Test
    public void dadoIdClienteExistenteEntoncesDevuelvePerfilCliente() {
        // Given
        // ???

        // When
        RespuestaPerfilCliente result = sut.consultar(null);

        // Then
        assertThat(result, is(not(nullValue())));
    }
}
