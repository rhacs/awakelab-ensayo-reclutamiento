package io.github.rhacs.reclutamiento.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.rhacs.reclutamiento.modelos.Postulante;
import io.github.rhacs.reclutamiento.repositorios.PostulantesRepositorio;

@Controller
@RequestMapping(path = "/postulantes")
public class PostulantesController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link PostulantesRepositorio} que contiene los métodos de
     * manipulación y consulta para el repositorio de {@link Postulante}s
     */
    @Autowired
    private PostulantesRepositorio postulantesRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el formulario de inscripción como {@link Postulante}
     * 
     * @param modelo objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @GetMapping
    public String mostrarFormulario(Model modelo) {
        // Agregar nueva instancia de Postulante al modelo
        modelo.addAttribute("postulante", new Postulante());

        // Devolver vista
        return "postulantes";
    }

}
