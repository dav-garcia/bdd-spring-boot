package com.autentia.tutoriales.bddspringboot.repositorio;

import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositorioPerfilClienteTest {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private RepositorioPerfilCliente sut;

    @Test
    public void dadoQueGuardoUnRegistroEntoncesPuedoRecuperarlo() {
        // Given
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        UUID id = UUID.randomUUID();
        PerfilCliente perfil = new PerfilCliente.Builder()
                .withId(id)
                .withNombre("David")
                .withFechaNacimiento(LocalDate.of(1976, 2, 28))
                .withEmail("dgarciagil@autentia.com")
                .withTelefono("+34 123456789")
                .build();

        // When
        transactionTemplate.execute(s -> sut.save(perfil));
        Optional<PerfilCliente> resultOpcional = transactionTemplate.execute(s -> sut.findById(id));

        // Then
        PerfilCliente result = resultOpcional.orElse(null);
        assertThat(result, is(not(nullValue())));
        assertThat(result.getId(), is(id));
        assertThat(result.getNombre(), is("David"));
        assertThat(result.getFechaNacimiento(), is(LocalDate.of(1976, 2, 28)));
        assertThat(result.getEmail(), is("dgarciagil@autentia.com"));
        assertThat(result.getTelefono(), is("+34 123456789"));
    }
}
