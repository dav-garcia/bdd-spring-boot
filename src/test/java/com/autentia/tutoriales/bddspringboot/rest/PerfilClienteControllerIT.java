package com.autentia.tutoriales.bddspringboot.rest;

import com.autentia.tutoriales.bddspringboot.servicio.ServicioConsultaPerfilCliente;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PerfilClienteControllerIT {

    @MockBean
    private ServicioConsultaPerfilCliente servicio;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void dadoIdClienteExistenteEntoncesDevuelvePerfilCliente() {
        // Given
        UUID id = UUID.randomUUID();
        RespuestaPerfilCliente respuesta = new RespuestaPerfilCliente.Builder()
                .withId(id)
                .withNombre("David")
                .withFechaNacimiento(LocalDate.of(1976, 2, 28))
                .withEmail("dgarciagil@autentia.com")
                .withTelefono("+34 123456789")
                .build();
        doReturn(respuesta).when(servicio).consultar(id);

        // When
        ResponseEntity<RespuestaPerfilCliente> result = restTemplate.getForEntity("/cliente/perfil/{id}", RespuestaPerfilCliente.class, id);

        // Then
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
        RespuestaPerfilCliente respuestaResult = result.getBody();
        assertThat(respuestaResult.getId(), is(id));
        assertThat(respuestaResult.getNombre(), is("David"));
        assertThat(respuestaResult.getFechaNacimiento(), is(LocalDate.of(1976, 2, 28)));
        assertThat(respuestaResult.getEmail(), is("dgarciagil@autentia.com"));
        assertThat(respuestaResult.getTelefono(), is("+34 123456789"));
    }
}
