package com.autentia.tutoriales.bddspringboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(schema = "perfil", name = "perfil_cliente")
public class PerfilCliente {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
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
        if (!(o instanceof PerfilCliente)) return false;
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
