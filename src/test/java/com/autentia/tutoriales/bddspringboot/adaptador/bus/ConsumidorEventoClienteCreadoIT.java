package com.autentia.tutoriales.bddspringboot.adaptador.bus;

import com.autentia.tutoriales.bddspringboot.adaptador.bus.EventoClienteCreadoSerializer;
import com.autentia.tutoriales.bddspringboot.adaptador.bus.UuidSerializer;
import com.autentia.tutoriales.bddspringboot.adaptador.bus.dto.EventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.ServicioEventoClienteCreado;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@SpringBootTest
@EmbeddedKafka(topics = EventoClienteCreado.TOPIC,
        brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "auto.create.topics.enable=false"})
class ConsumidorEventoClienteCreadoIT {

    @TestConfiguration
    public static class TestConfig {

        @Bean
        public ProducerFactory<UUID, EventoClienteCreado> producerFactory(EmbeddedKafkaBroker kafkaEmbedded) {
            Map<String, Object> props = KafkaTestUtils.producerProps(kafkaEmbedded);
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, UuidSerializer.class);
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EventoClienteCreadoSerializer.class);
            props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
            return new DefaultKafkaProducerFactory<>(props);
        }

        @Bean
        public KafkaTemplate<UUID, EventoClienteCreado> kafkaTemplate(ProducerFactory<UUID, EventoClienteCreado> producerFactory) {
            KafkaTemplate<UUID, EventoClienteCreado> kafkaTemplate = new KafkaTemplate<>(producerFactory);
            kafkaTemplate.setDefaultTopic(EventoClienteCreado.TOPIC);
            return kafkaTemplate;
        }
    }

    @MockBean
    private ServicioEventoClienteCreado servicio;

    @Autowired
    private EmbeddedKafkaBroker kafkaEmbedded;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Autowired
    private KafkaTemplate<UUID, EventoClienteCreado> kafkaTemplate;

    @BeforeEach
    void setUp() {
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry.getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer, kafkaEmbedded.getPartitionsPerTopic());
        }
    }

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
        kafkaTemplate.send(EventoClienteCreado.TOPIC, id, evento);

        // Then
        ArgumentCaptor<EventoClienteCreado> eventoCaptor = ArgumentCaptor.forClass(EventoClienteCreado.class);
        verify(servicio, timeout(10000)).registrar(eventoCaptor.capture());
        EventoClienteCreado result = eventoCaptor.getValue();

        assertThat(result, is(not(nullValue())));
        assertThat(result.getId(), is(id));
        assertThat(result.getNombre(), is("David"));
        assertThat(result.getFechaNacimiento(), is(LocalDate.of(1976, 2, 28)));
        assertThat(result.getEmail(), is("dgarciagil@autentia.com"));
        assertThat(result.getTelefono(), is("+34 123456789"));
    }
}
