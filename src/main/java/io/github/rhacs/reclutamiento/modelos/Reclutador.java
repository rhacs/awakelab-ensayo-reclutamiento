package io.github.rhacs.reclutamiento.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.github.rhacs.reclutamiento.Constantes;

@Entity
@Table(name = Constantes.TABLA_RECLUTADORES)
public class Reclutador {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico del {@link Reclutador}
     */
    @Id
    @Column(name = Constantes.RECLUTADORES_ID)
    private Long id;

    /**
     * Nombre de fantasía del {@link Reclutador}
     */
    @NotEmpty
    @Size(max = 50)
    private String nombreFantasia;

    /**
     * Razón social del {@link Reclutador}
     */
    @NotEmpty
    @Size(max = 50)
    private String razonSocial;

    /**
     * Rol Único Tributario del {@link Reclutador}
     */
    @NotEmpty
    @Size(max = 11)
    private String rut;

    /**
     * Dirección de Correo Electrónico del {@link Reclutador}
     */
    @NotEmpty
    @Email
    @Size(max = 50)
    private String email;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la entidad {@link Reclutador}
     */
    public Reclutador() {

    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico
     */
    public Long getId() {
        return id;
    }

    /**
     * @return el nombre de fantasía
     */
    public String getNombreFantasia() {
        return nombreFantasia;
    }

    /**
     * @return la razón social
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @return el rol único tributario
     */
    public String getRut() {
        return rut;
    }

    /**
     * @return la dirección de correo electrónico
     */
    public String getEmail() {
        return email;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador numérico a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nombreFantasia el nombre de fantasía a establecer
     */
    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    /**
     * @param razonSocial la razón social a establecer
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @param rut el rol único tributario a establecer
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * @param email la dirección de correo electrónico a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(email, id, rut);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Reclutador other = (Reclutador) obj;

        return Objects.equals(email, other.email) || Objects.equals(id, other.id) || Objects.equals(rut, other.rut);
    }

    @Override
    public String toString() {
        return String.format("Reclutador [id=%s, nombreFantasia=%s, razonSocial=%s, rut=%s, email=%s]", id,
                nombreFantasia, razonSocial, rut, email);
    }

}
