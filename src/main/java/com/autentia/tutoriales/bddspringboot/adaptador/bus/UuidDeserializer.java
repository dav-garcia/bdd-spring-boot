package com.autentia.tutoriales.bddspringboot.adaptador.bus;

import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

public class UuidDeserializer implements Deserializer<UUID> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Empty
    }

    @Override
    public UUID deserialize(String topic, byte[] data) {
        return data == null ? null : UUID.fromString(new String(data, StandardCharsets.UTF_8));
    }

    @Override
    public void close() {
        // Empty
    }
}
