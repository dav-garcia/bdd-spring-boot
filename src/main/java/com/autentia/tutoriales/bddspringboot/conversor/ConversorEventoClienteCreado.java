package com.autentia.tutoriales.bddspringboot.conversor;

import com.autentia.tutoriales.bddspringboot.adaptador.bus.dto.EventoClienteCreado;
import com.autentia.tutoriales.bddspringboot.PerfilCliente;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConversorEventoClienteCreado implements Converter<EventoClienteCreado, PerfilCliente> {

    @Override
    public PerfilCliente convert(EventoClienteCreado source) {
        return new PerfilCliente.Builder()
                .withId(source.getId())
                .withNombre(source.getNombre())
                .withFechaNacimiento(source.getFechaNacimiento())
                .withEmail(source.getEmail())
                .withTelefono(source.getTelefono())
                .build();
    }
}
