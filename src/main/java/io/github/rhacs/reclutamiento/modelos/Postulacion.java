package io.github.rhacs.reclutamiento.modelos;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import io.github.rhacs.reclutamiento.Constantes;

@Entity
@Table(name = Constantes.TABLA_POSTULACIONES)
public class Postulacion {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * El identificador de la {@link Postulacion}
     */
    @EmbeddedId
    private PostulacionesPK id;

    /**
     * {@link Postulante} de la {@link Postulacion}
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId(value = "postulanteId")
    @JoinColumn(name = Constantes.POSTULANTES_ID)
    private Postulante postulante;

    /**
     * {@link Oferta} de la {@link Postulacion}
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId(value = "ofertaId")
    @JoinColumn(name = Constantes.OFERTAS_ID)
    private Oferta oferta;

    /**
     * Fecha de la {@link Postulacion}
     */
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la entidad {@link Postulacion}
     */
    public Postulacion() {

    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador
     */
    public PostulacionesPK getId() {
        return id;
    }

    /**
     * @return el {@link Postulante}
     */
    public Postulante getPostulante() {
        return postulante;
    }

    /**
     * @return la {@link Oferta}
     */
    public Oferta getOferta() {
        return oferta;
    }

    /**
     * @return la fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador a establecer
     */
    public void setId(PostulacionesPK id) {
        this.id = id;
    }

    /**
     * @param postulante el {@link Postulante} a establecer
     */
    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    /**
     * @param oferta la {@link Oferta} a establecer
     */
    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    /**
     * @param fecha la fecha a establecer
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

        Postulacion other = (Postulacion) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("Postulacion [id=%s, postulante=%s, oferta=%s, fecha=%s]", id, postulante, oferta, fecha);
    }

}
