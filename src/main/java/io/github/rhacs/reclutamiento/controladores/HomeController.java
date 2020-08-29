package io.github.rhacs.reclutamiento.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el home
     * 
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @GetMapping
    public String home() {
        return "home";
    }

}
