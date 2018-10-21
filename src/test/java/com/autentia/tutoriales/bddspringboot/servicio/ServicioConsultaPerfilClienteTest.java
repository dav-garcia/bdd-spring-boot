package com.autentia.tutoriales.bddspringboot.servicio;

import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.repositorio.RepositorioPerfilCliente;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ServicioConsultaPerfilClienteTest {

    @MockBean
    private RepositorioPerfilCliente repositorio;

    @Autowired
    private ServicioConsultaPerfilCliente sut;

    @Test
    public void dadoIdClienteExistenteEntoncesDevuelvePerfilCliente() {
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
