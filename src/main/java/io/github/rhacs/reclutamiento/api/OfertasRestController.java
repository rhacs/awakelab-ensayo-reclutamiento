package io.github.rhacs.reclutamiento.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rhacs.reclutamiento.modelos.Oferta;
import io.github.rhacs.reclutamiento.repositorios.OfertasRepositorio;

@RestController
@RequestMapping(path = "/api/ofertas", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfertasRestController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link OfertasRepositorio} que contiene los métodos de manipulación y
     * consulta para el repositorio de {@link Oferta}s
     */
    @Autowired
    private OfertasRepositorio ofertasRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el listado de {@link Oferta}s disponibles en el repositorio,
     * ordenadas por fecha descendentemente
     * 
     * @return un objeto {@link List} con la respuesta a la solicitud
     */
    @GetMapping
    public List<Oferta> mostrarTodas() {
        return ofertasRepositorio.findAll(Sort.by(Order.desc("fecha")));
    }

}
