package io.github.rhacs.reclutamiento.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.rhacs.reclutamiento.modelos.Reclutador;
import io.github.rhacs.reclutamiento.repositorios.OfertasRepositorio;
import io.github.rhacs.reclutamiento.repositorios.ReclutadoresRepositorio;

@Controller
@RequestMapping(path = "/reclutadores")
public class ReclutadoresController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link ReclutadoresRepositorio} que contiene los métodos de
     * manipulación y consulta para el repositorio de {@link Reclutador}es
     */
    @Autowired
    private ReclutadoresRepositorio reclutadoresRepositorio;

    /**
     * Objeto {@link OfertasRepositorio} que contiene los métodos de manipulación y
     * consulta para el repositorio de {@link Oferta}s
     */
    @Autowired
    private OfertasRepositorio ofertasRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el formulario para agregar un nuevo {@link Reclutador}
     * 
     * @param modelo objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @GetMapping
    public String mostrarFormulario(Model modelo) {
        // Agregar nueva instancia de Reclutador al modelo
        modelo.addAttribute("reclutador", new Reclutador());

        // Devolver vista
        return "reclutadores";
    }

}
