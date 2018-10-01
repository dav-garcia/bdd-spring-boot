package com.autentia.tutoriales.bddspringboot.conversor;

import com.autentia.tutoriales.bddspringboot.evento.EventoPerfilClienteCreado;
import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConversorEventoPerfilClienteCreado implements Converter<EventoPerfilClienteCreado, PerfilCliente> {

    @Override
    public PerfilCliente convert(EventoPerfilClienteCreado source) {
        return new PerfilCliente.Builder()
                .withId(source.getId())
                .withNombre(source.getNombre())
                .withFechaNacimiento(source.getFechaNacimiento())
                .withEmail(source.getEmail())
                .withTelefono(source.getTelefono())
                .build();
    }
}
