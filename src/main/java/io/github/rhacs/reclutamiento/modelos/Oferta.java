package io.github.rhacs.reclutamiento.modelos;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import io.github.rhacs.reclutamiento.Constantes;

@Entity
@Table(name = Constantes.TABLA_OFERTAS)
public class Oferta {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico de la {@link Oferta}
     */
    @Id
    @Column(name = Constantes.OFERTAS_ID)
    private Long id;

    /**
     * Fecha de la {@link Oferta}
     */
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    /**
     * Título de la {@link Oferta}
     */
    @NotEmpty
    @Size(max = 50)
    private String titulo;

    /**
     * Descripción de la {@link Oferta}
     */
    @NotEmpty
    @Size(max = 50)
    private String descripcion;

    /**
     * Salario de la {@link Oferta}
     */
    @NotNull
    private Double salario;

    /**
     * {@link Reclutador} de la {@link Oferta}
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = Constantes.RECLUTADORES_ID)
    private Reclutador reclutador;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la entidad {@link Oferta}
     */
    public Oferta() {

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
     * @return la fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @return el título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return la descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return el salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @return el {@link Reclutador}
     */
    public Reclutador getReclutador() {
        return reclutador;
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
     * @param fecha la fecha a establecer
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * @param titulo el título a establecer
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param descripcion la descripción a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param salario el salario a establecer
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @param reclutador el {@link Reclutador} a establecer
     */
    public void setReclutador(Reclutador reclutador) {
        this.reclutador = reclutador;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Oferta other = (Oferta) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("Oferta [id=%s, fecha=%s, titulo=%s, descripcion=%s, salario=%s, reclutador=%s]", id,
                fecha, titulo, descripcion, salario, reclutador);
    }

}
