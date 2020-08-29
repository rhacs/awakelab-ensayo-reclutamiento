package io.github.rhacs.reclutamiento;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.github.rhacs.reclutamiento.modelos.Oferta;

public class Metodos {

    // Constructores
    // -----------------------------------------------------------------------------------------

    private Metodos() {
        // Constructor declarado privado para esconder el contructor público implícito
    }

    // Métodos
    // -----------------------------------------------------------------------------------------

    /**
     * Efectúa una petición GET a la API para obtener el listado de {@link Oferta}s
     * 
     * @return un objeto {@link List} que contiene los elementos devueltos por la
     *         API
     */
    public static List<Oferta> buscarOfertas() {
        // Establecer url de la API
        String url = "http://localhost/awakelab-ensayo-reclutamiento/api/ofertas";

        // Inicializar RestTemplate
        RestTemplate rest = new RestTemplate();

        // Efectuar consulta y capturar respuesta
        ResponseEntity<Oferta[]> respuesta = rest.getForEntity(url, Oferta[].class);

        // Procesar respuesta y devolver listado
        return Arrays.asList(respuesta.getBody());
    }

}
