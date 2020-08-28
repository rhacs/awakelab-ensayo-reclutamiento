package io.github.rhacs.reclutamiento.modelos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.github.rhacs.reclutamiento.Constantes;

@Embeddable
public class PostulacionesPK implements Serializable {

    // Constantes
    // -----------------------------------------------------------------------------------------

    /**
     * Número de serie de la clase
     */
    private static final long serialVersionUID = 3890716446285308818L;

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico del {@link Postulante}
     */
    @Column(name = Constantes.POSTULANTES_ID)
    private Long postulanteId;

    /**
     * Identificador numérico de la {@link Oferta}
     */
    @Column(name = Constantes.OFERTAS_ID)
    private Long ofertaId;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la llave compuesta {@link PostulacionesPK}
     */
    public PostulacionesPK() {

    }

    /**
     * Crea una nueva instancia de la llave compuesta {@link PostulacionesPK}
     * 
     * @param postulanteId identificador numérico del {@link Postulante}
     * @param ofertaId     identificador numérico de la {@link Oferta}
     */
    public PostulacionesPK(Long postulanteId, Long ofertaId) {
        this.postulanteId = postulanteId;
        this.ofertaId = ofertaId;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico del {@link Postulante}
     */
    public Long getPostulanteId() {
        return postulanteId;
    }

    /**
     * @return el identificador numérico de la {@link Oferta}
     */
    public Long getOfertaId() {
        return ofertaId;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param postulanteId el identificador numérico del {@link Postulante} a
     *                     establecer
     */
    public void setPostulanteId(Long postulanteId) {
        this.postulanteId = postulanteId;
    }

    /**
     * @param ofertaId el identificador numérico de la {@link Oferta} a establecer
     */
    public void setOfertaId(Long ofertaId) {
        this.ofertaId = ofertaId;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(ofertaId, postulanteId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        PostulacionesPK other = (PostulacionesPK) obj;

        return Objects.equals(ofertaId, other.ofertaId) && Objects.equals(postulanteId, other.postulanteId);
    }

    @Override
    public String toString() {
        return String.format("PostulacionesPK [postulanteId=%s, ofertaId=%s]", postulanteId, ofertaId);
    }

}
