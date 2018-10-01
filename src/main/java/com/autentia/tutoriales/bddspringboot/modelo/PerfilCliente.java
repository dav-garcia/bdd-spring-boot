package com.autentia.tutoriales.bddspringboot.modelo;

import com.autentia.tutoriales.bddspringboot.vo.RespuestaPerfilCliente;

import java.time.LocalDate;
import java.util.UUID;

public class PerfilCliente {

    private UUID id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;
    private String telefono;

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RespuestaPerfilCliente)) return false;
        PerfilCliente that = (PerfilCliente) o;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    public static class Builder {

        private final PerfilCliente object;

        public Builder() {
            object = new PerfilCliente();
        }

        public Builder withId(UUID value) {
            object.id = value;
            return this;
        }

        public Builder withNombre(String value) {
            object.nombre = value;
            return this;
        }

        public Builder withFechaNacimiento(LocalDate value) {
            object.fechaNacimiento = value;
            return this;
        }

        public Builder withEmail(String value) {
            object.email = value;
            return this;
        }

        public Builder withTelefono(String value) {
            object.telefono = value;
            return this;
        }

        public PerfilCliente build() {
            return object;
        }
    }
}
