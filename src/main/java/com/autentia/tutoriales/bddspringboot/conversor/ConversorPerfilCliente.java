package com.autentia.tutoriales.bddspringboot.conversor;

import com.autentia.tutoriales.bddspringboot.modelo.PerfilCliente;
import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConversorPerfilCliente implements Converter<PerfilCliente, RespuestaPerfilCliente> {
    @Override
    public RespuestaPerfilCliente convert(PerfilCliente source) {
        return source == null ? null : new RespuestaPerfilCliente.Builder()
                .withId(source.getId())
                .withNombre(source.getNombre())
                .withFechaNacimiento(source.getFechaNacimiento())
                .withEmail(source.getEmail())
                .withTelefono(source.getTelefono())
                .build();
    }
}
