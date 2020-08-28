package io.github.rhacs.reclutamiento.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.github.rhacs.reclutamiento.Constantes;

@Entity
@Table(name = Constantes.TABLA_POSTULANTES)
public class Postulante {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico del {@link Postulante}
     */
    @Id
    @Column(name = Constantes.POSTULANTES_ID)
    private Long id;

    /**
     * Nombre del {@link Postulante}
     */
    @NotEmpty
    @Size(max = 50)
    private String nombre;

    /**
     * Apellido del {@link Postulante}
     */
    @NotEmpty
    @Size(max = 50)
    private String apellido;

    /**
     * Rol Único Tributario del {@link Postulante}
     */
    @NotEmpty
    @Size(max = 11)
    private String rut;

    /**
     * Dirección de correo electrónico del {@link Postulante}
     */
    @NotEmpty
    @Size(max = 50)
    private String email;

    /**
     * Resumen del {@link Postulante}
     */
    @NotEmpty
    private String resumen;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la entidad {@link Postulante}
     */
    public Postulante() {

    }

    // Métodos
    // -----------------------------------------------------------------------------------------

    /**
     * @return el nombre completo del {@link Postulante}
     */
    public String getNombreCompleto() {
        return String.format("%s %s", nombre, apellido);
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
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el apellido
     */
    public String getApellido() {
        return apellido;
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

    /**
     * @return el resumen
     */
    public String getResumen() {
        return resumen;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador numérico a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param apellido el apellido a establecer
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    /**
     * @param resumen el resumen a establecer
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
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

        Postulante other = (Postulante) obj;

        return Objects.equals(email, other.email) || Objects.equals(id, other.id) || Objects.equals(rut, other.rut);
    }

    @Override
    public String toString() {
        return String.format("Postulante [id=%s, nombre=%s, apellido=%s, rut=%s, email=%s, resumen=%s]", id, nombre,
                apellido, rut, email, resumen);
    }

}
