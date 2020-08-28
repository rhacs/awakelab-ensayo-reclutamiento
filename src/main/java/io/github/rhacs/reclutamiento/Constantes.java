package io.github.rhacs.reclutamiento;

public class Constantes {

    // Tablas
    // -----------------------------------------------------------------------------------------

    /**
     * Nombre de la tabla que contiene los registros para el repositorio de
     * {@link Postulante}s
     */
    public static final String TABLA_POSTULANTES = "postulantes";

    /**
     * Nombre de la tabla que contiene los registros para el repositorio de
     * {@link Reclutador}es
     */
    public static final String TABLA_RECLUTADORES = "reclutadores";

    /**
     * Nombre de la tabla que contiene los registros para el repositorio de
     * {@link Oferta}s
     */
    public static final String TABLA_OFERTAS = "ofertas";

    /**
     * Nombre de la tabla que contiene los registros de relación entre la tabla de
     * {@link Postulante}s y {@link Oferta}s
     */
    public static final String TABLA_POSTULACIONES = "postulaciones";

    // Llaves primarias
    // -----------------------------------------------------------------------------------------

    /**
     * Nombre de la llave primaria para la tabla {@value #TABLA_POSTULANTES}
     */
    public static final String POSTULANTES_ID = "idPostulante";

    /**
     * Nombre de la llave primaria para la tabla {@value #TABLA_RECLUTADORES}
     */
    public static final String RECLUTADORES_ID = "idReclutador";

    /**
     * Nombre de la llave primaria para la tabla {@value #TABLA_OFERTAS}
     */
    public static final String OFERTAS_ID = "idOferta";

    // Constructores
    // -----------------------------------------------------------------------------------------

    private Constantes() {
        // Constructor declarado privado para esconder el constructor público implícito
    }

}
