package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.evento.EventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.repositorio.RepositorioPerfilCliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ServicioEventoClienteCreadoTest {

    @MockBean
    private RepositorioPerfilCliente repositorio;

    @Autowired
    private ServicioEventoClienteCreado sut;

    @Test
    public void dadoEventoClienteCreadoEntoncesRegistraPerfilCliente() {
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
