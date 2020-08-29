package io.github.rhacs.reclutamiento.controladores;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import io.github.rhacs.reclutamiento.modelos.Oferta;
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

    // Métodos
    // -----------------------------------------------------------------------------------------

    /**
     * Efectúa una petición GET a la API para obtener el listado de {@link Oferta}s
     * 
     * @return un objeto {@link List} que contiene los elementos devueltos por la
     *         API
     */
    private List<Oferta> buscarOfertas() {
        // Establecer url de la API
        String url = "http://localhost/awakelab-ensayo-reclutamiento/api/ofertas";

        // Inicializar RestTemplate
        RestTemplate rest = new RestTemplate();

        // Efectuar consulta y capturar respuesta
        ResponseEntity<Oferta[]> respuesta = rest.getForEntity(url, Oferta[].class);

        // Procesar respuesta y devolver listado
        return Arrays.asList(respuesta.getBody());
    }

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

    /**
     * Muestra el listado de {@link Oferta}s disponibles en el repositorio
     * 
     * @param modelo objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @GetMapping(path = "/ofertas")
    public String mostrarOfertas(Model modelo) {
        // Obtener listado de ofertas
        List<Oferta> ofertas = buscarOfertas();

        // Agregar listado al modelo
        modelo.addAttribute("ofertas", ofertas);

        // Devolver vista
        return "postulantes.ofertas";
    }

    // Solicitudes POST
    // -----------------------------------------------------------------------------------------

    /**
     * Agrega un nuevo {@link Postulante} al repositorio
     * 
     * @param postulante    un objeto {@link Postulante} que contiene la información
     *                      a agregar
     * @param model         objeto {@link Model} que contiene el modelo de la vista
     * @param bindingResult objeto {@link BindingResult} que contiene los errores de
     *                      validación
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @PostMapping
    public String procesarFormulario(@Valid Postulante postulante, Model model, BindingResult bindingResult) {
        // Verificar si hay errores
        if (bindingResult.hasErrors()) {
            // Devolver vista
            return "postulantes";
        }

        // Buscar último registro ingresado al repositorio
        Optional<Postulante> ultimo = postulantesRepositorio.findTopByOrderByIdDesc();

        // Verificar si existe
        if (ultimo.isPresent()) {
            // Asignar identificador de acuerdo al último ingresado
            postulante.setId(ultimo.get().getId() + 1L);
        } else {
            // Asignar identificador arbitrario
            postulante.setId(1L);
        }

        // Guardar datos
        postulantesRepositorio.save(postulante);

        // Redireccionar
        return "redirect:/postulantes/?add=true";
    }

}
