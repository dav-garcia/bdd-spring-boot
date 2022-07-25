package com.autentia.tutoriales.bddspringboot.adaptador.bus;

import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

public class UuidSerializer implements Serializer<UUID> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Empty
    }

    @Override
    public byte[] serialize(String topic, UUID data) {
        return data == null ? null : data.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void close() {
        // Empty
    }
}
